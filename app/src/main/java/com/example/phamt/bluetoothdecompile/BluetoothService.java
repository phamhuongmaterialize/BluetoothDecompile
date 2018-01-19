package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/16.
 */

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.ConnectSpeakerVO;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.ConnectWifiVO;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class BluetoothService {
    public static final int a = 2001;
    public static final int b = 2002;
    public static final int c = 101;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    private static final String TAG = BluetoothService.class.getSimpleName();
    private static BluetoothService mBluetoothService;
    private static final UUID v = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final UUID w = UUID.fromString("00000003-0000-1000-8000-00805F9B34FB");
    public BluetoothAdapter mBluetoothAdapter;
    public IBluetoothCallback mIBluetoothCallback;
    public HashMap<String, String> j = new HashMap();
    InputStream k = null;
    public boolean l = false;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
            LOG.c(BluetoothService.f(), "BroadcastReceiver onReceive : " + paramAnonymousIntent.getAction());
            if (paramAnonymousIntent.getAction() == "android.bluetooth.device.action.FOUND") {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.getBondState() != 12) {
                    BluetoothService.this.mIBluetoothCallback.a(bluetoothDevice.getName(), bluetoothDevice.getAddress());
                }
            }
        }
    };
    private int state;
    private Context mContext;
    private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    private BluetoothDevice mBluetoothDevice;
    private DisconnectThread mDisconnectThread;
    private boolean x = false;
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            LOG.c(BluetoothService.f(), "handle message : " + paramAnonymousMessage.what + " / " + paramAnonymousMessage.arg1);
            switch (paramAnonymousMessage.what) {
                case 10003:
                case 10004:
                case 10005:
                default:
                    return;
                case 10001:
                    LOG.d(BluetoothService.f(), "MESSAGE_STATE_CHANGE: " + paramAnonymousMessage.arg1);
                    switch (paramAnonymousMessage.arg1) {
                    }
                    for (; ; ) {
                        LOG.c(BluetoothService.f(), " Message : [ " + "" + "]");
                        return;
                        BluetoothService.this.mIBluetoothCallback.a(1);
                        continue;
                        BluetoothService.this.mIBluetoothCallback.a(2);
                        continue;
                        BluetoothService.this.mIBluetoothCallback.a(3);
                        continue;
                        BluetoothService.this.mIBluetoothCallback.a(0);
                    }
                case 10002:
                    BluetoothService.this.l = false;
                    String s = new String((byte[]) paramAnonymousMessage.obj, 0, paramAnonymousMessage.arg1, Charset.forName("UTF-8"));
                    LOG.c(BluetoothService.f(), "Message Read : [" + paramAnonymousMessage + "]");
                    if (s.isEmpty()) {
                        BluetoothService.this.mIBluetoothCallback.a("readMessage is Empty");
                        return;
                    }
                    BluetoothService.this.mIBluetoothCallback.b(s);
                    return;
                case 10006:
                    LOG.a(BluetoothService.f(), "MESSAGE_DISCONNECTED: " + paramAnonymousMessage.getData().getInt("failMsg"));
                    BluetoothService.this.mIBluetoothCallback.b(paramAnonymousMessage.getData().getInt("failMsg"));
                    return;
            }
            LOG.c(BluetoothService.f(), "connect failed...");
            BluetoothService.this.mIBluetoothCallback.a();
        }
    };

    public static BluetoothService a(Context paramContext, IBluetoothCallback paramIBluetoothCallback) {
        if (mBluetoothService == null) {
            mBluetoothService = new BluetoothService();
        }
        mBluetoothService.mContext = paramContext;
        mBluetoothService.mIBluetoothCallback = paramIBluetoothCallback;
        return mBluetoothService;
    }

    private void a(int paramInt) {
        d();
        Message localMessage = this.mHandler.obtainMessage(10006);
        Bundle localBundle = new Bundle();
        localBundle.putInt("failMsg", paramInt);
        localMessage.setData(localBundle);
        this.mHandler.sendMessage(localMessage);
    }

    public static boolean b(Context paramContext) {
        if (BluetoothAdapter.getDefaultAdapter() == null) {
            LOG.c(TAG, "Device not found");
            return false;
        }
        LOG.c(TAG, "Device is exist");
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) { //check if bluetooth is enabled
            LOG.c(TAG, "\nDevice can use");
            return true;
        }
        Intent localIntent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        ((Activity) paramContext).startActivityForResult(localIntent, 101);
        return false;
    }

    public static int e() {
        int i3 = 0;
        int i1 = 0;
        Object localObject = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        int i2 = i3;
        try {
            Method localMethod = Class.forName(BluetoothDevice.class.getCanonicalName()).getMethod("removeBond", new Class[0]);
            i2 = i3;
            localObject = ((Set) localObject).iterator();
            for (; ; ) {
                i2 = i1;
                if (!((Iterator) localObject).hasNext()) {
                    break;
                }
                i2 = i1;
                BluetoothDevice localBluetoothDevice = (BluetoothDevice) ((Iterator) localObject).next();
                i2 = i1;
                if (localBluetoothDevice.getName().toLowerCase().indexOf("mouse") < 0) {
                    i2 = i1;
                    localMethod.invoke(localBluetoothDevice, new Object[0]);
                    i1 += 1;
                }
            }
            return i1;
        } catch (Throwable localThrowable) {
        }
        return i2;
    }

    public static void getBlueToothList() {
        Object localObject = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        ArrayList localArrayList = new ArrayList();
        LOG.c(TAG, "===========================================");
        localObject = ((Set) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            BluetoothDevice localBluetoothDevice = (BluetoothDevice) ((Iterator) localObject).next();
            localArrayList.add(localBluetoothDevice.getName());
            LOG.c(TAG, ">>" + localBluetoothDevice.getName() + " ----> " + localBluetoothDevice.getAddress());
        }
        LOG.c(TAG, "===========================================");
    }

    private void h() {
        d();
        Message localMessage = this.mHandler.obtainMessage(10007);
        this.mHandler.sendMessage(localMessage);
    }

    public static boolean i(String paramString) {
        Object localObject = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        try {
            Method localMethod = Class.forName(BluetoothDevice.class.getCanonicalName()).getMethod("removeBond", new Class[0]);
            localObject = ((Set) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                BluetoothDevice localBluetoothDevice = (BluetoothDevice) ((Iterator) localObject).next();
                if (localBluetoothDevice.getAddress().equals(paramString)) {
                    localMethod.invoke(localBluetoothDevice, new Object[0]);
                    return true;
                }
            }
        } catch (Throwable throwable) {
        }
        return false;
    }

    private void setState(int paramInt) {
        try {
            LOG.c(TAG, "setState() " + this.state + " -> " + paramInt);
            this.state = paramInt;
            this.mHandler.obtainMessage(10001, paramInt, -1).sendToTarget();
            return;
        } finally {
            localObject = finally;
            throw ((Throwable) localObject);
        }
    }

    public void a() {
        if (getState() == 0) {
            LOG.a(TAG, "Bluetooth state init! STATE_NONE -> STATE_LISTEN");
            d();
        }
    }

//    public void a(int paramInt, String paramString) {   //requestBluetoothSpeakerConnect
//        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
//        localBlueToothMessageVO.setMessageType("requestBluetoothSpeakerConnect");
//        ConnectSpeakerVO localConnectSpeakerVO = new ConnectSpeakerVO();
//        localConnectSpeakerVO.setUserId(paramInt);
//        localConnectSpeakerVO.setAddress(paramString);
//        localBlueToothMessageVO.setData(localConnectSpeakerVO);
//        paramString = new Gson().toJson(localBlueToothMessageVO);
//        LOG.c(TAG, "getSpeakerConnect | reqDataStr : [" + paramString + "]");
//        e(paramString);
//    }

    public void a(int paramInt, String paramString1, String paramString2) {
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setMessageType("requestWifiConnect");
        ConnectWifiVO localConnectWifiVO = new ConnectWifiVO();
        localConnectWifiVO.setUserId("" + paramInt);
        localConnectWifiVO.setSsid(paramString1);
        localConnectWifiVO.setPassword(paramString2);
        localBlueToothMessageVO.setData(localConnectWifiVO);
        e(GsonService.b(localBlueToothMessageVO));
    }

    public void a(BluetoothDevice paramBluetoothDevice) {
        try {
            LOG.c(TAG, "connect to: " + paramBluetoothDevice);
            if ((this.state == 3) && (this.mConnectedThread != null)) {
                LOG.c(TAG, "Cancel any thread currently running a connection");
                this.mConnectedThread.a();
                this.mConnectedThread = null;
            }
            if (this.state == 2) {
                LOG.c(TAG, "STATE_CONNECTING");
                if (this.mConnectThread != null) {
                    this.mConnectThread.a();
                    this.mConnectThread = null;
                }
            }
            this.mConnectThread = new ConnectThread(paramBluetoothDevice);
            this.mConnectThread.start();
            setState(2);
            return;
        } finally {
        }
    }

    public void a(BluetoothSocket paramBluetoothSocket, BluetoothDevice paramBluetoothDevice) {  //connected thread create?
        try {
            LOG.c(TAG, "Bluetooth connect success");
            if (this.mConnectThread != null) {
                LOG.c(TAG, ">>mConnectThread close");
                this.mConnectThread.a();
                this.mConnectThread = null;
            }
            if (this.mConnectedThread != null) {
                LOG.c(TAG, ">>mConnectedThread close");
                this.mConnectedThread.a();
                this.mConnectedThread = null;
            }
            this.mConnectedThread = new ConnectedThread(paramBluetoothSocket);
            this.mConnectedThread.start();
            setState(3);
            return;
        } finally {
        }
    }

    public void a(String paramString) {  //requestWifiList
        this.l = true;
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setCode("requestRegist");
        localBlueToothMessageVO.setMessageType("requestWifiList");
        localBlueToothMessageVO.setData(paramString);
        paramString = new Gson().toJson(localBlueToothMessageVO);
        LOG.c(TAG, "STATE_CONNECTED | reqDataStr : [" + paramString + "]");
        e(paramString);
    }

    public void a(boolean paramBoolean) {
        LOG.c(TAG, "stopFindDevice..............." + this.mBluetoothAdapter.isDiscovering());
        if ((this.mBluetoothAdapter.isDiscovering()) || (paramBoolean)) {
            this.mBluetoothAdapter.cancelDiscovery();
        }
    }

    public void a(byte[] paramArrayOfByte) {
        try {
            if (this.state != 3) {
                return;
            }
            LOG.c(TAG, "Synchronize a copy of the ConnectedThread");
            ConnectedThread localConnectedThread = this.mConnectedThread;
            localConnectedThread.a(paramArrayOfByte);
            return;
        } finally {
        }
    }

    public boolean a(Context paramContext) {
        LOG.c(TAG, "Device can useDevice can useDevice can use");
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.mBluetoothAdapter == null) {
            LOG.c(TAG, "Device not found");
            return false;
        }
        LOG.c(TAG, "Device is exist");
        if (this.mBluetoothAdapter.isEnabled()) {  //check if bluetooth is enabled
            LOG.c(TAG, "\nDevice can use");
            return true;
        }
        Intent localIntent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        ((Activity) paramContext).startActivityForResult(localIntent, 101);
        return false;
    }

    public void b() {
        if (this.mBluetoothAdapter.isDiscovering()) {
            return;
        }
        LOG.c(TAG, "startFindDevice...............");
        this.j = new HashMap();
        this.mBluetoothAdapter.startDiscovery();
    }

    public void b(BluetoothDevice paramBluetoothDevice) {
        try {
            LOG.c(TAG, "Bluetooth disconnect success");
            setState(0);
            if (this.mConnectThread != null) {
                LOG.c(TAG, ">>mConnectThread close");
                this.mConnectThread.a();
                this.mConnectThread = null;
            }
            if (this.mConnectedThread != null) {
                LOG.c(TAG, ">>mConnectedThread close");
                this.mConnectedThread.a();
                this.mConnectedThread = null;
            }
            this.mDisconnectThread = new DisconnectThread(paramBluetoothDevice);
            this.mDisconnectThread.start();
            return;
        } finally {
        }
    }

    public void b(String paramString) {
        this.l = true;
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setMessageType("requestWifiList");
        localBlueToothMessageVO.setData(paramString);
        paramString = new Gson().toJson(localBlueToothMessageVO);
        LOG.c(TAG, "STATE_CONNECTED | reqDataStr : [" + paramString + "]");
        e(paramString);
    }

    public void c() {
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setMessageType("requestStartApp");
        localBlueToothMessageVO.setCode("00");
        e(GsonService.a(localBlueToothMessageVO));
    }

    public void c(Context paramContext) {
        try {
            LOG.c(TAG, "TEST ---- mContext: " + this.mContext);
            paramContext.unregisterReceiver(this.mBroadcastReceiver);
            return;
        } catch (Exception e) {
            LOG.a(TAG, "Exception : " + e.getMessage());
        }
    }

    public void c(String paramString) {
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setMessageType("requestBluetoothSpeakerSearching");
        localBlueToothMessageVO.setData(paramString);
        paramString = new Gson().toJson(localBlueToothMessageVO);
        LOG.c(TAG, "getSpeakerSearching | reqDataStr : [" + paramString + "]");
        e(paramString);
    }

    public void d() {
        try {
            LOG.c(TAG, "start");
            if (this.mConnectThread != null) {
                LOG.c(TAG, "Cancel any thread attempting to make a connection");
                this.mConnectThread.a();
                this.mConnectThread = null;
            }
            if (this.mConnectedThread != null) {
                LOG.c(TAG, "Cancel any thread currently running a connection");
                this.mConnectedThread.a();
                this.mConnectedThread = null;
            }
            setState(1);
            return;
        } finally {
        }
    }

    public void d(Context paramContext) {
        try {
            LOG.c(TAG, "TEST ---- mContext: " + this.mContext);
            paramContext.registerReceiver(this. mBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.FOUND"));
            return;
        } catch (Exception exception) {
            LOG.a(TAG, "Exception : " + exception.getMessage());
            return;
        }
//        catch (IllegalArgumentException illegalArgumentException) {
//        }
    }

    public void d(String paramString) {
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setMessageType("requestBluetoothSpeakerList");
        localBlueToothMessageVO.setData(paramString);
        paramString = new Gson().toJson(localBlueToothMessageVO);
        LOG.c(TAG, "getSpeakerList | reqDataStr : [" + paramString + "]");
        e(paramString);
    }

    public void e(String paramString) {
        if (getState() != 3) {
        }
        do {
            return;
            LOG.c(TAG, "send bluetooth message : [" + paramString + "]");
        } while (paramString.length() <= 0);
        try {
            a(paramString.getBytes("UTF-8"));
            return;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
    }

    public boolean f(String paramString) {
        Iterator localIterator = this.j.keySet().iterator();
        while (localIterator.hasNext()) {
            if (((String) localIterator.next()).equals(paramString)) {
                return true;
            }
        }
        return false;
    }

    public void g(String paramString) {
        this.mBluetoothDevice = this.mBluetoothAdapter.getRemoteDevice(paramString);
        this.x = false;
        a(this.mBluetoothDevice);
    }

    public ArrayList<BluetoothDevice> getPairingDeivce() {
        if (this.mBluetoothAdapter == null) {
            this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.mBluetoothAdapter != null) {
            ArrayList localArrayList = new ArrayList();
            Object localObject = this.mBluetoothAdapter.getBondedDevices();
            Log.d("BT", "paired device size : " + ((Set) localObject).size());
            if (((Set) localObject).size() > 0) {
                Log.d("BT", "pairDevices.size() : " + ((Set) localObject).size());
                localObject = ((Set) localObject).iterator();
                while (((Iterator) localObject).hasNext()) {
                    BluetoothDevice localBluetoothDevice = (BluetoothDevice) ((Iterator) localObject).next();
                    Log.d("BT", "paired device : " + localBluetoothDevice.getName() + ", " + localBluetoothDevice.getAddress());
                    localArrayList.add(localBluetoothDevice);
                }
            }
            return localArrayList;
        }
        return null;
    }

    public int getState() {
        try {
            int i1 = this.state;
            return i1;
        } finally {
            localObject = finally;
            throw ((Throwable) localObject);
        }
    }

    public void h(String paramString) {
        if ((paramString != null) && (!paramString.isEmpty())) {
            this.mBluetoothDevice = this.mBluetoothAdapter.getRemoteDevice(paramString);
        }
        this.x = true;
        b(this.mBluetoothDevice);
    }

    public void setLocale(String paramString) {
        this.l = true;
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setMessageType("requestSetLanguage");
        localBlueToothMessageVO.setCode("00");
        localBlueToothMessageVO.setData(paramString);
        e(new Gson().toJson(localBlueToothMessageVO));
    }

    public void setTimeZone(String paramString) {
        this.l = true;
        BlueToothMessageVO localBlueToothMessageVO = new BlueToothMessageVO();
        localBlueToothMessageVO.setMessageType("requestSetTimeZone");
        localBlueToothMessageVO.setCode("00");
        localBlueToothMessageVO.setData(paramString);
        e(GsonService.a(localBlueToothMessageVO));
    }

    private class ConnectThread
            extends Thread {
        private BluetoothSocket b;
        private final BluetoothDevice c;

        ConnectThread(BluetoothDevice paramBluetoothDevice) {
            this.c = paramBluetoothDevice;
            for (; ; ) {
                try {
                    this$1 = paramBluetoothDevice.createInsecureRfcommSocketToServiceRecord(BluetoothService.g());
                } catch (IOException ioException) {
                    this$1 = null;
                }
                for (; ; ) {
                    try {
                        LOG.c(BluetoothService.f(), "ConnectThread [ MY_UUID_INSECURE ]");
                        if (this.b == null) {
                            break;
                        }
                    } catch (IOException ioException) {
                        continue;
                    }
                    try {
                        this.b.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        this.b = null;
                        break;
                    } finally {
                        this.b = null;
                    }
                }
                this.b = BluetoothService.this;
                return;
                LOG.a(BluetoothService.f(), "create() failed", paramBluetoothDevice);
            }
        }

        public void a() {
            try {
                this.b.close();
                return;
            } catch (IOException localIOException) {
                LOG.a(BluetoothService.f(), "socket failed", localIOException);
            }
        }

        /* Error */
        public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield 21	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:a	Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;
            //   4: getfield 70	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:mBluetoothAdapter	Landroid/bluetooth/BluetoothAdapter;
            //   7: invokevirtual 76	android/bluetooth/BluetoothAdapter:cancelDiscovery	()Z
            //   10: pop
            //   11: invokestatic 40	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:f	()Ljava/lang/String;
            //   14: astore_2
            //   15: new 78	java/lang/StringBuilder
            //   18: dup
            //   19: invokespecial 79	java/lang/StringBuilder:<init>	()V
            //   22: ldc 81
            //   24: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   27: astore_3
            //   28: aload_0
            //   29: getfield 49	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   32: ifnonnull +70 -> 102
            //   35: iconst_1
            //   36: istore_1
            //   37: aload_2
            //   38: aload_3
            //   39: iload_1
            //   40: invokevirtual 88	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
            //   43: ldc 90
            //   45: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   48: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   51: invokestatic 47	com/cnl/bluecanvaseuserapp2/utils/LOG:c	(Ljava/lang/String;Ljava/lang/String;)V
            //   54: aload_0
            //   55: getfield 49	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   58: ifnull +10 -> 68
            //   61: aload_0
            //   62: getfield 49	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   65: invokevirtual 96	android/bluetooth/BluetoothSocket:connect	()V
            //   68: aload_0
            //   69: getfield 21	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:a	Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;
            //   72: astore_2
            //   73: aload_2
            //   74: monitorenter
            //   75: aload_0
            //   76: getfield 21	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:a	Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;
            //   79: aconst_null
            //   80: invokestatic 99	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:a	(Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread;)Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread;
            //   83: pop
            //   84: aload_2
            //   85: monitorexit
            //   86: aload_0
            //   87: getfield 21	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:a	Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;
            //   90: aload_0
            //   91: getfield 49	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   94: aload_0
            //   95: getfield 26	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:c	Landroid/bluetooth/BluetoothDevice;
            //   98: invokevirtual 102	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:a	(Landroid/bluetooth/BluetoothSocket;Landroid/bluetooth/BluetoothDevice;)V
            //   101: return
            //   102: iconst_0
            //   103: istore_1
            //   104: goto -67 -> 37
            //   107: astore_2
            //   108: invokestatic 40	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:f	()Ljava/lang/String;
            //   111: new 78	java/lang/StringBuilder
            //   114: dup
            //   115: invokespecial 79	java/lang/StringBuilder:<init>	()V
            //   118: ldc 104
            //   120: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   123: aload_2
            //   124: invokevirtual 107	java/io/IOException:getMessage	()Ljava/lang/String;
            //   127: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   130: ldc 90
            //   132: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   135: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   138: invokestatic 109	com/cnl/bluecanvaseuserapp2/utils/LOG:a	(Ljava/lang/String;Ljava/lang/String;)V
            //   141: aload_0
            //   142: getfield 21	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectThread:a	Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;
            //   145: invokestatic 112	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:a	(Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;)V
            //   148: return
            //   149: astore_3
            //   150: aload_2
            //   151: monitorexit
            //   152: aload_3
            //   153: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	154	0	this	ConnectThread
            //   36	68	1	bool	boolean
            //   107	44	2	localIOException	IOException
            //   27	12	3	localStringBuilder	StringBuilder
            //   149	4	3	localObject2	Object
            // Exception table:
            //   from	to	target	type
            //   54	68	107	java/io/IOException
            //   75	86	149	finally
            //   150	152	149	finally
        }
    }

    private class ConnectedThread
            extends Thread {
        private BluetoothSocket b;
        private InputStream c;
        private OutputStream d;

        /* Error */
        ConnectedThread(BluetoothSocket paramBluetoothSocket) {
            // Byte code:
            //   0: aconst_null
            //   1: astore 4
            //   3: aload_0
            //   4: aload_1
            //   5: putfield 23	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:a	Lcom/cnl/bluecanvaseuserapp2/controller/service/BluetoothService;
            //   8: aload_0
            //   9: invokespecial 26	java/lang/Thread:<init>	()V
            //   12: invokestatic 30	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:f	()Ljava/lang/String;
            //   15: ldc 32
            //   17: invokestatic 37	com/cnl/bluecanvaseuserapp2/utils/LOG:c	(Ljava/lang/String;Ljava/lang/String;)V
            //   20: aload_0
            //   21: getfield 39	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   24: ifnull +15 -> 39
            //   27: aload_0
            //   28: getfield 39	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   31: invokevirtual 44	android/bluetooth/BluetoothSocket:close	()V
            //   34: aload_0
            //   35: aconst_null
            //   36: putfield 39	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   39: aload_0
            //   40: getfield 46	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:c	Ljava/io/InputStream;
            //   43: ifnull +15 -> 58
            //   46: aload_0
            //   47: getfield 46	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:c	Ljava/io/InputStream;
            //   50: invokevirtual 49	java/io/InputStream:close	()V
            //   53: aload_0
            //   54: aconst_null
            //   55: putfield 46	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:c	Ljava/io/InputStream;
            //   58: aload_0
            //   59: getfield 51	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:d	Ljava/io/OutputStream;
            //   62: ifnull +15 -> 77
            //   65: aload_0
            //   66: getfield 51	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:d	Ljava/io/OutputStream;
            //   69: invokevirtual 54	java/io/OutputStream:close	()V
            //   72: aload_0
            //   73: aconst_null
            //   74: putfield 51	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:d	Ljava/io/OutputStream;
            //   77: aload_0
            //   78: aload_2
            //   79: putfield 39	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:bluetoothSocket	Landroid/bluetooth/BluetoothSocket;
            //   82: invokestatic 30	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:f	()Ljava/lang/String;
            //   85: ldc 56
            //   87: invokestatic 37	com/cnl/bluecanvaseuserapp2/utils/LOG:c	(Ljava/lang/String;Ljava/lang/String;)V
            //   90: aload_2
            //   91: invokevirtual 60	android/bluetooth/BluetoothSocket:getInputStream	()Ljava/io/InputStream;
            //   94: astore_3
            //   95: aload_2
            //   96: invokevirtual 64	android/bluetooth/BluetoothSocket:getOutputStream	()Ljava/io/OutputStream;
            //   99: astore_2
            //   100: aload_2
            //   101: astore_1
            //   102: aload_0
            //   103: aload_3
            //   104: putfield 46	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:c	Ljava/io/InputStream;
            //   107: aload_0
            //   108: aload_1
            //   109: putfield 51	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService$ConnectedThread:d	Ljava/io/OutputStream;
            //   112: return
            //   113: astore_2
            //   114: aconst_null
            //   115: astore_3
            //   116: invokestatic 30	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:f	()Ljava/lang/String;
            //   119: ldc 66
            //   121: aload_2
            //   122: invokestatic 69	com/cnl/bluecanvaseuserapp2/utils/LOG:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   125: aload_1
            //   126: getfield 73	com/cnl/bluecanvaseuserapp2/controller/service/BluetoothService:mIBluetoothCallback	Lcom/cnl/bluecanvaseuserapp2/controller/callback/IBluetoothCallback;
            //   129: aload_2
            //   130: invokevirtual 76	java/io/IOException:toString	()Ljava/lang/String;
            //   133: invokeinterface 81 2 0
            //   138: aload 4
            //   140: astore_1
            //   141: goto -39 -> 102
            //   144: astore_2
            //   145: goto -29 -> 116
            //   148: astore_3
            //   149: goto -77 -> 72
            //   152: astore_3
            //   153: goto -100 -> 53
            //   156: astore_3
            //   157: goto -123 -> 34
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	160	0	this	ConnectedThread
            //   0	160	1	this$1	BluetoothService
            //   0	160	2	paramBluetoothSocket	BluetoothSocket
            //   94	22	3	localInputStream	InputStream
            //   148	1	3	localException1	Exception
            //   152	1	3	localException2	Exception
            //   156	1	3	localException3	Exception
            //   1	138	4	localObject	Object
            // Exception table:
            //   from	to	target	type
            //   82	95	113	java/io/IOException
            //   95	100	144	java/io/IOException
            //   65	72	148	java/lang/Exception
            //   46	53	152	java/lang/Exception
            //   27	34	156	java/lang/Exception
        }

        public void a() {
            try {
                this.b.close();
                return;
            } catch (IOException localIOException) {
                LOG.a(BluetoothService.f(), "close() of connect socket failed", localIOException);
            }
        }

        public void a(byte[] paramArrayOfByte) { //send data over
            try {
                LOG.a(BluetoothService.f(), "write... byte[] buffer : " + new String(paramArrayOfByte, 0, paramArrayOfByte.length));
                this.d.write(paramArrayOfByte);
                this.d.flush();
                sleep(20000L);
                if (BluetoothService.this.l) {
                    BluetoothService.this.l = false;
                    BluetoothService.this.mIBluetoothCallback.b();
                }
                return;
            } catch (Exception exception) {
                LOG.a(BluetoothService.f(), "Exception during write", paramArrayOfByte);
            }
        }

        public void run() {
            LOG.d(BluetoothService.f(), "BEGIN 1");
            byte[] arrayOfByte = new byte['?'];
            try {
                for (; ; ) {
                    int i = this.c.read(arrayOfByte);
                    BluetoothService.b(BluetoothService.this).obtainMessage(10002, i, -1, arrayOfByte).sendToTarget();
                    LOG.c(BluetoothService.f(), "ConnectedThread [ Read froam the InputStrem ]");
                }
                return;
            } catch (IOException localIOException) {
                BluetoothService.this.l = true;
                LOG.a(BluetoothService.f(), "disconnected : " + localIOException.getMessage());
                BluetoothService.this.d();
                if (BluetoothService.c(BluetoothService.this)) {
                    BluetoothService.a(BluetoothService.this, 2001);
                    return;
                }
                BluetoothService.a(BluetoothService.this, 2002);
            }
        }
    }

    private class DisconnectThread
            extends Thread {
        private BluetoothSocket bluetoothSocket;

        DisconnectThread(BluetoothDevice paramBluetoothDevice) {
            for (; ; ) {
                try {
                    this$1 = paramBluetoothDevice.createInsecureRfcommSocketToServiceRecord(BluetoothService.g());
                } catch (IOException ioException) {
                    this$1 = null;
                }
                for (; ; ) {
                    try {
                        LOG.c(BluetoothService.f(), "DisconnectThread [ MY_UUID_INSECURE ]");
                        if (this.bluetoothSocket == null) {
                            break;
                        }
                    } catch (IOException ioException) {
                        continue;
                    }
                    try {
                        this.bluetoothSocket.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        this.bluetoothSocket = null;
                        break;
                    } finally {
                        this.bluetoothSocket = null;
                    }
                }
                this.bluetoothSocket = BluetoothService.this;
                return;
                LOG.a(BluetoothService.f(), "create() failed", paramBluetoothDevice);
            }
        }

        public void run() {
            BluetoothService.this.mBluetoothAdapter.cancelDiscovery();
//      ??? =BluetoothService.f();
            StringBuilder localStringBuilder = new StringBuilder().append("socket is null ? : [");
            boolean bool;
            if (this.bluetoothSocket == null) {
                bool = true;
            }
            for (; ; ) {
                LOG.c((String) BluetoothService.f(), bool + "]");
                try {
                    if (this.bluetoothSocket != null) {
                        this.bluetoothSocket.getOutputStream();
                        sleep(100L);
                        this.bluetoothSocket.close();
                        this.bluetoothSocket = null;
                    }
                } catch (Exception localException) {
                    synchronized (BluetoothService.this) {
                        BluetoothService.a(BluetoothService.this, null);
                        return;
                        bool = false;
                        continue;
                        localException = localException;
                        localException.printStackTrace();
                    }
                }
            }
        }
    }
}

