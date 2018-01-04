package com.example.ssm.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Aspect
@Component
public class FileDownloadAspect {
    private File[] files = new FileSystemResource("src/main/resources/static/pictures").getFile().listFiles();


    @Before("execution(* com.example.ssm.controller.FileController.downFile(..)) && args(response,index)")
    public void downFile(HttpServletResponse response,int index){
        response.setContentType("multipart/form-data");
        response.addHeader("Content-Disposition", "attachment;filename=" + files[index].getName());
        try (FileInputStream fis = new FileInputStream(files[index]);
             BufferedInputStream bis = new BufferedInputStream(fis);
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int i = 0;
            while ((i = bis.read(buffer)) != -1) {
                os.write(buffer, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
