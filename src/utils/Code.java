package utils;

import com.ndktools.javamd5.Mademd5;

public class Code {
    public static String jiaMiOne(String password){
        Mademd5 md5=new Mademd5();
        return md5.toMd5(password);
    }
    public static String jiaMiPlus(String password){
        for (int j = 0; j < 5; j++) {
            password=jiaMiOne(password);
            char[] chars=password.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                char c=chars[i];
                chars[i]=chars[chars.length-i-1];
                chars[chars.length-i-1]=c;
            }
            password=String.valueOf(chars);
        }
        return password;
    }
}
