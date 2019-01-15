package com.sense.penpal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sense.penpal.model.LetterBean;
import com.sense.penpal.model.MemberBean;


@Service("letterService")
public class LetterServiceImpl implements LetterService{

	 @Autowired
	 private LetterDAOImpl letterdao;
	 
	//�޴� ��� ���̵� üũ�ϴ°�
	public MemberBean le_toCheck(String id) throws Exception {
			return letterdao.le_toCheck(id);
	}
	 
	//���� ����
	public void inserletter(LetterBean letter) throws Exception {
		letterdao.insertletter(letter);
	}

	//���� �������� �� ���� ����
	public int getfromListCount() {
		return letterdao.getfromListCount();
	}
	
	//���� ������ ���
	public List<LetterBean> getletterFromList(String id) throws Exception {
		return letterdao.getLetterFromList(id);
	}

	//���� ������ �󼼺��� - ���� ����
	public LetterBean getletterFromCont(int le_inx) throws Exception {
		return letterdao.getletterFromCont(le_inx);
	}

	////���� ������ - �о������� ī��Ʈ ����
	public void fromHit(int le_inx) throws Exception{
		letterdao.fromHit(le_inx);
	}
	
	//�޴� �������� �� ���� ����
	public int gettoListCount() {
		return letterdao.gettoListCount();
	}
	
	//���� ������ ���
	public List<LetterBean> getletterToList(String id) throws Exception {
		return letterdao.getLetterToList(id);
	}
	
	//�޴� ������ - ���� �󼼺���
	public LetterBean getletterToCont(int le_inx) throws Exception {
		return letterdao.getletterToCont(le_inx);
	}
	
	//���� ����� ����������� ���� ����
	public void lettertoReply(LetterBean letterbean) throws Exception {
		letterdao.lettertoReply(letterbean);
	}

	//���� ����� ���� ����
	public void lettertoDelete(int letter_num) throws Exception {
	}
	
	//���� ����� ���� ����
	public void letterfromDelete(int letter_num) throws Exception {
	
	}
}
