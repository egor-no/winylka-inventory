package com.winylka;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@LocalBean
public class Catalog implements CatalogLocal {
	
	@PersistenceContext 
	private EntityManager entityManager; 
	
	private List<CatalogItem> items = new ArrayList<>(); 

    public Catalog() {
    }

	@Override
	public List<CatalogItem> getItems() {
		return this.entityManager.createQuery("select c from CatalogItem c", CatalogItem.class)
				.getResultList();
	}

	@Override
	public void addItem(CatalogItem item) {
		this.entityManager.persist(item);
	}

	@Override
	public CatalogItem findItem(Long itemId) {
		return this.entityManager.find(CatalogItem.class, itemId);
	}

	@Override
	public void deleteItem(CatalogItem item) {
		this.entityManager.remove(this.entityManager.contains(item) ? item : this.entityManager.merge(item));
	}

	@Override
	public List<CatalogItem> searchByArtistName(String name) {
		return this.entityManager
				.createQuery("select c from CatalogItem c " + " where c.artistName like :name", CatalogItem.class)
				.setParameter("name", "%" + name + "%").getResultList();
				
	}
	
	@Override
	public List<CatalogItem> searchByAlbumTitle(String title) {
		return this.entityManager
				.createQuery("select c from CatalogItem c " + " where c.albumTitle like :title", CatalogItem.class)
				.setParameter("title", "%" + title + "%").getResultList();
	}

}
