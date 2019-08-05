package com.lee.birthnotice.request.period;

import com.lee.birthnotice.model.PeriodInfo;
import com.lee.birthnotice.request.BaseSessionRequest;
import lombok.Data;

@Data
public class PeriodAddRequest extends BaseSessionRequest {
	private static final long serialVersionUID = 4699061714646115306L;
	private PeriodInfo periodInfo;
}
