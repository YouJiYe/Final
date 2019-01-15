package com.sense.penpal.dao;

import java.util.List;

import com.sense.penpal.model.LetterBean;
import com.sense.penpal.model.MemberBean;

public interface LetterService {
	
	//받는사람 아이디 체크
	public MemberBean le_toCheck(String id)throws Exception;
	
	//쪽지 저장
	public void inserletter(LetterBean letter) throws Exception; 
	
	//보낸 쪽지함의 총 갯수
	public int getfromListCount() throws Exception;
	
	//보낸 쪽지함
	public List<LetterBean> getletterFromList(String page) throws Exception;
	
	//보낸 쪽지함 - 쪽지 상세 보기
	public LetterBean getletterFromCont(int le_inx) throws Exception;
	
	//보낸 쪽지함 - 읽었을때만 카운트 증가
	public void fromHit(int le_inx) throws Exception;
	
	//받는 쪽지함의 총 쪽지 갯수
	public int gettoListCount() throws Exception;
	
	//받는 쪽지함
	public List<LetterBean> getletterToList(String page) throws Exception;
	
	//받는 쪽지함 - 쪽지 상세보기
	public LetterBean getletterToCont(int le_inx) throws Exception;
	
	//받는 쪽지함 - 받는 사람의 쪽지 답장 
	public void lettertoReply(LetterBean letterbean) throws Exception;

	//받는 쪽지함 - 쪽지 삭제
	public void lettertoDelete(int letter_num) throws Exception;
	
	//보낸 쪽지함 - 쪽지 삭제
	public void letterfromDelete(int letter_num) throws Exception;
}
