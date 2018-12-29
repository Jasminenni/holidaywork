package com.yxl.user.server.impl;

import java.util.List;

import javax.jws.WebService;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.yxl.user.dao.DB;
import com.yxl.user.model.Menu;
import com.yxl.user.model.Role;
import com.yxl.user.model.SexJabean;
import com.yxl.user.server.interfaces.IUserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(portName="userservice",serviceName="UserServiceImpl",
targetNamespace="http://jasmine.com/wsdl",
endpointInterface="com.yxl.user.server.interfaces.IUserService")
public class UserServerImpl implements IUserService
{

	@Override
	public String queryRoleData() {
		// TODO Auto-generated method stub
		
		DB db = new DB();
		List<Role> list= db.queryRoleData();
		
		JSONArray array=new JSONArray();
		for(Role role:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("id", role.getRid());
			obj.put("rname", role.getRname());
			array.add(obj);
		}

//		System.out.println("数据长度为："+list.size());
		
		System.out.println("角色表转换JSON后的数据为"+array.toString());
		return array.toString();
	}

	@Override
	public String querysexData() {
		// TODO Auto-generated method stub
		DB db = new DB();
		List<SexJabean> lists=db.querysexData();
		
		JSONArray array=new JSONArray();
		for(SexJabean sex:lists)
		{
			JSONObject obj=new JSONObject();
			obj.put("sex",sex.getSsex());
			obj.put("scount",sex.getCount());
			array.add(obj);
		}
		
		System.out.println("男女比列转换成JSON格式后的数据为"+array.toString());
		return array.toString();
	}

	@Override
	public String querykmCount(String name)
	{
		// TODO Auto-generated method stub
		
		DB db=new DB();
		String datas= db.querykmCount(name);
		
		System.out.println("科目数据："+datas);
		return datas;
	}

	@Override
	public String queryNamePwd(String name, String pwd)
	{
		// TODO Auto-generated method stub
		DB db=new DB();
		int count=db.queryNamePwd(name, pwd);
//		System.out.println(count);
		String data="";
		if(count==1)
		{
			data="登录成功";
		}
		else
		{
			data="登录失败！";
		}
		return data;
	}

	@Override
	public String queryMenu()
	{
		// TODO Auto-generated method stub
		DB db=new DB();
		List<Menu> lists = db.queryMenu();
		
		
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	
	}

	@Override
	public String queryStuKmCount()
	{
		// TODO Auto-generated method stub
		
		DB db=new DB();
		List datas=db.queryStuKmCount();
		
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(datas);
		System.out.println("---->"+strJson);
		return strJson;
	}
//	public static void main(String[] args)
//	{
//		UserServerImpl u = new UserServerImpl();
//		u.queryStuKmCount();
//	}
//	
}
