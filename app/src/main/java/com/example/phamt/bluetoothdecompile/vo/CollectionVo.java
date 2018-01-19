package com.example.phamt.bluetoothdecompile.vo;

/**
 * Created by phamt on 2018/01/16.
 */

public class CollectionVo
{
    private String collectionName;
    private int collectionOrder;
    private String defaultYN;
    private int deviceId;
    private String deviceNames;
    private boolean isChecked = false;
    private int myCollectionId;
    private String registDt;
    private int userId;

    public CollectionVo(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
        this.myCollectionId = paramInt1;
        this.collectionName = paramString1;
        this.collectionOrder = paramInt2;
        this.userId = paramInt3;
        this.deviceNames = paramString2;
    }

    public CollectionVo(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4)
    {
        this.myCollectionId = paramInt1;
        this.collectionName = paramString1;
        this.collectionOrder = paramInt2;
        this.userId = paramInt3;
        this.registDt = paramString2;
        this.defaultYN = paramString3;
        this.deviceNames = paramString4;
        this.deviceId = paramInt4;
    }

    public String getCollectionName()
    {
        return this.collectionName;
    }

    public int getCollectionOrder()
    {
        return this.collectionOrder;
    }

    public String getDefaultYN()
    {
        return this.defaultYN;
    }

    public int getDeviceId()
    {
        return this.deviceId;
    }

    public String getDeviceNames()
    {
        return this.deviceNames;
    }

    public int getMyCollectionId()
    {
        return this.myCollectionId;
    }

    public String getRegistDt()
    {
        return this.registDt;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public boolean isChecked()
    {
        return this.isChecked;
    }

    public void setChecked(boolean paramBoolean)
    {
        this.isChecked = paramBoolean;
    }

    public void setCollectionName(String paramString)
    {
        this.collectionName = paramString;
    }

    public void setCollectionOrder(int paramInt)
    {
        this.collectionOrder = paramInt;
    }

    public void setDefaultYN(String paramString)
    {
        this.defaultYN = paramString;
    }

    public void setDeviceId(int paramInt)
    {
        this.deviceId = paramInt;
    }

    public void setDeviceNames(String paramString)
    {
        this.deviceNames = paramString;
    }

    public void setMyCollectionId(int paramInt)
    {
        this.myCollectionId = paramInt;
    }

    public void setRegistDt(String paramString)
    {
        this.registDt = paramString;
    }

    public void setUserId(int paramInt)
    {
        this.userId = paramInt;
    }
}

