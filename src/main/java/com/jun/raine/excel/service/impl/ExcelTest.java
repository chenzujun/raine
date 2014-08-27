package com.jun.raine.excel.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTest {
	private static final String excelPath = "D:\\tmp\\workbook_create.xls";
	
	public static void main(String[] args) throws Exception {
		InputStream io = new FileInputStream(excelPath);

    	Workbook wb = WorkbookFactory.create(io);
		
		List lst = wb.getAllPictures();
	    for (Iterator it = lst.iterator(); it.hasNext(); ) {
	        PictureData pict = (PictureData)it.next();
	        String ext = pict.suggestFileExtension();
	        byte[] data = pict.getData();
	        if (ext.equals("jpeg")){
	        	FileOutputStream out = null;
				try {
					out = new FileOutputStream("D:\\tmp\\pict.jpg");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.write(data);
				out.close();
	        }
	    }
	      
	}
}
