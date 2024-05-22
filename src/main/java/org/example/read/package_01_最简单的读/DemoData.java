package org.example.read.package_01_最简单的读;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-16 17:13
 * @Version v2.0
 */
@Getter
@Setter
@EqualsAndHashCode
public class DemoData {
    private String string;
    private Date date;
    private Double doubleData;
}
