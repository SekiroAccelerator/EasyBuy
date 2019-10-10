package service.impl;

import dao.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.News;
import service.NewsService;

import java.util.List;
import java.util.Map;

@Transactional(rollbackFor={Exception.class})
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    @Qualifier("newsMapper")
    private NewsMapper newsMapper;

    /**
     * 查询最新的几条新闻
     * @return
     */
    public List<News> selectNews(Integer size){
        return newsMapper.selectNews(size);
    }

    /**
     * 根据title分页查询新闻信息
     * @param map
     * @return
     */
    @Override
    public List<News> selectNewsLimit(Map<String, Object> map) {
        return newsMapper.selectNewsLimit(map);
    }

    /**
     * 根据title查询新闻条数
     * @param title
     * @return
     */
    public int selectNewsCount(String title){
        return newsMapper.selectNewsCount(title);
    }

    /**
     * 根据id查询新闻信息
     * @param id
     * @return
     */
    @Override
    public News selectNewsbyId(Integer id) {
        return newsMapper.selectNewsbyId(id);
    }

    /**
     * 根据id删除新闻
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int count = 0;
        try {
            count = newsMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 添加新闻
     * @param record
     * @return
     */
    @Override
    public int insertSelective(News record) {
        int count = 0;
        try{
            count = newsMapper.insertSelective(record);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据id修改新闻
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(News record) {
        int count = 0;
        try{
            count = newsMapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
}
