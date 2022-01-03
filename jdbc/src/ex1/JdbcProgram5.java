package ex1;

import java.sql.SQLException;

import com.newjdbc.app.controller.NoticeController;

public class JdbcProgram5 {

	//Notice를 관리하기 위한 클래스
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeController cont = new NoticeController();
		
		
		//EXIT 라벨
		EXIT:
			//종료 누를때 까지 반복
			while(true) {
				cont.printNoticeList(); //목록을 출력하는
				int menu = cont.inputNoticeMenu(); //메뉴 입력받기
	
		switch(menu) {
		case 1: //상세조회
			break;
		case 2: //이전
			break;
		case 3: //다음
			break;
		case 4: //글쓰기
			break;
		case 5: //종료
			System.out.println("Bye");
			break EXIT;
			
		default :
				System.out.println("<<1 ~ 4까지만 입력 가능합니다.>>");
				break;
			}
		}
	}
}
