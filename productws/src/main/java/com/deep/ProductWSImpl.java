package com.deep;

import javax.ws.rs.core.Response;

import com.deep.dao.ProductDAO;
import com.deep.dto.Product;

public class ProductWSImpl implements ProductWS {

	private ProductDAO dao;
	
	@Override
	public Response add(Product product) {
		com.deep.entity.Product productEntity = mapWstoDAO(product);
		dao.create(productEntity);
		return Response.ok().build();
	}

	private com.deep.entity.Product mapWstoDAO(Product product) {
		com.deep.entity.Product productEntity = new com.deep.entity.Product();
		productEntity.setId(product.getId());
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setPrice(product.getPrice());
		return productEntity;
	}

	@Override
	public Response update(Product product) {
		dao.update(product.getId(),product.getPrice());
		return Response.ok().build();
	}

	@Override
	public Response delete(int id) {
		dao.delete(id);
		return Response.ok().build();
	}

	@Override
	public Product find(int id) {
		com.deep.entity.Product productEntity = dao.find(id);
		Product product = mapDAOToWS(productEntity);
		return product;
	}

	private Product mapDAOToWS(com.deep.entity.Product productEntity) {
		Product product=new Product();
		product.setId(productEntity.getId());
		product.setName(productEntity.getName());
		product.setDescription(productEntity.getDescription());
		product.setPrice(productEntity.getPrice());
		return product;
	}

	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

}
