package com.sense.penpal.dao;

import java.util.List;

import com.sense.penpal.model.AdminBean;


public interface AdminService {

	//�Ű�� ȸ�� ���
	public List<AdminBean> getadminmemberlist(int page) throws Exception;
	
	//ȸ������
	public void memberDelete(int letter_num) throws Exception;
	
	//�Ű�� �Խù� ���
	public List<AdminBean> getadminboardlist(int page) throws Exception;
	
	//�Խù� ����
	public void boardDelete(int letter_num) throws Exception;
}
