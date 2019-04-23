package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.dao.UserDao;
import com.example.demo.domain.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return baseMapper.selectList(null);
    }

    //返回名字为Michael的人的照片地址
    @Override
    public String getIMAGE(){
        String personname = "Michael";
        User user = baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getPersonname, personname));
        return user.getPersonimageadds();
    }

    //返回账号密码
    @Override
    public UserEntity getLogin(String username, String passwd){
        UserEntity userEntity = userDao.queryUserByNameAndPasswd(username, passwd);
        return userEntity;
    }
}
