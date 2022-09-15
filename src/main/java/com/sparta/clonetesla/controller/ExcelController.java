//package com.sparta.clonetesla.controller;
//
//import com.sparta.clonetesla.entity.ExcelData;
//import com.sparta.clonetesla.entity.Product;
//import com.sparta.clonetesla.repository.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//public class ExcelController {
//
//    private final ProductRepository productRepository;
//    @GetMapping("/excel")
//    public String main() { // 1
//        return "excel";
//    }
//
//    // 엑셀불러오기
//    @PostMapping("/excel/read")
//    public String readExcel(@RequestParam("file") MultipartFile file, Model model)
//            throws IOException { // 2
//
//        List<ExcelData> dataList = new ArrayList<>();
//
//        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3
//
//        if (!extension.equals("xlsx") && !extension.equals("xls")) {
//            throw new IOException("엑셀파일만 업로드 해주세요.");
//        }
//
//        Workbook workbook = null;
//
//        if (extension.equals("xlsx")) {
//            workbook = new XSSFWorkbook(file.getInputStream());
//        } else if (extension.equals("xls")) {
//            workbook = new HSSFWorkbook(file.getInputStream());
//        }
//
//        Sheet worksheet = workbook.getSheetAt(0);
//
//        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4
//
//            Row row = worksheet.getRow(i);
//
//            ExcelData data = new ExcelData();
//
//            Product product = Product.builder()
//                    .category(row.getCell(0).getStringCellValue())
//                    .imageUrl(row.getCell(1).getStringCellValue())
//                    .productName(row.getCell(2).getStringCellValue())
//                    .price((int) row.getCell(3).getNumericCellValue())
//                    .maxQuantity((int) row.getCell(4).getNumericCellValue())
//                    .content(row.getCell(5).getStringCellValue())
//                    .build();
//
//            productRepository.save(product);
//        }
//
////        model.addAttribute("datas", dataList); // 5
//
//        return "excelList";
//
//    }
//}