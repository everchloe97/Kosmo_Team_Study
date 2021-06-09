package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class Controller {
	
	// 변수 선언하기
	String error = "-99999"; // 에러에 대한 메시지 화면창에 출력하기
	String save1="", save2="", save3="", save4="";
	String operator1="", operator2="", operator3="", operator4="";
	String memeryNum;
	double ans;
	
	// 숫자들이 저장 될 List 생성하기
	ArrayList<String> arr = new ArrayList<String>();
	
	// 화면에 출력할 result 선언하기
	@FXML
	private Text result;
	
	// Clear 키 설정하기
    @FXML
    void clear(ActionEvent event) {
    	arr = new ArrayList<String>();
    	save1=""; save2=""; save3=""; save4="";
    	operator1=""; operator2=""; operator3=""; operator4="";
    	result.setText("");
    }
    
    // Del 키 설정하기
    @FXML
    void Del(ActionEvent event) {
    	arr.remove(arr.size()-1);
    	String del = "";
    	for(String s : arr) {
    		del = del + s;
    	}
    	System.out.println(result.getText());
    	result.setText(del);
    }
    
    // 1~10, Pi에 대한 버튼입력 값 받기
    @FXML
    void operand(ActionEvent event) {
    	String button = ((Button)event.getSource()).getText();
    	arr.add(button);  
    	System.out.println(result.getText());
   		result.setText(result.getText()+button);    	
    }
	
    // 사칙연산자에 대한 오퍼레이터 데이터 받기
    @FXML
    void operator(ActionEvent event) {	
    	String oper = ((Button)event.getSource()).getText();
    	arr.add(oper);  
    	System.out.println(result.getText());
   		result.setText(result.getText()+oper);  
    }
    
    // = 연산자를 사용했을 때 연산 값 추출하기
    @FXML
    void equal(ActionEvent event) {
    	result.setText("");
    	
    	// ----------------------------------------
		// 첫번째 operator까지의 숫자 추출
		for(int i =0; i<arr.size(); i++) {
			switch (arr.get(i)) {
			case "1": save1 = save1 + arr.get(i); break;
			case "2": save1 = save1 + arr.get(i); break;
			case "3": save1 = save1 + arr.get(i); break;
			case "4": save1 = save1 + arr.get(i); break;
			case "5": save1 = save1 + arr.get(i); break;
			case "6": save1 = save1 + arr.get(i); break;
			case "7": save1 = save1 + arr.get(i); break;
			case "8": save1 = save1 + arr.get(i); break;
			case "9": save1 = save1 + arr.get(i); break;
			case "0": save1 = save1 + arr.get(i); break;
			case ".": save1 = save1 + arr.get(i); break;
			case "π": save1 = "3.141592"; break;
			case "e": save1 = "2.7182818"; break;

			default : {
				operator1 = arr.get(i); 
				for(int j =0; j<=i; j++) {
					arr.remove(0);
				}
			} break;			
		}
		
	}
		// ----------------------------------------
		
		// ========================================
		// 두번째 operator까지의 숫자 추출
		for(int i =0; i<arr.size(); i++) {
			switch (arr.get(i)) {
			case "1": save2 = save2 + arr.get(i); break;
			case "2": save2 = save2 + arr.get(i); break;
			case "3": save2 = save2 + arr.get(i); break;
			case "4": save2 = save2 + arr.get(i); break;
			case "5": save2 = save2 + arr.get(i); break;
			case "6": save2 = save2 + arr.get(i); break;
			case "7": save2 = save2 + arr.get(i); break;
			case "8": save2 = save2 + arr.get(i); break;
			case "9": save2 = save2 + arr.get(i); break;
			case "0": save2 = save2 + arr.get(i); break;
			case ".": save2 = save2 + arr.get(i); break;
			case "π": save2 = "3.141592"; break;
			case "e": save2 = "2.7182818"; break;
	
			default : {
				operator2 = arr.get(i); 
				for(int j =0; j<=i; j++) {
					arr.remove(0);
				}
			} break;			
		}
		
	}
		// ========================================
		
		// ========================================
		// 세번째 operator까지의 숫자 추출
		for(int i =0; i<arr.size(); i++) {
			switch (arr.get(i)) {
			case "1": save3 = save3 + arr.get(i); break;
			case "2": save3 = save3 + arr.get(i); break;
			case "3": save3 = save3 + arr.get(i); break;
			case "4": save3 = save3 + arr.get(i); break;
			case "5": save3 = save3 + arr.get(i); break;
			case "6": save3 = save3 + arr.get(i); break;
			case "7": save3 = save3 + arr.get(i); break;
			case "8": save3 = save3 + arr.get(i); break;
			case "9": save3 = save3 + arr.get(i); break;
			case "0": save3 = save3 + arr.get(i); break;
			case ".": save3 = save3 + arr.get(i); break;
			case "π": save3 = "3.141592"; break;
			case "e": save3 = "2.7182818"; break;
	
			default : {
				operator2 = arr.get(i); 
				for(int j =0; j<=i; j++) {
					arr.remove(0);
				}
			} break;			
		}
		
	}
		// ========================================
		
		// ========================================
		// 네번째 operator까지의 숫자 추출
		for(int i =0; i<arr.size(); i++) {
			switch (arr.get(i)) {
			case "1": save4 = save4 + arr.get(i); break;
			case "2": save4 = save4 + arr.get(i); break;
			case "3": save4 = save4 + arr.get(i); break;
			case "4": save4 = save4 + arr.get(i); break;
			case "5": save4 = save4 + arr.get(i); break;
			case "6": save4 = save4 + arr.get(i); break;
			case "7": save4 = save4 + arr.get(i); break;
			case "8": save4 = save4 + arr.get(i); break;
			case "9": save4 = save4 + arr.get(i); break;
			case "0": save4 = save4 + arr.get(i); break;
			case ".": save4 = save4 + arr.get(i); break;
			case "π": save4 = "3.141592"; break;
			case "e": save4 = "2.7182818"; break;
			
			default : {
				operator2 = arr.get(i); 
				for(int j =0; j<=i; j++) {
					arr.remove(0);
				}
			} break;			
		}
		
	}
		// ========================================

		
		// ----------------------------------------
		// operator1의 계산부
		switch (operator1) {
		case "+" : {
			ans = Double.parseDouble(save1)+Double.parseDouble(save2);
			result.setText(Double.toString(ans));
		}; break;
		
		case "-" : {
			ans = Double.parseDouble(save1)-Double.parseDouble(save2);
			result.setText(Double.toString(ans));
		}; break;
		
		case "*" : {
			ans = Double.parseDouble(save1)*Double.parseDouble(save2);
			result.setText(Double.toString(ans));
		}; break;
		
		case "/" : {
			try{
				ans = Double.parseDouble(save1)/Double.parseDouble(save2);
				result.setText(Double.toString(ans));
			} catch(Exception e){
				result.setText(error);
				System.out.println("0으로 나눌 수 없습니다.");
			}

		}; break;
			
		default : {
			result.setText(error);
			System.out.println("최소 하나의 연산자가 필요합니다."); 	
		}; break;
		
		}
		// ----------------------------------------
		// operator2의 계산부
		String temp = Double.toString(ans);
		
		switch (operator2) {
		case "+" : {
			ans = Double.parseDouble(temp)+Double.parseDouble(save3);
			result.setText(Double.toString(ans));
		}; break;
		
		case "-" : {
			ans = Double.parseDouble(temp)-Double.parseDouble(save3);
			result.setText(Double.toString(ans));
		}; break;
		
		case "*" : {
			ans = Double.parseDouble(temp)*Double.parseDouble(save3);
			result.setText(Double.toString(ans));
		}; break;
		
		case "/" : {
			try{
				ans = Double.parseDouble(temp)/Double.parseDouble(save3);
				result.setText(Double.toString(ans));
			} catch(Exception e){
				result.setText(error);
				System.out.println("0으로 나눌 수 없습니다.");
			}

		}; break;
		case "" : break;	
		default : {
			result.setText(error);
			System.out.println("연산자가 올바르지 않습니다."); 	
		}; break;
		
		}
		// ----------------------------------------
		// operator3의 계산부
		temp = Double.toString(ans);
		
		switch (operator3) {
		case "+" : {
			ans = Double.parseDouble(temp)+Double.parseDouble(save4);
			result.setText(Double.toString(ans));
		}; break;
		
		case "-" : {
			ans = Double.parseDouble(temp)-Double.parseDouble(save4);
			result.setText(Double.toString(ans));
		}; break;
		
		case "*" : {
			ans = Double.parseDouble(temp)*Double.parseDouble(save4);
			result.setText(Double.toString(ans));
		}; break;
		
		case "/" : {
			try{
				ans = Double.parseDouble(temp)/Double.parseDouble(save4);
				result.setText(Double.toString(ans));
			} catch(Exception e){
				result.setText(error);
				System.out.println("0으로 나눌 수 없습니다.");
			}

		}; break;
		case "" : break;
		default : {
			result.setText(error);
			System.out.println("연산자가 올바르지 않습니다."); 	
		}; break;
		
		}
		// ----------------------------------------
		// 최종 결과 값 출력
		System.out.println("계산 결과 값은 = " + ans + "입니다.");
		
// equal action의 마지막================================================================
 } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
