package org.example.write.package_08_超链接_备注_公式_指定单个单元格的样式_单个单元格多种样式;

import com.alibaba.excel.metadata.data.WriteCellData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-23 14:38
 * @Version v2.0
 */
@Getter
@Setter
@EqualsAndHashCode
public class WriteCellDemoData {
    /**
     * 超链接
     *
     * @since 3.0.0-beta1
     */
    private WriteCellData<String> hyperlink;

    /**
     * 备注
     *
     * @since 3.0.0-beta1
     */
    private WriteCellData<String> commentData;

    /**
     * 公式
     *
     * @since 3.0.0-beta1
     */
    private WriteCellData<String> formulaData;

    /**
     * 指定单元格的样式。当然样式 也可以用注解等方式。
     *
     * @since 3.0.0-beta1
     */
    private WriteCellData<String> writeCellStyle;

    /**
     * 指定一个单元格有多个样式
     *
     * @since 3.0.0-beta1
     */
    private WriteCellData<String> richText;
}
