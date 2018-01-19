package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/16.
 */

import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.DeviceVo;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.WifiInfoVO;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.ConnectWifiVO;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.SpeakerVO;
import com.example.phamt.bluetoothdecompile.vo.JsonResultVo;
import com.example.phamt.bluetoothdecompile.vo.UserInfoVo;
import com.example.phamt.bluetoothdecompile.vo.ContentVo;
import com.example.phamt.bluetoothdecompile.vo.BannerVo;
import com.example.phamt.bluetoothdecompile.vo.CouponVo;
import com.example.phamt.bluetoothdecompile.vo.CollectionVo;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;


public class GsonService
{
    private static final String a = GsonService.class.getSimpleName();

    public static JsonResultVo a(String paramString)
    {
        try
        {
            JsonResultVo jsonResultVo = (JsonResultVo)new Gson().fromJson(paramString, JsonResultVo.class);
            return jsonResultVo;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return null;
    }

    public static String a(BlueToothMessageVO<String> paramBlueToothMessageVO)
    {
        try
        {
            String s = new Gson().toJson(paramBlueToothMessageVO);
            return s;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return "";
    }

    public static List<DeviceVo> a(JsonResultVo paramJsonResultVo)
    {
        Type localType = new TypeToken() {}.getType();
        try
        {
            List<DeviceVo> listResultVo = (List)new Gson().fromJson(new Gson().toJson(paramJsonResultVo.getData()), localType);
            return listResultVo;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return null;
    }

    public static List<WifiInfoVO> a(Object paramObject)
    {
        Type localType = new TypeToken() {}.getType();
        try
        {
            List<WifiInfoVO> wifiInfoVOList = (List)new Gson().fromJson(new Gson().toJson(paramObject), localType);
            return wifiInfoVOList;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + ((Exception)e).getMessage());
        }
        return null;
    }

    public static UserInfoVo b(Object paramObject)
    {
        try
        {
            UserInfoVo userInfoVo = (UserInfoVo)new Gson().fromJson(new Gson().toJson(paramObject), UserInfoVo.class);
            return userInfoVo;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + ((Exception)e).getMessage());
        }
        return null;
    }

    public static BlueToothMessageVO b(String paramString)
    {
        try
        {
            BlueToothMessageVO blueToothMessageVO = (BlueToothMessageVO)new Gson().fromJson(paramString, BlueToothMessageVO.class);
            return blueToothMessageVO;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return null;
    }

    public static DeviceVo b(JsonResultVo paramJsonResultVo)
    {
        Type localType = new TypeToken() {}.getType();
        try
        {
            DeviceVo deviceVo = (DeviceVo)new Gson().fromJson(new Gson().toJson(paramJsonResultVo.getData()), localType);
            return deviceVo;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return null;
    }

    public static String b(BlueToothMessageVO<ConnectWifiVO> paramBlueToothMessageVO)
    {
        try
        {
            String s = new Gson().toJson(paramBlueToothMessageVO);
            return s;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return "";
    }

    public static ContentVo c(Object paramObject)
    {
        try
        {
            ContentVo contentVo = (ContentVo)new Gson().fromJson(new Gson().toJson(paramObject), ContentVo.class);
            return contentVo;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + ((Exception)e).getMessage());
        }
        return null;
    }

    public static BlueToothMessageVO c(String paramString)
    {
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        int i = 0;
        for (;;)
        {
            if (i < BlueToothMessageVO.CODES.length)
            {
                if (paramString.indexOf(BlueToothMessageVO.CODES[i]) != -1)
                {
                    localBlueToothMessageVO.setCode("00");
                    localBlueToothMessageVO.setMessageType(BlueToothMessageVO.CODES[i]);
                }
            }
            else
            {
                if (paramString.indexOf("00") != -1) {
                    localBlueToothMessageVO.setCode("00");
                }
                if (localBlueToothMessageVO.getCode().equals("00")) {
                    break;
                }
                return null;
            }
            i += 1;
        }
        return localBlueToothMessageVO;
    }

    public static List<CollectionVo> c(JsonResultVo paramJsonResultVo)
    {
        Type localType = new TypeToken() {}.getType();
        try
        {
            List<CollectionVo> collectionVoList = (List)new Gson().fromJson(new Gson().toJson(paramJsonResultVo.getData()), localType);
            return collectionVoList;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return null;
    }

    public static CouponVo d(Object paramObject)
    {
        try
        {
            CouponVo couponVo = (CouponVo)new Gson().fromJson(new Gson().toJson(paramObject), CouponVo.class);
            return couponVo;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + ((Exception)e).getMessage());
        }
        return null;
    }

    public static List<ContentVo> d(JsonResultVo paramJsonResultVo)
    {
        Type localType = new TypeToken() {}.getType();
        try
        {
            List<ContentVo> contentVoList = (List)new Gson().fromJson(new Gson().toJson(paramJsonResultVo.getData()), localType);
            return contentVoList;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return null;
    }

    public static List<SpeakerVO> d(String paramString)
    {
        Type localType = new TypeToken() {}.getType();
        try
        {
            BlueToothMessageVO blueToothMessageVO
                    = (BlueToothMessageVO)new Gson().fromJson(paramString, localType);
            return (List<SpeakerVO>) blueToothMessageVO.getData();
        }
        catch (Exception e)
        {
            for (;;)
            {
                LOG.c(a, "Exception : " + e.getMessage());
                paramString = null;
            }
        }
    }

    public static List<BannerVo> e(JsonResultVo paramJsonResultVo)
    {
        Type localType = new TypeToken() {}.getType();
        try
        {
            List<BannerVo> bannerVoList = (List)new Gson().fromJson(new Gson().toJson(paramJsonResultVo.getData()), localType);
            return bannerVoList;
        }
        catch (Exception e)
        {
            LOG.c(a, "Exception : " + e.getMessage());
        }
        return null;
    }
}

