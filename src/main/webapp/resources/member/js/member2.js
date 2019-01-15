checkconfirm = false;	//아이디 중복 체크 안한 경우
checkid='';

function check(){

	if($.trim($("#join_id").val())==""){
		alert("회원아이디를 입력하세요!");
		$("#join_id").val("").focus();
		return false;
	}
	if(checkconfirm==false || checkid != $("#join_id").val()){
		alert("아이디 중복체크하세요.");
		return false;
	}
	
	if($.trim($("#join_pwd1").val())==""){
		alert("비밀번호를 입력하세요!");
		$("#join_pwd1").val("").focus();
		return false;
	}
	if($.trim($("#join_pwd2").val())==""){
		alert("비밀번호를 입력하세요!");
		$("#join_pwd2").val("").focus();
		return false;
	}
	if($.trim($("#join_pwd1").val()) != $.trim($("#join_pwd2").val())){
		//!=같지 않다 연산. 비밀번호가 다를 경우
		alert("비밀번호가 다릅니다.");
		$("#join_pwd1").val("");
		$("#join_pwd2").val("");
		$("#join_pwd1").focus();
		return false;
	}
	
	
	if($.trim($("#join_name").val())==""){
		alert("회원이름을 입력하세요!");
		$('#join_name').val("").focus();
		return false;
	}
	
	
	if($.trim($("#join_zip").val())==""){
		alert("우편번호를 입력하세요!");
		$("#join_zip").val("").focus();
		return false;
	}
	
	
	if($.trim($("#join_addr1").val())==""){
		alert("주소를 입력하세요!");
		$("#join_addr1").val("").focus();
		return false;
	}
	
	if($.trim($("#join_addr2").val())==""){
		alert("주소를 입력하세요!");
		$("#join_addr2").val("").focus();
		return false;
	}
	
	
	if($.trim($("#join_tel2").val())==""){
		alert("집 전화번호를 입력하세요!");
		$("#join_tel2").val("").focus();
		return false;
	}
	
	
	if($.trim($("#join_phone2").val())==""){
		alert("휴대전화번호를 입력하세요!");
		$("#join_phone2").val("").focus();
		return false;
	}
	if($.trim($("#join_phone3").val())==""){
		alert("휴대전화번호를 입력하세요!");
		$("#join_phone3").val("").focus();
		return false;
	}
	
	
	if($.trim($("#join_mailid").val())==""){
		alert("메일 아이디를 입력하세요!");
		$("#join_mailid").val("").focus();
		return false;
	}
	if($.trim($("#join_maildomain").val())==""){
		alert("메일 주소를 입력하세요!");
		$("#join_maildomain").val("").focus();
		return false;
	}
	
}


function post_search(){
	alert("우편번호 검색 버튼을 클릭하세요!");
}


function post_check(){
	window.open("zipcode_find.nhn", "우편번호검색", "width=520, height=500, scrollbars=yes");
	//폭이 520이고 높이가 500, 스크롤바가 생성되는 새로운 공지창을 만듦
}


function showMessage(newtext, color){
	$("#idcheck").text('');
	$("#idcheck").show('');
	$("#idcheck").append(newtext);
	$("#idcheck").css('color', color);
	if(color=='red')
		$("#join_id").val("").focus();
}




/*아이디 중복 체크*/
function id_check()	{
	$("#idcheck").hide();	//idcheck 영역을 숨긴다.
	
	if($.trim($("#join_id").val())==""){
		alert("회원아이디를 입력하세요!");
		$("#join_id").val("").focus();
		return false;
	}
	
	//var memid=$("#join_id").val();
	var memid = $.trim($("#join_id").val());
	
	
	//1. 입력글자 길이 체크
	if(memid.length < 4){
		newtext = '아이디는 4자 이상이어야 합니다.';
		showMessage(newtext, 'red');
		return false;
	}
	else if(memid.length > 12){
		newtext = '아이디는 12자 이하이어야 합니다.';
		showMessage(newtext, 'red');
		return false;
	}
	
	
	//2. 입력아이디 패턴 유효성 검사
	if(!(validate_userid(memid))){
		newtext='아이디는 영문소문자, 숫자, _ 조합만 가능합니다.';
		showMessage(newtext, 'red')
		return false;
	}
	
	
	
	//아이디 중복 확인
	$.ajax({
		type : "POST",
		url : "member_idcheck.nhn",
		cache : false,
		data : {"memid" : memid},
		success : function(data){
			if(data==1) {//중복 아이디가 있으면
				newtext = '중복 아이디입니다.';
				showMessage(newtext, 'red');
				return false;
			}
			else {//중복아이디가 없으면
				newtext='사용가능한 아이디입니다.';
				checkconfirm = true;	//사용가능한 아이디
				checkid = memid;	//사용가능하다고 한 아이디
				showMessage(newtext, 'blue');
			}
		}
		,
		error : function(){
			alert("data error" + memid);
		}
	});//$.ajax
}


function showMessage(newtext, color){
	$("#idcheck").text('');
	$("#idcheck").show();
	$("#idcheck").append(newtext);
	$("#idcheck").css('color', color);
	
	if(color=='red')
		$("#join_id").val("").focus();
}


function validate_userid(memid){
	/*
	 	/^[a-z0-9]+$/	: 영문 소문자, 숫자, _ 가능한 정규표현식
	 	1. /	: 시작과 끝에 붙인다.
	 	2.   ^	: 문자열의 시작을 의미
	 	3. a-z	: 영어 소문자 a부터 z까지
	 	4. 0-9	: 숫자 0부터 9까지
	 	5.   +	: 앞의 문자나 부분식을 1개 이상 찾는다.
	 	6.	 $	: 문자열의 끝을 의미한다.
	 	
	 	예) /^[a-z0-9_-]{3,16}$/
	 		/ : 시작과 끝을 나타낸다.
	 		문자열의 시작부분을 찾는 ^ 다음에 소문자(a-z)나 숫자(0-9), 언더스코어(_), 하이튼(-)가
	 		나올 수 있고 {3,16}은 앞의 캐릭터들( [a-z0-9_-] )이 최소 3개에서 16개 이하로
	 		나와야 하고 문자열의 끝을 의미하는 $가 마지막에 나온다.
	 */
	
	var pattern = /^[a-z0-9_]+$/;
	
	//test 메소드는 문자열 안에 패턴이 있는지 확인하여 있으면 true를, 없으면 false를 반환한다.
	var result = pattern.test(memid);
	
	return result;
}


function domain_list(){
	/*리스트에서 직접입력을 선택했을 때*/
	if($("#mail_list").val()=="0"){
		//@뒤의 도메인입력란을 공백처리
		$("#join_maildomain").val("");
		
		//@뒤의 도메인입력란을 쓰기 가능
		$('#join_maildomain').attr("readOnly", false);
		
		//도메인입력란으로 입력대기 상태
		$("#join_maildomain").focus();
	}
	else{	//리스트목록을 선택했을 때
		$("#join_maildomain").val($("#mail_list").val());
		$('#join_maildomain').attr("readOnly", true);
	}
}

