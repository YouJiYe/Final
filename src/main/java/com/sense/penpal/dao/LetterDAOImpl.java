package com.sense.penpal.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sense.penpal.model.LetterBean;
import com.sense.penpal.model.MemberBean;

@Repository
public class LetterDAOImpl {                  

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//���� ����
	public void insertletter(LetterBean letterbean) throws Exception {
		sqlSession.insert("letter_insert",letterbean);
	}
	
	//���� �������� �� ������ ����
	public int getfromListCount() {
		int fromcount = ((Integer) sqlSession.selectOne("letter_fromcount")).intValue();
		return fromcount;
	}
	
	//���� ������
	public List<LetterBean> getLetterFromList(String id) throws Exception{
		List<LetterBean> fromlist = sqlSession.selectList("letter_fromlist", id);
		return fromlist;
	}
	
	//���� ������ - ���� ���� ����
	public LetterBean getletterFromCont(int le_inx) throws Exception {
		return (LetterBean) sqlSession.selectOne("letter_fromcont", le_inx);
	}
	
	//���� ������ - �о������� ī��Ʈ ����
	public void fromHit(int le_inx)throws Exception{
		sqlSession.update("from_Hit", le_inx);
	}
	
	//�޴� �������� ������ �� ����
	public int gettoListCount() {
		int tocount = ((Integer) sqlSession.selectOne("letter_tocount")).intValue();
		return tocount;
	}
	
	//���� ������
	public List<LetterBean> getLetterToList(String id) throws Exception{
		List<LetterBean> tolist = sqlSession.selectList("letter_tolist", id);
		return tolist;
	}
	
	//�޴� ������ - ���� �� ����
	public LetterBean getletterToCont(int le_inx) throws Exception {
		return (LetterBean) sqlSession.selectOne("letter_tocont", le_inx);
	}
	
	//�޴� ����� ���� ����
	public void lettertoReply(LetterBean letterbean) throws Exception {
		sqlSession.insert("letter_toreply",letterbean);
	}
	
	//�޴� ����� ���� ����
	public void lettertoDelete(int letter_num) throws Exception {
		sqlSession.delete("letter_todel", letter_num);
	}
	
	//���� ����� ���� ����
	public void letterfromDelete(int letter_num) throws Exception {
		sqlSession.delete("letter_fromdel", letter_num);
	}

	//�޴� ����� ���̵� üũ
	public MemberBean le_toCheck(String id) {
		MemberBean result= sqlSession.selectOne("id_check", id);
		return result;
	}
}
