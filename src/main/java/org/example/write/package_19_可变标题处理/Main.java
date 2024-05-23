package org.example.write.package_19_可变标题处理;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import org.example.util.PathUtil;
import org.example.write.DemoData;
import org.example.write.WriteData;
import org.example.write.package_18_插入批注.CommentWriteHandler;

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
        new Main().variableTitleWrite();
    }

    /**
     * 可变标题处理(包括标题国际化等)
     * <p>
     * 简单的说用List<List<String>>的标题 但是还支持注解
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ConverterData}
     * <p>
     * 2. 直接写即可
     */
    public void variableTitleWrite() {
        String fileName = PathUtil.currentResource("variableTitleWrite") + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ConverterData.class).head(variableTitleHead()).sheet("模板").doWrite(WriteData.data());
    }

    private List<List<String>> variableTitleHead() {
        List<List<String>> list = ListUtils.newArrayList();
        List<String> head0 = ListUtils.newArrayList();
        head0.add("string" + System.currentTimeMillis());
        List<String> head1 = ListUtils.newArrayList();
        head1.add("number" + System.currentTimeMillis());
        List<String> head2 = ListUtils.newArrayList();
        head2.add("date" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }
}
