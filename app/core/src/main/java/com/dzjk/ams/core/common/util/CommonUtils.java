package com.dzjk.ams.core.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by daixiaohu on 2018/3/6.
 */
public class CommonUtils {
    /**
     * 生成32位随机数
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 数据写入文件
     * @param rows
     * @param filePath
     * @param fileName
     * @return
     */
    public static boolean createTxtFile(List<String> rows, String filePath, String fileName) {
        boolean flag = true;
        try {
            String fullPath = filePath + fileName + ".txt";
            File file = new File(fullPath);
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file = new File(fullPath);
            file.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(rows);
            oos.close();

       /*     FileWriter out = new FileWriter("D:\\1.txt", true);
            out.write("abc");
            out.write("\r\n");
            out.write("def");
            out.flush();
            out.close();*/


        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean  checkNum(String text) {
        Pattern patternSfzhm1 = Pattern
                .compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        Pattern patternSfzhm2 = Pattern
                .compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        Matcher matcherSfzhm1 = patternSfzhm1.matcher(text);
        Matcher matcherSfzhm2 = patternSfzhm2.matcher(text);
        if(!matcherSfzhm1.find() && !matcherSfzhm2.find())
            return false;
        else return true;

    }

    /**
     * 判断文件是否存在,如不存在,则创建
     * @param file
     */
    public static void judeDirExists(File file) {

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("dir exists");
            }
        } else {
            file.mkdir();
        }

    }

    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

}
