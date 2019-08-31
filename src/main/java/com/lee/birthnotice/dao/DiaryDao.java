package com.lee.birthnotice.dao;

import com.lee.birthnotice.model.Diary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DiaryDao {

	@Resource(name = "birthJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Diary> findAllDiary(Integer page,Integer pageSize){
		String sql = "select id,content,weather,memo,create_date,update_date from diary " +
				" limit ";
		return null;
	}

}
