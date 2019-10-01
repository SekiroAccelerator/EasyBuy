package utils;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Future;

public class MyMemcached {

    //初始化连接
    static {
        try{

            // 连接本地的 Memcached 服务
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessful.");

            // 添加数据
            Future fo = mcc.set("runoob", 900, "Free Education");

            // 打印状态
            System.out.println("set status:" + fo.get());

            // 输出
            System.out.println("runoob value in cache - " + mcc.get("runoob"));

            // 添加
            fo = mcc.add("runoob", 900, "memcached");

            // 打印状态
            System.out.println("add status:" + fo.get());

            // 添加新key
            fo = mcc.add("codingground", 900, "All Free Compilers");

            // 打印状态
            System.out.println("add status:" + fo.get());

            // 输出
            System.out.println("codingground value in cache - " + mcc.get("codingground"));

            // 关闭连接
            mcc.shutdown();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }


    public static void main(String[] args) {
        MyMemcached myMemcached=new MyMemcached();
    }
}
