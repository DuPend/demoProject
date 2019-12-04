package com.xinghuo.service.impl;
import com.xinghuo.mapper.TbPatentMapper;
import com.xinghuo.pojo.ResponseMessage;
import com.xinghuo.pojo.Result;
import com.xinghuo.pojo.TbDocument;
import com.xinghuo.pojo.TbDocumentType;
import com.xinghuo.service.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: patentmanager-parent
 * @description: 文件上传controller
 * @author: Yuyue
 * @create: 2019-11-25 10:45
 **/


@Service
@Slf4j
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    private TbPatentMapper patentMapper;
    @Value("${visualPath}")
    private String downfile; //下載文件時的ip路徑
    @Value("${savepath}")
    private String savepath; //服務器上的文件實際存儲位置
    @Value("${spring.http.multipart.max-file-size}")
    private String FILESIZE;

    /**
     * @Author:Yuyue
     * @Description:添加文件到数据库
     * @Date:15:16 2019/11/22
     * @Param: Integer patentId,Integer typeId,String docName,String docAddress
     * @Return:
     */
    public ResponseMessage addFile(Integer patentId, Integer typeId, String docName, String docAddress,Date date) {
        TbDocument tbDocument = new TbDocument();
        TbDocumentType tbDocumentType = new TbDocumentType();
        tbDocumentType.setDocTypeId(typeId);
        tbDocument.setTbDocumentType(tbDocumentType);
        tbDocument.setDocName(docName);
        tbDocument.setDocAddress(docAddress);
        tbDocument.setPatentId(patentId);
        tbDocument.setUploadDate(date);
        try {
            patentMapper.addFile(tbDocument);
            return ResponseMessage.ok();
        } catch (Exception e) {
            return ResponseMessage.error("上传文件失败:");
        }
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public ResponseMessage uploadFiles(MultipartFile[] files, Integer patentId, Integer typeId, HttpServletRequest request) {
        if (null == files || files.length <= 0){
            return  ResponseMessage.error("上传的文件为空！");
        }
            Date date = new Date();
            for (MultipartFile file : files) {
                Integer fileSize = Integer.valueOf(FILESIZE.substring(0, FILESIZE.lastIndexOf("MB"))) * 1024*1024;
                System.out.println(file.getSize() + "------");
                if (file.getSize() <= fileSize) {
                    String fileName = file.getOriginalFilename();
                    System.out.println("file.length" + file.getSize());
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    if (".doc".equals(suffixName) || ".docx".equals(suffixName) || ".pdf".equals(suffixName) || ".zip".equals(suffixName) || ".md".equals(suffixName)) {
                        ResponseMessage responseMessage = uploadFile(file, patentId, typeId, date, request);
                        if (!responseMessage.isSuccess()) {
                            return ResponseMessage.error( "上传失败！");
                            /*throw  new RuntimeException("上传文件失败，回滚！");*/
                        }
                    } else {
                        /*throw  new RuntimeException("上传文件失败,文件类型错误，回滚！");*/
                        return ResponseMessage.error( "上传的文件中有不允许上传的文件类型！");
                    }
                }else {
                    return ResponseMessage.error("上传的文件太大！");
                }
            }
            return ResponseMessage.ok();
    }

    @Override
    public ResponseMessage uploadFile(MultipartFile file, Integer patentId, Integer typeId,Date date, HttpServletRequest request) {
        if (file.isEmpty()) {
            return ResponseMessage.error("上传的文件为空！");
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        Date dateName = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str  =  format.format(dateName);
        fileName = fileName + "-" + str + suffixName;
        String path = savepath + "upfile/" + fileName;
        String url = downfile + "upfile/" + fileName;

       /* String projectUrl = request.getSession().getServletContext().getRealPath("/");
        String path=projectUrl+"/"+fileName;*/
        File dest = new File(path);
        System.out.println(downfile);
        System.out.println("url:" + url);
        System.out.println("path:" + path);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (IllegalStateException e) {
            return ResponseMessage.error("文件上传失败");
        } catch (IOException e) {
            return ResponseMessage.error("文件上传失败");
        }
        return addFile(patentId, typeId, fileName, url,date);
    }
}
