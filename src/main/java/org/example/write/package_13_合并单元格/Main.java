package org.example.write.package_13_合并单元格;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import org.example.util.PathUtil;
import org.example.write.DemoData;
import org.example.write.WriteData;
import org.example.write.package_11_注解形式自定义样式.DemoStyleData;

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
//        new Main().mergeWrite1();
        new Main().mergeWrite2();
    }

    /**
     * 注解形式自定义样式
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoStyleData}
     * <p>
     * 3. 直接写即可
     *
     * @since 2.2.0-beta1
     */
    public void mergeWrite1() {
        String fileName = PathUtil.currentResource("mergeWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法1 注解
        // 在DemoStyleData里面加上ContentLoopMerge注解
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoMergeData.class).sheet("模板").doWrite(WriteData.data());
    }

    public void mergeWrite2() {
        String fileName = PathUtil.currentResource("mergeWrite") + System.currentTimeMillis() + ".xlsx";
        // 方法2 自定义合并单元格策略
        // 每隔2行会合并 把eachColumn 设置成 3 也就是我们数据的长度，所以就第一列会合并。当然其他合并策略也可以自己写
        LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).registerWriteHandler(loopMergeStrategy).sheet("模板").doWrite(WriteData.data());
    }
}
