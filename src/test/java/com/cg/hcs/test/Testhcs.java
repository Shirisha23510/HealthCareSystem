package com.cg.hcs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.dao.HealthDao;
import com.cg.hcs.dao.HealthDaoImpl;

class Testhcs {
	   
           HealthDao  healthdao=new HealthDaoImpl();
            DiagnosticCenter diagnosticCenter=new DiagnosticCenter("tesla","1000",null,null);
         
          
 
	@Test
	public void addCenter() throws Exception
	{
		
		String centerId=diagnosticCenter.getCenterId();
		int b=Integer.parseInt(centerId);
		assertTrue(b>0);
	}

}
