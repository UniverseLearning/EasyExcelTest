package org.example.read.package_06_同步的返回;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.read.package_05_MultiLine.MultiLineData;
import org.example.read.package_05_MultiLine.MultiLineDataListener;
import org.example.util.PathUtil;

import java.util.List;
import java.util.Map;

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
        new Main().synchronousRead();
    }

    /**
     * 同步的返回，不推荐使用，如果数据量大会把数据放到内存里面
     */
    public void synchronousRead() {
        String fileName = PathUtil.currentPath(Main.class) + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<DemoData> list = EasyExcel.read(fileName).head(DemoData.class).sheet().doReadSync();
        for (DemoData data : list) {
            log.info("读取到数据1111111111111:{}", JSON.toJSONString(data));
        }
        // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        List<Map<Integer, String>> listMap = EasyExcel.read(fileName).sheet().doReadSync();
        for (Map<Integer, String> data : listMap) {
            // 返回每条数据的键值对 表示所在的列 和所在列的值
            log.info("读取到数据22222222222222222:{}", JSON.toJSONString(data));
        }

    }
}
