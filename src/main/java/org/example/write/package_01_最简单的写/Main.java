package org.example.write.package_01_最简单的写;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.example.util.PathUtil;
import org.example.write.DemoData;
import org.example.write.WriteData;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-23 13:47
 * @Version v2.0
 */
public class Main {

    public static void main(String[] args) {
//        new Main().simpleWrite1();
        new Main().simpleWrite2();
        new Main().simpleWrite3();
        new Main().simpleWrite4();
    }

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 直接写即可
     *
     *  注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入
     */
    public void simpleWrite1() {
        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = PathUtil.currentResource("simpleWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return WriteData.data();
                });

    }
    public void simpleWrite2() {
        String fileName = PathUtil.currentResource("simpleWrite") + System.currentTimeMillis() + ".xlsx";

        // 写法2
        fileName = PathUtil.currentResource("simpleWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(WriteData.data());

    }
    public void simpleWrite3() {
        String fileName = PathUtil.currentResource("simpleWrite") + System.currentTimeMillis() + ".xlsx";

        // 写法3:使用 try-with-resources @since 3.1.0
        fileName = PathUtil.currentResource("simpleWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(WriteData.data(), writeSheet);
        }
    }
    public void simpleWrite4() {
        String fileName = PathUtil.currentResource("simpleWrite") + System.currentTimeMillis() + ".xlsx";

        // 写法4: 不使用 try-with-resources
        fileName = PathUtil.currentResource("simpleWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(WriteData.data(), writeSheet);
        } finally {
            // 千万别忘记close 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.close();
            }
        }
    }
}
