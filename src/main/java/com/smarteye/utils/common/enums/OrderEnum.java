package com.smarteye.utils.common.enums;

/**
 * 类实现描述：指令枚举
 * yinjie 2018/10/25 16:45
 */
public interface OrderEnum
{
    enum OrderType
    {
        /**
         * 回包指令 1000
         */
        REPLY(1000), // 回包指令

        /**
         * 系统指令组 1001 - 1099
         */
        SYSTEM(1000), // 系统指令组

        /**
         * 告警指令组 1501 - 1999
         */
        ALARM(1500), // 告警指令组

        /**
         * 模块事件单元组 2001 - 4999
         */
        POLE_UNIT(2000), // 智能桩本身模块单元组, 如桩管理界面等
        CAMERA_UNIT(2100), // 摄像头模块单元组
        CHARGE_UNIT(2200), // 充电模块单元组

        /**
         * 参数设置/读取单元组 9000 - 9999
         */
        PARAM_SET(9000), // 参数设置指令组
        PARAM_READ(9500); // 参数读取指令组
        private int orderCode;
        OrderType(int orderCode)
        {
            this.orderCode = orderCode;
        }
        public int getOrderCode()
        {
            return this.orderCode;
        }
    }

    enum Reply
    {
        REPLY_ORDER(0);
        private int orderCode;
        Reply(int orderCode)
        {
            this.orderCode = OrderType.REPLY.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }

    /**
     * 系统指令组
     */
    enum System
    {
        REGISTER(1), //1001 开机上报
        HEARTBEAT(2); //1002 心跳
        private int orderCode;
        System(int orderCode)
        {
            this.orderCode = OrderType.SYSTEM.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }

    /**
     * 告警指令组
     */
    enum Alarm
    {
        CAMERA_BLIND(1), //1501 摄像头被遮挡
        CAMERA_SKEW(2); //1502 视频桩倾斜

        private int orderCode;
        Alarm(int orderCode)
        {
            this.orderCode = OrderType.ALARM.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }

    enum Pole
    {
        CALL_INSPECTOR(1);// 呼叫巡检员
        private int orderCode;
        Pole(int orderCode)
        {
            this.orderCode = OrderType.POLE_UNIT.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }

    /**
     * 摄像头指令组
     */
    enum Camera
    {
        CAMERA_CAR_MOVE(1), //2101 汽车驶入
        CAMERA_CAR_STOP(2), //2102 汽车停稳
        CAMERA_CAR_STOP_DETAIL(3), //2103 停车数据补充
        CAMERA_CAR_MONITOR(4), //2104 停车监控
        CAMERA_CAR_LEAVE(5), //2105 汽车离开
        CAMERA_CAR_UPLOAD(6), //2106 车牌图片上传
        CAMERA_CAR_PRICE(7), //2107 订单价格下发
        CAMERA_CAR_COMPLETE(8), //2108 支付完成下发
        CAMERA_CAR_PAY(9); //2109 发起支付,获取二维码

        private int orderCode;

        Camera(int orderCode)
        {
            this.orderCode = OrderType.CAMERA_UNIT.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }

    enum Charge
    {
        CHARGE_CHARGING_START(1),   //开始充电事件
        CHARGE_CHARGING_STOP(2),    //停止充电事件
        CHARGE_PRICE(3),            //充电中充电金额根据电量计算
        CHARGE_SCRAM_STOP(4),       //充电急停
        CHARGE_PRE_PAY(5),          //充电预付发起
        CHARGE_PRE_PAY_RESULT(6),   //充电预付支付结果
        CHARGE_START(7),            //开始充电
        CHARGE_STOP(8);             //停止充电
        private int orderCode;
        Charge(int orderCode)
        {
            this.orderCode = OrderType.CHARGE_UNIT.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }


    /**
     * 设置指令组
     */
    enum ParamSet
    {
        SET_BLUETOOTH_ENABLE(1),
        SET_BLUETOOTH_INFO(2),

        SET_WIFI_ENABLE(3),
        SET_WIFI_CONNECT(4),
        SET_WIFI_DISCONNECT(5),
        SET_WIFI_REMOVE(6),
        SET_PERSONAL_HOSTSPOT_ENABLE(7),

        CLEAR_RAM(8),
        CLEAR_ROM(9),
        SET_FLASH_LIGHT_ENABLE(10),
        SET_VOLUME(11),
        SET_SCREEN_INFO(12),
        QUIT_MAINTAIN(13),
        SET_FM_ENABLE(14),
        SET_GPS_ENABLE(14);

        private int orderCode;
        ParamSet(int orderCode)
        {
            this.orderCode = OrderType.PARAM_SET.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }


    /**
     * 读取指令组
     */
    enum ParamRead
    {
        READ_POLE_INFO(1),
        READ_POLE_HARDWARE_INFO(2),
        READ_BLUETOOTH_INFO(3),
        READ_NETWORK_INFO(4),
        READ_WIFI_INFO(5),
        READ_VOLUME(6),
        READ_SCREEN(7),
        READ_FM_INFO(8),
        READ_PERSONAL_HOTSPOT_INFO(9);


        private int orderCode;
        ParamRead(int orderCode)
        {
            this.orderCode = OrderType.PARAM_READ.orderCode + orderCode;
        }

        public int getOrderCode()
        {
            return this.orderCode;
        }
    }

    /**
     * 根据code 补0对齐
     *
     * @param code
     * @return
     */
    static String generateCode(int code)
    {
        return String.format("%02d", code);
    }
}
