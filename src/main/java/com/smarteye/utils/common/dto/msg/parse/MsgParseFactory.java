package com.smarteye.utils.common.dto.msg.parse;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.smarteye.utils.common.dto.BaseDTO;
import com.smarteye.utils.common.dto.bluetooth.GetBluetoothInfoRes;
import com.smarteye.utils.common.dto.bluetooth.SetBluetoothEnableRes;
import com.smarteye.utils.common.dto.bluetooth.SetBluetoothInfoRes;
import com.smarteye.utils.common.dto.camera.CarLeaveReq;
import com.smarteye.utils.common.dto.camera.CarMoveReq;
import com.smarteye.utils.common.dto.camera.CarPayReq;
import com.smarteye.utils.common.dto.camera.CarStopReq;
import com.smarteye.utils.common.dto.fm.GetFmIfoRes;
import com.smarteye.utils.common.dto.fm.SetFmEnableRes;
import com.smarteye.utils.common.dto.msg.MsgHead;
import com.smarteye.utils.common.dto.network.*;
import com.smarteye.utils.common.dto.os.*;
import com.smarteye.utils.common.dto.pole.HeartBeatReq;
import com.smarteye.utils.common.dto.pole.OnlineReq;
import com.smarteye.utils.common.dto.screen.GetScreenInfoRes;
import com.smarteye.utils.common.dto.screen.SetScreenInfoRes;
import com.smarteye.utils.common.dto.sys.QuitMaintainRes;
import com.smarteye.utils.common.enums.OrderEnum;
import lombok.Data;

@Data
public class MsgParseFactory {
    public enum MsgType {
        none(0),
        req(1),
        res(2);
        private int value = 0;
        MsgType(int i) {
            value = i;
        }
        public int getValue() {
            return value;
        }
        public static MsgType convert(int i) {
            if(i == 1) return req;
            else if(i == 2) return res;
            else return none;
        }
    }
    //public abstract <T extends Object> T create(Class<T> c);
/*    public static MsgHead parse(String json, int cmd, MsgHeadObject.MsgType type) throws Exception {
        if(type == MsgHeadObject.MsgType.req) {
            return parseReq(json,cmd);
        } else if(type == MsgHeadObject.MsgType.res) {
            return parseRes(json,cmd);
        }
        throw new Exception("未知的消息类型");
    }*/

    /**
     * 只解析头部
     * @param jsonStr
     * @return
     */
    public static MsgHead parseHead(String jsonStr) {
        return JSONObject.parseObject(jsonStr, MsgHead.class);
    }

    public static MsgHead parse(String json, int cmd, MsgType type) throws Exception {
        if(type == MsgType.req) {
            return parseReq(json,cmd);
        } else if(type == MsgType.res) {
            return parseRes(json,cmd);
        }
        throw new Exception("未知的消息类型");
    }

    public static BaseDTO parseBodyData(MsgHead msgHead, int cmd, MsgType type) throws Exception {
        if(type == MsgType.req) {
            return parseBodyDataReq(msgHead);
        } else if(type == MsgType.res) {
            return parseBodyDataRes(msgHead,cmd);
        }
        throw new Exception("未知的消息类型");
    }

    public static BaseDTO parseBodyData(String data, int cmd, MsgType type) throws Exception {
        if(type == MsgType.req) {
            return parseBodyDataReq(data,cmd);
        } else if(type == MsgType.res) {
            return parseBodyDataRes(data,cmd);
        }
        throw new Exception("未知的消息类型");
    }

    /**
     * 解析整个json包
     * @param json
     * @param cmd
     * @return
     * @throws Exception
     */
    public static MsgHead parseReq(String json, int cmd) throws Exception {
        /************************ system **************************/
        /*
        REGISTER(1), //1001 开机上报
        HEARTBEAT(2); //1002 心跳
         */
        if(cmd == OrderEnum.System.REGISTER.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<OnlineReq>>(){});
        } else if(cmd == OrderEnum.System.HEARTBEAT.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<HeartBeatReq>>(){});
        }
        /************************ Camera **************************/
        /*
        CAMERA_CAR_MOVE(1), //2101 汽车驶入
        CAMERA_CAR_STOP(2), //2102 汽车停稳
        CAMERA_CAR_STOP_DETAIL(3), //2103 停车数据补充
        CAMERA_CAR_MONITOR(4), //2104 停车监控
        CAMERA_CAR_LEAVE(5), //2105 汽车离开
        CAMERA_CAR_UPLOAD(6), //2106 车牌图片上传
        CAMERA_CAR_PRICE(7), //2107 订单价格下发
        CAMERA_CAR_COMPLETE(8), //2108 支付完成下发
        CAMERA_CAR_PAY(9); //2109 发起支付,获取二维码
         */
        else if(cmd == OrderEnum.Camera.CAMERA_CAR_MOVE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<CarMoveReq>>(){});
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_STOP.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<CarStopReq>>(){});
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_STOP_DETAIL.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_MONITOR.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_LEAVE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<CarLeaveReq>>(){});
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_UPLOAD.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_PRICE.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_COMPLETE.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_PAY.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<CarPayReq>>(){});
        }
        throw new Exception("不支持的命令解析");
    }

/*    public static MsgHead parseReqMap(String json, int cmd) throws Exception {
        QSclazz qSclazz = MsgParseConf.getInstance().getReqMap().get(cmd);
        if(qSclazz == null) throw new Exception("不支持的命令");
        return  (MsgHead) JSONObject.parseObject(json, qSclazz.getAll());
    }*/

    /**
     * 解析msgHead中body.data部分然后添加回msgHead中
     * @param msgHead
     * @return
     * @throws Exception
     */
    public static MsgHead parseReq(MsgHead msgHead) throws Exception {
        msgHead.getMsgBody().setMsgData(parseBodyDataReq(msgHead));
        return msgHead;
    }

    /**
     * 解析msgHead中body.data部分
     * @param bodyData
     * @param cmd
     * @return
     * @throws Exception
     */
    public static BaseDTO parseBodyDataReq(String bodyData, int cmd) throws Exception {
        /************************ system **************************/
        /*
        REGISTER(1), //1001 开机上报
        HEARTBEAT(2); //1002 心跳
         */
        if(cmd == OrderEnum.System.REGISTER.getOrderCode()) {
            return JSONObject.parseObject(bodyData,OnlineReq.class);
        } else if(cmd == OrderEnum.System.HEARTBEAT.getOrderCode()) {
            return JSONObject.parseObject(bodyData,HeartBeatReq.class);
        }
        /************************ Camera **************************/
        /*
                CAMERA_CAR_MOVE(1), //2101 汽车驶入
        CAMERA_CAR_STOP(2), //2102 汽车停稳
        CAMERA_CAR_STOP_DETAIL(3), //2103 停车数据补充
        CAMERA_CAR_MONITOR(4), //2104 停车监控
        CAMERA_CAR_LEAVE(5), //2105 汽车离开
        CAMERA_CAR_UPLOAD(6), //2106 车牌图片上传
        CAMERA_CAR_PRICE(7), //2107 订单价格下发
        CAMERA_CAR_COMPLETE(8), //2108 支付完成下发
        CAMERA_CAR_PAY(9); //2109 发起支付,获取二维码
         */
        else if(cmd == OrderEnum.Camera.CAMERA_CAR_MOVE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,CarMoveReq.class);
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_STOP.getOrderCode()) {
            return JSONObject.parseObject(bodyData,CarStopReq.class);
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_STOP_DETAIL.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_MONITOR.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_LEAVE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,CarLeaveReq.class);
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_UPLOAD.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_PRICE.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_COMPLETE.getOrderCode()) {
            ;
        } else if(cmd == OrderEnum.Camera.CAMERA_CAR_PAY.getOrderCode()) {
            return JSONObject.parseObject(bodyData,CarPayReq.class);
        }
        throw new Exception("不支持的命令解析");
    }

    public static BaseDTO parseBodyDataReq(MsgHead msgHead) throws Exception {
        return parseBodyDataReq(msgHead.getMsgBody().getMsgData().toString(),msgHead.getMsgBody().getMsgOrder().intValue());
    }

    public static BaseDTO parseBodyDataReqMap(String bodyData, int cmd) throws Exception {
        Class<?> aClass = MsgParseConf.getInstance().getReqMap().get(cmd);
        if(aClass == null) throw new Exception("不支持的命令");
        return  (BaseDTO) JSONObject.parseObject(bodyData, aClass);
    }

    /**
     * 解析整个回包
     * @param json
     * @param cmd
     * @return
     * @throws Exception
     */
    public static MsgHead parseRes(String json, int cmd) throws Exception {
        /************************ ParamRead **************************/
        /**
         *         READ_POLE_INFO(1),
         *         READ_POLE_HARDWARE_INFO(2),
         *         READ_BLUETOOTH_INFO(3),
         *         READ_NETWORK_INFO(4),
         *         READ_WIFI_INFO(5),
         *         READ_VOLUME(6),
         *         READ_SCREEM(7),
         *         READ_FM_INFO(8);
         */
        if(cmd == OrderEnum.ParamRead.READ_POLE_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetPoleInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamRead.READ_POLE_HARDWARE_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetPoleHardwareInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamRead.READ_BLUETOOTH_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetBluetoothInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamRead.READ_NETWORK_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetNetworkInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamRead.READ_WIFI_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetWifiInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamRead.READ_VOLUME.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetVolumeInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamRead.READ_SCREEN.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetScreenInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamRead.READ_FM_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<GetFmIfoRes>>(){});
        }
        /************************ ParamSet **************************/
        /**
         * SET_BLUETOOTH_ENABLE(1),
         *         SET_BLUETOOTH_INFO(2),
         *
         *         SET_WIFI_ENABLE(3),
         *         SET_WIFI_CONNECT(4),
         *         SET_WIFI_DISCONNECT(5),
         *         SET_WIFI_REMOVE(6),
         *         SET_PERSONAL_HOSTSPOT_ENABLE(7),
         *
         *         CLEAR_RAM(8),
         *         CLEAR_ROM(9),
         *         SET_FLASH_LIGHT_ENABLE(10),
         *         SET_VOLUME(11),
         *         SET_SCREEN_INFO(12),
         *         QUIT_MAINTAIN(13),
         *         SET_FM_ENABLE(14),
         *         SET_GPS_ENABLE(14);
         */
        else if(cmd == OrderEnum.ParamSet.SET_BLUETOOTH_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetBluetoothEnableRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_BLUETOOTH_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetBluetoothInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetWifiEnableRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_CONNECT.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<ConnectWifiRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_DISCONNECT.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<DisconnectWifiRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_REMOVE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<RemoveWifiRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_PERSONAL_HOSTSPOT_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetPersonalHotspotEnableRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.CLEAR_RAM.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<ClearRamRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.CLEAR_ROM.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<ClearRomRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_FLASH_LIGHT_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetFlashLightEnableRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_VOLUME.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetVolumeRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_SCREEN_INFO.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetScreenInfoRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.QUIT_MAINTAIN.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<QuitMaintainRes>>(){});
        } else if(cmd == OrderEnum.ParamSet.SET_FM_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetFmEnableRes>>(){});
        }  else if(cmd == OrderEnum.ParamSet.SET_GPS_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(json,new TypeReference<MsgHead<SetGpsEnableRes>>(){});
        }
        throw new Exception("不支持的命令解析");
    }

 /*   public static MsgHead parseResMap(String json, int cmd) throws Exception {
        Class<?> aClass = MsgParseConf.getInstance().getResMap().get(cmd);
        if(aClass == null) throw new Exception("不支持的命令");
        return  (MsgHead) JSONObject.parseObject(json, aClass);
    }*/

    /**
     * 解析回包
     * @param msgHead
     * @param cmd
     * @return
     * @throws Exception
     */
    public static MsgHead parseRes(MsgHead msgHead, int cmd) throws Exception {
        msgHead.getMsgBody().setMsgData(parseBodyDataRes(msgHead,cmd));
        return msgHead;
    }

    /**
     * 解析msgHead中body.data部分
     * @param bodyData
     * @param cmd
     * @return
     * @throws Exception
     */
    public static BaseDTO parseBodyDataRes(String bodyData, int cmd) throws Exception {
        /************************ ParamRead **************************/
        /**
         *         READ_POLE_INFO(1),
         *         READ_POLE_HARDWARE_INFO(2),
         *         READ_BLUETOOTH_INFO(3),
         *         READ_NETWORK_INFO(4),
         *         READ_WIFI_INFO(5),
         *         READ_VOLUME(6),
         *         READ_SCREEM(7),
         *         READ_FM_INFO(8);
         */
        if(cmd == OrderEnum.ParamRead.READ_POLE_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetPoleInfoRes.class);
        } else if(cmd == OrderEnum.ParamRead.READ_POLE_HARDWARE_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetPoleHardwareInfoRes.class);
        } else if(cmd == OrderEnum.ParamRead.READ_BLUETOOTH_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetBluetoothInfoRes.class);
        } else if(cmd == OrderEnum.ParamRead.READ_NETWORK_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetNetworkInfoRes.class);
        } else if(cmd == OrderEnum.ParamRead.READ_WIFI_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetWifiInfoRes.class);
        } else if(cmd == OrderEnum.ParamRead.READ_VOLUME.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetVolumeInfoRes.class);
        } else if(cmd == OrderEnum.ParamRead.READ_SCREEN.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetScreenInfoRes.class);
        } else if(cmd == OrderEnum.ParamRead.READ_FM_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,GetFmIfoRes.class);
        }
        /************************ ParamSet **************************/
        /**
         * SET_BLUETOOTH_ENABLE(1),
         *         SET_BLUETOOTH_INFO(2),
         *
         *         SET_WIFI_ENABLE(3),
         *         SET_WIFI_CONNECT(4),
         *         SET_WIFI_DISCONNECT(5),
         *         SET_WIFI_REMOVE(6),
         *         SET_PERSONAL_HOSTSPOT_ENABLE(7),
         *
         *         CLEAR_RAM(8),
         *         CLEAR_ROM(9),
         *         SET_FLASH_LIGHT_ENABLE(10),
         *         SET_VOLUME(11),
         *         SET_SCREEN_INFO(12),
         *         QUIT_MAINTAIN(13),
         *         SET_FM_ENABLE(14),
         *         SET_GPS_ENABLE(14);
         */
        else if(cmd == OrderEnum.ParamSet.SET_BLUETOOTH_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetBluetoothEnableRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_BLUETOOTH_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetBluetoothInfoRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetWifiEnableRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_CONNECT.getOrderCode()) {
            return JSONObject.parseObject(bodyData,ConnectWifiRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_DISCONNECT.getOrderCode()) {
            return JSONObject.parseObject(bodyData,DisconnectWifiRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_WIFI_REMOVE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,RemoveWifiRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_PERSONAL_HOSTSPOT_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetPersonalHotspotEnableRes.class);
        } else if(cmd == OrderEnum.ParamSet.CLEAR_RAM.getOrderCode()) {
            return JSONObject.parseObject(bodyData,ClearRamRes.class);
        } else if(cmd == OrderEnum.ParamSet.CLEAR_ROM.getOrderCode()) {
            return JSONObject.parseObject(bodyData,ClearRomRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_FLASH_LIGHT_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetFlashLightEnableRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_VOLUME.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetVolumeRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_SCREEN_INFO.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetScreenInfoRes.class);
        } else if(cmd == OrderEnum.ParamSet.QUIT_MAINTAIN.getOrderCode()) {
            return JSONObject.parseObject(bodyData,QuitMaintainRes.class);
        } else if(cmd == OrderEnum.ParamSet.SET_FM_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetFmEnableRes.class);
        }  else if(cmd == OrderEnum.ParamSet.SET_GPS_ENABLE.getOrderCode()) {
            return JSONObject.parseObject(bodyData,SetGpsEnableRes.class);
        }
        throw new Exception("不支持的命令解析");
    }

    public static BaseDTO parseBodyDataRes(MsgHead msgHead, int cmd) throws Exception {
        return parseBodyDataRes(msgHead.getMsgBody().getMsgData().toString(),cmd);
    }

    public static BaseDTO parseBodyDataResMap(String bodyData, int cmd) throws Exception {
        Class<?> aClass = MsgParseConf.getInstance().getResMap().get(cmd);
        if(aClass == null) throw new Exception("不支持的命令");
        return  (BaseDTO) JSONObject.parseObject(bodyData, aClass);
    }

    public static String createJson(MsgHead msgHead) throws Exception {
        return JSONObject.toJSONString(msgHead);
    }

}


