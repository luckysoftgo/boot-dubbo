package com.application.base.dubbo.provider.dao;

import com.application.base.dubbo.module.entity.TestStudent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
*@desc TestStudent表相关DAO基础接口.
*@author 孤狼.
*/
@Repository
public interface TestStudentMapper {

    /**
    * 添加对象。
    * @param testStudent
    * @return
    * @throws Exception
    */
    int saveTestStudent(TestStudent testStudent) throws Exception;

    /**
    * 批量添加对象。
    * @param testStudents
    * @return
    * @throws Exception
    */
    boolean saveTestStudents(List<TestStudent> testStudents) throws Exception;

    /**
    * 修改对象
    * @param testStudent
    * @return
    * @throws Exception
    */
    int updateTestStudent(TestStudent testStudent) throws Exception;

    /**
    * 删除对象
    * @param testStudent
    * @return
    * @throws Exception
    */
    int deleteTestStudent(TestStudent testStudent) throws Exception;

    /**
    * 根据唯一条件查询
    * @param param
    * @return
    * @throws Exception
    */
    TestStudent queryTestStudent(Map<String, Object> param) throws Exception;

    /**
    * 查询满足条件的列表
    * @param param
    * @return
    * @throws Exception
    */
    List<TestStudent> queryTestStudents(Map<String, Object> param) throws Exception;

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
    List<TestStudent> queryPageTestStudents(Map<String, Object> param) throws Exception;

}
