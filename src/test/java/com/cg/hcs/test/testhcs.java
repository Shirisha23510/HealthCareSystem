package com.cg.hcs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.dao.HealthDao;
import com.cg.hcs.dao.HealthDaoImpl;

class testhcs {
	
	
	HealthDao dao=null;
	public void setup()
	{
		dao=new HealthDaoImpl();
		
	}

	@Test
	void testremoveCenter() throws Exception
	{
		DiagnosticCenter center=new DiagnosticCenter();
	  center.setCenterName("tesla");
	  dao.removeCenter(center);
	  boolean g=dao.removeCenter(center);
	  assertTrue(g==true);
	  
	  
	}

}
