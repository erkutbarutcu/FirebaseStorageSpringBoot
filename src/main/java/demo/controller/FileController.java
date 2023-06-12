package demo.controller;


import demo.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FileController {


    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile multipartFile) {
        return ResponseEntity.ok(fileService.upload(multipartFile));
    }

    @PostMapping("/download/{filename}")
    public ResponseEntity download(@PathVariable("filename") String fileName) {
        return ResponseEntity.ok(fileService.download(fileName));

    }


}
