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
		//����һ��Excel�ļ�
		HSSFWorkbook workbook = new HSSFWorkbook();
		//����һ��������
		HSSFSheet sheet = workbook.createSheet("users��");
		//��ӱ�ͷ��
		HSSFRow hssfRow = sheet.createRow(0);
		//���õ�Ԫ���ʽ����
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//��ӱ�ͷ����
		HSSFCell headCell = hssfRow.createCell(0);
		headCell.setCellValue("���");
		headCell.setCellStyle(cellStyle);
		
		headCell = hssfRow.createCell(1);
		headCell.setCellValue("�˻���");
		headCell.setCellStyle(cellStyle);
		
		headCell = hssfRow.createCell(2);
		headCell.setCellValue("��ʵ����");
		headCell.setCellStyle(cellStyle);
		
		headCell = hssfRow.createCell(3);
		headCell.setCellValue("�Ա�");
		headCell.setCellStyle(cellStyle);
		
		//�����������
		for(int i=0;i<list.size();i++){
			hssfRow=sheet.createRow((int)i+1);
			Users users = list.get(i);
			//������Ԫ�񣬲�����ֵ
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
		System.out.println("�洢�ɹ�");
	}
}
