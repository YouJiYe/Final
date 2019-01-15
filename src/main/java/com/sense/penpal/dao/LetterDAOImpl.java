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
	
	//쪽지 저장
	public void insertletter(LetterBean letterbean) throws Exception {
		sqlSession.insert("letter_insert",letterbean);
	}
	
	//보낸 쪽지함의 총 쪽지의 갯수
	public int getfromListCount() {
		int fromcount = ((Integer) sqlSession.selectOne("letter_fromcount")).intValue();
		return fromcount;
	}
	
	//보낸 쪽지함
	public List<LetterBean> getLetterFromList(String id) throws Exception{
		List<LetterBean> fromlist = sqlSession.selectList("letter_fromlist", id);
		return fromlist;
	}
	
	//보낸 쪽지함 - 쪽지 내용 보기
	public LetterBean getletterFromCont(int le_inx) throws Exception {
		return (LetterBean) sqlSession.selectOne("letter_fromcont", le_inx);
	}
	
	//보낸 쪽지함 - 읽었을때만 카운트 증가
	public void fromHit(int le_inx)throws Exception{
		sqlSession.update("from_Hit", le_inx);
	}
	
	//받는 쪽지함의 쪽지의 총 갯수
	public int gettoListCount() {
		int tocount = ((Integer) sqlSession.selectOne("letter_tocount")).intValue();
		return tocount;
	}
	
	//받은 쪽지함
	public List<LetterBean> getLetterToList(String id) throws Exception{
		List<LetterBean> tolist = sqlSession.selectList("letter_tolist", id);
		return tolist;
	}
	
	//받는 쪽지함 - 쪽지 상세 보기
	public LetterBean getletterToCont(int le_inx) throws Exception {
		return (LetterBean) sqlSession.selectOne("letter_tocont", le_inx);
	}
	
	//받는 사람의 쪽지 답장
	public void lettertoReply(LetterBean letterbean) throws Exception {
		sqlSession.insert("letter_toreply",letterbean);
	}
	
	//받는 사람의 쪽지 삭제
	public void lettertoDelete(int letter_num) throws Exception {
		sqlSession.delete("letter_todel", letter_num);
	}
	
	//보낸 사람의 쪽지 삭제
	public void letterfromDelete(int letter_num) throws Exception {
		sqlSession.delete("letter_fromdel", letter_num);
	}

	//받는 사람의 아이디 체크
	public MemberBean le_toCheck(String id) {
		MemberBean result= sqlSession.selectOne("id_check", id);
		return result;
	}
}
