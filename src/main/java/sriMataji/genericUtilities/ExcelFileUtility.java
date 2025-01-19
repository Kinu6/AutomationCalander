package sriMataji.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class is for Excel FileUtility
 * @author KESHRI
 */
public class ExcelFileUtility {
    /**
     * This File is for reading excelFile value
     * @param sheet
     * @param row
     * @param cell
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
	public String readDataFromExcelFile( String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisE= new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fisE);
		Sheet sh= wb.getSheet(sheet);
		Row rw=sh.getRow(row);
		Cell ce=rw.getCell(cell);
		wb.close();
		return ce.getStringCellValue();
		
	}
	/**
	 * This Method is for reading lastrowCount
	 * @param sheet
	 * @param row
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount( String sheet, int row) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisE= new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fisE);
		Sheet sh= wb.getSheet(sheet);
		int Lastrw=sh.getLastRowNum();
		wb.close();
		return Lastrw;
	
	}
	/**
	 * This Method is for writing data in Excel Sheet
	 * @param sheet
	 * @param row
	 * @param ce
	 * @param cellName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int ce, String cellName) throws EncryptedDocumentException, IOException {
		
			
			FileInputStream fisE= new FileInputStream(IConstantUtility.excelFilePath);
			Workbook wb=WorkbookFactory.create(fisE);
			Sheet sh=wb.getSheet(sheet);
			sh.getRow(row).getCell(ce).setCellValue(cellName);
			FileOutputStream fisO= new FileOutputStream(IConstantUtility.excelFilePath);
			wb.write(fisO);
			wb.close();
		}
	/**
	 * This method is for DataProvider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readDataFromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException{
			FileInputStream fis= new FileInputStream(IConstantUtility.excelFilePath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh= wb.getSheet(SheetName);
			int lastRow= sh.getPhysicalNumberOfRows();
			System.out.println(lastRow);
			int lastCell= sh.getRow(0).getPhysicalNumberOfCells();
			System.out.println(lastCell);
			
			Object[][] data= new Object[lastRow-1][lastCell];
			for(int i=1;i<lastRow;i++) {
				for(int j=0;j<lastCell;j++) {
					data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			wb.close();	
			return data;
		}
}
