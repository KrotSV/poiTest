package test;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MainTest {
  public static void main(String[] args) throws Exception {
    InputStream in = new FileInputStream("C:\\Users\\KrotSV\\poiTest\\src\\main\\resources\\poiTest.xls");
    // Внимание InputStream будет закрыт
    // Если нужно не закрывающий см. JavaDoc по POIFSFileSystem :  http://goo.gl/1Auu7
    HSSFWorkbook wb = new HSSFWorkbook(in);

    ExcelExtractor extractor = new ExcelExtractor(wb);
    extractor.setFormulasNotResults(false); // Считать формулы
    extractor.setIncludeSheetNames(true);
    String text = extractor.getText();

    System.out.println(text);

  }
}
