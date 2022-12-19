package com.tianhui.service;

import com.tianhui.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/*
    文件上传接口
 */
public interface UploadService {

    /*
        图片上传
     */
    ResponseResult uploadImg(MultipartFile img);

}
