package kr.co.cgs4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cgs4.dao.MemberDAO;
import kr.co.cgs4.dto.MemberDTO;

@Controller
public class SignupController {

	// 회원가입 화면
	@RequestMapping("/signup")
	public String login(Model model) {
		System.out.println("sinup()");
		return "signup";
	}
	@RequestMapping("/signup-form")
	public String signup(Model model){
	System.out.println("sinup()");
	return "signup-form";
	}

	@RequestMapping(value = "signupProcess")
	public String signupProcess(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException, ParseException {

		// 비밀번호
		String getPW = request.getParameter("user_password");
		String getPWcheck = request.getParameter("user_password_re");

		// int pw=Integer.parseInt(getPW);
		// int pwcheck = Integer.parseInt(getPWcheck);

		// 이름
		String getUserName = request.getParameter("user_name");

		// 주소
		String getUserAddress1 = request.getParameter("user-address1");
		String getUserAddress2 = request.getParameter("user-address2");
		String getUserAddress3 = request.getParameter("user-address3");
		String getUserAddress = getUserAddress1 +getUserAddress2 +getUserAddress3;

		// 생년월일
		String getUserBirth = request.getParameter("user-birth");

		// 핸드폰번호
		String getUserPnum1 = request.getParameter("user-pnum");
		String getUserPnum2 = request.getParameter("user-pnum2");
		String getUserPnum3 = request.getParameter("user-pnum3");
		String getUserPnum = getUserPnum1 + getUserPnum2 + getUserPnum3;

		// 이메일
		String getUserEmail = request.getParameter("user-email");

		// 성별
		String getUserGender = request.getParameter("gender");
		// 아이디 중복체크
		MemberDAO dao = new MemberDAO();

		// 아이디
		String getID = request.getParameter("user-id");

		try{
		MemberDTO IdCheck=dao.IdCheck(getID);
		if (IdCheck != null) {
			// 자바에서 경고창띄우는부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.'); history.go(-1);</script>");
			out.close();
			return "login";

			
		} else {
			// 자바에서 경고창띄우는부분
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('예상못한 시스템오류입니다. 고객센터로 연락주세요'); history.go(-1);</script>");
						out.close();
						return "login";
			
		}
		}catch(EmptyResultDataAccessException e2){
			try {

				if (!getPW.equals(getPWcheck)) {
					// 자바에서 경고창띄우는부분
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('입력하신 비밀번호와 비밀번호 확인 값이 다릅니다!'); history.go(-1);</script>");
					out.close();
					return "login";
				} else {

					dao.signup(getID, getPW, getUserName, getUserAddress, getUserBirth, getUserPnum, getUserEmail,
							getUserGender);

					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('회원가입이 완료되었습니다'); document.location.href='index'; </script>");
					out.flush();
					out.close();
					return "index";
				}
			} catch (EmptyResultDataAccessException e) {
				System.out.println("입력이 올바르지않음");
				// 자바에서 경고창띄우는부분
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('모든 항목을 입력해주세요!'); history.go(-1);</script>");
				out.close();
				// 어차피 위에서 history.go(-1)때문에 return으로안감
				return "redirect:login";
			}



		}
	}

}
