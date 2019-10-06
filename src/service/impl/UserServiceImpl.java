package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.PageBean;
import pojo.User;
import service.UserService;
import utils.Code;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    /**
     * 查询用户名是否存在
     * @param loginName
     * @return
     */
    @Override
    public Integer loginNameIsExist(String loginName) {
        return userMapper.loginNameIsExist(loginName);
    }

    /**
     * 添加用户
     * @param record
     * @return
     */
    @Override
    public Integer addUser(User record){

        try {
            String MD5Password = Code.jiaMiOne(record.getPassword());
            record.setPassword(MD5Password);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return userMapper.insertSelective(record);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public Integer count() {
        return userMapper.count();
    }

    @Override
    public List<User> userList(PageBean pageBean) {
        return userMapper.userList(pageBean);
    }

    @Override
    public User userById(String id) {
        return userMapper.userById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updatePic(User user) {
        return userMapper.updatePic(user);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int yanZheng(User user) {
        return userMapper.yanZheng(user);
    }

}
