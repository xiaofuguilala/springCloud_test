package com.example.demo.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.demo.domain.entity.PatientEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 96599 on 2019/4/23.
 */
@Service
public interface PatientEntityService extends IService<PatientEntity> {
    List<PatientEntity> getAll();

   // String getIMAGE();
   List<PatientEntity> selectByAccountAndPager(String account, int pageSize, int currentPage);

    /**
     * 获取整个列表的值
     * @param pageSize
     * @param currentPage
     * @return
     */
    List<PatientEntity> getTaskPage( int pageSize, int currentPage);
}
