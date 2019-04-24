package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.bean.ResultTotal;
import com.example.demo.domain.entity.UserEntity;
import com.example.demo.domain.vo.ReceiveBackVo;
import com.example.demo.domain.vo.UserInfoVo;
import com.example.demo.domain.vo.UserListVo;
import com.example.demo.service.AlModelEnityService;
import com.example.demo.service.AllChosenEntityService;
import com.example.demo.service.FaceRecogDetectAlEntityService;
import com.example.demo.service.IUserEntityService;


import com.example.demo.system.SystemConstant;
import com.example.demo.util.TransCoding;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/api")
public class JavaController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    IUserEntityService userEntityService;

    @Resource
    FaceRecogDetectAlEntityService faceRecogDetectAlEntityService;

    @Resource
    AlModelEnityService alModelEnityService;

    @Resource
    AllChosenEntityService allChosenEntityService;


    //简写java本地服务调用
    @RequestMapping("/java-user")
    public String JavaUser() {
        return "{'username': 'java', 'password': 'java'}";
    }

    //数据库调用
    @ResponseBody
    @RequestMapping("/get-list")
    public List<UserEntity> GetList() {
        return userEntityService.getAll();
    }

    //数据库单条调用
    @ResponseBody
    @RequestMapping("/get-image")
    public String GetImage() {
        return userEntityService.getIMAGE();
    }

    //用户登录前端交互
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultTotal userLogin(@RequestBody UserInfoVo vo, HttpServletRequest request) {
        boolean result = userEntityService.login(vo);

        if (result) {
            return ResultTotal.success();
        }

        return ResultTotal.fail();
    }

    //用户注册前端交互
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultTotal userRegister(@RequestBody UserListVo vo, HttpServletRequest request){
        boolean result = userEntityService.register(vo);

        if (result){
            return ResultTotal.success();
        }
        return ResultTotal.fail();
    }

    //人脸识别系统检测算法表中算法名称
    @ResponseBody
    @RequestMapping(value = "/facerecogdetectalname", method = RequestMethod.GET)
    public List<String> faceSystemdetectalname(){
        return faceRecogDetectAlEntityService.facerecogdetectalname();
    }

    //模型库表中模型名称
    @ResponseBody
    @RequestMapping(value = "/facerecogdetectmodelname", method = RequestMethod.GET)
    public List<String> modelName(){
        return alModelEnityService.modelname();
    }

    @RequestMapping(path = "/information", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity information() {
        return new UserEntity();
    }

    //接收前端选择的人脸检测算法名称和模型名称
    @ResponseBody
    @RequestMapping(value = "/chosenback1", method = RequestMethod.POST)
    public ResultTotal chosenBack1(@RequestBody ReceiveBackVo vo, HttpServletRequest request){
        boolean result = allChosenEntityService.frontbackpara1(vo);

        if (result){
            return ResultTotal.success();
        }
        return ResultTotal.fail();
    }

    //接收前端选择的人脸对齐算法名称和模型名称
    @ResponseBody
    @RequestMapping(value = "/chosenback2", method = RequestMethod.POST)
    public ResultTotal chosenBack2(@RequestBody ReceiveBackVo vo, HttpServletRequest request){
        boolean result = allChosenEntityService.frontbackpara2(vo);

        if (result){
            return ResultTotal.success();
        }
        return ResultTotal.fail();
    }

    //接收前端选择的人脸识别算法名称和模型名称
    @ResponseBody
    @RequestMapping(value = "/chosenback3", method = RequestMethod.POST)
    public ResultTotal chosenBack3(@RequestBody ReceiveBackVo vo, HttpServletRequest request){
        boolean result = allChosenEntityService.frontbackpara3(vo);

        if (result){
            return ResultTotal.success();
        }
        return ResultTotal.fail();
    }

    //接收前端选择的人脸训练算法名称和模型名称
    @ResponseBody
    @RequestMapping(value = "/chosenback4", method = RequestMethod.POST)
    public ResultTotal chosenBack4(@RequestBody ReceiveBackVo vo, HttpServletRequest request){
        boolean result = allChosenEntityService.frontbackpara4(vo);

        if (result){
            return ResultTotal.success();
        }
        return ResultTotal.fail();
    }

    //有参调用-人脸检测
    @RequestMapping("/face-detect")
    public ResponseEntity FaceDetect(@RequestParam("files") MultipartFile[] files, String uid) {
        ResponseEntity<String> result = null;
        if (uid == null || uid.equals("")) {
            result = new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
        if (files != null && files.length != 0) {
            try {
                List<Map<String, Object>> CropListSuccess = new ArrayList<Map<String, Object>>();//接收返回码，存储预处理成功图片信息
                List<Map<String, Object>> CropListFail = new ArrayList<Map<String, Object>>();//接收返回码，存储预处理失败图片信息

                //存储预处理图片以及返回结果
                for (int i = 0; i < files.length; i++) {
                    MultipartFile mf = files[i];
                    //压缩图片
                    String filePath = UUID.randomUUID().toString() + ".jpg";
                    File mkdir = new File(SystemConstant.face_reg_temp);
                    if (!mkdir.exists() && !mkdir.isDirectory()) {
                        mkdir.mkdir();
                    } else {
                        System.out.println("目录存在");
                    }
                    File file = new File(SystemConstant.face_reg_temp, filePath);
                    Thumbnails.of(mf.getInputStream()).outputQuality(1.0).size(800, 800).toFile(file);
                    //检测人脸
                    String DecParam = "";
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j < CropListSuccess.size(); j++) {
                        if (i == CropListSuccess.size() - 1) {
                            sb.append(CropListSuccess.get(j).get("code"));//最后一位不拼接逗号
                        } else {
                            sb.append(CropListSuccess.get(j).get("code") + ",");
                        }
                    }
                    String Cropcode = TransCoding.getImageStr(file.getPath());
                    MultiValueMap<String, String> DecParamMap = new LinkedMultiValueMap<>();
                    //DecParamMap.put("uid", uid);
                    DecParamMap.add("faceImg", Cropcode);
                    String result1 = restTemplate.postForEntity("http://py-sidecar/tinyfaceDetect", DecParamMap, String.class).getBody();

                    Map decMap = JSON.parseObject(result1);
                    //JSONArray job = detect_json.getJSONArray("bean");
                    //System.out.print("-------------------------\n");
                    //System.out.print(job);

                    //String[] decresult= (String[]) decMap.get("bean");
                    String decresult = decMap.get("bean").toString();
                    String[] job = decresult.split(",");
                    for (int k = 0; k < job.length; k++) {

                        MultiValueMap<String, String> CropParam = new LinkedMultiValueMap<String, String>();//预处理参数
                        CropParam.add("faceImg", job[k]);
                        String cropresult = restTemplate.postForEntity("http://py-sidecar/faceCrop", CropParam, String.class).getBody();
                        JSONObject json = JSONObject.parseObject(cropresult);
                        System.out.print(json);
                        String status = json.get("status").toString();
                        Map<String, Object> CropMap = null;
                        switch (status) {
                            case "S0101":
                                MultiValueMap<String, String> RecognitionParam = new LinkedMultiValueMap<String, String>();//识别参数
                                RecognitionParam.add("targetImage", json.get("bean").toString());
                                //RecognitionParam.put("targetImage",	Cropcode);
                                RecognitionParam.add("threshold", "2");
                                RecognitionParam.add("uid", uid);
                                String Recognitionresult = restTemplate.postForEntity("http://py-sidecar/faceRecognitionID", RecognitionParam, String.class).getBody();
                                JSONObject Recognitionjson = JSONObject.parseObject(Recognitionresult);
                                String Recognitionstatus = Recognitionjson.get("status").toString();
                                System.out.println(Recognitionresult);
                                Map RerMap = JSON.parseObject(Recognitionresult);
                                String pensonID = RerMap.get("pensonID").toString();
                                String Rerstatus = RerMap.get("status").toString();
//                                Checkrecord cr = null;
//                                cr = new Checkrecord();
//                                cr.setImage(decresult);
//                                cr.setStatus(Rerstatus);
//                                cr.setPensonID(pensonID);
//                                cr.settargetImage(json.get("bean").toString());
//
//                                //  cr.=detect_json["people"];
//                                checkrecordService.insert(cr);


                            default:
                                CropMap = new HashMap<String, Object>();
                                CropMap.put("status", status);
                                CropMap.put("code", Cropcode);
                                CropMap.put("info", "预处理失败，预处理程序处理错误");
                                CropListFail.add(CropMap);
                                break;
                        }
                    }

                    String people = decMap.get("people").toString();


                    System.out.print("-------------------------\n");
                    System.out.println("图片中人数" + people);
                    System.out.print("-------------------------\n");

//                    Checkrecord cr = null;
//                    cr = new Checkrecord();
//                    cr.setImage(decresult);
//                    cr.setPeople(people);
//                    //  cr.=detect_json["people"];
//                    checkrecordService.insert(cr);
                    if (CropListSuccess.size() == 0) {
                        result = new ResponseEntity("照片预处理失败!", HttpStatus.BAD_REQUEST);
                    } else {
                        result = new ResponseEntity(null, HttpStatus.OK);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new ResponseEntity("人脸照片处理过程出现错误!", HttpStatus.BAD_REQUEST);
            }
        } else {
            result = new ResponseEntity("未检测到照片!", HttpStatus.BAD_REQUEST);
        }
        return result;
    }

}
