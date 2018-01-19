package com.example.phamt.bluetoothdecompile.vo.bluetooth;

/**
 * Created by phamt on 2018/01/16.
 */

import java.io.Serializable;

public class WifiInfoVO
        implements Serializable
{
    private String capablities = "";
    private int level = 0;
    private String ssid = "";

    public String getCapablities()
    {
        return this.capablities;
    }

    public int getLevel()
    {
        return this.level;
    }

    public int getPower()
    {
        if (this.level > -65) {
            return 3;
        }
        if (this.level > -75) {
            return 2;
        }
        return 1;
    }

    public String getSsid()
    {
        return this.ssid;
    }

    public boolean isLock()
    {
        if (this.capablities.contains("WPA2")) {}
        while ((this.capablities.contains("WPA")) || (this.capablities.contains("WEP"))) {
            return true;
        }
        return false;
    }

    public void setCapablities(String paramString)
    {
        this.capablities = paramString;
    }

    public void setLevel(int paramInt)
    {
        this.level = paramInt;
    }

    public void setSsid(String paramString)
    {
        this.ssid = paramString;
    }
}

