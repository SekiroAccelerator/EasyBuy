package dao;

import pojo.easybuy_news;

public interface easybuy_newsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(easybuy_news record);

    int insertSelective(easybuy_news record);

    easybuy_news selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(easybuy_news record);

    int updateByPrimaryKey(easybuy_news record);
}