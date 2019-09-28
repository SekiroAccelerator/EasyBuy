package utils;

import com.ndktools.javamd5.Mademd5;

public class Code {
    public static String jiaMiOne(String password){
        Mademd5 md5=new Mademd5();
        return md5.toMd5(password);
    }
    public static String jiaMiPlus(String password){
        Mademd5 md5=new Mademd5();
        for (int i = 0; i < 3; i++) {
            password=md5.toMd5(password);
        }
        return password;
    }
}
