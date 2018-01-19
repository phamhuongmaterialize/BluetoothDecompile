package com.example.phamt.bluetoothdecompile.vo;

/**
 * Created by phamt on 2018/01/16.
 */

public class BannerVo
{
    String bannerOrder;
    String downloadPath;
    String fileSize;
    String title;
    String url;

    public String getBannerOrder()
    {
        return this.bannerOrder;
    }

    public String getDownloadPath()
    {
        return this.downloadPath;
    }

    public String getFileSize()
    {
        return this.fileSize;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setBannerOrder(String paramString)
    {
        this.bannerOrder = paramString;
    }

    public void setDownloadPath(String paramString)
    {
        this.downloadPath = paramString;
    }

    public void setFileSize(String paramString)
    {
        this.fileSize = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public void setUrl(String paramString)
    {
        this.url = paramString;
    }
}

