package com.dto;

import java.util.Arrays;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Alias(value = "ProductDTO")
public class ProductDTO {
	private int pboard_no;
	private Date resistdate;
	private String title;
	private String pcontents;
	private int pview;
	private String id;
	private String username;
	
	private int isSell;
	private int price;
	private String productType;
	private String productLocation;
	private int[] imageNo;
	private String imageName;
	private CommonsMultipartFile image1;
	private CommonsMultipartFile image2;
	private CommonsMultipartFile image3;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(int pboard_no, Date resistdate, String title, String pcontents, int pview, String id,
			String username, int isSell, int price, String productType, String productLocation, int[] imageNo,
			String imageName, CommonsMultipartFile image1, CommonsMultipartFile image2, CommonsMultipartFile image3) {
		super();
		this.pboard_no = pboard_no;
		this.resistdate = resistdate;
		this.title = title;
		this.pcontents = pcontents;
		this.pview = pview;
		this.id = id;
		this.username = username;
		this.isSell = isSell;
		this.price = price;
		this.productType = productType;
		this.productLocation = productLocation;
		this.imageNo = imageNo;
		this.imageName = imageName;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
	}
	public int getPboard_no() {
		return pboard_no;
	}
	public void setPboard_no(int pboard_no) {
		this.pboard_no = pboard_no;
	}
	public Date getResistdate() {
		return resistdate;
	}
	public void setResistdate(Date resistdate) {
		this.resistdate = resistdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPcontents() {
		return pcontents;
	}
	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}
	public int getPview() {
		return pview;
	}
	public void setPview(int pview) {
		this.pview = pview;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductLocation() {
		return productLocation;
	}
	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}
	public int[] getImageNo() {
		return imageNo;
	}
	public void setImageNo(int[] imageNo) {
		this.imageNo = imageNo;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public CommonsMultipartFile getImage1() {
		return image1;
	}
	public void setImage1(CommonsMultipartFile image1) {
		this.image1 = image1;
	}
	public CommonsMultipartFile getImage2() {
		return image2;
	}
	public void setImage2(CommonsMultipartFile image2) {
		this.image2 = image2;
	}
	public CommonsMultipartFile getImage3() {
		return image3;
	}
	public void setImage3(CommonsMultipartFile image3) {
		this.image3 = image3;
	}
	@Override
	public String toString() {
		return "ProductDTO [pboard_no=" + pboard_no + ", resistdate=" + resistdate + ", title=" + title + ", pcontents="
				+ pcontents + ", pview=" + pview + ", id=" + id + ", username=" + username + ", isSell=" + isSell
				+ ", price=" + price + ", productType=" + productType + ", productLocation=" + productLocation
				+ ", imageNo=" + Arrays.toString(imageNo) + ", imageName=" + imageName + ", image1="
				+ image1 + ", image2=" + image2 + ", image3=" + image3 + "]";
	}
	
}