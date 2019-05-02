package cn.zdxh.personnelmanage.utils;

import java.util.UUID;

/**
 * 图片上传工具类
 */
public class UploadUtils {
    public static String  getFileName(String originalName){
        //原始文件名
        //切割图片的类型
        String formatName = originalName.substring(originalName.lastIndexOf('.'), originalName.length());
        //新建文件名
        String fileName= UUID.randomUUID().toString()+formatName;
        return fileName;
    }
}
