package org.example.read.package_02_指定列的下标或者列名;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-16 17:14
 * @Version v2.0
 */

import com.google.common.collect.FluentIterable;
import org.example.read.package_01_最简单的读.DemoData;

import java.util.List;

/**
 * 假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。
 **/
public class IndexOrNameDAO {
    public void save(List<DemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        FluentIterable.from(list).forEach(System.out::println);
    }
}