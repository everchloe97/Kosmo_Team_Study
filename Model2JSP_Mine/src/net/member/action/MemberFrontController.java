package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {

	// GET/POST 2개의 방식 상관없이 다 사용하기 위해 doProcess 메서드 작성
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess() 메서드 호출");
		// 가상주소 가져오기
		// http://localhost:8081/Model2JSP_Mine/Main.me
		// StringBuffer requestURL = requeest.getRequestURL();
		// System.out.println(requestURL);
		
		// /Model2JSP_Mine/Main.me
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		
		// /Model2JSP_Mine (프로젝트명)
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		// /Main.me(가상주소)
		String command = requestURI.substring(contextPath.length());
		System.out.println("command : "+command);
		
		
		// 뽑아온 가상주소를 가지고 비교해서 페이지 이동
		// * 페이지 이동 방식
		// 1. response를 이용한 이동방식
		//	  response.sendRedirect("이동할 페이지 주소");
		// 2. foward를 이용한 방식
		//	  => A.jsp => B.jsp 페이지로 이동시, 페이지 주소는 A, 내용은 B
		// RequestDispatcher dis =
		//   request.getRequestDispatcher("이동할 주소");
		// dis.forward(request, response);
		
		// * 페이지 이동시 필요한 정보 저장 매체
		//	 ActionForward 객체 사용 - 이동할 페이지 주소, 이동할 방식을 저장
				
				
		/*if(command.equals("/join.me")){
			System.out.println("/join.me 페이지로 이동");
		}*/
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/Main.me")) {
			// member/main.jsp로 보내준다
			
			forward = new ActionForward();
			
			forward.setPath("./member/main.jsp");
			forward.setRedirect(false);
			// 이동방식이 false면 : forward 방식으로 페이지 이동.
			// forward를 쓰는 이유 : 주소는 그대로 Main.me로 두고싶고, 페이지의 내용만 바꾸고 싶기 때문.
		}else if(command.equals("/MemberLogin.me")) {
			
			forward = new ActionForward();
			
			forward.setPath("./member/loginForm.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/MemberJoin.me")) {
			// 회원가입 페이지로 이동 (View 페이지로 이동)
			forward = new ActionForward();
			
			forward.setPath("./member/insertForm.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/MemberJoinAction.me")) {
			// 회원가입 처리 (Model1에서 pro와 같은 역할)
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberLoginAction.me")) {
			// 로그인 처리(pro,model1 방식) - MemberLoginAction() 객체 생성
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//////////////////////////////////////////////
		// 페이지 이동
		if(forward != null) {
			// 페이지 이동정보가 있다
			if(forward.isRedirect()) {
				// 이동방식이 true 일때
				response.sendRedirect(forward.getPath());
			}else {
				// 이동방식이 false 일때
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}
	
	// GET/POST 방식 상관없이 모두 사용 -> 위에 작성한 doProcess 메서드 호출한다
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		doProcess(request, response);
	}
}
