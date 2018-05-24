package com.example.dimit.portomontenegro.adapters;


import android.graphics.Bitmap;


public class Item {
	public String Name;
	public String Author;
	public String ShortDescription;
	public String Categories;
	public String Publisher;
	public String ISBN;
	public String CIP;
	public String COBISS;
	public String ImageUrl;
	public String Godina;
	public int IdBooks;
	public String BookUrl;
	public String Type="";
	public String ShortBookUrl;

	public String getShortBookUrl() {
		return ShortBookUrl;
	}

	public void setShortBookUrl(String shortBookUrl) {
		ShortBookUrl = shortBookUrl;
	}

	public int IdCategory;
	public int IdMyBooks;
	public String Description;

	public int IdPublisher;
	public String TitlePublisher;
	Bitmap image;
	String title;
	String datum;

	public Double Price=0.0;
	public Double DiscountPrice=0.0;
	public Double HardCopyPrice=0.0;

	public String Subtitle;

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getShortDescription() {
		return ShortDescription;
	}
	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}
	public String getCategories() {
		return Categories;
	}
	public void setCategories(String categories) {
		Categories = categories;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getCIP() {
		return CIP;
	}
	public void setCIP(String cIP) {
		CIP = cIP;
	}
	public String getCOBISS() {
		return COBISS;
	}
	public void setCOBISS(String cOBISS) {
		COBISS = cOBISS;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	int id;
	boolean isSelectedforDelete;

	public Item(String title){
		super();
		this.title=title;
		this.isSelectedforDelete = false;
	}
	public Item(String title, int id,String datum){
		super();
		this.title=title;
		this.id = id;
		this.datum = datum;
		this.isSelectedforDelete = false;
	}

	public Item(Bitmap image, String title) {
		super();
		this.image = image;
		this.title = title;
		this.id=-1;
		this.isSelectedforDelete = false;
	}
	public Item(Bitmap image, String title, int id) {
		super();
		this.image = image;
		this.title = title;
		this.id = id;
		this.isSelectedforDelete = false;
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public String getDatum() {
		return datum;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}


