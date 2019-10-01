package service;

import pojo.PageBean;
import pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 查询用户名是否存在
     * @param loginName
     * @return
     */
    Integer loginNameIsExist(String loginName);

    /**
     * 添加用户
     * @param record
     * @return
     */
    Integer addUser(User record);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 总数
     * @return
     */
    Integer count();

    /**
     * 遍历用户列表
     * @return
     */
    List<User> userList(PageBean pageBean);

    /**
     * 根据id查用户
     * @param id
     * @return
     */
    User userById(String id);

    /**
     * 修改用户
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据id修改头像
     * @param user
     * @return
     */
    int updatePic(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
}
