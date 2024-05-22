package org.example.read.package_07_读取表头数据;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
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
        new Main().complexHeaderRead();
    }

    /**
     * 读取表头数据
     *
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ReadHeadData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link ReadHeadDataListener}
     * <p>
     * 3. 直接读即可
     */
    public void complexHeaderRead() {
        String fileName = PathUtil.currentPath(Main.class) + "ReadHeadDemo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, ReadHeadData.class, new ReadHeadDataListener()).sheet().headRowNumber(2).doRead();

    }
}
