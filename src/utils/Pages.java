package utils;

import java.util.List;

//Pages对象
public class Pages<T> {
    private int pageNow = 1 ;
    private int pageSize = 16 ;
    private int pageCount = 0;
    private int count = 0;
    private List<T> list ;

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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

