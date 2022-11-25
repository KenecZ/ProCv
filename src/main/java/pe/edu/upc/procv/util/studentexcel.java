package pe.edu.upc.procv.util;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import pe.edu.upc.procv.model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class studentexcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Student> students;

    public studentexcel(List<Student> students) {
        this.students = students;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Resultado");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "first_name", style);
        createCell(row, 1, "last_name", style);
        createCell(row, 2, "dni", style);
        createCell(row, 3, "email", style);
        createCell(row, 4, "cellphone", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);

        if(value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if(value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }

        cell.setCellStyle(style);

    }


    private void writeDataLines() {

        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for( Student result: students) {

            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, result.getFirstName(), style);
            createCell(row, columnCount++, result.getLastName(), style);
            createCell(row, columnCount++, result.getDni(), style);
            createCell(row, columnCount++, result.getEmail(),style);
            createCell(row, columnCount++, result.getCellphone(),style); 

        }
    }


    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine(); //write the header
        writeDataLines(); //write the data
        ServletOutputStream servletOutput = response.getOutputStream();
        workbook.write(servletOutput);
        workbook.close();
        servletOutput.close();
    }

}
