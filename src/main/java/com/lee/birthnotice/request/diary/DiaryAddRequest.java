package com.lee.birthnotice.request.diary;

import com.lee.birthnotice.model.Diary;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lee5488
 * @version 1.0 2019/12/20
 */
@Data
public class DiaryAddRequest implements Serializable {
    private Diary diary;
}
