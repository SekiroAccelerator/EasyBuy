package utils;

import java.io.File;

public class DeleteFileUtil {
    /**
     * 删除单个文件
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File("D:\\Workspaces\\EasyBuyWeb\\"+fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件D:\\Workspaces\\EasyBuyWeb\\" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件D:\\Workspaces\\EasyBuyWeb\\" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：D:\\Workspaces\\EasyBuyWeb\\" + fileName + "不存在！");
            return false;
        }
    }
}
