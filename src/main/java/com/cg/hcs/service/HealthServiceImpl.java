package com.cg.hcs.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.dao.HealthDao;
import com.cg.hcs.dao.HealthDaoImpl;
import com.cg.hcs.exception.HealthException;

public class HealthServiceImpl implements HealthService {
	private HealthDao healthDao;

	public HealthServiceImpl() {
		healthDao = new HealthDaoImpl();
	}

	public boolean addCenter(DiagnosticCenter center) throws HealthException {
		String name = center.getCenterName();
		boolean flag = name.matches("[a-zA-Z]+");
		if (!flag) {
			throw new HealthException("Center name should contain only alphabets");
		}
		Random random = new Random();
		int centerid = random.nextInt(100) + 1000;
		String s = Integer.toString(centerid);
		center.setCenterId(s);
		healthDao.addCenter(center);
		return false;
	}

	public boolean removeCenter(DiagnosticCenter center) throws HealthException {

		String centId = center.getCenterId();
		boolean flag = centId.matches("[0-9]{4}");
		if (!flag) {
			throw new HealthException("Id should be 4 digits");
		}
		return healthDao.removeCenter(center);

	}

	@Override
	public List<DiagnosticCenter> displaycenter() throws HealthException {

		return healthDao.displaycenter();
	}
}
