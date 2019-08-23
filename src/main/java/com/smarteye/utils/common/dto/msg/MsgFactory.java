package com.smarteye.utils.common.dto.msg;

import com.smarteye.utils.common.enums.OrderEnum;
import com.smarteye.utils.common.utils.DefaultMsgIdGenerate;

import java.util.Calendar;

/**
 * 类实现描述：消息工厂
 * yinjie 2018/11/2 15:15
 */
public class MsgFactory
{
    public static <T> MsgHead<T> createMsg(T msgData)
    {
        MsgHead<T> msgHead = new MsgHead<>(new MsgBody<>(msgData));
        setHead(msgHead);
        return msgHead;
    }

    public static <T> MsgHead<T> createMsg(T msgData, String msgStyle,String msgToken,String msgId,String repayMsgId,int msgOrder)
    {
        MsgHead<T> msgHead = new MsgHead<>(new MsgBody<>(msgData));
        msgHead.setMsgStyle(msgStyle);
        msgHead.setMsgToken(msgToken);
        msgHead.getMsgBody().setMsgId(msgId);
        msgHead.getMsgBody().setRepayMsgId(repayMsgId);
        msgHead.getMsgBody().setMsgOrder(msgOrder);
        return msgHead;
    }

    public static <T> MsgHead<T> createMsg(T msgData, String msgId,String repayMsgId,int msgOrder)
    {
        MsgHead<T> msgHead = createMsgByOrder(msgData,msgOrder);
        msgHead.getMsgBody().setRepayMsgId(repayMsgId);
        msgHead.getMsgBody().setMsgId(msgId);
        return msgHead;
    }

    public static <T> MsgHead<T> createMsgByOrder(T msgData, int msgOrder)
    {
        MsgHead<T> msgHead = createMsg(msgData);
        setOrder(msgHead, msgOrder);
        return msgHead;
    }

    public static <T> MsgHead<T> createReplyMsgForSuccess(T msgData)
    {
        return createMsgByOrder(msgData, OrderEnum.OrderType.REPLY.getOrderCode());
    }

    public static MsgHead createReplyMsgForSuccess()
    {
        return createMsgByOrder(null, OrderEnum.OrderType.REPLY.getOrderCode());
    }

    /**
     * 设置默认消息头
     *
     * @param msgHead
     */
    private static void setHead(MsgHead msgHead)
    {
        msgHead.setMsgStyle("json");
        msgHead.setMsgToken("test_nobody");
        msgHead.getMsgBody().setMsgId(DefaultMsgIdGenerate.getInstance().nextId() + "");
        msgHead.getMsgBody().setMsgTimestamp(Calendar.getInstance().getTimeInMillis());
    }

    private static void setHead(MsgHead msgHead, int msgOrder)
    {
        setHead(msgHead);
        setOrder(msgHead, msgOrder);
    }

    private static void setOrder(MsgHead msgHead, int msgOrder)
    {
        msgHead.getMsgBody().setMsgOrder(msgOrder);
    }
}

