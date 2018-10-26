package com.application.base.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.application.base.common.BaseCommonMsg;
import com.application.base.common.exception.CommonException;
import com.application.base.common.page.Pagination;
import com.application.base.dubbo.api.service.TestStudentService;
import com.application.base.dubbo.module.entity.TestStudent;
import com.application.base.dubbo.provider.dao.TestStudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @desc TestStudentService接口实现
 * @author admin
 */
@Service(version = "${dubbo.provider.version}",
		application = "${dubbo.application.id}",
		protocol = "${dubbo.protocol.id}",
		registry = "${dubbo.registry.id}")
@Slf4j
public class TestStudentServiceImpl implements TestStudentService {

	@Autowired
	private TestStudentMapper testStudentMapper;

	/**
	* 添加对象。
	* @param testStudent
	* @return
	*/
	@Override
	public int saveTestStudent(TestStudent testStudent){
		try {
			return testStudentMapper.saveTestStudent(testStudent);
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
			return testStudentMapper.updateTestStudent(testStudent);
		}catch (Exception ex){
			ex.printStackTrace();
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
			return testStudentMapper.deleteTestStudent(testStudent);
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
			return testStudentMapper.queryTestStudent(param);
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
			return testStudentMapper.queryTestStudents(param);
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
			return testStudentMapper.queryPageTestStudents(param);
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
			return testStudentMapper.totalCount(param);
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
		int count = 0;
		List<TestStudent> list = queryPageTestStudents(param);
		// 如果list为空则没有必须再查询总条数
		if (list != null && list.size() > 0) {
			count = totalCount(param);
		}
		Pagination<TestStudent> pageResult = new Pagination<TestStudent>(list, pageNo, pageSize);
		// 如果总条数为零则不需要设置初始化数值
		if (count > 0) {
			pageResult.setRowCount(count);
		}
		return pageResult;
	}
	
	@Override
	public PageInfo<TestStudent> queryHelperPageInfo(Map<String, Object> param, int pageNo, int pageSize) {
		//将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNo, pageSize);
		List<TestStudent> list = queryTestStudents(param);
		PageInfo result = new PageInfo(list);
		return result;
	}
}
