package com.sense.penpal.dao;

import java.util.List;

import com.sense.penpal.model.AdminBean;


public interface AdminService {

	//신고된 회원 목록
	public List<AdminBean> getadminmemberlist(int page) throws Exception;
	
	//회원삭제
	public void memberDelete(int letter_num) throws Exception;
	
	//신고된 게시물 목록
	public List<AdminBean> getadminboardlist(int page) throws Exception;
	
	//게시물 삭제
	public void boardDelete(int letter_num) throws Exception;
}
