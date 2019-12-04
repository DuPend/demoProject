package com.xinghuo.service.impl;

import com.xinghuo.mapper.AdminPatentMapper;
import com.xinghuo.mapper.TbUserPatentMapper;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.TbExportService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * create by   duanlian on 2019/11/25
 **/
@Service
public class TbExportServiceImpl implements TbExportService {
    @Autowired
    private TbUserPatentMapper tbUserPatentMapper;

    @Autowired
    private AdminPatentMapper adminPatentMapper;

    @Override
    public XSSFWorkbook show() {
        List<TbPatent> list = tbUserPatentMapper.findAll();
        XSSFWorkbook wb = new XSSFWorkbook();
        try {

            Sheet sheet = wb.createSheet("excel"); //创建一张表
            Row titleRow = sheet.createRow(0); //创建第一行，起始为0
            titleRow.createCell(0).setCellValue("编号"); //第一列
            titleRow.createCell(1).setCellValue("专利名称");
            titleRow.createCell(2).setCellValue("案件文号");
            titleRow.createCell(3).setCellValue("申请号");
            titleRow.createCell(4).setCellValue("申请日");
            titleRow.createCell(5).setCellValue("发明人中文名称");
            titleRow.createCell(6).setCellValue("进度");

            int cell = 1;
            for (TbPatent patent : list) {
                Row row = sheet.createRow(cell); //从第二行开始保存数据
                row.createCell(0).setCellValue(cell); //编号
               /* row.createCell(1).setCellValue(patent.getPatentId());*/
                row.createCell(1).setCellValue(patent.getPatentName()); //专利名称
                row.createCell(2).setCellValue(patent.getCaseNumber()); //案件文号
                row.createCell(3).setCellValue(patent.getProposeNumber()); //申请号
                //申请日
                row.createCell(4).setCellValue(new SimpleDateFormat("yyyy-MM-dd ").format(patent.getProposeDate()));
                row.createCell(5).setCellValue(patent.getInventorName()); //发明人中文名称
                row.createCell(6).setCellValue(patent.getTbPlan().getPlanContent()); //进度

                cell++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return wb;
    }

    @Override
    public XSSFWorkbook AdminShow() {
        List<TbPatent> list = adminPatentMapper.selectAll();
        XSSFWorkbook wb = new XSSFWorkbook();
        try {

            Sheet sheet = wb.createSheet("excel"); //创建一张表
            Row titleRow = sheet.createRow(0); //创建第一行，起始为0
            titleRow.createCell(0).setCellValue("编号"); //第一列
            titleRow.createCell(1).setCellValue("专利名称");
            titleRow.createCell(2).setCellValue("案件文号");
            titleRow.createCell(3).setCellValue("申请号");
            titleRow.createCell(4).setCellValue("申请日");
            titleRow.createCell(5).setCellValue("发明人中文名称");
            titleRow.createCell(6).setCellValue("进度");

            int cell = 1;
            for (TbPatent patent : list) {
                Row row = sheet.createRow(cell); //从第二行开始保存数据
                row.createCell(0).setCellValue(cell); //编号
                /* row.createCell(1).setCellValue(patent.getPatentId());*/
                row.createCell(1).setCellValue(patent.getPatentName()); //专利名称
                row.createCell(2).setCellValue(patent.getCaseNumber()); //案件文号
                row.createCell(3).setCellValue(patent.getProposeNumber()); //申请号
                //申请日
                row.createCell(4).setCellValue(new SimpleDateFormat("yyyy-MM-dd ").format(patent.getProposeDate()));
                row.createCell(5).setCellValue(patent.getInventorName()); //发明人中文名称
                row.createCell(6).setCellValue(patent.getTbPlan().getPlanContent()); //进度

                cell++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return wb;
    }
}
