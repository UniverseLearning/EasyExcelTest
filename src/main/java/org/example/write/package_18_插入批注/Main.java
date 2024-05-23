package org.example.write.package_18_插入批注;

import com.alibaba.excel.EasyExcel;
import org.example.util.PathUtil;
import org.example.write.DemoData;
import org.example.write.WriteData;
import org.example.write.package_17_自定义拦截器.CustomCellWriteHandler;
import org.example.write.package_17_自定义拦截器.CustomSheetWriteHandler;

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
        new Main().commentWrite();
    }

    /**
     * 插入批注
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 注册拦截器 {@link CommentWriteHandler}
     * <p>
     * 2. 直接写即可
     */
    public void commentWrite() {
        String fileName = PathUtil.currentResource("commentWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 这里要注意inMemory 要设置为true，才能支持批注。目前没有好的办法解决 不在内存处理批注。这个需要自己选择。
        EasyExcel.write(fileName, DemoData.class).inMemory(Boolean.TRUE).registerWriteHandler(new CommentWriteHandler())
                .sheet("模板").doWrite(WriteData.data());
    }
}
