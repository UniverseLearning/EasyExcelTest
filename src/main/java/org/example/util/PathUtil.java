package org.example.util;

import com.alibaba.excel.util.FileUtils;
import com.google.common.io.Files;
import org.example.read.package_01_最简单的读.Main;

import java.io.File;

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

    public static String currentResource(String name) {
        String rootPath = System.getProperty("user.dir");
        String dir = rootPath + "\\src\\main\\resources\\" + name + "\\";
        File folder = new File(dir);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return dir;
    }
}
