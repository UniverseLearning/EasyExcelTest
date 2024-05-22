package org.example.read.package_03_读多个sheet;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import lombok.extern.slf4j.Slf4j;
import org.example.read.package_01_最简单的读.DemoData;
import org.example.read.package_01_最简单的读.DemoDataListener;
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
//        new Main().repeatedRead();
//        new Main().repeatedRead1();
        new Main().repeatedRead2();
    }

    /**
     * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>
     * 3. 直接读即可
     */
    public void repeatedRead() {
        String fileName = PathUtil.currentPath(Main.class) + "RepeatedReadDemo.xlsx";
        // 读取全部sheet
        // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
        EasyExcel.read(fileName, SheetCommonData.class, new SheetCommonDataListener()).doReadAll();

    }
    public void repeatedRead1() {
        String fileName = PathUtil.currentPath(Main.class) + "RepeatedReadDemo.xlsx";

        // 写法1： 使用 try-with-resources @since 3.1.0
        try (ExcelReader excelReader = EasyExcel.read(fileName).build()) {
            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
            ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(SheetOneData.class).registerReadListener(new SheetOneDataListener()).build();
            ReadSheet readSheet2 =
                    EasyExcel.readSheet(1).head(SheetTwoData.class).registerReadListener(new SheetTwoDataListener()).build();
            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            excelReader.read(readSheet1, readSheet2);
        }

    }
    public void repeatedRead2() {
        String fileName = PathUtil.currentPath(Main.class) + "RepeatedReadDemo.xlsx";

        // 写法2： 不使用 try-with-resources
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(fileName).build();

            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
            ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(SheetOneData.class).registerReadListener(new SheetOneDataListener()).build();
            ReadSheet readSheet2 =
                    EasyExcel.readSheet(1).head(SheetTwoData.class).registerReadListener(new SheetTwoDataListener()).build();
            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            excelReader.read(readSheet1, readSheet2);
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.close();
            }
        }

    }
}
