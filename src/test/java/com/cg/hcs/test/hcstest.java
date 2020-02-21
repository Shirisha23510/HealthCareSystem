package com.cg.hcs.test;

import com.cg.hcs.dao.HealthDao;
import com.cg.hcs.dao.HealthDaoImpl;

public class hcstest 
{
	HealthDao dao=null;
	public void setup()
	{
		dao=new HealthDaoImpl();
		
	}
	

	void removeCenter() throws Exception
	{
		
	}

}
