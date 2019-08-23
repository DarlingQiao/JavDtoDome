package com.smarteye.utils.common.dto.charge;


import com.smarteye.utils.common.dto.BaseDTO;
import com.smarteye.utils.common.dto.charge.struct.ChargeInfo;
import lombok.Data;

import java.util.List;

/**
 * 急停事件
 */

@Data
public class ChargeScramReq extends BaseDTO {
    private String type;//急停类型
    private Long time;//急停时间
    private List<ChargeInfo> list;

    public static transient String type_button = "1";//物理按钮急停
    public static transient String type_overdrive = "2";//过载急停
    public static transient String type_leakage = "3";//漏电急停
}
