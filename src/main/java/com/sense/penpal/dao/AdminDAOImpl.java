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
	
	//ȸ�� ���(�Ű�� ȸ������� ���⼭ �̾Ƽ� �����)
	public List<AdminBean> selectAdminmemberList(int page) throws Exception{
		List<AdminBean> memberlist =  sqlSession.selectList("Admin", page);
		return memberlist;
	}
	
	//ȸ�� ����
	public void memberDelete(int admin_num) throws Exception {
		sqlSession.delete("member_del", admin_num);
	}
	
	//�Ű�� �Խù� ���
	public List<AdminBean> selectAdminmemberboardList() throws Exception{
		List<AdminBean> boardlist = sqlSession.selectList("Admin");
		return boardlist;
	}
	
	//�Ű�� �Խù� ����
	public void adminDelete(int admin_num) throws Exception {
		sqlSession.delete("board_del", admin_num);
	}
}
