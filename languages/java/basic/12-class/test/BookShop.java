package test;
import java.util.Scanner;

// (2)조건
/*  1) practice8클래스의 main 메서드에서 BookShop 클래스로 객체 만들기
 *  2) setBook("자바완성, " 황완성 " 25000 대입후 vB 메서ㄹ드로 출력
 *  3) setBookName(")
 */


public class BookShop {
	Scanner sc = new Scanner(System.in);
	
	
	// 가능한 데이터 감추기(은닉) private : 접근 제한자
	private String bookName ;	// 책이름
	private String author ;		// 저자
	private int price = 0 ;		// 가격
	
	// 방법 2
	
	//아무것도 안써있는 경우, package 가 붙어 있음 , 동일 파일 + 동일 폴더
	//public 프로젝트내에 있는 자료에서 접근 허용
	
	public void setBook(String bN, String author, int price){
		this.bookName = bN;
		this.author = author;
		this.price  = price;
	}
		
	public void viewBook() { // 결과 출력
		System.out.println("책이름 : " + this.bookName);
		System.out.println("저  자 : " + this.author);
		System.out.println("가  격 : " + this.price + "원\n");

	}
	
	public void setBookName(String bN){
		this.bookName = bN;
	}
	public void setAuthor(String a){
		this.author = a;
	}
	public void setPrice(int price){
		this.price = price;
	}
	
	
	public String getBookName(){
		return bookName;	
	}
	public String getAuthor(){
		return author;	
	}
	public int getPrice(){
		return price;	
	}
	

		//setter & getter
	
	
	
	
	
	
	
	
}
