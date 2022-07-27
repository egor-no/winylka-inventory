package com.winylka.jsf;

import java.time.LocalDate;

public class CatalogItem {

	private Long itemId; 
	private String artistName; 
	private String albumTitle;
	private String albumInfo; 
	private Integer albumYear; 
	private LocalDate releaseDate;
	private String format;
	private String notes; //notes such as vinyl colour, ltd edition, etc.
	private String label;
	
	public CatalogItem() {
		
	}
	
	public CatalogItem(Long id, String artistName, String albumTitle, String albumInfo, Integer albumYear, LocalDate releaseDate,
			String format, String notes, String label) {
		super();
		this.itemId = id;
		this.artistName = artistName;
		this.albumTitle = albumTitle;
		this.albumInfo = albumInfo;
		this.albumYear = albumYear;
		this.releaseDate = releaseDate;
		this.format = format;
		this.notes = notes;
		this.label = label;
	}
	
	public Long getItemId() {
		return itemId; 
	}
	
	public void setItemId(Long id) {
		this.itemId = id; 
	}
	
	public String getArtistName() {
		return artistName;
	}
	
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	
	public String getAlbumInfo() {
		return albumInfo;
	}
	
	public void setAlbumInfo(String albumInfo) {
		this.albumInfo = albumInfo;
	}
	
	public Integer getAlbumYear() {
		return albumYear;
	}
	
	public void setAlbumYear(Integer albumYear) {
		this.albumYear = albumYear;
	}
	
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	} 
	
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(this.itemId + ": ");
		sb.append(this.artistName + " " + this.albumTitle); 
		sb.append(" (" + this.albumYear + "). " + this.albumInfo);
		sb.append(this.format + " " + this.notes + ". Out " + this.releaseDate + " on " + this.label);
		
		return sb.toString();
	}
	
}
