package co.edu.uco.treepruning.infrastructure.storage;

public interface PhotoStoragePort {

    /**
     * Sube una foto al storage y devuelve la key (ruta interna) bajo la cual
     * quedó almacenada. La key es estable y se persiste en
     * {@code PruningEntity.photographicRecordPath}.
     */
    String upload(byte[] bytes, String contentType, String originalFilename);

    /**
     * Genera una URL prefirmada de lectura para la key dada, válida por el
     * tiempo configurado en {@code storage.minio.presigned-url-expiry-seconds}.
     */
    String presignedUrl(String key);
}
