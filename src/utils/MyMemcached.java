package utils;

import net.spy.memcached.MemcachedClient;
import pojo.User;

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
            User user=new User();
            user.setUserName("小白");
            // 添加数据
            Future fo = mcc.set("runoob", 900, user);

            // 打印状态
            System.out.println("set status:" + fo.get());

            // 输出
            User user1= (User) mcc.get("runoob");
            System.out.println("runoob value in cache - " + user1.getUserName());
            mcc.delete("runoob");
            User user2=new User();
            user2.setUserName("小黑");
            // 添加
            fo = mcc.add("runoob", 900, user2);

            user1= (User) mcc.get("runoob");
            // 打印状态
            System.out.println("add status:" + fo.get());
            System.out.println("runoob value in cache - " + user1.getUserName());

            User user3=new User();
            user3.setUserName("小黄");
            // 添加新key
            fo = mcc.add("codingground", 1, user3);

            // 打印状态
            System.out.println("add status:" + fo.get());
            user1= (User) mcc.get("codingground");
            // 输出
            System.out.println("codingground value in cache - " + user1.getUserName());

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
