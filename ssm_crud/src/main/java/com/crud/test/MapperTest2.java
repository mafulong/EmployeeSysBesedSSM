package com.crud.test;

import com.crud.bean.Employee;
import com.crud.bean.EmployeeExample;
import com.crud.dao.DepartmentMapper;
import com.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试DAO层
 * @author copywang
 * 1. 导入springtest模块-pom.xml配置
 * 2. @ContextConfiguration指定spring配置文件的位置
 * 3. 直接autowired找对象
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest2 {
	@Autowired
	private DepartmentMapper dept;
	@Autowired
	private EmployeeMapper emp;
	@Autowired
	SqlSession sqlSession;
	/**
	 * 测试DepartmentMapper.xml
	 */
	@Test
	public void testprepareData() {
		String name="5d";
		EmployeeExample employeeExample=new EmployeeExample();
		EmployeeExample.Criteria criteria=employeeExample.createCriteria();
		criteria.andEmpNameLike('%'+name+'%');
		criteria.andGenderEqualTo("F");
		employeeExample.or().andEmpNameLike("79d0720");
//		employeeExample.createCriteria().andEmpNameLike('%'+name+'%');

		List<Employee> list=emp.selectByExample(employeeExample);
		System.out.println(list);
		System.out.println("\n\n");
		System.out.println(employeeExample.toString());

	}
}
