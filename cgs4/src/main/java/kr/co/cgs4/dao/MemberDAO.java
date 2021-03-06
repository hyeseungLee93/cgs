package kr.co.cgs4.dao;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Date;

import javax.xml.ws.Response;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import kr.co.cgs4.dto.MemberDTO;
import kr.co.cgs4.util.Constant;

public class MemberDAO {
	JdbcTemplate template ;

	public MemberDAO() {
		this.template = Constant.template;
	}

	public MemberDTO member() {
		String query = "select * from member;";
		return (MemberDTO) template.queryForObject(query, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}

	//id와 pw에 맞는 해당 맴버의 데이터를 모두 불러온다!
	//로그인할때 사용함
	public MemberDTO member_list(String id, String pw) {
		String query = "select * from member where MEMBER_ID = '" + id + "' and PASSWORD = '" + pw + "'";
			return (MemberDTO) template.queryForObject(query, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		
	}

	//회원가입시 사용
	public void signup(final String id, final String pw, final String name, final String address, final String birth, final String phone, final String e_mail, final String gender) throws ParseException{
		
		System.out.println(birth);
//		String birth1 = birth.substring(0,4);
//		String birth2 = birth.substring(5,7);
//		String birth3 = birth.substring(8,10);
//		String birthInput = birth1+birth2+birth3;
//		System.out.println(birthInput);
		//날짜 입력 포멧 정하기
//		SimpleDateFormat format = new SimpleDateFormat("yyMMdd") ;
		//가입일 정의
		//현재시간
		long dateNow=new java.util.Date().getTime();
		//현재 시간을 db에 넣을 형태로 변환
		final java.sql.Date currDate = new java.sql.Date(dateNow);
		System.out.println(currDate);
		
		
		//birth를  java.sql.Date 타입으로! // 이건됨
//		final java.sql.Date iBirth = new java.sql.Date(format.parse(birthInput).getTime());
//		System.out.println(iBirth);

		
		//나중에 email 이후 값은 지우고 db구축할것
		  String insert = "insert into member(member_ID, password, name, address, birth, phone_num, email,gender,join_date,accum_point,member_grade,membership,curr_point) values (?,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?,?,?,?)";
		  this.template.update(insert, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
				ps.setString(2, pw);
				ps.setString(3, name);
				ps.setString(4, address);
				
				
				ps.setString(5, birth);
				ps.setString(6, phone);
				ps.setString(7, e_mail);
				//젠더
				ps.setString(8, gender);
				//가입일
				ps.setDate(9, currDate);
				
				
				//이밑으로는 나중에 차후 구현
				
				//누적포인트
				ps.setInt(10, 300);
				//멤버등급
				ps.setInt(11, 0);
				//맴버십카드번호
				ps.setString(12, "0000000000000004");
				//현재포인트
				ps.setInt(13, 100);
				
				
				
			}
		});
		
	}
	
	
	//핸드폰번호, 이메일, 주소 수정할떄 사용함
	public void modify(final String id, final String pw,final String pnum, final String email, final String address){
		String modify ="UPDATE MEMBER SET phone_num= '"+pnum+"',email='"+email+"',address='"+address+"' WHERE member_id='" + id + "' and PASSWORD = '" + pw + "'";
		this.template.update(modify);
		  
	}
	
	//비밀번호 수정할때 사용함
	public void modify_pw(final String id, final String pw, final String Modify_pw){
		String modify_pw ="UPDATE MEMBER SET password= '"+Modify_pw+"' WHERE member_id='" + id + "' and PASSWORD = '" + pw + "'";
		this.template.update(modify_pw);
		  
	}
	
	//아이디 찾을때 사용함
	public MemberDTO findID(final String name, final String birth, final String gender, final String Pnum) throws ParseException{
		System.out.println(birth);
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd") ;
		
		//
		final java.sql.Date iBirth = new java.sql.Date(format.parse(birth).getTime());
		System.out.println(iBirth);
		String findID ="select * from member where name = '" + name + "' and birth = to_date('"+iBirth+"','yyyy-MM-dd') and gender='"+ gender +"' and phone_num= '"+Pnum+"'";
		return (MemberDTO) template.queryForObject(findID, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		  
	}
	
	//비밀번호 찾을때 사용함
	public MemberDTO findPW(final String id, final String name, final String Pnum, final String email){
		
		String findPW = "select * from member where member_id = '" + id + "' and name = '" + name + "' and phone_num='"+ Pnum +"' and email= '"+email+"'";
		return (MemberDTO) template.queryForObject(findPW, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));	
	}
	
	//아이디 중복체크 할떄 사용함
	public MemberDTO IdCheck(final String id){
		String checkId = "select* from member where member_id = '"+id+"'";
		return (MemberDTO) template.queryForObject(checkId, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));	
		
	}
	
	
	
	
	
}
