package org.example.util;

import org.example.read.package_01_最简单的读.Main;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-16 17:55
 * @Version v2.0
 */
public class PathUtil {

    public static String currentPath(Class<?> clazz) {
        String rootPath = System.getProperty("user.dir");
        String packName = clazz.getPackage().getName().replace("." , "\\");
        return rootPath + "\\src\\main\\java\\" + packName + "\\";
    }
}
