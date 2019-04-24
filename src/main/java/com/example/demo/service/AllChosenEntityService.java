package com.example.demo.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.demo.domain.entity.AllChosenEntity;
import com.example.demo.domain.vo.ReceiveBackVo;

public interface AllChosenEntityService extends IService<AllChosenEntity> {

    boolean frontbackpara1(ReceiveBackVo vo);

    boolean frontbackpara2(ReceiveBackVo vo);

    boolean frontbackpara3(ReceiveBackVo vo);

    boolean frontbackpara4(ReceiveBackVo vo);
}