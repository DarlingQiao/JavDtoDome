package com.smarteye.utils.common.enums;

/**
 * 类实现描述：TODO 类实现描述
 * yinjie 2018/11/5 11:18
 */
public interface MsgIdManagerEnum
{
    enum DataCenterGroup
    {
        /**
         * 数据中心组
         *
         * id从 0 - 31
         */
        HZ(0); // 杭州

        private int groupCode;
        DataCenterGroup(int orderCode)
        {
            this.groupCode = orderCode;
        }
        public int getGroupCode()
        {
            return this.groupCode;
        }
    }

    enum WorkerGroup
    {
        /**
         * 计算节点组
         *
         * id从 0 - 31
         */
        WORKER_0(0); // 0号节点 web-api 在使用

        private int groupCode;
        WorkerGroup(int orderCode)
        {
            this.groupCode = orderCode;
        }
        public int getGroupCode()
        {
            return this.groupCode;
        }
    }
}
