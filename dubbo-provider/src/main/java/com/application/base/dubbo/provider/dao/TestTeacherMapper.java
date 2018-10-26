package com.application.base.dubbo.provider.dao;

import com.application.base.dubbo.module.entity.TestTeacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
*@desc TestTeacher表相关DAO基础接口.
*@author 孤狼.
*/
@Repository
public interface TestTeacherMapper {

    /**
    * 添加对象。
    * @param testTeacher
    * @return
    * @throws Exception
    */
    int saveTestTeacher(TestTeacher testTeacher) throws Exception;

    /**
    * 批量添加对象。
    * @param testTeachers
    * @return
    * @throws Exception
    */
    boolean saveTestTeachers(List<TestTeacher> testTeachers) throws Exception;

    /**
    * 修改对象
    * @param testTeacher
    * @return
    * @throws Exception
    */
    int updateTestTeacher(TestTeacher testTeacher) throws Exception;

    /**
    * 删除对象
    * @param testTeacher
    * @return
    * @throws Exception
    */
    int deleteTestTeacher(TestTeacher testTeacher) throws Exception;

    /**
    * 根据唯一条件查询
    * @param param
    * @return
    * @throws Exception
    */
    TestTeacher queryTestTeacher(Map<String, Object> param) throws Exception;

    /**
    * 查询满足条件的列表
    * @param param
    * @return
    * @throws Exception
    */
    List<TestTeacher> queryTestTeachers(Map<String, Object> param) throws Exception;

    /**
    * 按照条件查询总条数
    * @param param
    * @return
    * @throws Exception
    */
    Integer totalCount(Map<String, Object> param) throws Exception;

    /**
    * 分頁查询满足条件的列表
    * @param param
    * @return
    * @throws Exception
    */
    List<TestTeacher> queryPageTestTeachers(Map<String, Object> param) throws Exception;

}
