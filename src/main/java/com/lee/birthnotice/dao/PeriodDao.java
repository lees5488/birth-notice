package com.lee.birthnotice.dao;

import com.lee.birthnotice.model.PeriodInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PeriodDao {


	@Resource(name = "birthJdbcTemplate")
	private JdbcTemplate jdbcTemplate;



	public List<PeriodInfo> findAllPeriodByUserId(Integer userId) {
		String sql = "SELECT " +
				" id, " +
				" period_time_start, " +
				" period_time_end, " +
				" notes, " +
				" apart, " +
				" user_id, " +
				" `interval`, " +
				" create_date, " +
				" update_date " +
				" FROM " +
				" period" +
				" WHERE user_id = ?;";
		List<PeriodInfo> list = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(PeriodInfo.class));
		return list;
	}

	/**
	 * insert
	 * @param periodInfo
	 */
	public void insert(PeriodInfo periodInfo){
		String sql = " insert into period " +
				" (period_time_start,period_time_end,notes,apart,user_id,`interval`,create_date,update_date) values " +
				" (?,?,?,?,?,?,?,?)";
		if(jdbcTemplate.update(sql, new Object[]{
				periodInfo.getPeriodTimeStart(),
				periodInfo.getPeriodTimeEnd(),
				periodInfo.getNotes(),
				periodInfo.getApart(),
				periodInfo.getUserId(),
				periodInfo.getInterval(),
				periodInfo.getCreateDate(),
				periodInfo.getUpdateDate()
		}) < 1){
			//failed
		}
	}

	/**
	 * update
	 * @param periodInfo
	 */
	public void updatePeriodById(PeriodInfo periodInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" update period set ");
		ArrayList<Object> params = new ArrayList<>();
		if (Objects.nonNull(periodInfo.getPeriodTimeStart())) {
			sql.append(" period_time_start = ? ,");
			params.add(periodInfo.getPeriodTimeStart());
		}
		if (Objects.nonNull(periodInfo.getPeriodTimeEnd())) {
			sql.append(" period_time_end = ?,");
			params.add(periodInfo.getPeriodTimeEnd());
		}
		if (!StringUtils.isEmpty(periodInfo.getNotes())){
			sql.append(" notes = ? ,");
			params.add(periodInfo.getNotes());
		}
		if (Objects.nonNull(periodInfo.getApart())){
			sql.append(" apart = ?, ");
			params.add(periodInfo.getApart());
		}
		if(Objects.nonNull(periodInfo.getUserId())){
			sql.append(" user_id = ? ,");
			params.add(periodInfo.getUserId());
		}
		if(Objects.nonNull(periodInfo.getInterval())){
			sql.append(" `interval` = ? ,");
			params.add(periodInfo.getInterval());
		}
		sql.append(" update_date = now() where id = ? ");
		params.add(periodInfo.getId());
		jdbcTemplate.update(sql.toString(),params.toArray());
	}
}
