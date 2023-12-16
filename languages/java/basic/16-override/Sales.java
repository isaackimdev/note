import java.util.Scanner;

public class Sales {
	Scanner sc = new Scanner(System.in);
	private String article;
	private int qty;
	private int cost;
	private static int cnt;			// 총 판매건수
	private static double discount;	// 할인율
	
	void input() {
		System.out.print("품목 : ");
		article = sc.next();
		System.out.print("수량 : ");
		qty = sc.nextInt();
		System.out.print("단가 : ");
		cost = sc.nextInt();
	}
	
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public static int getCnt() {
		return cnt;
	}
	public static void setCnt(int cnt) {
		Sales.cnt = cnt;
	}
	public static double getDiscount() {
		return discount;
	}
	public static void setDiscount(double discount) {
		Sales.discount = discount;
	}	
}
