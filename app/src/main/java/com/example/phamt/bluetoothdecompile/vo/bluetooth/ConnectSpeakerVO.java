package com.example.phamt.bluetoothdecompile.vo.bluetooth;

/**
 * Created by phamt on 2018/01/16.
 */

public class ConnectSpeakerVO
{
    private String address;
    private int userId;

    public String getAddress()
    {
        return this.address;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public void setAddress(String paramString)
    {
        this.address = paramString;
    }

    public void setUserId(int paramInt)
    {
        this.userId = paramInt;
    }
}