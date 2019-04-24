package com.example.demo.controller;

import com.example.demo.domain.bean.Result;
import com.example.demo.domain.entity.PatientEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.service.PatientEntityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 96599 on 2019/4/23.
 */
@RestController
@RequestMapping("/people")
public class HuaXiFaceController {

    @Resource
    PatientEntityService patientEntityService;



    //数据库调用测试
    @ResponseBody
    @GetMapping(value = "/get-list")
    public List<PatientEntity> GetList() {
        return patientEntityService.getAll();
    }

    //获取数据库patient 姓名+床号
    @ResponseBody
    @PostMapping(value = "/getUserList")
    public Result getList(HttpServletResponse httpServletRequest, @RequestBody PageVO vo) {

        List<PatientEntity> users = new ArrayList<>();
        if (vo.getIndex()!=0) {

//            users = patientEntityService.selectByAccountAndPager(vo.getAccount(),vo.getSize(),vo.getIndex());
            return Result.builder().setData(users);
        } else {
            //Pageable pageable =new PageRequest (vo.getIndex(), vo.getSize());
            return Result.builder().setData(patientEntityService.getTaskPage(vo.getSize(),vo.getIndex()));
        }
    }

}
