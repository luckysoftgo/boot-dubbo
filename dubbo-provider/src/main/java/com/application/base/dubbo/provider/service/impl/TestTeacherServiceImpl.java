package com.application.base.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.application.base.common.BaseCommonMsg;
import com.application.base.common.exception.CommonException;
import com.application.base.common.page.Pagination;
import com.application.base.dubbo.api.service.TestTeacherService;
import com.application.base.dubbo.module.entity.TestTeacher;
import com.application.base.dubbo.provider.dao.TestTeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @desc TestTeacherService接口实现
 * @author admin
 */
@Service(version = "${dubbo.provider.version}",
		application = "${dubbo.application.id}",
		protocol = "${dubbo.protocol.id}",
		registry = "${dubbo.registry.id}")
@Slf4j
public class TestTeacherServiceImpl implements TestTeacherService {

	@Autowired
	private TestTeacherMapper testTeacherMapper;

	/**
	* 添加对象。
	* @param testTeacher
	* @return
	*/
	@Override
	public int saveTestTeacher(TestTeacher testTeacher){
		try {
			return testTeacherMapper.saveTestTeacher(testTeacher);
		}catch (Exception ex){
			throw new CommonException(BaseCommonMsg.ADD_DATA_TO_DB_FAIL_MSG.getCode(), BaseCommonMsg.ADD_DATA_TO_DB_FAIL_MSG.getMsg());
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
			return testTeacherMapper.updateTestTeacher(testTeacher);
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
			return testTeacherMapper.deleteTestTeacher(testTeacher);
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
			return testTeacherMapper.queryTestTeacher(param);
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
			return testTeacherMapper.queryTestTeachers(param);
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
			return testTeacherMapper.queryPageTestTeachers(param);
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
			return testTeacherMapper.totalCount(param);
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
		int count = 0;
		List<TestTeacher> list = queryPageTestTeachers(param);
		// 如果list为空则没有必须再查询总条数
		if (list != null && list.size() > 0) {
			count = totalCount(param);
		}
		Pagination<TestTeacher> pageResult = new Pagination<TestTeacher>(list, pageNo, pageSize);
		// 如果总条数为零则不需要设置初始化数值
		if (count > 0) {
			pageResult.setRowCount(count);
		}
		return pageResult;
	}
}
