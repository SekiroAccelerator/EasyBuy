package dao;

import pojo.easybuy_user;

public interface easybuy_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(easybuy_user record);

    int insertSelective(easybuy_user record);

    easybuy_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(easybuy_user record);

    int updateByPrimaryKey(easybuy_user record);
}