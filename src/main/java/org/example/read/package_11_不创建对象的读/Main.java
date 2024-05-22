package org.example.read.package_11_不创建对象的读;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.example.read.package_10_DataException.ReadExceptionData;
import org.example.read.package_10_DataException.ReadExceptionListener;
import org.example.util.PathUtil;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-16 17:16
 * @Version v2.0
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        new Main().noModelRead();
    }

    /**
     * 不创建对象的读
     */
    public void noModelRead() {
        String fileName = PathUtil.currentPath(Main.class) + "demo.xlsx";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
        EasyExcel.read(fileName, new NoModelDataListener()).sheet().doRead();

    }
}
