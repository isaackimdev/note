package test01;

public class GoodsVO {
	private String code;
	private String name;
	private int price;
	private String maker;
	
	@Override
	public String toString() {
		return "GoodsVO [code=" + code + ", name=" + name + ", price=" + price + ", maker=" + maker + "]\n";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
}
