package org.example.write.package_06_日期数字或者自定义格式转换;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import org.example.util.PathUtil;
import org.example.write.WriteData;
import org.example.write.package_04_复杂头写入.ComplexHeadData;

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
        new Main().converterWrite();
    }

    /**
     * 日期、数字或者自定义格式转换
     * <p>1. 创建excel对应的实体对象 参照{@link ConverterData}
     * <p>2. 使用{@link ExcelProperty}配合使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
     * <p>3. 直接写即可
     */
    public void converterWrite() {
        String fileName = PathUtil.currentResource("converterWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ConverterData.class).sheet("模板").doWrite(WriteData.data());
    }
}
