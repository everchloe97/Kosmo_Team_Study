package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberDAO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("MemberLoginAction까지 오는지 확인용");
		
		// id, pass 정보를 가져오기
		
		// DB 처리객체 생성
				
		// idCheck(id,pass) 메서드 생성
		// 아이디가 존재할 경우(회원) : 1
		// 비밀번호 오류 : 0
		// 아이디가 없는 경우(비회원) : -1
				
		// 각각의 경우에 따른 처리
		// 0, -1 경고메시지 출력 / 페이지 뒤로가기
				
		// 로그인 -> id값을 세션객체에 저장
				
		// 페이지 이동 (./Main.me)
				
				
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
						
		// 전달받은 정보를 DB와 비교
		// 자바빈(DTO 객체)를 생성해서 저장
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// DB 처리객체(DAO 객체)를 사용하여 처리
		MemberDAO mdao = new MemberDAO();
		
		int check = mdao.idCheck(id,pass);
		
		System.out.println("로그인 정보 체크 : "+check);
		
		
		if(check == 0){
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println(" alert('비밀번호 오류'); ");
			out.println(" history.back(); ");
			out.println("</script>");
			
			out.close();
			
			// actionForward를 사용한 페이지 이동 X
			return null;
		}else if(check == -1){
			
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script> ");
			out.println("  alert('아이디 없음'); ");
			out.println("  history.back(); ");
			out.println("</script>");
			
			out.close();
			
			// actionForward를 사용한 페이지 이동 X
			return null;			
		}
		
		// check == 1
		// 로그인 -> id값을 세션객체에 저장
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		System.out.println("세션 id값 : "+id);
		
		// 페이지 이동(./Main.me)
		ActionForward forward = new ActionForward();
		
		forward.setPath("./Main.me");
		forward.setRedirect(true);		

		return forward;
	}

}
