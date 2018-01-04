package com.example.ssm.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@EnableAspectJAutoProxy
public class FileController {

    private File file = new FileSystemResource("src/main/resources/static/pictures").getFile();

    @RequestMapping("/showFiles")
    public String showAllFiles(Model model) {
        model.addAttribute("files", file.listFiles());
        return "files_download";
    }

    @RequestMapping("/downloadFile")
    public String downFile(HttpServletResponse response, @RequestParam int index) {
        return null;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        try {
            File tempFile = File.createTempFile("silence", new String(file.getOriginalFilename().getBytes("UTF-8")), this.file);
            IOUtils.copy(file.getInputStream(), new FileOutputStream(tempFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
