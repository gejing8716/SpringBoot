package cn.gj.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class SourceGenerator {
	public static void main(String[] args) throws Exception {
		generator("Role");
	}
	public static void generator(String className) throws Exception{
		generQuery(className);
		
		generDao(className);
		generDaoImpl(className);
		
		generService(className);
		generServiceImpl(className);
		
		generDaoConfig(className);
		generServiceConfig(className);
	}
	public static void generQuery(String ClassName) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/cn/gj/template/DemoQuery.tlf"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/gj/query/"+ClassName+"Query.java"));
		String line = null;
		String newLine = null;
		while((line = br.readLine())!= null){
			newLine = line.replace("Demo", ClassName);
			bw.write(newLine);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
	public static void generDao(String ClassName) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/cn/gj/template/DemoDao.tlf"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/gj/dao/"+ClassName+"Dao.java"));
		String line = null;
		String newLine = null;
		while((line = br.readLine())!= null){
			newLine = line.replace("Demo", ClassName);
			bw.write(newLine);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
	public static void generDaoImpl(String ClassName) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/cn/gj/template/DemoDaoImpl.tlf"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/gj/dao/impl/"+ClassName+"DaoImpl.java"));
		String line = null;
		String newLine = null;
		while((line = br.readLine())!= null){
			newLine = line.replace("Demo", ClassName);
			bw.write(newLine);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
	public static void generService(String ClassName) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/cn/gj/template/DemoService.tlf"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/gj/service/"+ClassName+"Service.java"));
		String line = null;
		String newLine = null;
		while((line = br.readLine())!= null){
			newLine = line.replace("Demo", ClassName);
			bw.write(newLine);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
	public static void generServiceImpl(String ClassName) throws Exception{
		String lowerCaseClassName = ClassName.substring(0, 1).toLowerCase()+ClassName.substring(1);
		BufferedReader br = new BufferedReader(new FileReader("config/cn/gj/template/DemoServiceImpl.tlf"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/gj/service/impl/"+ClassName+"ServiceImpl.java"));
		String line = null;
		String newLine = null;
		while((line = br.readLine())!= null){
			newLine = line.replace("Demo", ClassName).replace("demo", lowerCaseClassName);
			bw.write(newLine);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
	public static void generDaoConfig(String ClassName) throws Exception{
		String lowerCaseClassName = ClassName.substring(0, 1).toLowerCase()+ClassName.substring(1);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new FileReader("config/ApplicationContext-dao.xml"));
		Element rootElement = doc.getRootElement();
		Element newEle = rootElement.addElement("bean")
									.addAttribute("id", lowerCaseClassName+"Dao")
									.addAttribute("class", "cn.gj.dao.impl."+ClassName+"DaoImpl");
		newEle.addElement("property")
			  .addAttribute("name", "sessionFactory")
			  .addAttribute("ref", "sessionFactory");
		XMLWriter writer = new XMLWriter(new FileWriter("config/ApplicationContext-dao.xml"), OutputFormat.createPrettyPrint());
		writer.write(doc);
		writer.close();
	}
	public static void generServiceConfig(String ClassName) throws Exception{
		String lowerCaseClassName = ClassName.substring(0, 1).toLowerCase()+ClassName.substring(1);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new FileReader("config/ApplicationContext-service.xml"));
		Element rootElement = doc.getRootElement();
		Element newEle = rootElement.addElement("bean")
									.addAttribute("id", lowerCaseClassName+"Service")
									.addAttribute("class", "cn.gj.service.impl."+ClassName+"ServiceImpl");
		newEle.addElement("property")
			  .addAttribute("name", lowerCaseClassName+"Dao")
			  .addAttribute("ref", lowerCaseClassName+"Dao");
		XMLWriter writer = new XMLWriter(new FileWriter("config/ApplicationContext-service.xml"), OutputFormat.createPrettyPrint());
		writer.write(doc);
		writer.close();
	}
}
