package com.jun.raine.excel.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jun.raine.excel.service.ExcelUtil;

public class ExcelUtilImpl implements ExcelUtil {

	private static final Logger logger = LoggerFactory.getLogger(ExcelUtilImpl.class);
	
	private static final String excelPath = "D:\\tmp\\业务规则批量导入.xlsx";
	
	
	@Override
	public void createExcel() {
		Workbook wb = new XSSFWorkbook();  // or new HSSFWorkbook();
		CellStyle style;
		DataFormat format = wb.createDataFormat();

		CreationHelper createHelper = wb.getCreationHelper();
		
	    Sheet sheet1 = wb.createSheet("new sheet");
	    Sheet sheet2 = wb.createSheet("second sheet");

	    // Note that sheet name is Excel must not exceed 31 characters
	    // and must not contain any of the any of the following characters:
	    // 0x0000
	    // 0x0003
	    // colon (:)
	    // backslash (\)
	    // asterisk (*)
	    // question mark (?)
	    // forward slash (/)
	    // opening square bracket ([)
	    // closing square bracket (])

	    // You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
	    // for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
	    String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
	    Sheet sheet3 = wb.createSheet(safeName);

	    // Create a row and put some cells in it. Rows are 0 based.
	    Row row = sheet1.createRow((short)0);
	    // Create a cell and put a value in it.
	    Cell cell = row.createCell(0);
	    cell.setCellValue(1);
	    
//	    style = wb.createCellStyle();
//	    style.setDataFormat(format.getFormat("0.0"));
//	    cell.setCellStyle(style);

	    // Or do it on one line.
	    row.createCell(1).setCellValue(1.2);
	    row.createCell(2).setCellValue(
	         createHelper.createRichTextString("This is a string"));
	    row.createCell(3).setCellValue(true);
	    
	    
	    addPic(wb);
	    
	    FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("D:\\tmp\\workbook_create.xls");
			wb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fileOut != null){
					fileOut.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void addPic(Workbook wb) {
		//add picture data to this workbook.
	    InputStream is = null;
	    int pictureIdx = 0;
		try {
			is = new FileInputStream("D:\\tmp\\image1.jpg");
			byte[] bytes = IOUtils.toByteArray(is);
		    pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		CreationHelper helper = wb.getCreationHelper();

	    //create sheet
		String safeName = WorkbookUtil.createSafeSheetName("pic_sheet"); 
	    Sheet sheet = wb.createSheet(safeName);

	    // Create the drawing patriarch.  This is the top level container for all shapes. 
	    Drawing drawing = sheet.createDrawingPatriarch();

	    //add a picture shape
	    ClientAnchor anchor = helper.createClientAnchor();
	    //set top-left corner of the picture,
	    //subsequent call of Picture#resize() will operate relative to it
	    anchor.setCol1(0);
	    anchor.setRow1(0);
	    Picture pict = drawing.createPicture(anchor, pictureIdx);

	    //auto-size picture relative to its top-left corner
	    pict.resize();
	}

	@Override
	public void updateExcel() {
		
	}

	@Override
	public void readExcel(){
    	logger.info("-----------------excelPath:[{}]---------------------",excelPath);
    	InputStream io = null;
    	Workbook wb = null;
		try {
			io = new FileInputStream(excelPath);
			wb = WorkbookFactory.create(io);
		} catch (FileNotFoundException e) {
			logger.error("文件不存在。", e);
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

    	// 循环工作表Sheet
    	for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
			Sheet sheet = wb.getSheetAt(numSheet);
			if(sheet == null || sheet.getLastRowNum() == 0){
				continue;
			}

			logger.info("-----------rowNum:[{}]--------------",sheet.getLastRowNum());
			// 循环行Row
			for (int rowNum = 0; rowNum <=sheet.getLastRowNum(); rowNum++) {
				Row row = sheet.getRow(rowNum);
				
				if(row == null){
					continue;
				}
				logger.info("-----------cellNum:[{}]--------------",row.getLastCellNum());
				// 循环列Cell
				for (int cellNum = 0; cellNum <row.getLastCellNum(); cellNum++) {
					Cell cell = row.getCell(cellNum);
					if(cell == null){
						System.out.print(":null===");
						continue;
					}
					
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "===");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "===");
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "===");
						break;

					default:
						System.out.print(cell.getCellType() + ":error===");
						break;
					}
				}
				System.out.println();
			}
    	}
	}

	
	public static void main(String[] args) throws Exception {
		new ExcelUtilImpl().readExcel();
//		new ExcelUtilImpl().createExcel();
	}
}
