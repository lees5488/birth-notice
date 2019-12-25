package com.lee.birthnotice.mapper;

import com.lee.birthnotice.model.FestivalNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lee5488
 * @version 1.0 2019/12/25
 */
@Mapper
public interface FestivalNoticeMapper {

    /**
     * 根据 type 查询
     * @param type 类型
     * @return 节日提醒
     */
    @Select("select id,notice_type noticeType,notice_date noticeDate,note,create_date createDate,update_date updateDate from festival_notice where notice_type = #{type}")
    List<FestivalNotice> findAllFestivalNoticeByType(@Param("type") Integer type);

}
