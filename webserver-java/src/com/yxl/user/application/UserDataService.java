package com.yxl.user.application;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import com.yxl.user.server.impl.UserServerImpl;

//使用webservice统一发布 数据访问接口中间件
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class UserDataService
{
	public static void main(String[] args) 
	{
		System.out.println("server发布服务");
		Endpoint.publish("http://127.0.0.1:8100/userdataserver/user", new UserServerImpl());
		
		System.out.println("server端服务发布成功");
	}
}