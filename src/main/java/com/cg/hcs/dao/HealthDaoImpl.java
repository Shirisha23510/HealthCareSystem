package com.cg.hcs.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.HealthException;
public class HealthDaoImpl implements HealthDao {
	private Map<String,Test> map;
private	HashMap<String,DiagnosticCenter> centerMap;

	public HealthDaoImpl()
	{
		centerMap=new HashMap<String,DiagnosticCenter>();
		/*
		DiagnosticCenter center= new DiagnosticCenter("tesla","8001", null,null);
		List<Test>list=new ArrayList<Test>();
		Test test=new Test();
		test.setTestId("1000");
		test.setTestName("blood test");
		list.add(test);
		Test test1=new Test();
		test1.setTestId("1001");
		test1.setTestName("blood group");
		list.add(test1);
		Test test2=new Test();
		test2.setTestId("1002");
		test2.setTestName("blood pressure");
		list.add(test2);
		center.setListOfTests(list);
		centerMap.put(center.getCenterId(), center);
		*/
	}
	public boolean addCenter(DiagnosticCenter center) throws HealthException 
		{
		       String centerName=center.getCenterName();
			   if(centerMap.containsKey(centerName))
			   {
				 throw new HealthException("center already exist");
			   }
			   else
			   {
				List<Test> list=new ArrayList<Test>();
				Test test=new Test();
				test.setTestId("1000");
				test.setTestName("blood test");
				list.add(test);
				Test test1=new Test();
				test1.setTestId("1001");
				test1.setTestName("blood group");
				list.add(test1);
				Test test2=new Test();
				test2.setTestId("1002");
				test2.setTestName("blood pressure");
				list.add(test2);
				center.setListOfTests(list);
				
				centerMap.put(center.getCenterId(), center);
		        }
	            return true; 
		}
	@Override
	public boolean removeCenter(DiagnosticCenter center) throws HealthException 
	{
		
		String centerId=center.getCenterId();
		boolean flag=centerMap.containsKey(centerId);
		if(flag) 
		{
			center=centerMap.remove(centerId);
		}
		
		else
		{
			throw new HealthException(centerId+"Id not found");
		}
	      return flag;
		
	}

	
	@Override
	public List<DiagnosticCenter> displaycenter() throws HealthException {
		Collection<DiagnosticCenter> col=centerMap.values();
		List<DiagnosticCenter> list=new ArrayList<DiagnosticCenter>(col);
		return list;
	}
	
	@Override
	public String addTest(String centerName, Test test) throws HealthException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeTest(Test test) throws HealthException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
