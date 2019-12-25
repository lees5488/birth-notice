package com.lee.birthnotice.mapper;

import com.lee.birthnotice.model.PeriodInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lee5488
 * @version 1.0 2019/12/23
 */
@Mapper
public interface PeriodMapper {

    /**
     *
     * @param userId 用户ID
     * @return 信息
     */
    @Select("SELECT id, period_time_start, period_time_end, notes, apart, user_id, `interval`, create_date, update_date FROM period WHERE user_id = #{userId}")
    List<PeriodInfo> findByUserId(@Param("userId") Integer userId);
}
