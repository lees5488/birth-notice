package com.lee.birthnotice.dao;

import com.lee.birthnotice.model.BirthNotice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
			" email," +
			" send_type " +
			" FROM " +
			" birth_notice;";
	List<BirthNotice> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(BirthNotice.class));
	return list;
  }


  public int insertEntity(List<BirthNotice> data){
    String sql = "INSERT INTO birth_notice " +
			" (pinyin,name,nick,new_birth,old_birth,notes,id_card,phone,email,send_type) " +
			" VALUES(?,?,?,?,?,?,?,?,?,?)";
	List<Object[]> batchArgs = new ArrayList<>();
	data.stream().forEach(crap -> batchArgs.add(new Object[]{
			crap.getPinyin(),
			crap.getName(),
			crap.getNick(),
			crap.getNewBirth(),
			crap.getOldBirth(),
			crap.getNotes(),
			crap.getIdCard(),
			crap.getPhone(),
			crap.getEmail(),
			crap.getSendType()
	}));
	int[] result = jdbcTemplate.batchUpdate(sql,batchArgs);
	return Arrays.stream(result).sum();
  }

}
