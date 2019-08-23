package com.smarteye.utils.common.dto.msg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.smarteye.utils.common.dto.BaseDTO;
import com.smarteye.utils.common.dto.camera.*;
import com.smarteye.utils.common.dto.msg.parse.MsgParseConf;
import com.smarteye.utils.common.dto.msg.parse.MsgParseFactory;
import com.smarteye.utils.common.dto.pole.HeartBeatReq;
import com.smarteye.utils.common.dto.pole.OnlineReq;
import com.smarteye.utils.common.dto.pole.OnlineRes;
import com.smarteye.utils.common.dto.pole.struct.ParkCameraInfo;
import com.smarteye.utils.common.enums.OrderEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 类实现描述：样例
 * yinjie 2018/11/2 10:52
 */
@Data
public class TestExample extends BaseDTO
{
    private int aa;
    public static void main(String[] args)
    {
        // 创建消息样例
        TestExample testExample1 = new TestExample();
        MsgHead<TestExample> msgHead = new MsgHead(new MsgBody<>(testExample1)); //MsgFactory.createMsg(testExample1,"json","test_nobody",null,null,0);
        msgHead.setMsgStyle("json");
        msgHead.setMsgToken("test_nobody");
        msgHead.getMsgBody().setMsgId("15145L");
        msgHead.getMsgBody().setRepayMsgId("151455L");
        msgHead.getMsgBody().setMsgOrder(OrderEnum.Camera.CAMERA_CAR_PRICE.getOrderCode());
        msgHead.getMsgBody().setMsgTimestamp(Calendar.getInstance().getTimeInMillis());
        msgHead.getMsgBody().getMsgData().setAa(58);
        System.out.println(JSONObject.toJSONString(msgHead));


        // 解析消息样例
        String aaaa =  "{\"msgBody\":{\"msgData\":{\"aa\":58},\"msgId\":\"15145\",\"msgOrder\":1501,"
                       + "\"msgTimestamp\":1541148410503,\"repayMsgId\":\"151455\"},\"msgStyle\":\"msgStyle\","
                       + "\"msgToken\":\"msgToken\"}";
        Long cutime1 = System.currentTimeMillis() * 1000; // 微秒
        MsgHead bbb = JSONObject.parseObject(aaaa, MsgHead.class);
        System.out.println((System.currentTimeMillis() * 1000 - cutime1) + "|" +bbb.getMsgBody().getMsgOrder());
        TestExample testExample = JSONObject.parseObject(bbb.getMsgBody().getMsgData().toString(), TestExample.class);
        System.out.println((System.currentTimeMillis() * 1000 - cutime1) + "|" + testExample.aa);
        MsgHead msgHead1 = JSON.parseObject(aaaa, new  MsgHead<TestExample>().getClass());
        System.out.println((System.currentTimeMillis() * 1000 - cutime1) + "|" + msgHead1);

        String onlines = "{\"msgBody\":{\"msgData\":{\"pltCode\":\"test12345678\",\"code\":0},\"msgId\":\"\",\"repayMsgId\":\"\",\"msgOrder\":1000,\"msgTimestamp\":1542271934465},\"msgStyle\":\"json\",\"msgToken\":\"test_nobody\"}";
        MsgHead honlines = JSONObject.parseObject(onlines, MsgHead.class);
        OnlineRes  onlineRes = JSONObject.parseObject(honlines.getMsgBody().getMsgData().toString(), OnlineRes.class);


        String test = JSONObject.toJSONString(testExample1.exampleHeartBeatReq());
        System.out.print(test);
        MsgHead msa = JSONObject.parseObject(test, MsgHead.class);
        CarStopRes carStopRes = JSONObject.parseObject(msa.getMsgBody().getMsgData().toString(), CarStopRes.class);
        System.out.print(carStopRes);
        System.out.print(JSONObject.toJSONString(testExample1.exampleHeartBeatReq()));
        System.out.print(JSONObject.toJSONString(testExample1.exampleOnlineReq()));


        System.out.print(JSONObject.toJSONString(testExample1.exampleCarCompleteReq()));
        System.out.print(JSONObject.toJSONString(testExample1.exampleCarLeaveReq()));
        MsgHead<CarPayReq> carPayReqMsgHead = testExample1.exampleCarPayReq();
        System.out.print(JSONObject.toJSONString(carPayReqMsgHead));
        System.out.print(JSONObject.toJSONString(testExample1.exampleCarPayRes(carPayReqMsgHead.getMsgBody().getMsgId())));
        System.out.print(JSONObject.toJSONString(testExample1.exampleCarPriceReq()));
        MsgHead<CarStopReq> carStopReqMsgHead = testExample1.exampleCarStopReq();
        System.out.print(JSONObject.toJSONString(carStopReqMsgHead));
        System.out.print(JSONObject.toJSONString(testExample1.exampleCarStopRes(carStopReqMsgHead.getMsgBody().getMsgId())));



        String json = "{\"msgBody\":{\"msgData\":{\"androidVersion\":\"6.0.1\",\"deviceFactory\":\"SHIXIN\",\"deviceId\":\"309b0e90204d8c98\",\"deviceModel\":\"SX-A001\",\"gpsX\":13.1,\"gpsY\":13.1,\"parkInfo\":[]},\"msgId\":\"309b0e90204d8c9815816178484117504\",\"msgOrder\":1001,\"msgTimestamp\":1545118070801},\"msgStyle\":\"json\",\"msgToken\":\"test_nobody\"}";
        System.out.println("接收到消息，此处用来处理接收到的消息" + json);
        try {
            MsgParseConf.getInstance();
            Long cutime = System.currentTimeMillis() * 1000; // 微秒
            MsgHead m = JSONObject.parseObject(json, MsgHead.class);
            //boolean b = MsgContainerManage.getInstance().connect(MsgRedis.containerType);
            System.out.println("time:" + (System.currentTimeMillis() * 1000 - cutime) + "json:" + m.toString());
            //MsgInfoObject parse = MsgParseBase.parseBody(msgHead,msgHead.getMsgBody().getMsgData().toString());
            BaseDTO parse = MsgParseFactory.parseBodyDataReqMap(m.getMsgBody().getMsgData().toString(),m.getMsgBody().getMsgOrder().intValue());
            System.out.println("time:" + (System.currentTimeMillis() * 1000 - cutime) + "json:" + parse.toString());

            /*Class<?> aClass1 = new MsgHead<OnlineReq>() {}.getClass();
            MsgHead reqMap = MsgParseFactory.parseReqMap(json, m.getMsgBody().getMsgOrder().intValue());*/
                    /*(MsgHead)JSONObject.parseObject(json,MsgParseConf.getInstance().get());*/
            //System.out.println("time:" + (System.currentTimeMillis() * 1000 - cutime) + "json:" + reqMap.toString());
            //MsgContainerManage.getInstance().destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private <T>MsgHead<T> create(T msgData,int order) {
        MsgHead<T> msgHead = new MsgHead(new MsgBody<>(msgData));
        msgHead.setMsgStyle("json");
        msgHead.setMsgToken("test_nobody");
        msgHead.getMsgBody().setMsgId("15145L");
        msgHead.getMsgBody().setRepayMsgId("151455L");
        msgHead.getMsgBody().setMsgOrder(order);
        msgHead.getMsgBody().setMsgTimestamp(Calendar.getInstance().getTimeInMillis());
        return msgHead;
    }

    public MsgHead<HeartBeatReq> exampleHeartBeatReq() {
        HeartBeatReq object = new HeartBeatReq();
        object.setPltCode("test_001");
        object.setAndroidVersion("5.0.1");
        object.setAppVersion("1.0.1");
        object.setCameraAppVersion("1.0.1");
        object.setDeviceId("1234567890");
        List<ParkCameraInfo> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ParkCameraInfo parkCameraInfo = new ParkCameraInfo();
            parkCameraInfo.setParkCode(i+10 + "");
            parkCameraInfo.setParkPosition(i+1);
            list.add(parkCameraInfo);
        }
        object.setParkInfo(list);
        return create(object,OrderEnum.System.HEARTBEAT.getOrderCode());
    }

    public MsgHead<OnlineReq> exampleOnlineReq() {
        OnlineReq object = new OnlineReq();
        object.setDeviceId("1234567890");
        object.setDeviceFactory("shixin");
        object.setDeviceModel("sx-a001");
        object.setGpsX(77.9);
        object.setGpsY(77.9);
        object.setAndroidVersion("5.0.1");
        object.setAppVersion("1.0.1");
        object.setCameraAppVersion("1.0.1");
        object.setDeviceId("1234567890");
        List<ParkCameraInfo> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ParkCameraInfo parkCameraInfo = new ParkCameraInfo();
            parkCameraInfo.setParkCode(i+10 + "");
            if(i == 0) {
                parkCameraInfo.setCarId("浙A12345");
            }
            parkCameraInfo.setParkPosition(i+1);
            list.add(parkCameraInfo);
        }
        object.setParkInfo(list);
        return create(object,OrderEnum.System.REGISTER.getOrderCode());
    }

    public MsgHead<CarCompleteReq> exampleCarCompleteReq() {
        CarCompleteReq object = new CarCompleteReq();
        object.setPltCode("test_001");
        object.setCarOrder("123456789345678");
        //MsgHead<CarCompleteReq> msg = MsgFactory.createMsg(object);
        return create(object,OrderEnum.Camera.CAMERA_CAR_COMPLETE.getOrderCode());
    }

    public MsgHead<CarLeaveReq> exampleCarLeaveReq() {
        CarLeaveReq object = new CarLeaveReq();
        object.setPltCode("test_001");
        object.setCarOrder("123456789345678");
        //MsgHead<CarLeaveReq> msg = MsgFactory.createMsg(object);
        return create(object,OrderEnum.Camera.CAMERA_CAR_LEAVE.getOrderCode());
        //return msg;
    }

    public MsgHead<CarPayReq> exampleCarPayReq() {
        CarPayReq object = new CarPayReq();
        object.setPltCode("test_001");
        object.setCarOrder("123456789345678");
        //MsgHead<CarPayReq> msg = MsgFactory.createMsg(object);
        return create(object,OrderEnum.Camera.CAMERA_CAR_PAY.getOrderCode());
        //return msg;
    }

    public MsgHead<CarPayRes> exampleCarPayRes(String reqm) {
        CarPayRes object = new CarPayRes();
        object.setPltCode("test_001");
        object.setCarOrder("123456789345678");
        object.setTotalPrice("10.6");
        object.setPriceImgUrl("wx://adfklkmamklmm");
        object.setKeepTime(new Integer(1800).longValue());
        object.setPrice(3.2);
        object.setStartTime(Calendar.getInstance().getTimeInMillis());
        MsgHead<CarPayRes> msg = create(object,OrderEnum.Reply.REPLY_ORDER.getOrderCode());
        msg.getMsgBody().setRepayMsgId(reqm);
        return msg;
    }

    public MsgHead<CarPriceReq> exampleCarPriceReq() {
        CarPriceReq object = new CarPriceReq();
        object.setPltCode("test_001");
        object.setCarOrder("123456789345678");
        object.setTotalPrice(12.4);
        object.setCarId("沪C.432198");
        object.setParkCode("10");
        //object.setStartTime(Calendar.getInstance().getTimeInMillis());
        //MsgHead<CarPriceReq> msg = MsgFactory.createMsg(object);
        return create(object,OrderEnum.Camera.CAMERA_CAR_PRICE.getOrderCode());
        //return msg;
    }

    public MsgHead<CarStopReq> exampleCarStopReq() {
        CarStopReq object = new CarStopReq();
        object.setPltCode("test_001");
        object.setParkCode("10");
        object.setCarId("沪C.432198");
        object.setCarIdImg("");
        //MsgHead<CarStopReq> msg = MsgFactory.createMsg(object);
        return create(object,OrderEnum.Camera.CAMERA_CAR_STOP.getOrderCode());
        //return msg;
    }

    public MsgHead<CarStopRes> exampleCarStopRes(String reqm) {
        CarStopRes object = new CarStopRes();
        object.setPltCode("test_001");
        object.setCarOrder("123456789345678");
        object.setParkCode("10");
        object.setCarId("沪C.432198");
        object.setStartTime(Calendar.getInstance().getTimeInMillis());
        MsgHead<CarStopRes> msg = create(object,OrderEnum.Reply.REPLY_ORDER.getOrderCode());
        msg.getMsgBody().setRepayMsgId(reqm);
        return msg;
    }

}
