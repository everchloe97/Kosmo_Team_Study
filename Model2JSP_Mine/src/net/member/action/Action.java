package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 추상메서드 -> 메서드의 틀(형식)지정
	// 모든 처리동작은 반드시 해당 추상메서드를 구현해서 사용
	public ActionForward execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}