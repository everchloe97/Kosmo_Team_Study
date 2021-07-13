package net.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberDAO;
import net.member.db.MemberDTO;

public class MemberJoinAction implements Action {
	// 회원가입에 대한 모든 처리
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("MemberJoinAction까지 오는지 확인용");
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 전달받은 정보를 DB에 저장
		// 자바빈(DTO 객체)를 생성해서 저장
		
		MemberDTO mdto = new MemberDTO();
		
		mdto.setId(request.getParameter("id"));
		mdto.setPass(request.getParameter("pass"));
		mdto.setName(request.getParameter("name"));
		mdto.setAge(Integer.parseInt(request.getParameter("age")));
		mdto.setGender(request.getParameter("gender"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		// DB 처리객체 (DAO 객체)를 사용해 처리
		MemberDAO mdao = new MemberDAO();
		// 회원가입 메서드 생성 insertMember(DTO 객체);
		mdao.insertMember(mdto);
		
		// 페이지 이동 (ActionForward 객체)
		ActionForward forward = new ActionForward();
		
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true);
		
		return forward;
	}
}
