package com.xinghuo.service;

import com.xinghuo.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public interface UploadFileService {

    Result uploadFile(MultipartFile file, Integer patentId, Integer typeId, Date date, HttpServletRequest request);

    Result uploadFiles(MultipartFile[] files, Integer patentId, Integer typeId, HttpServletRequest request);
}
