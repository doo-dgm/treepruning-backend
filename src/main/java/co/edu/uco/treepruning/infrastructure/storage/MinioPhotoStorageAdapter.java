package co.edu.uco.treepruning.infrastructure.storage;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import io.minio.BucketExistsArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;

@Component
public class MinioPhotoStorageAdapter implements PhotoStoragePort {

    private static final Logger log = LoggerFactory.getLogger(MinioPhotoStorageAdapter.class);

    private final MinioClient client;
    private final StorageProperties props;

    public MinioPhotoStorageAdapter(MinioClient client, StorageProperties props) {
        this.client = client;
        this.props = props;
        ensureBucketExists();
    }

    private void ensureBucketExists() {
        try {
            boolean exists = client.bucketExists(
                    BucketExistsArgs.builder().bucket(props.getBucket()).build());
            if (!exists) {
                client.makeBucket(
                        MakeBucketArgs.builder().bucket(props.getBucket()).build());
                log.info("MinIO bucket '{}' created", props.getBucket());
            }
        } catch (Exception e) {
            throw new IllegalStateException(
                    "MinIO: no se pudo asegurar el bucket '" + props.getBucket() + "'", e);
        }
    }

    @Override
    public String upload(byte[] bytes, String contentType, String originalFilename) {
        LocalDate today = LocalDate.now();
        String key = String.format("%d/%02d/%s%s",
                today.getYear(), today.getMonthValue(),
                UUID.randomUUID(),
                resolveExtension(originalFilename, contentType));

        try (ByteArrayInputStream in = new ByteArrayInputStream(bytes)) {
            client.putObject(PutObjectArgs.builder()
                    .bucket(props.getBucket())
                    .object(key)
                    .stream(in, bytes.length, -1)
                    .contentType(contentType)
                    .build());
            log.info("MinIO upload OK: bucket={}, key={}, size={}",
                    props.getBucket(), key, bytes.length);
            return key;
        } catch (Exception e) {
            log.error("MinIO upload failed: bucket={}, key={}, error={}",
                    props.getBucket(), key, e.getMessage(), e);
            throw TreePruningException.fromCode(
                    "USER.ERROR.STORAGE.UPLOAD_FAILED",
                    "TECHNICAL.ERROR.STORAGE.UPLOAD_FAILED",
                    Map.of("key", key, "error", e.getMessage() != null ? e.getMessage() : "unknown"));
        }
    }

    @Override
    public String presignedUrl(String key) {
        try {
            return client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(props.getBucket())
                    .object(key)
                    .expiry(props.getPresignedUrlExpirySeconds(), TimeUnit.SECONDS)
                    .build());
        } catch (Exception e) {
            log.error("MinIO presign failed: bucket={}, key={}, error={}",
                    props.getBucket(), key, e.getMessage(), e);
            throw TreePruningException.fromCode(
                    "USER.ERROR.STORAGE.PRESIGN_FAILED",
                    "TECHNICAL.ERROR.STORAGE.PRESIGN_FAILED",
                    Map.of("key", key, "error", e.getMessage() != null ? e.getMessage() : "unknown"));
        }
    }

    private String resolveExtension(String filename, String contentType) {
        if (filename != null) {
            int dot = filename.lastIndexOf('.');
            if (dot > -1 && dot < filename.length() - 1) {
                return filename.substring(dot).toLowerCase();
            }
        }
        if (contentType == null) {
            return "";
        }
        return switch (contentType.toLowerCase()) {
            case "image/jpeg" -> ".jpg";
            case "image/png" -> ".png";
            case "image/webp" -> ".webp";
            default -> "";
        };
    }
}
