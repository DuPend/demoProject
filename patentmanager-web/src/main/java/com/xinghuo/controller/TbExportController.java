package com.xinghuo.controller;

import com.xinghuo.service.TbExportService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author:DuanLian
 * @Description:用户 controller
 * @Date:14:53 2019/12/02
 * @Param: HttpServletResponse
 */
@Controller
public class TbExportController {
    @Autowired
    private TbExportService tbExportService;
    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        XSSFWorkbook wb = tbExportService.show();
        String fileName = "查询报表.xlsx";
        OutputStream outputStream = null;
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author:DuanLian
     * @Description:管理员导出 controller
     * @Date:14:53 2019/12/02
     * @Param: HttpServletResponse
     */
    @RequestMapping("/adminExport")
    public void adminExport(HttpServletResponse response) {
        System.out.println("管理员导出文件报表................");
        XSSFWorkbook wb = tbExportService.AdminShow();
        String fileName = "管理员查询报表.xlsx";
        OutputStream outputStream = null;
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
