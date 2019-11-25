package com.koy.dodo.util;

import com.koy.dodo.pojo.FileVO;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
public class FileUtil {

    public static FileVO saveFile(MultipartFile file, String path) {
        String originalFilename = file.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String storePath = path + fileName + suffixName;
        try {
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(storePath)));
            FileVO fileVO = new FileVO();
            fileVO.setFileName(fileName);
            fileVO.setFileSrc(storePath);
            return fileVO;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
