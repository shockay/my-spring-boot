package com.areca.my_spring_boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// @Transaction(readOnly=true)
	public <T> List<T> queryForList(final Class<T> clazz, String sql, Object... args) {

		final List<T> items = new ArrayList<T>();

		jdbcTemplate.query(sql, args, new ResultSetExtractor<Object>() {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				int currentRow = 0;
				while (rs.next()) {
					items.add((T) new BeanPropertyRowMapper(clazz).mapRow(rs, currentRow));
					currentRow++;
				}
				return items;
			}
		});

		return items;
	}

	@SuppressWarnings("unchecked")
	public <T> T queryForObject(final Class<T> clazz, String sql, Object...args){
		
		if(clazz == String.class || clazz == Integer.class){
			return (T)jdbcTemplate.queryForObject(sql, clazz,args);
		}
		
		return (T) jdbcTemplate.query(sql, args, new ResultSetExtractor<Object>(){

			@SuppressWarnings("rawtypes")
			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					return (T)new BeanPropertyRowMapper(clazz).mapRow(rs, 0);
				}else{
					return null;
				}
			}
		});
	}
	
	
	@Transactional
	public int update(String sql, Object...args){
		return jdbcTemplate.update(sql,args);
	}

}
