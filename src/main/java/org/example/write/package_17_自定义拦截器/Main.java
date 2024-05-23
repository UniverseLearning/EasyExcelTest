package org.example.write.package_17_自定义拦截器;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.example.util.PathUtil;
import org.example.write.DemoData;
import org.example.write.WriteData;
import org.example.write.package_16_自动列宽.LongestMatchColumnWidthData;

import java.util.ArrayList;
import java.util.Date;
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
        new Main().customHandlerWrite();
    }

    /**
     * 下拉，超链接等自定义拦截器（上面几点都不符合但是要对单元格进行操作的参照这个）
     * <p>
     * demo这里实现2点。1. 对第一行第一列的头超链接到:https://github.com/alibaba/easyexcel 2. 对第一列第一行和第二行的数据新增下拉框，显示 测试1 测试2
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 注册拦截器 {@link CustomCellWriteHandler} {@link CustomSheetWriteHandler}
     * <p>
     * 2. 直接写即可
     */
    public void customHandlerWrite() {
        String fileName = PathUtil.currentResource("customHandlerWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).registerWriteHandler(new CustomSheetWriteHandler())
                .registerWriteHandler(new CustomCellWriteHandler()).sheet("模板").doWrite(WriteData.data());
    }
}
