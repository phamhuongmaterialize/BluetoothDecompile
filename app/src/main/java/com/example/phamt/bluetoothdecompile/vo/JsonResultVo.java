package com.example.phamt.bluetoothdecompile.vo;

/**
 * Created by phamt on 2018/01/16.
 */

public class JsonResultVo<T>
{
    private String code = null;
    private int currentPageNum;
    private T data = null;
    private int dataSize;
    private int displayPageNum;
    private String message = null;
    private int totalPageNum;

    public String getCode()
    {
        return this.code;
    }

    public int getCurrentPageNum()
    {
        return this.currentPageNum;
    }

    public T getData()
    {
        return (T)this.data;
    }

    public int getDataSize()
    {
        return this.dataSize;
    }

    public int getDisplayPageNum()
    {
        return this.displayPageNum;
    }

    public String getMessage()
    {
        return this.message;
    }

    public int getTotalPageNum()
    {
        return this.totalPageNum;
    }

    public void setCode(String paramString)
    {
        this.code = paramString;
    }

    public void setCurrentPageNum(int paramInt)
    {
        this.currentPageNum = paramInt;
    }

    public void setData(T paramT)
    {
        this.data = paramT;
    }

    public void setDataSize(int paramInt)
    {
        this.dataSize = paramInt;
    }

    public void setDisplayPageNum(int paramInt)
    {
        this.displayPageNum = paramInt;
    }

    public void setMessage(String paramString)
    {
        this.message = paramString;
    }

    public void setTotalPageNum(int paramInt)
    {
        this.totalPageNum = paramInt;
    }
}
