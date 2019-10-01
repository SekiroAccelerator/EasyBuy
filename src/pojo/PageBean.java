package pojo;

import java.util.List;

public class PageBean {
    private Integer count=0;
    private Integer page=1;
    private Integer pageNo=0;
    private Integer pageCount=1;
    private Integer pageSize =12;
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        if (count>0){
            this.count = count;
            if (this.count%this.pageSize==0){
                this.pageCount=this.count/this.pageSize;
            }else{
                this.pageCount=this.count/this.pageSize+1;
            }
        }
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page>0&&page<=pageCount){
            this.page = page;
        }else if (page>pageCount){
            this.page=pageCount;
        }else {
            this.page=1;
        }
        if (this.page>1){
            this.pageNo =(this.page-1)*pageSize;
        }
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
