package com.deep.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deep.dao.mapper.ProductRowMapper;
import com.deep.entity.Product;

public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Product product) {
		jdbcTemplate.update("insert into product value(" + product.getId() + ",'" + product.getName() + "','"
				+ product.getDescription() + "','" + product.getPrice() + "'");

	}

	@Override
	public void update(int id, int price) {

		jdbcTemplate.update("update product set price=" + price + " where id=" + id);
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("delete from product where id=" + id);

	}

	@Override
	public Product find(int id) {
		Product product=jdbcTemplate.queryForObject("select * from product where id="+ id, new ProductRowMapper());
		return product;
	}

}
