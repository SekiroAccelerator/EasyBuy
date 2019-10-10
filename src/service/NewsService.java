package service;

import pojo.News;

import java.util.List;
import java.util.Map;

public interface NewsService {
    /**
     * 查询最新的几条新闻
     * @return
     */
    List<News> selectNews(Integer size);

    /**
     * 根据title分页查询新闻信息
     * @param map
     * @return
     */
    List<News> selectNewsLimit(Map<String, Object> map);
    /**
     * 根据title查询新闻条数
     * @param title
     * @return
     */
    int selectNewsCount(String title);

    /**
     * 根据id查询新闻信息
     * @return
     */
    News selectNewsbyId(Integer id);

    /**
     * 根据id删除新闻
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加新闻
     * @param record
     * @return
     */
    int insertSelective(News record);

    /**
     * 根据id修改新闻
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(News record);
}
