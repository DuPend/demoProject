package com.xinghuo.service;

import com.xinghuo.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UploadFileService {
    Result uploadFile(MultipartFile file, Integer patentId, Integer typeId,
                      HttpServletRequest request);
}
