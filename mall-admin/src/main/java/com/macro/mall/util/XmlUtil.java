package com.macro.mall.util;

import com.macro.mall.dto.OilDemo;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: XmlUtil
 * @description: 解析xml工具
 * @author: gjm
 * @date: 2020-07-26 16 08
 **/
public class XmlUtil {

	/**
	 * 解析XML文件为对象集合
	 * InputStream Is为Xml文件流
	 * @return
	 */
	public static List<OilDemo> XMLToList(InputStream Is)throws Exception{
		SAXReader saxReader=new SAXReader();
		Document doc=saxReader.read(Is);
		//获取根元素
		Element root=doc.getRootElement();
		//获取集合元素
		List<Element> orders=root.elements("wellInfo");
		List<OilDemo> list=new ArrayList<OilDemo>();
		//遍历出集合元素的值
		for(Element e:orders){
			OilDemo oilDemo=new OilDemo();
			//这里只解析需要的字段组装实体类
			oilDemo.setWellId(e.elementText("well_id"));
			oilDemo.setWellPurpose(e.elementText("well_purpose"));
			oilDemo.setUpdateDate(e.elementText("update_date"));
			list.add(oilDemo);
		}
		return list;
	}


	public static void main(String[] args) throws Exception{
		File file=new File("C:\\Users\\xiaoguo\\Music\\gitwork\\jianzhi\\毕业设计\\池11井区.xml");
		FileInputStream fis=new FileInputStream(file);
		List<OilDemo> list=XMLToList(fis);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getWellId());
			System.out.println(list.get(i).getWellPurpose());
			System.out.println(list.get(i).getUpdateDate());
		}
	}
}
