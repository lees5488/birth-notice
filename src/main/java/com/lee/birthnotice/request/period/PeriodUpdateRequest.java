package com.lee.birthnotice.request.period;

import com.lee.birthnotice.model.PeriodInfo;
import com.lee.birthnotice.request.BaseSessionRequest;
import lombok.Data;


@Data
public class PeriodUpdateRequest extends BaseSessionRequest {
	private static final long serialVersionUID = 6345945401684908328L;
	private PeriodInfo periodInfo;
}
