package com.sense.penpal.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sense.penpal.model.AdminBean;


@Repository
public class AdminDAOImpl {

	@Autowired
	 private SqlSessionTemplate sqlSession;
	
	//회원 목록(신고된 회원목록은 여기서 뽑아서 쓰면됨)
	public List<AdminBean> selectAdminmemberList(int page) throws Exception{
		List<AdminBean> memberlist =  sqlSession.selectList("Admin", page);
		return memberlist;
	}
	
	//회원 삭제
	public void memberDelete(int admin_num) throws Exception {
		sqlSession.delete("member_del", admin_num);
	}
	
	//신고된 게시물 목록
	public List<AdminBean> selectAdminmemberboardList() throws Exception{
		List<AdminBean> boardlist = sqlSession.selectList("Admin");
		return boardlist;
	}
	
	//신고된 게시물 삭제
	public void adminDelete(int admin_num) throws Exception {
		sqlSession.delete("board_del", admin_num);
	}
}
