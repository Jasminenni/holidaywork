package com.yxl.user.server.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace="http://jasmine.com/wsdl")
public interface IUserService 
{
	@WebMethod
	public String queryRoleData();
	
	public String querysexData();
	
	public String querykmCount(String name);
	
	public String queryNamePwd(String name,String pwd);
	
	public String queryMenu();
	
	//2.ͳ��ѧ�����˼��ſ� 
	public String  queryStuKmCount();
	
}
