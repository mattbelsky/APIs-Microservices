package FileMetadataMicroservice;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileService {

    private final String PATH = "";

    public void handleFileUpload(MultipartFile file) throws IOException {

        String filename = file.getOriginalFilename();
        byte[] contents = file.getBytes();

        try (FileOutputStream output = new FileOutputStream(PATH + filename)) {
            output.write(contents);
        }
    }

    public FileMetadataResponse getFileMetadataResponse(MultipartFile file) {

        String filename = file.getOriginalFilename();
        long size = file.getSize();
        return new FileMetadataResponse(filename, size);
    }
}
