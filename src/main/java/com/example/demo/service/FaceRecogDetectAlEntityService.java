package com.example.demo.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.demo.domain.entity.FaceRecogDetectAlEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 96599 on 2018/12/28.
 */
@Service
public interface FaceRecogDetectAlEntityService extends IService<FaceRecogDetectAlEntity> {

    List<String> facerecogdetectalname();
}
