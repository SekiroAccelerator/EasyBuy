package service.impl;

import dao.User_AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.User_Address;
import service.User_AddressService;

import java.util.List;

@Service("user_AddressService")
public class User_AddressServiceImpl implements User_AddressService {
    @Autowired
    @Qualifier("user_AddressMapper")
    private User_AddressMapper addressMapper;

    @Override
    public List<User_Address> addressList(Integer id) {
        return addressMapper.addressList(id);
    }

    @Override
    public User_Address selectByPrimaryKey(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(User_Address record) {
        return addressMapper.insertSelective(record);
    }

    @Override
    public int updateDefault(User_Address user_address) {
        return addressMapper.updateDefault(user_address);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User_Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }
}
