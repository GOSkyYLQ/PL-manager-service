package LightningProtection.service.imp;

import LightningProtection.mapper.UserMapper;
import LightningProtection.pojo.ta_auth_user;
import LightningProtection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    /*@Override
    public int userRegister(ta_auth_user adduser){
        return userMapper.userRegister(adduser);
    }*/

    @Override
    public boolean userLogin(String username,String password){
        List<ta_auth_user> userList = userMapper.userLogin(username,password);
        return  userList.size() != 0;
    }
}
