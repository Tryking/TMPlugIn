package com.tryking.tmplugin.utils;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作工具类
 *
 * @author dengkaiting
 * @date 2017/8/27
 */
public class FileUtil {
    /**
     * 判断当前SD卡是否可以使用
     *
     * @return 可用：true
     */
    public static boolean isExternalStorageAvailable() {
        boolean mExternalStorageAvailable;
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            mExternalStorageAvailable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            mExternalStorageAvailable = true;
        } else {
            mExternalStorageAvailable = false;
        }
        return mExternalStorageAvailable;
    }

    /**
     * 获取给定SD卡路径下的所有文件
     *
     * @param
     * @return
     */
    public static List<String> getFileNames(List fileNames) {
//        File sdDir = Environment.getExternalStorageDirectory();
//        File file = new File(sdDir +"/"+ path);
        File sdDir = Environment.getDataDirectory();
        File file = sdDir;
//        List<String> fileNames = new ArrayList<>();
        if (file == null) {
            return null;
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                if (file.isFile()) {
                    String name = f.getName();
                    fileNames.add(name);
                }else {
                   getFileNames(fileNames);
                }
            }
        }
        return fileNames;
    }
}