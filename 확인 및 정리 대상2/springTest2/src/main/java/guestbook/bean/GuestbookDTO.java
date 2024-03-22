package guestbook.bean;

public class GuestbookDTO {
	private int guest_num;			// 글 번호
	private String guest_writer;	// 작성자
	private String guest_email;		// 이메일
	private String guest_subject;	// 글제목
	private String guest_content;	// 글내용
	private String logtime;			// 작성일
	
	public int getGuest_num() {
		return guest_num;
	}
	public void setGuest_num(int guest_num) {
		this.guest_num = guest_num;
	}
	public String getGuest_writer() {
		return guest_writer;
	}
	public void setGuest_writer(String guest_writer) {
		this.guest_writer = guest_writer;
	}
	public String getGuest_email() {
		return guest_email;
	}
	public void setGuest_email(String guest_email) {
		this.guest_email = guest_email;
	}
	public String getGuest_subject() {
		return guest_subject;
	}
	public void setGuest_subject(String guest_subject) {
		this.guest_subject = guest_subject;
	}
	public String getGuest_content() {
		return guest_content;
	}
	public void setGuest_content(String guest_content) {
		this.guest_content = guest_content;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
}
