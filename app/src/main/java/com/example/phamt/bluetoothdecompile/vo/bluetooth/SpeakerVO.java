package com.example.phamt.bluetoothdecompile.vo.bluetooth;

/**
 * Created by phamt on 2018/01/16.
 */

public class SpeakerVO
{
    private String address;
    private int bond_state_int;
    private String bond_state_str;
    private String name;

    public String getAddress()
    {
        return this.address;
    }

    public int getBond_state_int()
    {
        return this.bond_state_int;
    }

    public String getBond_state_str()
    {
        return this.bond_state_str;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAddress(String paramString)
    {
        this.address = paramString;
    }

    public void setBond_state_int(int paramInt)
    {
        this.bond_state_int = paramInt;
    }

    public void setBond_state_str(String paramString)
    {
        this.bond_state_str = paramString;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }
}

