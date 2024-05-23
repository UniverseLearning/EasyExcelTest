package org.example.write.package_05_重复多次写入;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.example.util.PathUtil;
import org.example.write.DemoData;
import org.example.write.WriteData;
import org.example.write.package_04_复杂头写入.ComplexHeadData;

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
        new Main().repeatedWrite1();
        new Main().repeatedWrite2();
        new Main().repeatedWrite3();
        new Main().repeatedWrite4();
        new Main().repeatedWrite5();
        new Main().repeatedWrite6();
    }

    /**
     * 重复多次写入
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
     * <p>
     * 2. 使用{@link ExcelProperty}注解指定复杂的头
     * <p>
     * 3. 直接调用二次写入即可
     */
    public void repeatedWrite1() {
        String fileName = PathUtil.currentResource("repeatedWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法1.1: 如果写到同一个sheet 使用 try-with-resources @since 3.1.0
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = WriteData.data();
                excelWriter.write(data, writeSheet);
            }
        }
    }
    public void repeatedWrite2() {
        String fileName = PathUtil.currentResource("repeatedWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法1.2: 如果写到同一个sheet 不使用 try-with-resources
        ExcelWriter writer = null;
        try {
            // 这里 需要指定写用哪个class去写
            writer = EasyExcel.write(fileName, DemoData.class).build();
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = WriteData.data();
                writer.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记close 会帮忙关闭流
            if (writer != null) {
                writer.close();
            }
        }
    }
    public void repeatedWrite3() {
        String fileName = PathUtil.currentResource("repeatedWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法2.1: 如果写到不同的sheet 同一个对象 使用 try-with-resources @since 3.1.0
        // 这里 指定文件
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = WriteData.data();
                excelWriter.write(data, writeSheet);
            }
        }
    }
    public void repeatedWrite4() {
        String fileName = PathUtil.currentResource("repeatedWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法2.2: 如果写到不同的sheet 同一个对象 不使用 try-with-resources
        ExcelWriter writer = null;
        try {
            // 这里 指定文件
            writer = EasyExcel.write(fileName, DemoData.class).build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = WriteData.data();
                writer.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记close 会帮忙关闭流
            if (writer != null) {
                writer.close();
            }
        }
    }
    public void repeatedWrite5() {
        String fileName = PathUtil.currentResource("repeatedWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法3.1 如果写到不同的sheet 不同的对象 使用 try-with-resources @since 3.1.0
        // 这里 指定文件
        try (ExcelWriter excelWriter = EasyExcel.write(fileName).build()) {
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class
                // 实际上可以一直变
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(DemoData.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = WriteData.data();
                excelWriter.write(data, writeSheet);
            }
        }
    }
    public void repeatedWrite6() {
        String fileName = PathUtil.currentResource("repeatedWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法3.2 如果写到不同的sheet 不同的对象 不使用 try-with-resources
        ExcelWriter writer = null;
        try {
            // 这里 指定文件
            writer = EasyExcel.write(fileName).build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class
                // 实际上可以一直变
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(DemoData.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = WriteData.data();
                writer.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记close 会帮忙关闭流
            if (writer != null) {
                writer.close();
            }
        }
    }
}
