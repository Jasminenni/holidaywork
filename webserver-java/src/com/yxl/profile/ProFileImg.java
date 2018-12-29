package com.yxl.profile;

import java.io.FileInputStream;
import java.util.Properties;

public class ProFileImg
{
	public static   String  getImagePath()
	{
		Properties  p = new Properties();
		try
		{
			p.load(new FileInputStream("./src/appimgurl.properties"));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return p.getProperty("m_img");		
	}


}
