package FileMetadataMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    FileService service;

    @GetMapping(value = { "/home", "/" })
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {

        if (file.isEmpty()) return "redirect:/";

        service.handleFileUpload(file);
        redirectAttributes.addFlashAttribute("filedata", service.getFileMetadataResponse(file));

        return "redirect:/fileinfo";
    }

    @GetMapping("/fileinfo")
    public String getFileMetadata(@ModelAttribute("filedata") FileMetadataResponse fileData, Model model) {

        model.addAttribute("filedata", fileData);
        return "fileinfo";
    }
}
