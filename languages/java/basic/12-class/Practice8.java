import test.BookShop;

public class Practice8 {

	public static void main(String[] args) {
		
		BookShop B = new BookShop();
		B.setBook("자바완성","황완성",25000);
		B.viewBook();
		
//		B.bookName = "JSP잡기";
//		B.author = "송jp";
//		B.price = 35000;
		
		B.setBookName("JSP잡기");
		B.setAuthor("송JP");
		B.setPrice(3500);
		
		System.out.println("책이름 : " + B.getBookName());
		System.out.println("저  자 : " + B.getAuthor());
		System.out.println("가  격 : " + B.getPrice());		
		
		
	}

}
