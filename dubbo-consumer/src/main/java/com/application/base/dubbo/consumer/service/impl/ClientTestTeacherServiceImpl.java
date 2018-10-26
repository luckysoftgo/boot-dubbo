package com.application.base.dubbo.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.application.base.common.BaseCommonMsg;
import com.application.base.common.exception.CommonException;
import com.application.base.common.page.Pagination;
import com.application.base.dubbo.api.service.TestTeacherService;
import com.application.base.dubbo.consumer.service.ClientTestTeacherService;
import com.application.base.dubbo.module.entity.TestTeacher;
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
public class ClientTestTeacherServiceImpl implements ClientTestTeacherService {
	
	@Reference(version = "${dubbo.consumer.version}",
			application = "${dubbo.application.id}")
	private TestTeacherService testTeacherService;
	
	/**
	 * 添加对象。
	 * @param testTeacher
	 * @return
	 */
	@Override
	public int saveTestTeacher(TestTeacher testTeacher){
		try {
			return testTeacherService.saveTestTeacher(testTeacher);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.ADD_DATA_TO_DB_FAIL_MSG.getCode(),BaseCommonMsg.ADD_DATA_TO_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 修改对象
	 * @param testTeacher
	 * @return
	 */
	@Override
	public int updateTestTeacher(TestTeacher testTeacher){
		try {
			return testTeacherService.updateTestTeacher(testTeacher);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.UPDATE_DATA_TO_DB_FAIL_MSG.getCode(),BaseCommonMsg.UPDATE_DATA_TO_DB_FAIL_MSG.getMsg());
		}
	}
	
	/**
	 * 删除对象
	 * @param testTeacher
	 * @return
	 */
	@Override
	public int deleteTestTeacher(TestTeacher testTeacher){
		try {
			return testTeacherService.deleteTestTeacher(testTeacher);
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
	public TestTeacher queryTestTeacher(Map<String, Object> param){
		try {
			return testTeacherService.queryTestTeacher(param);
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
	public List<TestTeacher> queryTestTeachers(Map<String, Object> param){
		try {
			return testTeacherService.queryTestTeachers(param);
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
	public List<TestTeacher> queryPageTestTeachers(Map<String, Object> param){
		try {
			return testTeacherService.queryPageTestTeachers(param);
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
			return testTeacherService.totalCount(param);
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
	public Pagination<TestTeacher> queryPagePagination(Map<String, Object> param, int pageNo, int pageSize){
		return testTeacherService.queryPagePagination(param,pageNo,pageSize);
	}
	
}
