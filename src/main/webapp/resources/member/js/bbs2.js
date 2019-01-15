
  function check(){
	  if($.trim($("#bbs_name").val())==""){
		  alert("글쓴이를 입력하세요!");
		  $("#bbs_name").val("").focus();
		  return false;
	  }
	  if($.trim($("#bbs_pass").val())==""){
		  alert("비밀번호를 입력하세요!");
		  $("#bbs_pass").val("").focus();
		  return false;
	  }
	  if($.trim($("#bbs_subject").val())==""){
		  alert("글제목을 입력하세요!");
		  $("#bbs_subject").val("").focus();
		  return false;
	  }
	  if($.trim($("#bbs_content").val())==""){
		  alert("글내용을 입력하세요!");
		  $("#bbs_content").val("").focus();
		  return false;
	  }
  }
  
  $(function(){
	  if($("#filevalue").text()==""){
		  $("#close").css('display','none');
	  }	 
	  
	  $("#upfile").change(function(){
	    	$('#filevalue').text('');
	    	// $(this).val() => C:\fakepath\image1.png
	    	var inputfile=$(this).val().split('\\'); // C:,fakepath,image1.png
	    	$('#filevalue').text(inputfile[inputfile.length-1]);
	    	$("#close").css('display','inline');
	    	$('#bbs_original').remove();
	    	$('#bbs_file').remove();
	    });
	  
	  //cancel.png(제거) 버튼을 클릭한 경우
	  $("#close").click(function(){
		  $('#bbs_original').remove();
		  $('#bbs_file').remove();
		  
		  $('#filevalue').text('');
		  $(this).css('display','none');	
		  
		  //글쓰기에서 파일을 선택 후 cancel.png를 누른 경우 파일의 값을 초기화한다.
		  $('#upfile').val('');
	  });
	  
  });