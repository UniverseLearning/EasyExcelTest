package org.example.write.package_21_web中的写;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import org.example.util.PathUtil;
import org.example.write.package_19_可变标题处理.ConverterData;

import java.io.IOException;
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
//
//    /**
//     * 文件下载（失败了会返回一个有部分数据的Excel）
//     * <p>
//     * 1. 创建excel对应的实体对象 参照{@link DownloadData}
//     * <p>
//     * 2. 设置返回的 参数
//     * <p>
//     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
//     */
//    @GetMapping("download")
//    public void download(HttpServletResponse response) throws IOException {
//        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        response.setCharacterEncoding("utf-8");
//        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
//        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
//    }
}
