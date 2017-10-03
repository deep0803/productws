package com.deep.dao;

import com.deep.entity.Product;

public interface ProductDAO {

	void create(Product product);
	void update(int id,int price);
	void delete(int id);
	Product find(int id);
}
