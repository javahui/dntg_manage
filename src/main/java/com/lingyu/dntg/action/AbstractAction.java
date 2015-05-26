package com.lingyu.dntg.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.lingyu.dntg.dao.base.AbstractDao;

public class AbstractAction extends AbstractDao{

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 返回默认的路径
	 */
	public final static String DEFAULT_PATH = "default";
	/**
	 * 返回默认的列表路径
	 */
	public final static String INDEX_PATH = "redirect:./index.do";

	/**
	 * 每5万条一个sheet
	 */
	public final static int MAX_SHEET_RECORD_NUM = 50000;
	
	/**
	 * 导出xls
	 * @param dataList 数据集只能是List<Map>形式
	 * @param fileName 文件名
	 * @param titles 标题
	 */
	public ResponseEntity<byte[]> exportXls(List<Map> dataList, String fileName, String... titles) {
		int dataListSize = dataList.size();
		HSSFWorkbook workBook = new HSSFWorkbook();   // 创建Excel文档 
		for (int k = 0; k <= dataListSize / MAX_SHEET_RECORD_NUM; k ++) {
			int fromIndex = k * MAX_SHEET_RECORD_NUM;
			int toIndex = fromIndex + MAX_SHEET_RECORD_NUM;
			if (toIndex > dataListSize) {
				toIndex =  dataListSize;
			}
			List<Map> subList = dataList.subList(fromIndex, toIndex);
			// 新建一个工作页
			HSSFSheet sheet = workBook.createSheet();
			if (titles != null) {
				HSSFRow titleRow = sheet.createRow(0); // 下标为0的行开始  
				HSSFCell[] firstcell = new HSSFCell[titles.length];
				for (int i = 0; i < titles.length; i++) {
					firstcell[i] = titleRow.createCell(i);
					firstcell[i].setCellValue(new HSSFRichTextString(titles[i]));
				}  
			}
			for (int i = 0; i < subList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 1);  // 创建一行 
				Map recordMap = subList.get(i);
				Set keySet = recordMap.keySet();
				int j = 0;
				for (Object key : keySet) {
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(MapUtils.getString(recordMap, key));
					j++;
				}
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		try { workBook.write(out); }
		catch (IOException e) {
			log.error(null, e);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		try { fileName = new String((fileName+".xls").getBytes("UTF-8"), "ISO-8859-1");} catch (UnsupportedEncodingException e) {}
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(out.toByteArray(), headers, HttpStatus.OK);
	}
}