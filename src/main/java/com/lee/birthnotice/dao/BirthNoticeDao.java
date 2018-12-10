package com.lee.birthnotice.dao;

import com.lee.birthnotice.model.BirthNotice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BirthNoticeDao {

  @Resource(name = "birthJdbcTemplate")
  private JdbcTemplate jdbcTemplate;


  public List<BirthNotice> getEntity() {
	String sql = "SELECT " +
			" id, " +
			" pinyin, " +
			" NAME, " +
			" nick, " +
			" new_birth, " +
			" old_birth, " +
			" notes, " +
			" id_card, " +
			" phone, " +
			" email " +
			" FROM " +
			" birth_notice;";
	List<BirthNotice> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(BirthNotice.class));
	return list;
  }

}
