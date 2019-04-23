package kr.hs.dgsw.web02blog.Controller;

import kr.hs.dgsw.web02blog.Repository.UserRepository;
import kr.hs.dgsw.web02blog.domain.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class AttachmentController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostController postController;

    @PostMapping("/attachment")
    public Attachment upload(@RequestPart MultipartFile uploadFile)
    {
        String storedPath = "C:/Users/Quote/IdeaProjects/web02blog/upload/"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd/"))
                + UUID.randomUUID().toString() + "_"
                + uploadFile.getOriginalFilename();

        try
        {
            File destFile = new File(storedPath);
            destFile.getParentFile().mkdirs();
            uploadFile.transferTo(destFile);
            String originName = destFile.getName();
            Attachment attachmentProtocol = new Attachment(storedPath, null);
            return attachmentProtocol;
        }
        catch(Exception e)
        {

        }
        return null;
    }

    @GetMapping("/attachment/{type}/{id}")
    public void download(@PathVariable String type, @PathVariable Long id, HttpServletRequest req, HttpServletResponse res)
    {
        try
        {
            String filePath = "";
            String fileName = "";


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
