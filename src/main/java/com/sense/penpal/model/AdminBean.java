package com.sense.penpal.model;

import org.springframework.web.multipart.MultipartFile;

public class AdminBean {

	private String ad_member_name;				//����� �̸�
	private String ad_member_id;					//����� ���̵�
	
	private String ad_singo_member;		//�Ű� ȸ��
	private String ad_singo_board;			//�Ű� �Խù�
	
	private MultipartFile ad_uploadfile;	//����
	
	private String ad_file;			//DB��Ͻ� ���ϸ�
	private String ad_original;		//���� ÷�ν� �������ϸ�
	
	
	public String getAd_member_name() {
		return ad_member_name;
	}
	public void setAd_member_name(String ad_member_name) {
		this.ad_member_name = ad_member_name;
	}
	public String getAd_member_id() {
		return ad_member_id;
	}
	public void setAd_member_id(String ad_member_id) {
		this.ad_member_id = ad_member_id;
	}
	public String getAd_singo_member() {
		return ad_singo_member;
	}
	public void setAd_singo_member(String ad_singo_member) {
		this.ad_singo_member = ad_singo_member;
	}
	public String getAd_singo_board() {
		return ad_singo_board;
	}
	public void setAd_singo_board(String ad_singo_board) {
		this.ad_singo_board = ad_singo_board;
	}
	public MultipartFile getAd_uploadfile() {
		return ad_uploadfile;
	}
	public void setAd_uploadfile(MultipartFile ad_uploadfile) {
		this.ad_uploadfile = ad_uploadfile;
	}
	public String getAd_file() {
		return ad_file;
	}
	public void setAd_file(String ad_file) {
		this.ad_file = ad_file;
	}
	public String getAd_original() {
		return ad_original;
	}
	public void setAd_original(String ad_original) {
		this.ad_original = ad_original;
	}
}
