package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.dao.FaceRecogDetectAlEntityMapper;
import com.example.demo.domain.entity.FaceRecogDetectAlEntity;
import com.example.demo.service.FaceRecogDetectAlEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 96599 on 2018/12/28.
 */
@Service("faceRecogDetectService")
public class FaceRecogDetectAlEntityAlEntityServiceImpl extends ServiceImpl<FaceRecogDetectAlEntityMapper,FaceRecogDetectAlEntity> implements FaceRecogDetectAlEntityService {

    @Autowired
    FaceRecogDetectAlEntityMapper faceRecogDetectAlEntityMapper;

    //读取人脸识别系统检测算法表中算法名称
    @Override
    public List<String> facerecogdetectalname(){

        List<FaceRecogDetectAlEntity> faceRecogDetectAlEntityList = faceRecogDetectAlEntityMapper.selectList(null);

        List<String> nameList = faceRecogDetectAlEntityList.stream()
                .map(entity -> entity.getAlgorithmname())
                .collect(Collectors.toList());

        return nameList;
    }
}
