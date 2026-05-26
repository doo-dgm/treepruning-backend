package co.edu.uco.treepruning.infrastructure.storage;

public interface PhotoStoragePort {

    /**
     * Sube una foto al storage y devuelve la key (ruta interna) bajo la cual
     * quedo almacenada. La key es estable y se persiste en
     * {@code PruningEntity.photographicRecordPath}.
     *
     * @param bytes             contenido del archivo
     * @param contentType       MIME type (image/jpeg, image/png, image/webp)
     * @param originalFilename  nombre original del archivo (para inferir extension)
     * @param uploadedByUserId  UUID del usuario autenticado que realiza la subida
     */
    String upload(byte[] bytes, String contentType, String originalFilename, String uploadedByUserId);

    /**
     * Genera una URL prefirmada de lectura para la key dada, valida por el
     * tiempo configurado en {@code storage.minio.presigned-url-expiry-seconds}.
     */
    String presignedUrl(String key);
}
