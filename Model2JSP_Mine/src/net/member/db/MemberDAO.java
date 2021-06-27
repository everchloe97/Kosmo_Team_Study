package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	// 데이터 처리객체 (DB-mysql과 직접 연결)
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	// DB 연결
	private Connection getCon() throws Exception {
		
		// Context 객체 생성
		Context init = new InitialContext();
		// DB연동 이름으로 DB 호출 -> DataSource 저장
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/model2jspdb");
		// 연결정보를 가져와서 리턴
		con = ds.getConnection();
		
		System.out.println("DB 접속 완료 : " + con);
		
		return con;
	}
	
	// DB 자원해제
	public void closeDB() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입 처리
	public void insertMember(MemberDTO mdto) {
		try {
			con = getCon();
			
			sql = "insert into `member`(id,password,name,age,gender,email,reg_date) "
					+ "values(?,?,?,?,?,?,?)";
//			member를 `` <- esc 밑에 물결표 키 입니다.    안에 쓰는 이유 : mysql 버전 업그레이드 되면서
//			member가 select,delete처럼 mysql내부 언어가 되서 ``를 붙이지 않으면 예약어로 인식합니다. 그래서 `member`라고 써줘야 합니다.
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPass());
			pstmt.setString(3, mdto.getName());
			pstmt.setInt(4, mdto.getAge());
			pstmt.setString(5, mdto.getGender());
			pstmt.setString(6, mdto.getEmail());
			pstmt.setTimestamp(7, mdto.getReg_date());
			
			pstmt.executeUpdate();
			
			System.out.println("회원가입 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원해제
			closeDB();
		}
	}
	/*
	try(Connection con = getCon()){
		
		pstmt = con.prepareStatement(sql);
		...
		
	}catch (Exception e) {
       e.printStackTrace();
	}
	*/
	
	// 로그인 처리
	public int idCheck(String id,String pass) {
		int check = -1;
		
		try {
			con = getCon();
			
			sql = "select password from `member` where id=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();		
			
			if(rs.next()){				
				if(pass.equals(rs.getString("password"))){
					// 아이디 O, 비밀번호 O
					check = 1;
				}else{
					// 아이디 O, 비밀번호 X
					check = 0;
				}				
			}else{
				// 아이디 없음
				check = -1;
			}			
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
			// 자원해제
			closeDB();
		}		
		return check;		
	}

}
