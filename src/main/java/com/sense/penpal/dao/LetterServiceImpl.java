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
	 
	//받는 사람 아이디 체크하는거
	public MemberBean le_toCheck(String id) throws Exception {
			return letterdao.le_toCheck(id);
	}
	 
	//쪽지 저장
	public void inserletter(LetterBean letter) throws Exception {
		letterdao.insertletter(letter);
	}

	//보낸 쪽지함의 총 쪽지 갯수
	public int getfromListCount() {
		return letterdao.getfromListCount();
	}
	
	//보낸 쪽지함 목록
	public List<LetterBean> getletterFromList(String id) throws Exception {
		return letterdao.getLetterFromList(id);
	}

	//보낸 쪽지함 상세보기 - 쪽지 보기
	public LetterBean getletterFromCont(int le_inx) throws Exception {
		return letterdao.getletterFromCont(le_inx);
	}

	////보낸 쪽지함 - 읽었을때만 카운트 증가
	public void fromHit(int le_inx) throws Exception{
		letterdao.fromHit(le_inx);
	}
	
	//받는 쪽지함의 총 쪽지 갯수
	public int gettoListCount() {
		return letterdao.gettoListCount();
	}
	
	//받은 쪽지함 목록
	public List<LetterBean> getletterToList(String id) throws Exception {
		return letterdao.getLetterToList(id);
	}
	
	//받는 쪽지함 - 쪽지 상세보기
	public LetterBean getletterToCont(int le_inx) throws Exception {
		return letterdao.getletterToCont(le_inx);
	}
	
	//받은 사람이 보낸사람에게 쪽지 답장
	public void lettertoReply(LetterBean letterbean) throws Exception {
		letterdao.lettertoReply(letterbean);
	}

	//받은 사람의 쪽지 삭제
	public void lettertoDelete(int letter_num) throws Exception {
	}
	
	//보낸 사람의 쪽지 삭제
	public void letterfromDelete(int letter_num) throws Exception {
	
	}
}
