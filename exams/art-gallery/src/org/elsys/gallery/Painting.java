package org.elsys.gallery;

public class Painting {

	private String artist;
	private String title;
	private int year;
	private double price;

	public Painting(String artist, String title, int year, double price) {
		this.artist = artist;
		this.title = title;
		this.year = year;
		this.price = price;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}
}
