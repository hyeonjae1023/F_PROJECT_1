package com.moviement.controller;

import java.util.List;
import java.util.Scanner;

import com.moviement.container.Container;
import com.moviement.dto.Member;
import com.moviement.dto.Review;
import com.moviement.service.MemberService;
import com.moviement.service.ReviewService;

public class MemberController extends Controller {
	private Scanner sc;
	private int selectNum;
	private MemberService memberService;
	private Session session;
	private ReviewService reviewService;
	
	public MemberController(Scanner isc) {
		this.sc = isc;
		memberService = Container.memberService;
		reviewService = Container.reviewService;
		session = Container.getSession();
	}

	public void doAction(int selectNum) {
		this.selectNum = selectNum;

		System.out.printf("=== === === M E M B E R === === ===\n\n");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 로그아웃");
		System.out.println("4. 마이 페이지");
		System.out.printf("9. 이전 단계로\n\n");
		System.out.printf("선택 : ");
		selectNum = sc.nextInt();
		System.out.println();

		switch (selectNum) {
		case 1:
			doJoin();
			break;
		case 2:
			doLogin();
			break;
		case 3:
			doLogout();
			break;
		case 4:
			showMyPage();
			break;
		case 9:
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
	}

	private boolean isJoinableLoginId(String loginId) {
		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return true;
		}
		return false;
	}
	
	private boolean isJoinableEmail(String Email) {
		Member member = memberService.getMemberByLoginId(Email);

		if (member == null) {
			return true;
		}
		return false;
	}

	private boolean isJoinableNickName(String nickName) {
		Member member = memberService.getMemberBynickName(nickName);

		if (member == null) {
			return true;
		}
		return false;
	}
	
	private void doJoin() {
		String loginId = null;

		while (true) {
			System.out.printf("아이디 : ");
			loginId = sc.next();

			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s(은)는 이미 사용중인 아이디입니다.\n", loginId);
				continue;
			}
			break;
		}

		String loginPw = null;
		String loginPwConfirm = null;

		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.next();
			System.out.printf("비밀번호 확인 : ");
			loginPwConfirm = sc.next();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요.");
				continue;
			}
			break;
		}

		String Email = null;

		while (true) {
			System.out.printf("이메일 : ");
			Email = sc.next();

			if (isJoinableEmail(Email) == false) {
				System.out.printf("%s(은)는 이미 사용중인 이메일입니다.\n", Email);
				continue;
			}
			break;
		}
		
		String nickName = null;

		while (true) {
			System.out.printf("닉네임 : ");
			nickName = sc.next();

			if (isJoinableNickName(nickName) == false) {
				System.out.printf("%s(은)는 이미 사용중인 닉네임입니다.\n", nickName);
				continue;
			}
			break;
		}
		
		System.out.printf("이름 : ");
		String name = sc.next();

		memberService.join(loginId, Email, nickName, loginPw, name);

		System.out.printf("%s님, MovieMent 회원이 되신걸 환영합니다 :D\n", name);
	}
	
	public void doLogin() {
		if (Container.getSession().isLogined()) {
			System.out.println("이미 로그인 되어있습니다.\n");
			return;
		}
		System.out.printf("=== === === L O G I N === === ===\n\n");
		System.out.printf("아이디 : ");
		String loginId = sc.next();
		System.out.printf("비밀번호 : ");
		String loginPw = sc.next();
		System.out.println();
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if (member == null) {
			System.out.println("해당 회원은 존재하지 않습니다.");
			return;
		}
		
		if (member.loginPw.equals(loginPw) == false) {
			System.out.println("비밀번호가 맞지 않습니다.");
			return;
		}
		
		session.setLoginedMember(member);
		Member loginedMember = session.getLoginedMember();
		
		System.out.printf("어서 오세요 %s님, 환영합니다 :D\n\n", loginedMember.name);
	}
	
	private void doLogout() {
		if (Container.getSession().isLogined() == false) {
			System.out.println("로그인 후 이용해주세요.\n");
			return;
		}
		session.setLoginedMember(null);
		System.out.println("로그아웃 되었습니다.");
	}

	private void showMyPage() {
		if (Container.getSession().isLogined() == false) {
			System.out.println("로그인 후 이용해주세요.\n");
			return;
		}
		
		System.out.printf("수정 항목 선택 : \n");
		System.out.printf("1. 이메일  \n");
		System.out.printf("2. 비밀번호  \n");
		System.out.printf("3. 닉네임  \n");
		System.out.printf("4. 리뷰 내역  \n");
		System.out.printf("선택  ");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1 :
			changeEmail();
			break;
		case 2 :
			changeLoginPw();
			break;
		case 3 :
			changeNickName();
			break;
		case 4 :
			showReviewList();
			break;
		}
	}

	private void showReviewList() {
		System.out.printf("1.리뷰 내역으로 \n");
		System.out.printf("2. 이전으로 \n");
		System.out.printf("\n 입력 >> ");
		int menu = sc.nextInt();
		
		if(menu == 2) {
			System.out.println("변경을 취소합니다.");
			return;
		}
		Member loginedMember = Container.getSession().getLoginedMember();
		List<Review> forPrintReview = Container.reviewService.getForPrintReivews(loginedMember.nickName);
		
		if (forPrintReview.size() == 0) {
			System.out.println("검색결과가 존재하지 않습니다.");
			return;
		}
		
		System.out.printf("=== === ===수정할 리뷰 선택 === === ===\n\n");
		System.out.println(" 번호 | 닉네임 | 평점 | 제목 ");
		
		Review review;
		for (int i = 0; i <= forPrintReview.size()-1; i++) {
			if(forPrintReview.size()==0) {
				System.out.println("리뷰 내역이 없습니다.");
				return;
			}
			
			review = forPrintReview.get(i);
			
			System.out.printf("%4d|%6s|%4.1f|%s|%s\n", review.id, review.name, review.grades, review.title,review.body);
		}
		
		System.out.println();
		
		System.out.printf("리뷰 번호 : ");
		int reviewId = sc.nextInt();
		
		Review choiceReview = Container.reviewService.getForPrintReview(reviewId);
		
		System.out.printf("평점 : ");
		float grades = sc.nextFloat();
		
		sc.nextLine();
		
		System.out.println("내용 : ");
		String body = sc.nextLine();
		
		reviewService.modifyReview(choiceReview.id,body,grades);
		
		
		System.out.println("수정완료");
	}

	private void changeNickName() {
		System.out.printf("1.닉네임 변경\n");
		System.out.printf("2. 이전으로\n");
		System.out.printf("\n입력 >> ");
		
		int menu = sc.nextInt();
		
		if(menu == 2) {
			System.out.println("변경을 취소합니다.");
			return;
		}
		
		Member loginedMember = Container.getSession().getLoginedMember();
		
		String nickName = null;
	
		while(true) {
			System.out.printf("현재 닉네임 : %s \n",loginedMember.nickName);
			System.out.printf("변경할 닉네임 : ");
			
			nickName = sc.next();
			
			if(isJoinableNickName(nickName) == false) {
				System.out.println("이미 사용중인 닉네임 입니다.");
				return;
			}
			break;
		}
		
		memberService.modifyNickName(loginedMember.name, nickName);
		System.out.println("닉네임이 변경 되었습니다.");
	}

	private void changeLoginPw() {
		System.out.printf("1.비밀번호 변경\n");
		System.out.printf("2. 이전으로\n");
		System.out.printf("\n입력 >> ");
		
		int menu = sc.nextInt();
		
		if(menu == 2) {
			System.out.println("변경을 취소합니다.");
			return;
		}
		Member loginedMember = Container.getSession().getLoginedMember();
		
		String loginPw = null;
		System.out.printf("현재 비밀번호 : %s \n",loginedMember.loginPw);

			System.out.printf("변경할 비밀번호 : ");
			loginPw = sc.next();
		
		memberService.modifyLoginPw(loginedMember.name, loginPw);
		System.out.println("비밀번호가 변경 되었습니다.");
	}

	private void changeEmail() {
		System.out.printf("1.이메일 변경\n");
		System.out.printf("2. 이전으로\n");
		System.out.printf("\n입력 >> ");
		
		int menu = sc.nextInt();
		
		if(menu == 2) {
			System.out.println("변경을 취소합니다.");
			return;
		}
		
		Member loginedMember = Container.getSession().getLoginedMember();
		
		String Email = null;
	
		while(true) {
			System.out.printf("현재 Email : %s \n",loginedMember.Email);

			System.out.printf("변경할 Email : ");
			Email = sc.next();
			
			if(isJoinableEmail(Email) == false) {
				System.out.println("이미 사용중인 이메일 입니다.");
				return;
			}
			break;
		}
		
		memberService.modifyEmail(loginedMember.name, Email);
		System.out.println("이메일이 변경 되었습니다.");
	}
}