package com.cg.hcs.pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.exception.HealthException;
import com.cg.hcs.service.HealthService;
import com.cg.hcs.service.HealthServiceImpl;

public class Client {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		HealthService healthService=new HealthServiceImpl();
          	DiagnosticCenter dc=null;
		ArrayList<Test>listofTests =new ArrayList<Test>();
		int choice=0;
		Test test=new Test();
		
		while(choice!=4)
		{
		System.out.println("1.Add Center");
		System.out.println("2.Display Center");
		System.out.println("3.Add Test");
		System.out.println("4.Remove Test");
		System.out.println("5.remove center");
		System.out.println("Enter choice");
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			try
			{
			 dc=new DiagnosticCenter();
			System.out.println("Enter center name");
			scanner.nextLine();
			String centerName=scanner.nextLine();
			dc.setCenterName(centerName);
			healthService.addCenter(dc);
			String centerId=dc.getCenterId();
			System.out.println("centerid="+centerId);
			System.out.println("Center added sucesfully");
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				System.err.println(e.getMessage());
			}
			break;
		case 2:
			try
			{
				scanner.nextLine();
			List<DiagnosticCenter>l=healthService.displaycenter();
			for(DiagnosticCenter d:l)
			{
				String ci=d.getCenterId()+" "+d.getCenterName();
			
				System.out.println(ci);
				List<Test> t=d.getListOfTests();
				
				for(Test y:t)
				{
					String tid=y.getTestId();
					String tname=y.getTestName();
					System.out.println(tid+"."+tname);			
				}
		
			}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			break;
			
	case 3:
		scanner.nextLine();
	    System.out.println("Select center name");
		String centerName=scanner.nextLine();
		//String centerName= scanner.nextLine();
		//System.out.println(listofTests.add(test));
		 System.out.println("Enter test name");
		 String TestName=scanner.nextLine();
		 test=new Test();
		 
		test.setTestName(TestName);
		
		try 
		{
	
		 String sid= healthService.addTest(centerName,test);
	 System.out.println("Test Id = "+sid);
		
		}
	catch (HealthException e)
		{
		System.err.println(e.getMessage());
		}
		break;
		
		
	case 5:
		System.out.println("enter center name");
		
		String name=scanner.next();
		dc.setCenterName(name);
      try
      {
    	 healthService.removeCenter(dc);
    	 System.out.println("center deleted successfully");
      }
    catch(HealthException e)
    {
    System.err.println(e.getMessage());
    }
	break;

		
		
		
		
		
		
		
		
		
		}
		}
	}


}
