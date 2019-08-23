package com.smarteye.utils.common.dto.msg;

import com.smarteye.utils.common.dto.CommonDTO;
import lombok.Data;

/**
 * 类实现描述：
 * yinjie 2018/11/2 10:46
 */

@Data
public class MsgBody<T> extends CommonDTO
{
    public MsgBody()
    {

    }

    MsgBody(T msgData)
    {
        this.msgData = msgData;
    }
    private String msgId;
    private String repayMsgId;
    private Integer msgOrder;
    private Long msgTimestamp;

    private T msgData;
}
