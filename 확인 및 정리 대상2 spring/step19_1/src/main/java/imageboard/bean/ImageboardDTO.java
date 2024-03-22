package imageboard.bean;

public class ImageboardDTO {
	private int seq, imagePrice, imageQty;
	private String imageId, imageName, imageContent, image1, logtime;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getImagePrice() {
		return imagePrice;
	}
	public void setImagePrice(int imagePrice) {
		this.imagePrice = imagePrice;
	}
	public int getImageQty() {
		return imageQty;
	}
	public void setImageQty(int imageQty) {
		this.imageQty = imageQty;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageContent() {
		return imageContent;
	}
	public void setImageContent(String imageContent) {
		this.imageContent = imageContent;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
}
