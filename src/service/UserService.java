package service;

import pojo.User;

import java.util.List;

public interface UserService {

    User login(User user);
    List<User> userList();
}
