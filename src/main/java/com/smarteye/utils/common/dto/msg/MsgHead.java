package com.smarteye.utils.common.dto.msg;

import com.smarteye.utils.common.dto.CommonDTO;
import lombok.Data;

/**
 * 类实现描述：消息头定义
 * yinjie 2018/11/2 10:45
 */
@Data
public class MsgHead<T> extends CommonDTO
{
    public MsgHead()
    {

    }

    public MsgHead(MsgBody<T> msgBody)
    {
        this.msgBody = msgBody;
    }

    private String msgStyle = "json";
    private String msgToken;
    private MsgBody<T> msgBody;
}
