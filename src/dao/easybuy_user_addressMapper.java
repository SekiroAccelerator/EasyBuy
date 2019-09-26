package dao;

import pojo.easybuy_user_address;

public interface easybuy_user_addressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(easybuy_user_address record);

    int insertSelective(easybuy_user_address record);

    easybuy_user_address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(easybuy_user_address record);

    int updateByPrimaryKey(easybuy_user_address record);
}