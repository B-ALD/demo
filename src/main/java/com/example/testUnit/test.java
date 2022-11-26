package com.example.testUnit;


import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String regular = "^((?!@).)*$";
        String str1 = "jxs2611@sop.com";
// 正则表达式
        Pattern pattern = Pattern.compile(regular);
        System.out.println("是否匹配str1：" + pattern.matcher(str1).find());

    }


    private static void writeResult(String errorMsg, int i) throws Exception {
        FileInputStream file = new FileInputStream("D:/FundHouseParam.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
//        XSSFSheet sheet = wb.getSheetAt(0);
//        XSSFRow row0 = sheet.getRow(0);
//        if (i == 1) {
//            row0.createCell(59).setCellValue("result");
//        }
//        XSSFRow row = sheet.getRow(i);
//        row.createCell(59).setCellValue(errorMsg);
//        FileOutputStream out = new FileOutputStream("D:/FundHouseResult.xlsx");
//        wb.write(out);
//        out.close();
        XSSFExcelExtractor extractor = new XSSFExcelExtractor(wb);
        extractor.setFormulasNotResults(true);
        extractor.setIncludeSheetNames(false);
        String text = extractor.getText();
        System.out.println(text);
    }

}

