package pojo;

import java.util.Date;

/**
 * 新闻表：存放新闻信息
 */
public class easybuy_news {
    private Integer id;   //新闻id

    private String title;  // 新闻标题

    private String content;  //新闻内容

    private Date createTime;  //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}