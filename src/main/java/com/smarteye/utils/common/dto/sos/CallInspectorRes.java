package com.smarteye.utils.common.dto.sos;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 呼叫巡检员回包
 */

@Data
public class CallInspectorRes extends BaseResponseData {
    private String inspectorId;     //巡检员id
}

