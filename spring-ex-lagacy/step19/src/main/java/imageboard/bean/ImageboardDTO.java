package imageboard.bean;

import java.util.Date;

public class ImageboardDTO {
	private int seq;
	private String imageId;
	private String imageName;
	private int imagePrice;
	private int imageQty;
	private String imageContent;
	private String image1;
	private Date logtime;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getImageContent() {
		return imageContent;
	}
	public void setImageContent(String imageContent) {
		this.imageContent = imageContent;
	}
	/* image */
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	////////////
	public Date getLogtime() {
		return logtime;
	}
	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}
	@Override
	public String toString() {
		return "ImageboardDTO [seq=" + seq + ", imageId=" + imageId + ", imageName=" + imageName + ", imagePrice="
				+ imagePrice + ", imageQty=" + imageQty + ", imageContent=" + imageContent + ", image1=" + image1 + "]";
	}
	
}
