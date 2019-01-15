package com.sense.penpal.dao;

import java.util.List;

import com.sense.penpal.model.LetterBean;
import com.sense.penpal.model.MemberBean;

public interface LetterService {
	
	//�޴»�� ���̵� üũ
	public MemberBean le_toCheck(String id)throws Exception;
	
	//���� ����
	public void inserletter(LetterBean letter) throws Exception; 
	
	//���� �������� �� ����
	public int getfromListCount() throws Exception;
	
	//���� ������
	public List<LetterBean> getletterFromList(String page) throws Exception;
	
	//���� ������ - ���� �� ����
	public LetterBean getletterFromCont(int le_inx) throws Exception;
	
	//���� ������ - �о������� ī��Ʈ ����
	public void fromHit(int le_inx) throws Exception;
	
	//�޴� �������� �� ���� ����
	public int gettoListCount() throws Exception;
	
	//�޴� ������
	public List<LetterBean> getletterToList(String page) throws Exception;
	
	//�޴� ������ - ���� �󼼺���
	public LetterBean getletterToCont(int le_inx) throws Exception;
	
	//�޴� ������ - �޴� ����� ���� ���� 
	public void lettertoReply(LetterBean letterbean) throws Exception;

	//�޴� ������ - ���� ����
	public void lettertoDelete(int letter_num) throws Exception;
	
	//���� ������ - ���� ����
	public void letterfromDelete(int letter_num) throws Exception;
}
