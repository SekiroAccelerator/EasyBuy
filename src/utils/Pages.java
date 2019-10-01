package utils;

import pojo.Order;
import pojo.Product;

import java.util.List;

//Pages对象
public class Pages<T> {
    private int pageNow = 1 ;
    private int pageSize = 5 ;
    private int pageCount = 0;
    private int count = 0;
    private List<Order> list ;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int count) {
        if(count > 0){
            this.pageCount = count%pageSize == 0 ? count/pageSize : count/pageSize + 1 ;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }
}
