import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        File file = new File("f:\\任务栏重启.bat");
        Resource resource = new FileSystemResource("src/main/resources/static/pictures");
        try {
            System.out.println(resource.getFile());
            File tempFile = File.createTempFile("silence", ".bat", resource.getFile());
            IOUtils.copy(new FileInputStream(file), new FileOutputStream(tempFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
