package com.winylka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="RELEASE")
public class CatalogItem {

	private volatile int hashCode;
	
	@Id
	@Column(name="RELEASE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long itemId; 
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name="CATALOG_ITEM_ID"), 
			inverseJoinColumns = @JoinColumn(name="ITEM_MANAGER_ID"))
	private List<ItemManager> itemManagers = new ArrayList<>(); 
	
	@Column(name="ARTIST_NAME")
	private String artistName; 
	
	@Column(name="ALBUM_TITLE")
	private String albumTitle;
	
	@Column(name="ALBUM_INFO")
	private String albumInfo; 
	
	@Column(name="ALBUM_YEAR")
	private Integer albumYear; 
	
	@Column(name="RELEASE_DATE")
	private LocalDate releaseDate;
	
	@Column(name="FORMAT")
	private String format;
	
	@Column(name="NOTES")
	private String notes; //notes such as vinyl colour, ltd edition, etc.
	
	@Column(name="LABEL")
	private String label;
	
	public CatalogItem() {
		
	}
	
	public CatalogItem(String artistName, String albumTitle, String albumInfo, Integer albumYear, LocalDate releaseDate,
			String format, String notes, String label) {
		super();
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
	
	public List<ItemManager> getItemManagers() {
		return itemManagers;
	}

	public void setItemManagers(List<ItemManager> itemManagers) {
		this.itemManagers = itemManagers;
	}
	
	@Override 
	public boolean equals(Object o) {
		if (this == o) 
			return true; 
		if (!(o instanceof CatalogItem))
			return false; 
		CatalogItem that = (CatalogItem) o; 
		return this.itemId == that.itemId;
	}
	
	@Override 
	public int hashCode() {
		int n = (int) (this.itemId / 1); 
		return 17 +  n * 31; 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(this.itemId + ": ");
		sb.append(this.artistName + " " + this.albumTitle); 
		sb.append(" (" + this.albumYear + "). ");
		if (isNotEmpty(this.albumInfo)) 
			sb.append(this.albumInfo + " ");
		if (isNotEmpty(this.format)) 
			sb.append(this.format + " ");
		if (isNotEmpty(this.notes)) 
			sb.append(this.notes + ".");
		if (this.releaseDate != null) 
			sb.append("Out " + this.releaseDate);
		if (isNotEmpty(this.label))
			sb.append(" on " + this.label);
		return sb.toString();
	}
	
	private boolean isNotEmpty(String string) {
		return string != null && string.isBlank(); 
	}
	
}
