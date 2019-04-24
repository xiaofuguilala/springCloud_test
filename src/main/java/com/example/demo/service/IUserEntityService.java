package com.example.demo.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.demo.domain.entity.UserEntity;
import com.example.demo.domain.vo.UserInfoVo;
import com.example.demo.domain.vo.UserListVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserEntityService extends IService<UserEntity> {

    List<UserEntity> getAll();

    String getIMAGE();

    /**
     * 判断用户是否存在
     * @paramusername
     * @parampasswd
     * @return
     */
    boolean login(UserInfoVo vo);

    boolean register(UserListVo vo);

}