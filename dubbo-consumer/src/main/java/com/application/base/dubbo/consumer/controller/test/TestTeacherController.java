package com.application.base.dubbo.consumer.controller.test;

import com.application.base.common.BaseStringUtil;
import com.application.base.common.page.Pagination;
import com.application.base.common.web.BaseCommController;
import com.application.base.dubbo.api.service.TestTeacherService;
import com.application.base.dubbo.consumer.service.ClientTestTeacherService;
import com.application.base.dubbo.module.entity.TestTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @desc TestTeacherController实现
 * @author 孤狼
 */
@RestController
@RequestMapping("/testTeacher")
public class TestTeacherController extends BaseCommController {

    @Autowired
    private ClientTestTeacherService testTeacherService;

    /**
    * 添加对象.
    *
    */
    @RequestMapping(value="/addTestTeacher",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void addTestTeacher(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        TestTeacher object = null;
        String resultStr = successResultJSON(object);
        printJsonWriter(response, resultStr);
    }

    /**
    * 通过主键获得对象.
    *
    */
    @RequestMapping(value="/getTestTeacherById",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void getTestTeacherById(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        Integer id = BaseStringUtil.intValue(param.get("id"));
        //根据实际情况去验证 objId 的类型的合法性。
        TestTeacher object = null;
        String resultStr = successResultJSON(object);
        printJsonWriter(response, resultStr);
    }

    /**
    * 通过UUId获得对象.
    *
    */
    @RequestMapping(value="/getTestTeacherByUUId",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void getTestTeacherByUUId(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        String uuid = BaseStringUtil.stringValue(param.get("uuid"));
        TestTeacher object = null;
        String resultStr = successResultJSON(object);
        printJsonWriter(response, resultStr);
    }

    /**
    * 通过id修改对象.
    *
    */
    @RequestMapping(value="/updateTestTeacherById",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void updateTestTeacherById(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        Integer id = BaseStringUtil.intValue(param.get("id"));
        //根据实际情况去验证 objId 的类型的合法性。
        printJsonWriter(response, successResultJSON("通过Id="+id+"修改成功"));
    }

    /**
    * 通过uuid修改对象.
    *
    */
    @RequestMapping(value="/updateTestTeacherByUUId",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void updateTestTeacherByUUId(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        String uuid = BaseStringUtil.stringValue(param.get("uuid"));
        printJsonWriter(response, successResultJSON("通过UUId="+uuid+"修改成功"));
    }

    /**
    * 通过Id删除消息
    *
    */
    @RequestMapping(value="/delTestTeacherById",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void delTestTeacherById(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        Integer id = BaseStringUtil.intValue(param.get("id"));
        //根据实际情况去验证 objId 的类型的合法性。
        printJsonWriter(response, successResultJSON("通过Id="+id+"删除成功"));
    }

    /**
    * 通过UUId删除消息
    *
    */
    @RequestMapping(value="/delTestTeacherByUUId",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void delTestTeacherByUUId(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        String uuid = BaseStringUtil.stringValue(param.get("uuid"));
        printJsonWriter(response, successResultJSON("通过UUId="+uuid+"删除成功"));
    }

    /**
    * 获得所有消息
    *
    */
    @RequestMapping(value="/getTestTeachers",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void getTestTeachers(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        printJsonWriter(response, successResultJSON(""));
    }

    /**
    * 分页获得消息
    *
    */
    @RequestMapping(value="/getTestTeachersByPage",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void getTestTeachersByPage(@RequestBody Map<String,Object> param) {
        // 根据实际情况填写.
        int pageNo = BaseStringUtil.intValue(param.get(PAGE_NO));
        int pageSize = BaseStringUtil.intValue(param.get(PAGE_SIZE));
        Pagination<TestTeacher> result = null;
        printJsonWriter(response, successResultJSON(result));
    }

}


