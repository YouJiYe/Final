package com.sense.penpal.model;

public class LetterBean {
	private int le_inx;			//���� Ű��
	private String le_fromUser; //�������
	private String le_toUser;	//�޴� ���
	private String le_contents;	//��������
	
	private String le_date;		//���� ���� ��¥
	
	private String le_state;	//���� ���� ����(�о����� ���о����� Ȯ��)
	
	private String le_fromdel;	//���� ����� ���� �����Կ� ���� ���� �Ǵ�
	private String le_todel;	//�޴� ����� ���� �����Կ� ���� ���� �Ǵ�
	
	public int getLe_inx() {
		return le_inx;
	}
	public void setLe_inx(int le_inx) {
		this.le_inx = le_inx;
	}
	public String getLe_fromUser() {
		return le_fromUser;
	}
	public void setLe_fromUser(String le_fromUser) {
		this.le_fromUser = le_fromUser;
	}
	public String getLe_toUser() {
		return le_toUser;
	}
	public void setLe_toUser(String le_toUser) {
		this.le_toUser = le_toUser;
	}
	public String getLe_contents() {
		return le_contents;
	}
	public void setLe_contents(String le_contents) {
		this.le_contents = le_contents;
	}
	public String getLe_date() {
		return le_date;
	}
	public void setLe_date(String le_date) {
		this.le_date = le_date;
	}
	public String getLe_state() {
		return le_state;
	}
	public void setLe_state(String le_state) {
		this.le_state = le_state;
	}
	public String getLe_fromdel() {
		return le_fromdel;
	}
	public void setLe_fromdel(String le_fromdel) {
		this.le_fromdel = le_fromdel;
	}
	public String getLe_todel() {
		return le_todel;
	}
	public void setLe_todel(String le_todel) {
		this.le_todel = le_todel;
	}

}
