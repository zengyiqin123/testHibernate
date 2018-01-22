package com.zeng.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.zeng.entity.Users;

public class TestExcel {
	
	private static List<Users> getUsers(){
		ArrayList<Users> list = new ArrayList<Users>();
		Users user = new Users(1,"zhangsan", "123", "women");
		Users user2 = new Users(2,"lisi", "456", "women");
		Users user3 = new Users(3,"wangwu", "567", "man");
		Users user4 = new Users(4,"zhaoliu", "789", "man");
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		return list;
	}
	public static void createExcel(List<Users> list){
		//创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个工作表
		HSSFSheet sheet = workbook.createSheet("users表");
		//添加表头行
		HSSFRow hssfRow = sheet.createRow(0);
		//设置单元格格式居中
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//添加表头内容
		HSSFCell headCell = hssfRow.createCell(0);
		headCell.setCellValue("编号");
		headCell.setCellStyle(cellStyle);
		
		headCell = hssfRow.createCell(1);
		headCell.setCellValue("账户名");
		headCell.setCellStyle(cellStyle);
		
		headCell = hssfRow.createCell(2);
		headCell.setCellValue("真实姓名");
		headCell.setCellStyle(cellStyle);
		
		headCell = hssfRow.createCell(3);
		headCell.setCellValue("性别");
		headCell.setCellStyle(cellStyle);
		
		//添加数据内容
		for(int i=0;i<list.size();i++){
			hssfRow=sheet.createRow((int)i+1);
			Users users = list.get(i);
			//创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(users.getUserid());
			cell.setCellStyle(cellStyle);
			
			cell=hssfRow.createCell(1);
			cell.setCellValue(users.getLoginname());
			cell.setCellStyle(cellStyle);
			
			cell=hssfRow.createCell(2);
			cell.setCellValue(users.getLoginpwd());
			cell.setCellStyle(cellStyle);
			
			cell=hssfRow.createCell(3);
			cell.setCellValue(users.getSex());
			cell.setCellStyle(cellStyle);
			
		}
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/user.xls");
			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		createExcel(getUsers());
		System.out.println("存储成功");
	}
}
