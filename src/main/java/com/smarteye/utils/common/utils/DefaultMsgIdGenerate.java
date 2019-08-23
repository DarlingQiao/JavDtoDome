package com.smarteye.utils.common.utils;

import com.smarteye.utils.common.enums.MsgIdManagerEnum;

import java.util.Calendar;

/**
 * 类实现描述：唯一消息ID默认实现
 * yinjie 2018/11/5 11:29
 */
public class DefaultMsgIdGenerate extends MsgIdGenerate
{
    /**
     * workerId, datacenterId 需要根据需要更改
     */
    private static final long workerId = MsgIdManagerEnum.WorkerGroup.WORKER_0.getGroupCode();
    private static final long dataCenterId = MsgIdManagerEnum.DataCenterGroup.HZ.getGroupCode();

    public static final MsgIdGenerate getInstance()
    {
        return DefaultMsgIdGenerateHolder.INSTANCE;
    }

    @Override
    public long getWorkerId()
    {
        return workerId;
    }

    @Override
    public long getDataCenterId()
    {
        return dataCenterId;
    }

    private static class DefaultMsgIdGenerateHolder
    {
        private static final DefaultMsgIdGenerate INSTANCE = new DefaultMsgIdGenerate();
    }

    public static void main(String[] args)
    {
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(DefaultMsgIdGenerate.getInstance().createMsgId());
        System.out.println(DefaultMsgIdGenerate.getInstance().createMsgId());
    }
}

