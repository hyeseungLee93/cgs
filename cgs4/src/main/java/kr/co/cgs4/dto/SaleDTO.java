package kr.co.cgs4.dto;

import java.sql.Timestamp;

public class SaleDTO {
	
	Timestamp sale_date;//sysdate
	String sale_ID;//랜덤
	String screening_ID;//받아옴
	String sale_type;//0-카드
	String member_type;//0-회원
	int sale_price;//받아옴
	String paycard_num;//받아옴
	String refund_type;//0-비환불
	int sale_cnt;//받아옴
	int discount_price;//0-없음
	String discount_type;//0-없음
	int final_price;//받아옴
	int use_cnt;//기본1, 내가본영화로
	int common_cnt;//받아옴
	int young_cnt;//받아옴
	int special_cnt;//받아옴
	
	//sale_date
	public Timestamp getSale_date() {
		return sale_date;
	}
	public void setSale_date(Timestamp sale_date) {
		this.sale_date = sale_date;
	}
	
	//sale_id
	public String getSale_ID() {
		return sale_ID;
	}
	public void setSale_ID(String sale_ID) {
		this.sale_ID = sale_ID;
	}
	
	//screening_id
	public String getScreening_ID() {
		return screening_ID;
	}
	public void setScreening_ID(String screening_ID) {
		this.screening_ID = screening_ID;
	}
	
	//sale_type
	public String getSale_type() {
		return sale_type;
	}
	public void setSale_type(String sale_type) {
		this.sale_type = sale_type;
	}
	
	//member_type
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	
	//sale_price
	public int getSale_price() {
		return sale_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	
	//paycard_num
	public String getPaycard_num() {
		return paycard_num;
	}
	public void setPaycard_num(String paycard_num) {
		this.paycard_num = paycard_num;
	}
	
	//refund_type
	public String getRefund_type() {
		return refund_type;
	}
	public void setRefund_type(String refund_type) {
		this.refund_type = refund_type;
	}
	
	//sale_count
	public int getSale_cnt() {
		return sale_cnt;
	}
	public void setSale_cnt(int sale_cnt) {
		this.sale_cnt = sale_cnt;
	}
	
	//discount_price
	public int getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(int discount_price) {
		this.discount_price = discount_price;
	}
	
	//discount_type
	public String getDiscount_type() {
		return discount_type;
	}
	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}
	
	//final_price
	public int getFinal_price() {
		return final_price;
	}
	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}
	
	//use_count
	public int getUse_cnt() {
		return use_cnt;
	}
	public void setUse_cnt(int use_cnt) {
		this.use_cnt = use_cnt;
	}
	
	//common_count
	public int getCommon_cnt() {
		return common_cnt;
	}
	public void setCommon_cnt(int common_cnt) {
		this.common_cnt = common_cnt;
	}
	
	//young_count
	public int getYoung_cnt() {
		return young_cnt;
	}
	public void setYoung_cnt(int young_cnt) {
		this.young_cnt = young_cnt;
	}
	
	//special_count
	public int getSpecial_cnt() {
		return special_cnt;
	}
	public void setSpecial_cnt(int special_cnt) {
		this.special_cnt = special_cnt;
	}
	
	
}
