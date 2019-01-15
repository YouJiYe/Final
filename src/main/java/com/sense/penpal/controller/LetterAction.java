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

	//메인 페이지로 이동
	@RequestMapping(value = "penpa_main.to")
	public String panpel_main() {
		System.out.println("여기는 penpa_main 페이지 입니다.");
		return "/penpa_main";
	}

	//로그인 페이지로 이동
	@RequestMapping(value = "member_login.to")
	public String member_login() {
		System.out.println("여기는 member_login 페이지 입니다.");
		return "/member_login";
	}

	//쪽지 페이지로 이동 할 시 아이디 받아오기
	@RequestMapping(value="/letter_wrmain.to") 
	public ModelAndView letter_wrmain(
		HttpServletRequest request) {

		System.out.println("여기는 letter_wrmain 페이지 입니다.");
		 
		ModelAndView le = new ModelAndView("letter_wrmain");
		le.addObject("id", "bae9177");//session id값 저장할 곳  
	  return le; 
	}
	
	 //쪽지 보내기 
	@RequestMapping(value="/letter_wrmain_ok.to", method= RequestMethod.POST)
	public void letter_wrmain( 
			//MemberBean안에 담겨 있는것을 사용
			MemberBean member,
			LetterBean letter,//command 객체(자동으로 파라미터 값이 들어감)
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		  
			System.out.println("쪽지를 보내는 페이지 입니다.");
		
		 	response.setContentType("text/html;charset=UTF-8"); //한글 안깨지기 위해 쓰는 인코딩(우리나라에서만 사용 가능)
		 	
		 	PrintWriter out = response.getWriter();//출력 스트림
		  
		 	//HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로운 세션을 생성합니다
		 	HttpSession session = request.getSession();
		 	session.setAttribute("id", letter.getLe_fromUser());
		 	//id를 getParameter에 받는 사람의 아이디를 받아옴
		 	String id = request.getParameter("le_toUser");
			System.out.println("le_toUser=" + id);
			
		 	//받는 사람의 아이디를 체크
		 	MemberBean m= this.letterService.le_toCheck(id);
		 	
		 	System.out.println("member=" + m);
		 
		 	if(m == null) {//받는사람의 아이디가 맞지 않을때
		 		out.println("<script>");
				out.println("alert('받는사람의 아이디가 없습니다. 받는사람의 아이디를 다시 입력해주세요');");
				out.println("history.back();");
				out.println("</script>");
				
		 	}else{//받는사람의 아이디가 맞을때
		 		letterService.inserletter(letter);
		 		
		 		out.println("<script>");
				out.println("alert('쪽지를 발송 했습니다.');");
				out.println("</script>");
				response.sendRedirect("letter_fromlist.to");
		 	}
	  }
	  
	//쪽지 보낸 쪽지함 페이지
	@RequestMapping(value="/letter_fromlist.to") 
	public ModelAndView letter_fromlist(
				@RequestParam(value="page", defaultValue="1", required = false)	int page,
				HttpServletRequest request) 
						throws Exception{
	  
		System.out.println("여기는 letter_fromlist 페이지 입니다.");
		
		//value="page" : 요청 파라미터 page //defaultValue="1" : 요청 파라미터가 존재하지 않을 때 1 의 값의설정
		//required=false : 요청 파라미터가 필수가 아닌 경우
		
		int fromlimit=10; //한 화면에 출력할 레코드 개수
		int fromlistcount = letterService.getfromListCount(); //총 리스트수를 받아옴
		
		//총 페이지수
		int maxpage = (fromlistcount + fromlimit -1)/fromlimit;
		
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//현재페이지에 보여줄 마지막 페이지수 (10, 20, 30...)
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage)
			endpage = maxpage;
		
		HttpSession session = request.getSession();//회원가입되면 지워야 함
		String id = (String)session.getAttribute("id");//회원가입되면 지워야 함
		
		List<LetterBean> letterlist = letterService.getletterFromList(id); //리스트를 받아옵니다.
		
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
	 
	//보낸 쪽지함 - 쪽지 내용보기
	//쪽지 상태 확인하기
	@RequestMapping(value="/letter_fromcont.to", method= RequestMethod.GET) 
	public ModelAndView letter_fromcont(
			@RequestParam("le_inx") int le_inx,
			@RequestParam("state") String state) throws Exception{
		
		if(state.equals("cont")) {
			this.letterService.fromHit(le_inx); //읽으면 1
		}
		
		//번호를 기준으로 DB내용을 가져옵니다.
		LetterBean letterbean = this.letterService.getletterFromCont(le_inx);
		System.out.println("letterbean=" + letterbean);
		
		ModelAndView lettercontM = new ModelAndView();
		
		lettercontM.addObject("letterbean", letterbean);
		
		return lettercontM; 
	}
	
	//받은 쪽지함 페이지 
	@RequestMapping(value="/letter_tolist.to") 
	public ModelAndView letter_to(
			@RequestParam(value="page", defaultValue="1", required = false)	int page,
			LetterBean letter,
			HttpServletRequest request) 
					throws Exception{
		
		int tolimit=10; //한 화면에 출력할 레코드 개수
		int tolistcount = letterService.gettoListCount(); //총 리스트수를 받아옴
		
		//총 페이지수
		int maxpage = (tolistcount + tolimit -1)/tolimit;
		
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//현재페이지에 보여줄 마지막 페이지수 (10, 20, 30...)
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage)
			endpage = maxpage;
		
		HttpSession session = request.getSession();
		/* session.setAttribute("id", letter.getLe_fromUser()); */
		
		String id = request.getParameter("le_fromUser");
		System.out.println("le_fromUser=" + id);
		
		List<LetterBean> letterlist = letterService.getletterToList(id); //리스트를 받아옵니다.
		
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
	
	//받은 쪽지함 - 쪽지 내용보기
	@RequestMapping(value="/letter_tocont.to", method= RequestMethod.GET) 
	public ModelAndView letter_tocont(
			@RequestParam("le_inx") int le_inx) throws Exception{
		
		//번호를 기준으로 DB내용을 가져옵니다.
		LetterBean letterbean = this.letterService.getletterFromCont(le_inx);
		System.out.println("letterbean=" + letterbean);
			
		ModelAndView lettercontM = new ModelAndView();
			
		lettercontM.addObject("letterbean", letterbean);
			
		return lettercontM; 
	}
	
	/*
	 * //쪽지 답장하기 페이지
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
	 //쪽지 삭제하기 페이지
	/*
	 * @RequestMapping(value="/letter_fromdel_ok.to", method= RequestMethod.POST)
	 * public String letter_fromdel( HttpServletRequest request, HttpServletResponse
	 * response,
	 * 
	 * @RequestParam("le_inx") int le_inx,
	 * 
	 * @RequestParam("page")int page ) throws Exception{
	 * 
	 * response.setContentType("text/html; charset=UTF-8");//웹상에 보이는 언어코딩 타입을 지정
	 * 
	 * //글 번호에 해당하는 DB 내용을 가져옵니다. LetterBean letterbean =
	 * this.letterService.getletterFromCont(le_inx);
	 * 
	 * return null; }
	 */
}
