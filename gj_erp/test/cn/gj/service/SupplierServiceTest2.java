package cn.gj.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.gj.model.Supplier;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})
public class SupplierServiceTest2 {
	
	@Autowired
	private SupplierService supplierService;
	
	@Test
	public void testSaveDep() {
		Supplier supplier = new Supplier();
		supplier.setName("naike");
		supplier.setAddress("shanghai");
		supplierService.save(supplier);
	}

	
}
