package com.application.base.dubbo.consumer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.application.base.common.BaseCommonMsg;
import com.application.base.common.exception.CommonException;
import com.application.base.common.page.Pagination;
import com.application.base.dubbo.api.service.TestStudentService;
import com.application.base.dubbo.consumer.service.ClientTestStudentService;
import com.application.base.dubbo.module.entity.TestStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 孤狼
 * @desc:
 */
@Service
@Slf4j
public class ClientTestStudentServiceImpl implements ClientTestStudentService {
	
	@Reference(version = "${dubbo.consumer.version}",
			application = "${dubbo.application.id}")
	private TestStudentService testStudentService;
	
	/**
	 * 添加对象。
	 * @param testStudent
	 * @return
	 */
	@Override
	public int saveTestStudent(TestStudent testStudent){
		try {
			return testStudentService.saveTestStudent(testStudent);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.ADD_DATA_TO_DB_FAIL_MSG.getCode(),BaseCommonMsg.ADD_DATA_TO_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 修改对象
	 * @param testStudent
	 * @return
	 */
	@Override
	public int updateTestStudent(TestStudent testStudent){
		try {
			return testStudentService.updateTestStudent(testStudent);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.UPDATE_DATA_TO_DB_FAIL_MSG.getCode(),BaseCommonMsg.UPDATE_DATA_TO_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 删除对象
	 * @param testStudent
	 * @return
	 */
	@Override
	public int deleteTestStudent(TestStudent testStudent){
		try {
			return testStudentService.deleteTestStudent(testStudent);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.DELETE_DATA_TO_DB_FAIL_MSG.getCode(),BaseCommonMsg.DELETE_DATA_TO_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 根据唯一条件查询
	 * @param param
	 * @return
	 */
	@Override
	public TestStudent queryTestStudent(Map<String, Object> param){
		try {
			return testStudentService.queryTestStudent(param);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.SELECT_DATA_FROM_DB_FAIL_MSG.getCode(),BaseCommonMsg.SELECT_DATA_FROM_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 查询满足条件的列表
	 * @param param
	 * @return
	 */
	@Override
	public List<TestStudent> queryTestStudents(Map<String, Object> param){
		try {
			return testStudentService.queryTestStudents(param);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.SELECT_DATA_FROM_DB_FAIL_MSG.getCode(),BaseCommonMsg.SELECT_DATA_FROM_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 分頁查询满足条件的列表
	 * @param param
	 * @return
	 */
	@Override
	public List<TestStudent> queryPageTestStudents(Map<String, Object> param){
		try {
			return testStudentService.queryPageTestStudents(param);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.SELECT_DATA_FROM_DB_FAIL_MSG.getCode(),BaseCommonMsg.SELECT_DATA_FROM_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 按照条件查询总条数
	 * @param param
	 * @return
	 */
	@Override
	public Integer totalCount(Map<String, Object> param){
		try {
			return testStudentService.totalCount(param);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.QUERY_TOTAL_DATA_FAIL_MSG.getCode(),BaseCommonMsg.QUERY_TOTAL_DATA_FAIL_MSG.getMsg());
		}
	}
	
	
	/**
	 * 分页查询
	 * @param param
	 @param pageNo
	 @param pageSize
	  * @return
	 */
	@Override
	public Pagination<TestStudent> queryPagePagination(Map<String, Object> param, int pageNo, int pageSize){
		return testStudentService.queryPagePagination(param,pageNo,pageSize);
	}
	
	
	/**
	 * 分页查询
	 * @param param
	 @param pageNo
	 @param pageSize
	  * @return
	 */
	@Override
	public PageInfo<TestStudent> queryPageHelperInfo(Map<String, Object> param, int pageNo, int pageSize){
		return testStudentService.queryHelperPageInfo(param,pageNo,pageSize);
	}
}
