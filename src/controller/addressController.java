package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User_Address;
import service.User_AddressService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class addressController {
    @Resource
    private User_AddressService service;

    @RequestMapping("showAddress")
    @ResponseBody
    public List<User_Address> showAddress(@RequestParam Integer userId){
        return service.addressList(userId);
    }

    @RequestMapping("address")
    @ResponseBody
    public User_Address address(@RequestParam Integer id){
        return service.selectByPrimaryKey(id);
    }

    @RequestMapping("addAddress")
    @ResponseBody
    public boolean addAddress(User_Address user_address){
        int i = service.insertSelective(user_address);
        if (user_address.getIsDefault()!=null&&user_address.getIsDefault()==1){
            service.updateDefault(user_address);
        }
        return i>0;
    }

    @RequestMapping("isDefault")
    @ResponseBody
    public boolean isDefault(@RequestParam Integer id,@RequestParam Integer userId){
        User_Address user_address=new User_Address();
        user_address.setId(id);
        user_address.setUserId(userId);
        return service.updateDefault(user_address)>0;
    }

    @RequestMapping("updateAddress")
    @ResponseBody
    public boolean updateAddress(User_Address user_address){
        int i = service.updateByPrimaryKeySelective(user_address);
        if (user_address.getIsDefault()!=null&&user_address.getIsDefault()==1){
            service.updateDefault(user_address);
        }
        return i>0;
    }

    @RequestMapping("delAddress")
    @ResponseBody
    public boolean delAddress(Integer id){
        return service.deleteByPrimaryKey(id)>0;
    }
}
