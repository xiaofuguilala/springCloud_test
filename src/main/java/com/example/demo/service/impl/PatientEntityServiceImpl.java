package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.dao.PatientEntityMapper;
import com.example.demo.domain.entity.PatientEntity;
import com.example.demo.service.PatientEntityService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 96599 on 2019/4/23.
 */
@Service("patientEntityService")
public class PatientEntityServiceImpl  extends ServiceImpl<PatientEntityMapper, PatientEntity> implements PatientEntityService{

    @Autowired
    private PatientEntityMapper patientEntityMapper;

    @Override
    public List<PatientEntity> getAll(){
        return baseMapper.selectList(null);
    }

    @Override
    public List<PatientEntity> selectByAccountAndPager(String account, int pageSize, int currentPage){
        List<PatientEntity> userList = patientEntityMapper.selectPage(
                new RowBounds((currentPage - 1) * pageSize, pageSize),
                new EntityWrapper<PatientEntity>().eq("account", account)
        );
        List<PatientEntity> userListDto = new ArrayList<>();
        if (userList != null && userList.size() > 0) {
            for(PatientEntity user:userList) {
                userListDto.add(user);
            }
        }
        return userListDto;
    }


    public List<PatientEntity> getTaskPage( int pageSize, int currentPage){
        List<PatientEntity> userList = patientEntityMapper.selectPage(
                new RowBounds((currentPage - 1) * pageSize, pageSize),
                new EntityWrapper<PatientEntity>()
        );
        if(userList != null || userList.size()>0){
            return userList;
        }else {
            return null;
        }
    }

}
