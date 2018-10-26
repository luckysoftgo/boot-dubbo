package com.application.base.dubbo.api.service;

import com.application.base.common.page.Pagination;
import com.application.base.dubbo.module.entity.TestTeacher;

import java.util.List;
import java.util.Map;


/**
*@desc TestTeacher表相关Service基础接口.
*@author admin
*/
public interface TestTeacherService {

    /**
    * 添加对象。
    * @param testTeacher
    * @return
    */
    int saveTestTeacher(TestTeacher testTeacher);

    /**
    * 修改对象
    * @param testTeacher
    * @return
    */
    int updateTestTeacher(TestTeacher testTeacher);

    /**
    * 删除对象
    * @param testTeacher
    * @return
    */
    int deleteTestTeacher(TestTeacher testTeacher);

    /**
    * 根据唯一条件查询
    * @param param
    * @return
    */
    TestTeacher queryTestTeacher(Map<String, Object> param);

    /**
    * 查询满足条件的列表
    * @param param
    * @return
    */
    List<TestTeacher> queryTestTeachers(Map<String, Object> param);

    /**
    * 分頁查询满足条件的列表
    * @param param
    * @return
    */
    List<TestTeacher> queryPageTestTeachers(Map<String, Object> param);

    /**
    * 按照条件查询总条数
    * @param param
    * @return
    */
    Integer totalCount(Map<String, Object> param);

    /**
    * 分页查询
    *@param param
    *@param pageNo
    *@param pageSize
    * @return
    */
    Pagination<TestTeacher> queryPagePagination(Map<String, Object> param, int pageNo, int pageSize);

}
