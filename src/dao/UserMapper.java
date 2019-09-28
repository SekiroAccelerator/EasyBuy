package dao;

import pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登录验证
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户列表
     * @return
     */
    List<User> userList();
}