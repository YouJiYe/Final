package com.sense.penpal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sense.penpal.dao.AdminServiceImpl;
import com.sense.penpal.model.AdminBean;


public class AdminAction {

	@Autowired
	private AdminServiceImpl adminService;	
	
	//������ �Ű�� ȸ�� ���
	@RequestMapping(value="/admin_member.to")
	public String admin_member(
			@RequestParam(value = "page", defaultValue="1") int page
			)throws Exception{
		
		List<AdminBean> adminMemberList = adminService.getadminmemberlist(page);
		
		return "/admin_member";
	}
	
	//������ �Ű�� ȸ������
	@RequestMapping(value="/member_del_ok.to", method= RequestMethod.POST)
	public String letter_delete(
			@RequestParam("admin_num") int admin_num,
			@RequestParam("page")int page
			) throws Exception{
		
		return null;
	}
	
	//������ �Ű�� �Խù� ���
	@RequestMapping(value="/admin_board.to", method= RequestMethod.POST)
	public String admin_board(
			@RequestParam(value = "page", defaultValue="1") int page
			)throws Exception{
		
		List<AdminBean> adminMemberBoardList = adminService.getadminboardlist(page);
		
		return "admin/admin_memberboard";
	}
	
	//������ �Ű�� �Խù� ����
	@RequestMapping(value="/board_del_ok.to", method= RequestMethod.POST)
	public String board_delete(
			@RequestParam("admin_num") int admin_num,
			@RequestParam("page")int page
			) throws Exception{
		
		return null;
	}
}
