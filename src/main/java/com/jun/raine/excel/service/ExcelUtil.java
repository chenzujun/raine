package com.jun.raine.excel.service;

/**
 * excel 操作
 * @author chenj
 *
 */
public interface ExcelUtil {

	public void createExcel();
	
	public void updateExcel();
	
	/**
	 * 读取excel
	 * 
	 * @throws Exception
	 */
	public void readExcel();
	
}
