package cn.gj.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.gj.model.Dep;
import cn.gj.query.DepQuery;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})
public class DepServiceTest {
	
	@Autowired
	private DepService depService;
	
	@Test
	public void testSaveDep() {
		Dep dep = new Dep();
		dep.setDepId(9);
		dep.setName("开发部");
		dep.setTel("010-8575331");
		depService.save(dep);
	}

	@Test
	public void testUpdateDep() {
		Dep dep = depService.getObj(9);
		dep.setTel("010-8129121");
		depService.update(dep);
	}

	@Test
	public void testGetDep() {
		Dep dep = depService.getObj(8);
		System.out.println(dep);
	}

	@Test
	public void testDeleteDep() {
		depService.delete(9);
	}

	@Test
	public void testQueryDepByCondition() {
		DepQuery dq = new DepQuery();
		dq.setName("采");
		//List<Dep> list = depService.queryObjByCondition(dq);
		//System.out.println(list);
	}

}
