package com.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Alias(value = "ProductDTO")
public class ProductDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -703743337035325777L;
	private int pboard_no;
	private Date resistdate;
	private String registdate;
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
	private String originalFilename1;
	private String originalFilename2;
	private String originalFilename3;
	private CommonsMultipartFile image1;
	private CommonsMultipartFile image2;
	private CommonsMultipartFile image3;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(int pboard_no, Date resistdate, String title, String pcontents, int pview, String id,
			String username, int isSell, int price, String productType, String productLocation, int[] imageNo,
			String originalFilename1, String originalFilename2, String originalFilename3, CommonsMultipartFile image1,
			CommonsMultipartFile image2, CommonsMultipartFile image3) {
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
		this.originalFilename1 = originalFilename1;
		this.originalFilename2 = originalFilename2;
		this.originalFilename3 = originalFilename3;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		
	}
	public ProductDTO(int pboard_no, Date resistdate, String registdate, String title, String pcontents, int pview,
			String id, String username, int isSell, int price, String productType, String productLocation,
			int[] imageNo, String originalFilename1, String originalFilename2, String originalFilename3,
			CommonsMultipartFile image1, CommonsMultipartFile image2, CommonsMultipartFile image3) {
		super();
		this.pboard_no = pboard_no;
		this.resistdate = resistdate;
		this.registdate = registdate;
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
		this.originalFilename1 = originalFilename1;
		this.originalFilename2 = originalFilename2;
		this.originalFilename3 = originalFilename3;
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
	public String getOriginalFilename1() {
		return originalFilename1;
	}
	public void setOriginalFilename1(String originalFilename1) {
		this.originalFilename1 = originalFilename1;
	}
	public String getOriginalFilename2() {
		return originalFilename2;
	}
	public void setOriginalFilename2(String originalFilename2) {
		this.originalFilename2 = originalFilename2;
	}
	public String getOriginalFilename3() {
		return originalFilename3;
	}
	public void setOriginalFilename3(String originalFilename3) {
		this.originalFilename3 = originalFilename3;
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
	
	public String getRegistdate() {
		return registdate;
	}
	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}
	@Override
	public String toString() {
		return "ProductDTO [pboard_no=" + pboard_no + ", resistdate=" + resistdate + ", title=" + title + ", pcontents="
				+ pcontents + ", pview=" + pview + ", id=" + id + ", username=" + username + ", isSell=" + isSell
				+ ", price=" + price + ", productType=" + productType + ", productLocation=" + productLocation
				+ ", imageNo=" + Arrays.toString(imageNo) + ", originalFilename1=" + originalFilename1
				+ ", originalFilename2=" + originalFilename2 + ", originalFilename3=" + originalFilename3 + ", image1="
				+ image1 + ", image2=" + image2 + ", image3=" + image3 + "]";
	}
	
	
}