package com.sense.penpal.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sense.penpal.dao.LetterServiceImpl;
import com.sense.penpal.model.LetterBean;
import com.sense.penpal.model.MemberBean;

@Controller
public class LetterAction {

	@Autowired
	private LetterServiceImpl letterService;

	//���� �������� �̵�
	@RequestMapping(value = "penpa_main.to")
	public String panpel_main() {
		System.out.println("����� penpa_main ������ �Դϴ�.");
		return "/penpa_main";
	}

	//�α��� �������� �̵�
	@RequestMapping(value = "member_login.to")
	public String member_login() {
		System.out.println("����� member_login ������ �Դϴ�.");
		return "/member_login";
	}

	//���� �������� �̵� �� �� ���̵� �޾ƿ���
	@RequestMapping(value="/letter_wrmain.to") 
	public ModelAndView letter_wrmain(
		HttpServletRequest request) {

		System.out.println("����� letter_wrmain ������ �Դϴ�.");
		 
		ModelAndView le = new ModelAndView("letter_wrmain");
		le.addObject("id", "bae9177");//session id�� ������ ��  
	  return le; 
	}
	
	 //���� ������ 
	@RequestMapping(value="/letter_wrmain_ok.to", method= RequestMethod.POST)
	public void letter_wrmain( 
			//MemberBean�ȿ� ��� �ִ°��� ���
			MemberBean member,
			LetterBean letter,//command ��ü(�ڵ����� �Ķ���� ���� ��)
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		  
			System.out.println("������ ������ ������ �Դϴ�.");
		
		 	response.setContentType("text/html;charset=UTF-8"); //�ѱ� �ȱ����� ���� ���� ���ڵ�(�츮���󿡼��� ��� ����)
		 	
		 	PrintWriter out = response.getWriter();//��� ��Ʈ��
		  
		 	//HttpSession�� �����ϸ� ���� HttpSession�� ��ȯ�ϰ� �������� ������ ���ο� ������ �����մϴ�
		 	HttpSession session = request.getSession();
		 	session.setAttribute("id", letter.getLe_fromUser());
		 	//id�� getParameter�� �޴� ����� ���̵� �޾ƿ�
		 	String id = request.getParameter("le_toUser");
			System.out.println("le_toUser=" + id);
			
		 	//�޴� ����� ���̵� üũ
		 	MemberBean m= this.letterService.le_toCheck(id);
		 	
		 	System.out.println("member=" + m);
		 
		 	if(m == null) {//�޴»���� ���̵� ���� ������
		 		out.println("<script>");
				out.println("alert('�޴»���� ���̵� �����ϴ�. �޴»���� ���̵� �ٽ� �Է����ּ���');");
				out.println("history.back();");
				out.println("</script>");
				
		 	}else{//�޴»���� ���̵� ������
		 		letterService.inserletter(letter);
		 		
		 		out.println("<script>");
				out.println("alert('������ �߼� �߽��ϴ�.');");
				out.println("</script>");
				response.sendRedirect("letter_fromlist.to");
		 	}
	  }
	  
	//���� ���� ������ ������
	@RequestMapping(value="/letter_fromlist.to") 
	public ModelAndView letter_fromlist(
				@RequestParam(value="page", defaultValue="1", required = false)	int page,
				HttpServletRequest request) 
						throws Exception{
	  
		System.out.println("����� letter_fromlist ������ �Դϴ�.");
		
		//value="page" : ��û �Ķ���� page //defaultValue="1" : ��û �Ķ���Ͱ� �������� ���� �� 1 �� ���Ǽ���
		//required=false : ��û �Ķ���Ͱ� �ʼ��� �ƴ� ���
		
		int fromlimit=10; //�� ȭ�鿡 ����� ���ڵ� ����
		int fromlistcount = letterService.getfromListCount(); //�� ����Ʈ���� �޾ƿ�
		
		//�� ��������
		int maxpage = (fromlistcount + fromlimit -1)/fromlimit;
		
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//������������ ������ ������ �������� (10, 20, 30...)
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage)
			endpage = maxpage;
		
		HttpSession session = request.getSession();//ȸ�����ԵǸ� ������ ��
		String id = (String)session.getAttribute("id");//ȸ�����ԵǸ� ������ ��
		
		List<LetterBean> letterlist = letterService.getletterFromList(id); //����Ʈ�� �޾ƿɴϴ�.
		
		System.out.println("letterlist=" + letterlist);
		
		ModelAndView le = new ModelAndView("/letter_fromlist");
		le.addObject("page", page);
		le.addObject("maxpage", maxpage);
		le.addObject("startpage", startpage);
		le.addObject("endpage", endpage);
		le.addObject("fromlistcount", fromlistcount);
		le.addObject("letterlist", letterlist);
		
		return le; 
	}
	 
	//���� ������ - ���� ���뺸��
	//���� ���� Ȯ���ϱ�
	@RequestMapping(value="/letter_fromcont.to", method= RequestMethod.GET) 
	public ModelAndView letter_fromcont(
			@RequestParam("le_inx") int le_inx,
			@RequestParam("state") String state) throws Exception{
		
		if(state.equals("cont")) {
			this.letterService.fromHit(le_inx); //������ 1
		}
		
		//��ȣ�� �������� DB������ �����ɴϴ�.
		LetterBean letterbean = this.letterService.getletterFromCont(le_inx);
		System.out.println("letterbean=" + letterbean);
		
		ModelAndView lettercontM = new ModelAndView();
		
		lettercontM.addObject("letterbean", letterbean);
		
		return lettercontM; 
	}
	
	//���� ������ ������ 
	@RequestMapping(value="/letter_tolist.to") 
	public ModelAndView letter_to(
			@RequestParam(value="page", defaultValue="1", required = false)	int page,
			LetterBean letter,
			HttpServletRequest request) 
					throws Exception{
		
		int tolimit=10; //�� ȭ�鿡 ����� ���ڵ� ����
		int tolistcount = letterService.gettoListCount(); //�� ����Ʈ���� �޾ƿ�
		
		//�� ��������
		int maxpage = (tolistcount + tolimit -1)/tolimit;
		
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//������������ ������ ������ �������� (10, 20, 30...)
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage)
			endpage = maxpage;
		
		HttpSession session = request.getSession();
		/* session.setAttribute("id", letter.getLe_fromUser()); */
		
		String id = request.getParameter("le_fromUser");
		System.out.println("le_fromUser=" + id);
		
		List<LetterBean> letterlist = letterService.getletterToList(id); //����Ʈ�� �޾ƿɴϴ�.
		
		System.out.println("letterlist=" + letterlist);
		
		ModelAndView le = new ModelAndView("/letter_tolist");
		le.addObject("page", page);
		le.addObject("maxpage", maxpage);
		le.addObject("startpage", startpage);
		le.addObject("endpage", endpage);
		le.addObject("tolistcount", tolistcount);
		le.addObject("letterlist", letterlist);
		
		return le; 
	}
	
	//���� ������ - ���� ���뺸��
	@RequestMapping(value="/letter_tocont.to", method= RequestMethod.GET) 
	public ModelAndView letter_tocont(
			@RequestParam("le_inx") int le_inx) throws Exception{
		
		//��ȣ�� �������� DB������ �����ɴϴ�.
		LetterBean letterbean = this.letterService.getletterFromCont(le_inx);
		System.out.println("letterbean=" + letterbean);
			
		ModelAndView lettercontM = new ModelAndView();
			
		lettercontM.addObject("letterbean", letterbean);
			
		return lettercontM; 
	}
	
	/*
	 * //���� �����ϱ� ������
	 * 
	 * @RequestMapping(value="/letter_toreply_ok.to", method=RequestMethod.GET)
	 * public String letter_toreply( MemberBean member, LetterBean letter,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception{
	 * 
	 * response.setContentType("text/html;charset=UTF-8");
	 * 
	 * HttpSession session = request.getSession(); session.setAttribute("id",
	 * letter.getLe_toUser());
	 * 
	 * String id = request.getParameter("le_fromUser");
	 * System.out.println("le_fromUser=" + id);
	 * 
	 * MemberBean m= this.letterService.le_toCheck(id);
	 * 
	 * System.out.println("member=" + m); return null; }
	 */
	 //���� �����ϱ� ������
	/*
	 * @RequestMapping(value="/letter_fromdel_ok.to", method= RequestMethod.POST)
	 * public String letter_fromdel( HttpServletRequest request, HttpServletResponse
	 * response,
	 * 
	 * @RequestParam("le_inx") int le_inx,
	 * 
	 * @RequestParam("page")int page ) throws Exception{
	 * 
	 * response.setContentType("text/html; charset=UTF-8");//���� ���̴� ����ڵ� Ÿ���� ����
	 * 
	 * //�� ��ȣ�� �ش��ϴ� DB ������ �����ɴϴ�. LetterBean letterbean =
	 * this.letterService.getletterFromCont(le_inx);
	 * 
	 * return null; }
	 */
}
