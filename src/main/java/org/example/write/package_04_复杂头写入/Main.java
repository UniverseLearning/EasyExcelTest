package org.example.write.package_04_复杂头写入;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import org.example.util.PathUtil;
import org.example.write.WriteData;

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
        new Main().complexHeadWrite();
    }

    /**
     * 复杂头写入
     * <p>1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
     * <p>2. 使用{@link ExcelProperty}注解指定复杂的头
     * <p>3. 直接写即可
     */
    public void complexHeadWrite() {
        String fileName = PathUtil.currentResource("complexHeadWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(WriteData.data());
    }
}
