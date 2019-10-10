package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.News;
import service.NewsService;
import utils.Pages;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新闻控制器
 */
@Controller
public class NewsController {
    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    /**
     * 查询最新的几条新闻
     * @return
     */
    @RequestMapping("/selectNews")
    @ResponseBody
    public List<News> selectNews(){
        Integer size = 8;
        return newsService.selectNews(size);
    }

    /**
     * 根据title分页查询新闻信息(显示最新的)
     * @return
     */
    @RequestMapping("/selectNewsLimit")
    @ResponseBody
    public Pages<News> selectNewsLimit(Integer pageNow,String title){
        Map<String,Object> map = new HashMap<String,Object>();
        Pages<News> pages = new Pages<News>();
        pages.setPageSize(12);

        int count = newsService.selectNewsCount(title);
        pages.setCount(count);
        pages.setPageCount(pages.getCount());
        if (pageNow>pages.getPageCount()&&pages.getPageCount()>0){
            pages.setPageNow(pages.getPageCount());
        }else if (pageNow<1){
            pages.setPageNow(1);
        }else {
            pages.setPageNow(pageNow);
        }

        map.put("title",title);
        map.put("pageStart",(pages.getPageNow()-1)*pages.getPageSize());
        map.put("pageSize",pages.getPageSize());

        pages.setList(newsService.selectNewsLimit(map));
        return pages;
    }

    /**
     * 根据id查询新闻信息
     * @param id
     * @return
     */
    @RequestMapping("/selectNewsbyId")
    @ResponseBody
    public News selectNewsbyId(Integer id){
        return newsService.selectNewsbyId(id);
    }

    /**
     * 根据id删除新闻
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public int deleteByPrimaryKey(Integer id){
        return newsService.deleteByPrimaryKey(id);
    }

    /**
     * 添加新闻
     * @param record
     * @return
     */
    @RequestMapping("/insertSelective")
    @ResponseBody
    public int insertSelective(News record){
        record.setCreateTime(new Date());
        return newsService.insertSelective(record);
    }

    /**
     * 根据id修改新闻
     * @param record
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public int updateByPrimaryKeySelective(News record){
        return newsService.updateByPrimaryKeySelective(record);
    }
}
