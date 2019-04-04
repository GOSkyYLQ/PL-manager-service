package LightningProtection.service;

import LightningProtection.pojo.ta_auth_user;

public interface UserService {
    //int userRegister(ta_auth_user adduser);
    boolean userLogin(String username,String password);
}
