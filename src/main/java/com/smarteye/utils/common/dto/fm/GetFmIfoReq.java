package com.smarteye.utils.common.dto.fm;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;


/**
 * 获取调频收音机的信息
 */

@Data
public class GetFmIfoReq extends BaseDTO {
    private boolean searchInfoList;//是否获取搜索列表
}
