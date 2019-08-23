package com.smarteye.utils.common.dto.msg.parse;

import com.smarteye.utils.common.dto.bluetooth.*;
import com.smarteye.utils.common.dto.camera.*;
import com.smarteye.utils.common.dto.fm.GetFmIfoReq;
import com.smarteye.utils.common.dto.fm.GetFmIfoRes;
import com.smarteye.utils.common.dto.fm.SetFmEnableReq;
import com.smarteye.utils.common.dto.fm.SetFmEnableRes;
import com.smarteye.utils.common.dto.msg.MsgHead;
import com.smarteye.utils.common.dto.network.*;
import com.smarteye.utils.common.dto.os.*;
import com.smarteye.utils.common.dto.pole.HeartBeatReq;
import com.smarteye.utils.common.dto.pole.OnlineReq;
import com.smarteye.utils.common.dto.pole.OnlineRes;
import com.smarteye.utils.common.dto.screen.GetScreenInfoReq;
import com.smarteye.utils.common.dto.screen.GetScreenInfoRes;
import com.smarteye.utils.common.dto.screen.SetScreenInfoReq;
import com.smarteye.utils.common.dto.screen.SetScreenInfoRes;
import com.smarteye.utils.common.dto.sys.QuitMaintainReq;
import com.smarteye.utils.common.dto.sys.QuitMaintainRes;
import com.smarteye.utils.common.enums.OrderEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;



@Data
public final class MsgParseConf {
    private static final MsgParseConf conf = new MsgParseConf();
    public static MsgParseConf getInstance() {
        return conf;
    }
    private Map<Integer, Class<?>> reqMap = new HashMap<>();
    private Map<Integer, Class<?> > resMap = new HashMap<>();
    Class<?> aClass1;
    private MsgParseConf() {
        initReqMap();
        initResMap();//new TypeReference<MsgHead<SetFlashLightEnableRes>()
        aClass1 = new MsgHead<OnlineReq>() {}.getClass();
    }

    public  Class<?> get() {
       //Class<?> aClass1 = new MsgHead<OnlineReq>() {}.getClass();
        return aClass1;
    }

    private void initReqMap() {
        reqMap.put(OrderEnum.System.REGISTER.getOrderCode(), OnlineReq.class/*new QSclazz(OnlineReq.class,new MsgHead<OnlineReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.System.HEARTBEAT.getOrderCode(), HeartBeatReq.class/*new QSclazz(HeartBeatReq.class,new MsgHead<HeartBeatReq>(){}.getClass())*/);
        /**
         *         CAMERA_CAR_MOVE(1), //2101 汽车驶入
         *         CAMERA_CAR_STOP(2), //2102 汽车停稳
         *         CAMERA_CAR_STOP_DETAIL(3), //2103 停车数据补充
         *         CAMERA_CAR_MONITOR(4), //2104 停车监控
         *         CAMERA_CAR_LEAVE(5), //2105 汽车离开
         *         CAMERA_CAR_UPLOAD(6), //2106 车牌图片上传
         *         CAMERA_CAR_PRICE(7), //2107 订单价格下发
         *         CAMERA_CAR_COMPLETE(8), //2108 支付完成下发
         *         CAMERA_CAR_PAY(9); //2109 发起支付,获取二维码
         */
        reqMap.put(OrderEnum.Camera.CAMERA_CAR_MOVE.getOrderCode(), CarMoveReq.class/*new QSclazz(CarMoveReq.class,new MsgHead<CarMoveReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.Camera.CAMERA_CAR_STOP.getOrderCode(), CarStopReq.class/*new QSclazz(CarStopReq.class,new MsgHead<CarStopReq>(){}.getClass())*/);
        //reqMap.put(OrderEnum.Camera.CAMERA_CAR_STOP_DETAIL.getOrderCode(), );
        //reqMap.put(OrderEnum.Camera.CAMERA_CAR_MONITOR.getOrderCode(), );
        reqMap.put(OrderEnum.Camera.CAMERA_CAR_LEAVE.getOrderCode(), CarLeaveReq.class/*new QSclazz(CarLeaveReq.class,new MsgHead<CarLeaveReq>(){}.getClass())*/);
        //reqMap.put(OrderEnum.Camera.CAMERA_CAR_UPLOAD.getOrderCode(), );
        reqMap.put(OrderEnum.Camera.CAMERA_CAR_PRICE.getOrderCode(), CarPriceReq.class/*new QSclazz(CarPriceReq.class,new MsgHead<CarPriceReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.Camera.CAMERA_CAR_COMPLETE.getOrderCode(), CarCompleteReq.class/*new QSclazz(CarCompleteReq.class,new MsgHead<CarCompleteReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.Camera.CAMERA_CAR_PAY.getOrderCode(), CarPayReq.class/*new QSclazz(CarPayReq.class,new MsgHead<CarPayReq>(){}.getClass())*/);
        /**
         *         SET_BLUETOOTH_ENABLE(1),
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
        reqMap.put(OrderEnum.ParamSet.SET_BLUETOOTH_ENABLE.getOrderCode(), SetBluetoothEnableReq.class/*new QSclazz(SetBluetoothEnableReq.class,new MsgHead<SetBluetoothEnableReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_BLUETOOTH_INFO.getOrderCode(), SetBluetoothInfoReq.class/*new QSclazz(SetBluetoothInfoReq.class,new MsgHead<SetBluetoothInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_WIFI_ENABLE.getOrderCode(), SetWifiEnableReq.class/*new QSclazz(SetWifiEnableReq.class,new MsgHead<SetWifiEnableReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_WIFI_CONNECT.getOrderCode(), ConnectWifiReq.class/*new QSclazz(ConnectWifiReq.class,new MsgHead<ConnectWifiReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_WIFI_DISCONNECT.getOrderCode(), DisconnectWifiReq.class/*new QSclazz(DisconnectWifiReq.class,new MsgHead<DisconnectWifiReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_WIFI_REMOVE.getOrderCode(), RemoveWifiReq.class/*new QSclazz(RemoveWifiReq.class,new MsgHead<RemoveWifiReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_PERSONAL_HOSTSPOT_ENABLE.getOrderCode(), SetPersonalHotspotEnableReq.class/*new QSclazz(SetPersonalHotspotEnableReq.class,new MsgHead<SetPersonalHotspotEnableReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.CLEAR_RAM.getOrderCode(), ClearRamReq.class/*new QSclazz(ClearRamReq.class,new MsgHead<ClearRamReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.CLEAR_ROM.getOrderCode(), ClearRomReq.class/*new QSclazz(ClearRomReq.class,new MsgHead<ClearRomReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_FLASH_LIGHT_ENABLE.getOrderCode(), SetFlashLightEnableReq.class/*new QSclazz(SetFlashLightEnableReq.class,new MsgHead<SetFlashLightEnableReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_VOLUME.getOrderCode(), SetVolumeReq.class/*new QSclazz(SetVolumeReq.class,new MsgHead<SetVolumeReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_SCREEN_INFO.getOrderCode(), SetScreenInfoReq.class/*new QSclazz(SetScreenInfoReq.class,new MsgHead<SetScreenInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.QUIT_MAINTAIN.getOrderCode(), QuitMaintainReq.class/*new QSclazz(QuitMaintainReq.class,new MsgHead<QuitMaintainReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_FM_ENABLE.getOrderCode(), SetFmEnableReq.class/*new QSclazz(SetFmEnableReq.class,new MsgHead<SetFmEnableReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamSet.SET_GPS_ENABLE.getOrderCode(), SetGpsEnableReq.class/*new QSclazz(SetGpsEnableReq.class,new MsgHead<SetGpsEnableReq>(){}.getClass())*/);

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
        reqMap.put(OrderEnum.ParamRead.READ_POLE_INFO.getOrderCode(), GetPoleInfoReq.class/*new QSclazz(GetPoleInfoReq.class,new MsgHead<GetPoleInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamRead.READ_POLE_HARDWARE_INFO.getOrderCode(), GetPoleHardwareInfoReq.class/*new QSclazz(GetPoleHardwareInfoReq.class,new MsgHead<GetPoleHardwareInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamRead.READ_BLUETOOTH_INFO.getOrderCode(), GetBluetoothInfoReq.class/*new QSclazz(GetBluetoothInfoReq.class,new MsgHead<GetBluetoothInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamRead.READ_NETWORK_INFO.getOrderCode(), GetNetworkInfoReq.class/*new QSclazz(GetNetworkInfoReq.class,new MsgHead<GetNetworkInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamRead.READ_WIFI_INFO.getOrderCode(), GetWifiInfoReq.class/*new QSclazz(GetWifiInfoReq.class,new MsgHead<GetWifiInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamRead.READ_VOLUME.getOrderCode(), GetVolumeInfoReq.class/*new QSclazz(GetVolumeInfoReq.class,new MsgHead<GetVolumeInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamRead.READ_SCREEN.getOrderCode(), GetScreenInfoReq.class/*new QSclazz(GetScreenInfoReq.class,new MsgHead<GetScreenInfoReq>(){}.getClass())*/);
        reqMap.put(OrderEnum.ParamRead.READ_FM_INFO.getOrderCode(), GetFmIfoReq.class/*new QSclazz(GetFmIfoReq.class,new MsgHead<GetFmIfoReq>(){}.getClass())*/);
    }

    private void initResMap() {

        resMap.put(OrderEnum.System.REGISTER.getOrderCode(), OnlineRes.class/*new QSclazz(OnlineRes.class,new MsgHead<OnlineRes>(){}.getClass())*/);

        /**
         *         CAMERA_CAR_MOVE(1), //2101 汽车驶入
         *         CAMERA_CAR_STOP(2), //2102 汽车停稳
         *         CAMERA_CAR_STOP_DETAIL(3), //2103 停车数据补充
         *         CAMERA_CAR_MONITOR(4), //2104 停车监控
         *         CAMERA_CAR_LEAVE(5), //2105 汽车离开
         *         CAMERA_CAR_UPLOAD(6), //2106 车牌图片上传
         *         CAMERA_CAR_PRICE(7), //2107 订单价格下发
         *         CAMERA_CAR_COMPLETE(8), //2108 支付完成下发
         *         CAMERA_CAR_PAY(9); //2109 发起支付,获取二维码
         */

        resMap.put(OrderEnum.Camera.CAMERA_CAR_STOP.getOrderCode(), CarStopRes.class/*new QSclazz(CarStopRes.class,new MsgHead<CarStopRes>(){}.getClass())*/);
        //resMap.put(OrderEnum.Camera.CAMERA_CAR_STOP_DETAIL.getOrderCode(), );
        //resMap.put(OrderEnum.Camera.CAMERA_CAR_MONITOR.getOrderCode(), );
        resMap.put(OrderEnum.Camera.CAMERA_CAR_LEAVE.getOrderCode(), CarLeaveRes.class/*new QSclazz(CarLeaveRes.class,new MsgHead<CarLeaveRes>(){}.getClass())*/);
        //resMap.put(OrderEnum.Camera.CAMERA_CAR_UPLOAD.getOrderCode(), );
        resMap.put(OrderEnum.Camera.CAMERA_CAR_PAY.getOrderCode(), CarPayRes.class/*new QSclazz(CarPayRes.class,new MsgHead<CarPayRes>(){}.getClass())*/);
        /**
         *         SET_BLUETOOTH_ENABLE(1),
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
        resMap.put(OrderEnum.ParamSet.SET_BLUETOOTH_ENABLE.getOrderCode(), SetBluetoothEnableRes.class/*new QSclazz(SetBluetoothEnableRes.class,new MsgHead<SetBluetoothEnableRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_BLUETOOTH_INFO.getOrderCode(), SetBluetoothInfoRes.class/*new QSclazz(SetBluetoothInfoRes.class,new MsgHead<SetBluetoothInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_WIFI_ENABLE.getOrderCode(), SetWifiEnableRes.class/*new QSclazz(SetWifiEnableRes.class,new MsgHead<SetWifiEnableRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_WIFI_CONNECT.getOrderCode(), ConnectWifiRes.class/*new QSclazz(ConnectWifiRes.class,new MsgHead<ConnectWifiRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_WIFI_DISCONNECT.getOrderCode(), DisconnectWifiRes.class/*new QSclazz(DisconnectWifiRes.class,new MsgHead<DisconnectWifiRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_WIFI_REMOVE.getOrderCode(), RemoveWifiRes.class/*new QSclazz(RemoveWifiRes.class,new MsgHead<RemoveWifiRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_PERSONAL_HOSTSPOT_ENABLE.getOrderCode(), SetPersonalHotspotEnableRes.class/*new QSclazz(SetPersonalHotspotEnableRes.class,new MsgHead<SetPersonalHotspotEnableRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.CLEAR_RAM.getOrderCode(), ClearRamRes.class/*new QSclazz(ClearRamRes.class,new MsgHead<ClearRamRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.CLEAR_ROM.getOrderCode(), ClearRomRes.class/*new QSclazz(ClearRomRes.class,new MsgHead<ClearRomRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_FLASH_LIGHT_ENABLE.getOrderCode(), SetFlashLightEnableRes.class/*new QSclazz(SetFlashLightEnableRes.class,new MsgHead<SetFlashLightEnableRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_VOLUME.getOrderCode(), SetVolumeRes.class/*new QSclazz(SetVolumeRes.class,new MsgHead<SetVolumeRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_SCREEN_INFO.getOrderCode(), SetScreenInfoRes.class/*new QSclazz(SetScreenInfoRes.class,new MsgHead<SetScreenInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.QUIT_MAINTAIN.getOrderCode(), QuitMaintainRes.class/*new QSclazz(QuitMaintainRes.class,new MsgHead<QuitMaintainRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_FM_ENABLE.getOrderCode(), SetFmEnableRes.class/*new QSclazz(SetFmEnableRes.class,new MsgHead<SetFmEnableRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamSet.SET_GPS_ENABLE.getOrderCode(), SetGpsEnableRes.class/*new QSclazz(SetGpsEnableRes.class,new MsgHead<SetGpsEnableRes>(){}.getClass())*/);

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
        resMap.put(OrderEnum.ParamRead.READ_POLE_INFO.getOrderCode(), GetPoleInfoRes.class/*new QSclazz(GetPoleInfoRes.class,new MsgHead<GetPoleInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamRead.READ_POLE_HARDWARE_INFO.getOrderCode(), GetPoleHardwareInfoRes.class/*new QSclazz(GetPoleHardwareInfoRes.class,new MsgHead<GetPoleHardwareInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamRead.READ_BLUETOOTH_INFO.getOrderCode(), GetBluetoothInfoRes.class/*new QSclazz(GetBluetoothInfoRes.class,new MsgHead<GetBluetoothInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamRead.READ_NETWORK_INFO.getOrderCode(), GetNetworkInfoRes.class/*new QSclazz(GetNetworkInfoRes.class,new MsgHead<GetNetworkInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamRead.READ_WIFI_INFO.getOrderCode(), GetWifiInfoRes.class/*new QSclazz(GetWifiInfoRes.class,new MsgHead<GetWifiInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamRead.READ_VOLUME.getOrderCode(), GetVolumeInfoRes.class/*new QSclazz(GetVolumeInfoRes.class,new MsgHead<GetVolumeInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamRead.READ_SCREEN.getOrderCode(), GetScreenInfoRes.class/*new QSclazz(GetScreenInfoRes.class,new MsgHead<GetScreenInfoRes>(){}.getClass())*/);
        resMap.put(OrderEnum.ParamRead.READ_FM_INFO.getOrderCode(), GetFmIfoRes.class/*new QSclazz(GetFmIfoRes.class,new MsgHead<GetFmIfoRes>(){}.getClass())*/);
    }

}
