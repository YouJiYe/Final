package com.sense.penpal.model;

import org.springframework.web.multipart.MultipartFile;

public class AdminBean {

	private String ad_member_name;				//사용자 이름
	private String ad_member_id;					//사용자 아이디
	
	private String ad_singo_member;		//신고 회원
	private String ad_singo_board;			//신고 게시물
	
	private MultipartFile ad_uploadfile;	//파일
	
	private String ad_file;			//DB등록시 파일명
	private String ad_original;		//파일 첨부시 원본파일명
	
	
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
