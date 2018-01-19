package com.example.phamt.bluetoothdecompile.vo.bluetooth;

/**
 * Created by phamt on 2018/01/16.
 */

public class DeviceVo
{
    private String appLatestVersion;
    private String appVersion;
    private String bluetoothMacAddress = "";
    private int brightness;
    private String collectionName;
    private String connectYN;
    private int contentsMax;
    private int contentsTotal;
    private int cpuAppUsed;
    private int cpuTemp;
    private int cpuTotalUsed;
    private String deviceHeight;
    private int deviceId;
    private String deviceName;
    private String deviceSn;
    private String deviceWidth;
    private String ipAddress;
    private int lastVersionCode;
    private String locale;
    private String macAddress;
    private String macAddressList;
    private int memoryTotal;
    private int memoryUsed;
    private int mycollectionId = 0;
    private int orientation;
    private String registDt;
    private String registYN;
    private String scaleType;
    private String scheduleYN;
    private String showStartTime;
    private String sleepStartTime;
    private String slideShowAnimationType;
    private int slideShowInterval;
    private String slideShowIntervalUnit;
    private String speakerADDR;
    private String speakerName;
    private String timeZone;
    private String updateDate;
    private int userId;
    private int versionCode;
    private String wifiEncType;
    private String wifiPassword;
    private String wifiSsid;

    public DeviceVo(String paramString1, String paramString2)
    {
        this.deviceName = paramString1;
        this.bluetoothMacAddress = paramString2;
    }

    public String getAppLatestVersion()
    {
        return this.appLatestVersion;
    }

    public String getAppVersion()
    {
        return this.appVersion;
    }

    public String getBluetoothMacAddress()
    {
        return this.bluetoothMacAddress;
    }

    public int getBrightness()
    {
        return this.brightness;
    }

    public String getCollectionName()
    {
        return this.collectionName;
    }

    public String getConnectYN()
    {
        return this.connectYN;
    }

    public int getContentsMax()
    {
        return this.contentsMax;
    }

    public int getContentsTotal()
    {
        return this.contentsTotal;
    }

    public int getCpuAppUsed()
    {
        return this.cpuAppUsed;
    }

    public int getCpuTemp()
    {
        return this.cpuTemp;
    }

    public int getCpuTotalUsed()
    {
        return this.cpuTotalUsed;
    }

    public String getDeviceHeight()
    {
        return this.deviceHeight;
    }

    public int getDeviceId()
    {
        return this.deviceId;
    }

    public String getDeviceName()
    {
        return this.deviceName;
    }

    public String getDeviceSn()
    {
        return this.deviceSn;
    }

    public String getDeviceWidth()
    {
        return this.deviceWidth;
    }

    public String getIpAddress()
    {
        return this.ipAddress;
    }

    public int getLastVersionCode()
    {
        return this.lastVersionCode;
    }

    public String getLocale()
    {
        return this.locale;
    }

    public String getMacAddress()
    {
        return this.macAddress;
    }

    public String getMacAddressList()
    {
        return this.macAddressList;
    }

    public int getMemoryTotal()
    {
        return this.memoryTotal;
    }

    public int getMemoryUsed()
    {
        return this.memoryUsed;
    }

    public int getMycollectionId()
    {
        return this.mycollectionId;
    }

    public int getOrientation()
    {
        return this.orientation;
    }

    public String getRegistDt()
    {
        return this.registDt;
    }

    public String getRegistYN()
    {
        return this.registYN;
    }

    public String getScaleType()
    {
        return this.scaleType;
    }

    public String getScheduleYN()
    {
        return this.scheduleYN;
    }

    public String getShowStartTime()
    {
        return this.showStartTime;
    }

    public String getSleepStartTime()
    {
        return this.sleepStartTime;
    }

    public String getSlideShowAnimationType()
    {
        return this.slideShowAnimationType;
    }

    public int getSlideShowInterval()
    {
        return this.slideShowInterval;
    }

    public String getSlideShowIntervalUnit()
    {
        return this.slideShowIntervalUnit;
    }

    public String getSpeakerADDR()
    {
        return this.speakerADDR;
    }

    public String getSpeakerName()
    {
        return this.speakerName;
    }

    public String getTimeZone()
    {
        return this.timeZone;
    }

    public String getUpdateDate()
    {
        return this.updateDate;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public int getVersionCode()
    {
        return this.versionCode;
    }

    public String getWifiEncType()
    {
        return this.wifiEncType;
    }

    public String getWifiPassword()
    {
        return this.wifiPassword;
    }

    public String getWifiSsid()
    {
        return this.wifiSsid;
    }

    public void setAppLatestVersion(String paramString)
    {
        this.appLatestVersion = paramString;
    }

    public void setAppVersion(String paramString)
    {
        this.appVersion = paramString;
    }

    public void setBluetoothMacAddress(String paramString)
    {
        this.bluetoothMacAddress = paramString;
    }

    public void setBrightness(int paramInt)
    {
        this.brightness = paramInt;
    }

    public void setCollectionName(String paramString)
    {
        this.collectionName = paramString;
    }

    public void setConnectYN(String paramString)
    {
        this.connectYN = paramString;
    }

    public void setContentsMax(int paramInt)
    {
        this.contentsMax = paramInt;
    }

    public void setContentsTotal(int paramInt)
    {
        this.contentsTotal = paramInt;
    }

    public void setCpuAppUsed(int paramInt)
    {
        this.cpuAppUsed = paramInt;
    }

    public void setCpuTemp(int paramInt)
    {
        this.cpuTemp = paramInt;
    }

    public void setCpuTotalUsed(int paramInt)
    {
        this.cpuTotalUsed = paramInt;
    }

    public void setDeviceHeight(String paramString)
    {
        this.deviceHeight = paramString;
    }

    public void setDeviceId(int paramInt)
    {
        this.deviceId = paramInt;
    }

    public void setDeviceName(String paramString)
    {
        this.deviceName = paramString;
    }

    public void setDeviceSn(String paramString)
    {
        this.deviceSn = paramString;
    }

    public void setDeviceWidth(String paramString)
    {
        this.deviceWidth = paramString;
    }

    public void setIpAddress(String paramString)
    {
        this.ipAddress = paramString;
    }

    public void setLastVersionCode(int paramInt)
    {
        this.lastVersionCode = paramInt;
    }

    public void setLocale(String paramString)
    {
        this.locale = paramString;
    }

    public void setMacAddress(String paramString)
    {
        this.macAddress = paramString;
    }

    public void setMacAddressList(String paramString)
    {
        this.macAddressList = paramString;
    }

    public void setMemoryTotal(int paramInt)
    {
        this.memoryTotal = paramInt;
    }

    public void setMemoryUsed(int paramInt)
    {
        this.memoryUsed = paramInt;
    }

    public void setMycollectionId(int paramInt)
    {
        this.mycollectionId = paramInt;
    }

    public void setOrientation(int paramInt)
    {
        this.orientation = paramInt;
    }

    public void setRegistDt(String paramString)
    {
        this.registDt = paramString;
    }

    public void setRegistYN(String paramString)
    {
        this.registYN = paramString;
    }

    public void setScaleType(String paramString)
    {
        this.scaleType = paramString;
    }

    public void setScheduleYN(String paramString)
    {
        this.scheduleYN = paramString;
    }

    public void setShowStartTime(String paramString)
    {
        this.showStartTime = paramString;
    }

    public void setSleepStartTime(String paramString)
    {
        this.sleepStartTime = paramString;
    }

    public void setSlideShowAnimationType(String paramString)
    {
        this.slideShowAnimationType = paramString;
    }

    public void setSlideShowInterval(int paramInt)
    {
        this.slideShowInterval = paramInt;
    }

    public void setSlideShowIntervalUnit(String paramString)
    {
        this.slideShowIntervalUnit = paramString;
    }

    public void setSpeakerADDR(String paramString)
    {
        this.speakerADDR = paramString;
    }

    public void setSpeakerName(String paramString)
    {
        this.speakerName = paramString;
    }

    public void setTimeZone(String paramString)
    {
        this.timeZone = paramString;
    }

    public void setUpdateDate(String paramString)
    {
        this.updateDate = paramString;
    }

    public void setUserId(int paramInt)
    {
        this.userId = paramInt;
    }

    public void setVersionCode(int paramInt)
    {
        this.versionCode = paramInt;
    }

    public void setWifiEncType(String paramString)
    {
        this.wifiEncType = paramString;
    }

    public void setWifiPassword(String paramString)
    {
        this.wifiPassword = paramString;
    }

    public void setWifiSsid(String paramString)
    {
        this.wifiSsid = paramString;
    }
}

