package com.lee.birthnotice.mapper;

import com.lee.birthnotice.model.Diary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 * @author lee5488
 * @version 1.0 2020/1/3
 */

@Mapper
public interface DiaryMapper {

    @Insert("insert into diary (diary_date,content,weather,note) values(date_format(now(),'%Y-%m-%d'),#{content},#{weather},#{memo})")
    void insertDiary(Diary diary);

    @Select("select count(*) from diary where diary_date = date_format(now(),'%Y-%m-%d')")
    int getDiaryBydiaryDate();
}
