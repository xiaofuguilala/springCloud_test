package com.example.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.dao.AlModelEntityMapper;
import com.example.demo.domain.entity.AlModelEntity;
import com.example.demo.service.AlModelEnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

;

/**
 * Created by 96599 on 2018/12/28.
 */
@Service("alModelEnityService")
public class AlModelEnityServiceImpl extends ServiceImpl<AlModelEntityMapper,AlModelEntity> implements AlModelEnityService{

    @Autowired
    AlModelEntityMapper alModelEntityMapper;
    //读取模型库表中模型名称
    @Override
    public List<String> modelname(){
        List<AlModelEntity> alModelEntityList = alModelEntityMapper.selectList(null);

        List<String> nameList = alModelEntityList.stream()
                .map(entity -> entity.getModelname())
                .collect(Collectors.toList());

        return nameList;
    }


}
