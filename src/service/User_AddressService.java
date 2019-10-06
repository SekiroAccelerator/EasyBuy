package service;

import pojo.User_Address;

import java.util.List;

public interface User_AddressService {
    /**
     * 用户地址列表
     * @return
     */
    List<User_Address> addressList(Integer id);

    /**
     * 用户地址
     * @return
     */
    User_Address selectByPrimaryKey(Integer id);

    /**
     *新增地址
     * @param record
     * @return
     */
    int insertSelective(User_Address record);

    /**
     * 修改默认地址
     * @param user_address
     * @return
     */
    int updateDefault(User_Address user_address);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User_Address record);
}
