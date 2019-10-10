package dao;

import org.apache.ibatis.annotations.Param;
import pojo.News;

import java.util.List;
import java.util.Map;

public interface NewsMapper {
    /**
     * 根据id删除新闻
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param(value = "id") Integer id);

    int insert(News record);

    /**
     * 添加新闻
     * @param record
     * @return
     */
    int insertSelective(News record);

    News selectByPrimaryKey(@Param(value = "id") Integer id);

    /**
     * 根据id修改新闻
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

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
    int selectNewsCount(@Param(value = "title") String title);

    /**
     * 根据id查询新闻信息
     * @return
     */
    News selectNewsbyId(@Param(value = "id") Integer id);
}