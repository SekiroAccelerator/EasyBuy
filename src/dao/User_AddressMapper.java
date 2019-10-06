package dao;

import pojo.User_Address;

import java.util.List;

public interface User_AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User_Address record);

    int insertSelective(User_Address record);

    User_Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User_Address record);

    int updateByPrimaryKey(User_Address record);

    /**
     * 用户地址列表
     * @return
     */
    List<User_Address> addressList(Integer id);

    /**
     * 修改默认地址
     * @param user_address
     * @return
     */
    int updateDefault(User_Address user_address);
}