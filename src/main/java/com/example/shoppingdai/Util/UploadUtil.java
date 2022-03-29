package com.example.shoppingdai.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Component
public class UploadUtil {
    @Autowired
    ServletContext context;

    public String save(MultipartFile file, String folder){
        File dir = new File(context.getRealPath(folder));
        if(!dir.exists()){
            dir.mkdir();
        }
        try {
            File saveFile = new File(dir, file.getOriginalFilename());
            file.transferTo(saveFile);
            return file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
