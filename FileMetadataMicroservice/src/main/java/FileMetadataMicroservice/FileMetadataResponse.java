package FileMetadataMicroservice;

public class FileMetadataResponse {

    String filename;
    long size;

    public FileMetadataResponse(String filename, long size) {
        this.filename = filename;
        this.size = size;
    }

    public FileMetadataResponse() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
