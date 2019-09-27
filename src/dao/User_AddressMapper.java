package dao;

import pojo.User_Address;

public interface User_AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User_Address record);

    int insertSelective(User_Address record);

    User_Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User_Address record);

    int updateByPrimaryKey(User_Address record);
}