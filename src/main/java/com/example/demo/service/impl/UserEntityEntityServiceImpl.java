package com.example.demo.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.dao.UserEntityMapper;
import com.example.demo.domain.entity.UserEntity;
import com.example.demo.domain.vo.UserInfoVo;
import com.example.demo.domain.vo.UserListVo;
import com.example.demo.service.IUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userEntityService")
public class UserEntityEntityServiceImpl extends ServiceImpl<UserEntityMapper, UserEntity> implements IUserEntityService {

    @Autowired
    private UserEntityMapper userEntityMapper;


    @Override
    public List<UserEntity> getAll() {
        return baseMapper.selectList(null);
    }

    //返回名字为Michael的人的email地址
    @Override
    public String getIMAGE() {
        String personname = "Michael";
        UserEntity userEntity = new UserEntity();
        userEntity.setPersonaccount(personname);
        UserEntity user = baseMapper.selectOne(userEntity);
        return user.getPersonemail();
    }

    //返回账号密码
    @Override
    public boolean login(UserInfoVo vo) {
        UserEntity user = new UserEntity();
        user.setPersonaccount(vo.getAccount());
        UserEntity userEntity = userEntityMapper.selectOne(user);

        if (userEntity == null)
        {
            return false;
        }
        return userEntity.getPersonpasswd().equals(vo.getPasswd());
    }

    //注册
    @Override
    public boolean register(UserListVo vo){

        boolean exist = false;
        UserEntity userEntity = new UserEntity();
        userEntity.setPersonaccount(vo.getAccount());
        UserEntity userEntityTemp = userEntityMapper.selectOne(userEntity);

        if (userEntityTemp == null){
            exist = true;
        }
        else return exist;

        userEntity.setPersonname(vo.getUsername())
                .setPersonaccount(vo.getAccount())
                .setPersonpasswd(vo.getPasswd())
                .setPersonemail(vo.getEmail())
                .setPersonphone(vo.getPhone())
                .setPersoncard(vo.getCard())
                .setPersonbirth(vo.getBirth())
                .setPersonsex(vo.getSex());

        baseMapper.insert(userEntity);

        return exist;
    }

}
