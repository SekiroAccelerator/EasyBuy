package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }
}
