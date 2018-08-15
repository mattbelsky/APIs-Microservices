package FileMetadataMicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileService {

    @Value("${uploaddirectory}")
    private String uploadDirectory;

    public void handleFileUpload(MultipartFile file) throws IOException {

        String filename = file.getOriginalFilename();
        byte[] contents = file.getBytes();

        try (FileOutputStream output = new FileOutputStream(uploadDirectory + filename)) {
            output.write(contents);
        }
    }

    public FileMetadataResponse getFileMetadataResponse(MultipartFile file) {

        String filename = file.getOriginalFilename();
        long size = file.getSize();
        return new FileMetadataResponse(filename, size);
    }
}
