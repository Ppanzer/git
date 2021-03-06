package com.example.excalhandler.util;

import com.example.excalhandler.entity.DataInsides;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xjq
 * @date 2020/8/6
 */
public class ExcelReader {

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    /**
     * 读取Excel文件内容
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<DataInsides> readExcel(String fileName) {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
                return null;
            }

            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
            workbook = getWorkbook(inputStream, fileType);

            // 读取excel中的数据

            return parseExcel(workbook);
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                //return null;
            }
        }
    }

    /**
     * 解析Excel数据
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<DataInsides> parseExcel(Workbook workbook) {
        List<DataInsides> resultDataList = new ArrayList<>();
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }

                DataInsides resultData = convertRowToData(row);
                resultDataList.add(resultData);
            }
        }

        return resultDataList;
    }

    /**
     * 将单元格内容转换为字符串
     * @param cell
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if(cell==null){
            return "";
        }
        String returnValue ="";
        switch (cell.getCellType()) {
            case NUMERIC:   //数字

                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                    returnValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue()));}
                else {
                    Double doubleValue = cell.getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("0.#");
                    returnValue = df.format(doubleValue);}
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                boolean booleanValue = cell.getBooleanCellValue();
                returnValue = Boolean.toString(booleanValue);
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }
    /**
     * 提取每一行中需要的数据，构造成为一个结果数据对象
     *
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    private static DataInsides convertRowToData(Row row) {
        DataInsides resultData = new DataInsides();
        Cell cell;
        int cellNum = 0;
        // 获取风速
        cell = row.getCell(cellNum++);
        Float wind = Float.valueOf(convertCellValueToString(cell));
        resultData.setWind(wind);
        // 获取降水量
        cell = row.getCell(cellNum++);
        Float rain = Float.valueOf(convertCellValueToString(cell));
        resultData.setRain(rain);
        // 获取温度
        cell = row.getCell(cellNum++);
        Float temperature = Float.valueOf(convertCellValueToString(cell));
        resultData.setTemperature(temperature);
        // 获取总降水
        cell = row.getCell(cellNum++);
        Float raincc = Float.valueOf(convertCellValueToString(cell));
        resultData.setRainacc(raincc);
        // 获取气压
        cell = row.getCell(cellNum++);
        Float pressure = Float.valueOf(convertCellValueToString(cell));
        resultData.setPressure(pressure);
        // 获取风向
        cell = row.getCell(cellNum++);
        Integer direction = Integer.valueOf(convertCellValueToString(cell));
        resultData.setDirection(direction);
        // 获取湿度
        cell = row.getCell(cellNum++);
        Float humidity= Float.valueOf(convertCellValueToString(cell));
        resultData.setHumidity(humidity);
        // 获取噪声
        cell = row.getCell(cellNum++);
        Float noise= Float.valueOf(convertCellValueToString(cell));
        resultData.setNoise(noise);
        // 获取照度
        cell = row.getCell(cellNum++);
        Integer illumination= Integer.valueOf(convertCellValueToString(cell));
        resultData.setIllumination(illumination);
        // 获取pm10
        cell = row.getCell(cellNum++);
        Integer pm10 = Integer.valueOf(convertCellValueToString(cell));
        resultData.setPm10(pm10);
        // 获取pm10
        cell = row.getCell(cellNum++);
        Integer pm25 = Integer.valueOf(convertCellValueToString(cell));
        resultData.setPm25(pm25);
        // 获取记录时间


        cell = row.getCell(cellNum++);
        String datestr = convertCellValueToString(cell);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        Date creatingtime = new Date();
        try {
            creatingtime =sdf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resultData.setCreatingtime(creatingtime);

        return resultData;
    }
}