package com.sense.penpal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sense.penpal.model.AdminBean;


@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAOImpl adminDAO;

	@Override
	public List<AdminBean> getadminmemberlist(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberDelete(int letter_num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdminBean> getadminboardlist(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardDelete(int letter_num) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
