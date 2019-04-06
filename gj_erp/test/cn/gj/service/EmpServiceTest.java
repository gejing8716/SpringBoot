package cn.gj.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.gj.model.Emp;
import cn.gj.query.EmpQuery;
import cn.gj.utils.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})
public class EmpServiceTest {
	@Autowired
	private EmpService empService;
	@Test
	public void testSaveEmp() {
		Emp emp = new Emp();
		emp.setAddress("北京");
		emp.setBirthday(new Date());
		emp.setEmail("renliangge@126.com");
		emp.setGender(1);
		emp.setName("任亮");
		emp.setPassword("123");
		emp.setTel("9999");
		emp.setUsername("renliang");
		empService.save(emp);
	}

	@Test
	public void testUpdateEmp() {
		Emp emp = empService.getObj(9);
		emp.setUsername("rl");
		empService.update(emp);
	}

	@Test
	public void testGetEmp() {
		Emp emp = empService.getObj(9);
		System.out.println(emp);
	}

	@Test
	public void testDeleteEmp() {
		empService.delete(9);
	}

	@Test
	public void testQueryEmpByCondition() {
		EmpQuery empQuery = new EmpQuery();
		empQuery.setPageNo(1);
		/*empQuery.setUsername("a");
		empQuery.setGender(1);*/
		ArrayList<String> exclude = new ArrayList<String>();
		exclude.add("pageNo");
		exclude.add("startNum");
		Page page = empService.queryObjByCondition(empQuery, exclude);
		System.out.println(page);
	}

}
