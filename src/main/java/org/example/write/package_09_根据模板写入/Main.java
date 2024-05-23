package org.example.write.package_09_根据模板写入;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.*;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.example.util.PathUtil;
import org.example.write.DemoData;
import org.example.write.WriteData;
import org.example.write.package_03_指定写入的列.IndexData;
import org.example.write.package_08_超链接_备注_公式_指定单个单元格的样式_单个单元格多种样式.WriteCellDemoData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-23 14:05
 * @Version v2.0
 */
public class Main {
    public static void main(String[] args) {
        new Main().templateWrite();
    }

    /**
     * 根据模板写入
     * <p>1. 创建excel对应的实体对象 参照{@link IndexData}
     * <p>2. 使用{@link ExcelProperty}注解指定写入的列
     * <p>3. 使用withTemplate 写取模板
     * <p>4. 直接写即可
     */
    public void templateWrite() {
        String templateFileName = PathUtil.currentPath(Main.class) + "template.xlsx";
        String fileName = PathUtil.currentResource("templateWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).withTemplate(templateFileName).sheet().doWrite(WriteData.data());
    }
}
