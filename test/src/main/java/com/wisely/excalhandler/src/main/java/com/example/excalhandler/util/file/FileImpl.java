package com.example.excalhandler.util.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件相关的算法实现
 */
public class FileImpl {

    /**
     * 利用文件头特征判断文件的编码方式
     *
     * @param fileName 需要处理的文件
     * @return 返回文件编码
     */
    public static String simpleEncoding(String fileName) {
        int p = 0;
        try (
                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        ) {
            p = (bin.read() << 8) + bin.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }

}