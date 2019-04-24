package com.example.demo.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.dao.AllChosenEntityMapper;
import com.example.demo.domain.entity.AllChosenEntity;
import com.example.demo.domain.vo.ReceiveBackVo;
import com.example.demo.service.AllChosenEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("allChosenEntityService")
public class AllChosenEntityServiceImpl extends ServiceImpl<AllChosenEntityMapper,AllChosenEntity> implements AllChosenEntityService{
    @Autowired
    AllChosenEntityMapper allChosenEntityMapper;

    public boolean frontbackpara1(ReceiveBackVo vo){

        System.out.println(vo.getAlbackname());

        System.out.println(vo.getModelbackname());

        return true;

    }

    public boolean frontbackpara2(ReceiveBackVo vo){

        System.out.println(vo.getAlbackname());

        System.out.println(vo.getModelbackname());

        return true;

    }

    public boolean frontbackpara3(ReceiveBackVo vo){

        System.out.println(vo.getAlbackname());

        System.out.println(vo.getModelbackname());

        return true;

    }

    public boolean frontbackpara4(ReceiveBackVo vo){

        System.out.println(vo.getAlbackname());

        System.out.println(vo.getModelbackname());

        return true;

    }
}