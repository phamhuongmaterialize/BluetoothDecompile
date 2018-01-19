package com.example.phamt.bluetoothdecompile.vo.bluetooth;

/**
 * Created by phamt on 2018/01/16.
 */

public class ConnectWifiVO
{
    private String password;
    private String ssid;
    private String userId;

    public String getPassword()
    {
        return this.password;
    }

    public String getSsid()
    {
        return this.ssid;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setPassword(String paramString)
    {
        this.password = paramString;
    }

    public void setSsid(String paramString)
    {
        this.ssid = paramString;
    }

    public void setUserId(String paramString)
    {
        this.userId = paramString;
    }
}
