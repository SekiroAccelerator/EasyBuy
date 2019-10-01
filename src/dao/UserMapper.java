package dao;

import pojo.PageBean;
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
     * 查询用户名是否存在
     * @param loginName
     * @return
     */
    int loginNameIsExist(String loginName);

    /**
     * 登录验证
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
     * 用户列表
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
     * 根据id修改头像
     * @param user
     * @return
     */
    int updatePic(User user);

}