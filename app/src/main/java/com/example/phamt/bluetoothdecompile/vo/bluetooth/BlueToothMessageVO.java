package com.example.phamt.bluetoothdecompile.vo.bluetooth;

/**
 * Created by phamt on 2018/01/16.
 */

public class BlueToothMessageVO<T>
{
    public static final String[] CODES = { "requestWifiList", "responseWifiList", "requestWifiConnect", "requestSetLanguage", "requestSetTimeZone", "responseSetTimeZone", "requestBluetoothSpeakerSearching", "requestBluetoothSpeakerSearching", "requestBluetoothSpeakerList", "responseBluetoothSpeakerList", "requestBluetoothSpeakerConnect", "responseBluetoothSpeakerConnect", "responseNotUseDevice", "responseUseDevice" };
    public static final String REQ_BT_SPEAKER_CONNECT = "requestBluetoothSpeakerConnect";
    public static final String REQ_BT_SPEAKER_LIST = "requestBluetoothSpeakerList";
    public static final String REQ_BT_SPEAKER_SEARCHING = "requestBluetoothSpeakerSearching";
    public static final String REQ_GO_STEP_1 = "requestStep1";
    public static final String REQ_GO_STEP_2 = "requestStep2";
    public static final String REQ_REGIST = "requestRegist";
    public static final String REQ_SET_LANGUAGE = "requestSetLanguage";
    public static final String REQ_SET_TIMEZONE = "requestSetTimeZone";
    public static final String REQ_START_APP = "requestStartApp";
    public static final String REQ_WIFI_CONNECT = "requestWifiConnect";
    public static final String REQ_WIFI_LIST = "requestWifiList";
    public static final String REQ_WIFI_LIST_FOR_CHANGE = "requestWifiListForChange";
    public static final String RESULT_DUPLICATE_CONNECT_CODE = "02";
    public static final String RESULT_FAIL_CODE = "01";
    public static final String RESULT_INVALID_DEVICE_CONNECT_CODE = "03";
    public static final String RESULT_SUCCESS_CODE = "00";
    public static final String RES_BT_SPEAKER_CONNECT = "responseBluetoothSpeakerConnect";
    public static final String RES_BT_SPEAKER_LIST = "responseBluetoothSpeakerList";
    public static final String RES_BT_SPEAKER_SEARCHING = "responseBluetoothSpeakerSearching";
    public static final String RES_NOT_USE_DEVICE = "responseNotUseDevice";
    public static final String RES_REGIST = "responseRegist";
    public static final String RES_SET_LANGUAGE = "responseSetLanguage";
    public static final String RES_SET_TIMEZONE = "responseSetTimeZone";
    public static final String RES_START_APP = "responseStartApp";
    public static final String RES_USE_DEVICE = "responseUseDevice";
    public static final String RES_WIFI_CONNECT = "responseWifiConnect";
    public static final String RES_WIFI_LIST = "responseWifiList";
    public static final String RES_WIFI_LIST_FOR_CHANGE = "responseWifiListForChange";
    private String code;
    private T data;
    private String messageType;

    public String getCode()
    {
        return this.code;
    }

    public T getData()
    {
        return (T)this.data;
    }

    public String getMessageType()
    {
        return this.messageType;
    }

    public void setCode(String paramString)
    {
        this.code = paramString;
    }

    public void setData(T paramT)
    {
        this.data = paramT;
    }

    public void setMessageType(String paramString)
    {
        this.messageType = paramString;
    }
}
