package com.smarteye.utils.common.utils;

/**
 * 类实现描述：消息唯一ID生成器
 * yinjie 2018/11/5 14:09
 */
public abstract class MsgIdGenerate extends SnowflakeIdWorker implements MsgId
{
    /**
     * 工作ID (0~31)
     */
    public abstract long getWorkerId();

    /**
     * 数据中心ID (0~31)
     */
    public abstract long getDataCenterId();

    @Override
    public long createMsgId()
    {
        return nextId();
    }
}
