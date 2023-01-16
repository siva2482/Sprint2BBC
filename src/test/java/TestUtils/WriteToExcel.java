package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.TestBase;

public class WriteToExcel extends TestBase {
	
public void writeExcel(List<String> title_list,List<String> desc_list) throws IOException
{

	
	File file = new File(".\\src\\test\\resources\\OUTPUT\\BBCRESULTS.xlsx");
	Row row;
	Cell cell;
	FileInputStream fin = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fin);
	XSSFSheet sheet = workbook.createSheet("BBCNEWS");
	int j = 0;
	int k=1;
	for (int i = 0; i < title_list.size(); i++) {
		row = sheet.createRow(i);
		cell = row.createCell(j);
		
		cell.setCellValue(title_list.get(i));
		cell = row.createCell(k);
		cell.setCellValue(desc_list.get(i));
		//j++;

	}
	fin.close();
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\OUTPUT\\BBCRESULTS.xlsx");
	workbook.write(fos);
	fos.close();

}
}