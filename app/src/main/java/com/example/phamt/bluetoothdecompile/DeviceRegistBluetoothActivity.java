package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/18.
 */

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.DeviceVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class DeviceRegistBluetoothActivity
        extends BaseActivity
{
    private static final String TAG = DeviceRegistBluetoothActivity.class.getSimpleName();
    private static final int w = 1001;
    private boolean A = false;
    private BluetoothService mBluetoothService;
    private String ac = "";
    private ImageView ad;
    private int ae = 0;
    private Timer af;
    private int ag = 0;
    private HashMap<String, String> ah = new HashMap();
    private HashMap<String, String> ai = new HashMap();
    private boolean aj = false;
    IBluetoothCallback u = new IBluetoothCallback()
    {
        public void a()
        {
            Alert.a();
            DeviceRegistBluetoothActivity.h(DeviceRegistBluetoothActivity.this);
            if (DeviceRegistBluetoothActivity.i(DeviceRegistBluetoothActivity.this) >= 5)
            {
                Toast.makeText(DeviceRegistBluetoothActivity.this.V, DeviceRegistBluetoothActivity.this.getString(2131230804), 0).show();
                return;
            }
            Toast.makeText(DeviceRegistBluetoothActivity.this.V, DeviceRegistBluetoothActivity.this.getString(2131231133), 0).show();
        }

        public void a(int paramAnonymousInt)
        {
            switch (paramAnonymousInt)
            {
                default:
                    return;
            }
            LOG.c(DeviceRegistBluetoothActivity.l(), "BLUETOOTH ?? ??");
            new Thread()
            {
                public void run()
                {
                    DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).a("" + DeviceRegistBluetoothActivity.this.U.myUserInfo.getUserId());
                }
            }.start();
        }

        public void a(String paramAnonymousString)
        {
            Alert.a();
            Toast.makeText(DeviceRegistBluetoothActivity.this.V, DeviceRegistBluetoothActivity.this.getString(2131231133), 0).show();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2)
        {
            DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this, paramAnonymousString1, paramAnonymousString2);
        }

        public void b()
        {
            if (DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).getState() == 3) {
                new Thread()
                {
                    public void run()
                    {
                        DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).a("" + DeviceRegistBluetoothActivity.this.U.myUserInfo.getUserId());
                    }
                }.start();
            }
        }

        public void b(int paramAnonymousInt)
        {
            if (paramAnonymousInt == 2002)
            {
                Alert.a();
                Toast.makeText(DeviceRegistBluetoothActivity.this.V, DeviceRegistBluetoothActivity.this.getString(2131231000), 0).show();
                DeviceRegistBluetoothActivity.this.finish();
            }
        }

        public void b(String paramAnonymousString)
        {
            int j = -1;
            Alert.a();
            LOG.c(DeviceRegistBluetoothActivity.l(), "response msg :::: " + paramAnonymousString);
            Object localObject = GsonService.b(paramAnonymousString);
            for (;;)
            {
                String str;
                try
                {
                    str = ((BlueToothMessageVO)localObject).getMessageType();
                    localObject = ((BlueToothMessageVO)localObject).getCode();
                    switch (str.hashCode())
                    {
                        default:
                            i = -1;
                            switch (i)
                            {
                                default:
                                    return;
                            }
                            break;
                    }
                }
                catch (NullPointerException paramAnonymousString)
                {
                    paramAnonymousString.printStackTrace();
                    Toast.makeText(DeviceRegistBluetoothActivity.this, DeviceRegistBluetoothActivity.this.getStr(2131230889), 0).show();
                    DeviceRegistBluetoothActivity.this.finish();
                    return;
                }
                if (str.equals("responseWifiList"))
                {
                    i = 0;
                    continue;
                    if (str.equals("responseRegist")) {
                        i = 1;
                    }
                }
            }
            int i = j;
            switch (((String)localObject).hashCode())
            {
                default:
                    i = j;
            }
            for (;;)
            {
                switch (i)
                {
                    default:
                        return;
                    case 0:
                        DeviceRegistBluetoothActivity.b(DeviceRegistBluetoothActivity.this, paramAnonymousString);
                        return;
                    i = j;
                    if (((String)localObject).equals("00"))
                    {
                        i = 0;
                        continue;
                        i = j;
                        if (((String)localObject).equals("02"))
                        {
                            i = 1;
                            continue;
                            i = j;
                            if (((String)localObject).equals("03")) {
                                i = 2;
                            }
                        }
                    }
                    break;
                }
            }
            LOG.c(DeviceRegistBluetoothActivity.l(), "??? ???? ??????");
            return;
            LOG.c(DeviceRegistBluetoothActivity.l(), "?? ??? ??");
            return;
            Toast.makeText(DeviceRegistBluetoothActivity.this.V, DeviceRegistBluetoothActivity.this.getStr(2131230982), 0).show();
            DeviceRegistBluetoothActivity.this.finish();
        }
    };
    private DeviceListAdapter x;
    private ListView y;
    private ArrayList<DeviceVo> z;

    private void a(String paramString)
    {
        if (!isDestroyed())
        {
            Intent localIntent = new Intent(this, DeviceRegistWifiActivity.class);
            localIntent.putExtra("wifiList", paramString);
            localIntent.putExtra("wifiChangeFlag", "N");
            localIntent.putExtra("registeringDeviceBluetoothMac", this.ac);
            a(localIntent, 1001, 0);
            this.A = true;
            finish();
        }
    }

    private void a(String paramString1, String paramString2)
    {
        LOG.c(TAG, "=============  paired Device Find: " + paramString1 + " - " + paramString2);
        String str = paramString1;
        if (paramString1 == null) {
            str = "noname";
        }
        if (!this.ah.containsKey(paramString2)) {
            this.ah.put(paramString2, str);
        }
        if (!this.ai.containsKey(paramString2))
        {
            this.ai.put(paramString2, str);
            this.z.add(new DeviceVo(str, paramString2));
            runOnUiThread(new Runnable()
            {
                public void run()
                {
                    if (DeviceRegistBluetoothActivity.c(DeviceRegistBluetoothActivity.this) != null) {
                        DeviceRegistBluetoothActivity.c(DeviceRegistBluetoothActivity.this).notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private void m()
    {
        this.mBluetoothService = BluetoothService.a(this, this.u);
        this.mBluetoothService.d(this);
        this.mBluetoothService.a();
    }

    private void n()
    {
        if (this.mBluetoothService.a(this.V))
        {
            if (this.af != null) {
                this.af.cancel();
            }
            this.ag = 0;
            this.af = new Timer();
            this.af.schedule(new TimerTask()
            {
                public void run()
                {
                    if (DeviceRegistBluetoothActivity.d(DeviceRegistBluetoothActivity.this) >= 10)
                    {
                        DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).a(true);
                        DeviceRegistBluetoothActivity.e(DeviceRegistBluetoothActivity.this);
                        DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this, 0);
                    }
                    DeviceRegistBluetoothActivity.f(DeviceRegistBluetoothActivity.this);
                    DeviceRegistBluetoothActivity.g(DeviceRegistBluetoothActivity.this);
                }
            }, 0L, 1000L);
        }
    }

    private void o()
    {
        if (this.mBluetoothService != null)
        {
            ArrayList localArrayList = this.mBluetoothService.getPairingDeivce();
            int i = 0;
            while (i < localArrayList.size())
            {
                BluetoothDevice localBluetoothDevice = (BluetoothDevice)localArrayList.get(i);
                a(localBluetoothDevice.getName(), localBluetoothDevice.getAddress());
                i += 1;
            }
            this.mBluetoothService.b();
        }
    }

    private void y()
    {
        LOG.c(TAG, "TEST ============ ???? ?? ?? ?? ??? ??? ??? ???? ?? ?? ??");
        int i = 0;
        while (i < this.z.size())
        {
            if (!this.ah.containsKey(((DeviceVo)this.z.get(i)).getBluetoothMacAddress()))
            {
                LOG.c(TAG, "TEST ============ ????!! : " + ((DeviceVo)this.z.get(i)).getDeviceName() + " === " + ((DeviceVo)this.z.get(i)).getBluetoothMacAddress());
                this.ai.remove(((DeviceVo)this.z.get(i)).getBluetoothMacAddress());
                this.z.remove(i);
            }
            i += 1;
        }
        this.ah = new HashMap();
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                if (DeviceRegistBluetoothActivity.c(DeviceRegistBluetoothActivity.this) != null) {
                    DeviceRegistBluetoothActivity.c(DeviceRegistBluetoothActivity.this).notifyDataSetChanged();
                }
            }
        });
        LOG.c(TAG, "TEST ============ ???? ?? ?? ?? ??? ??? ??? ???? ?? ?? ?");
    }

    public void j() //set device list view
    {
        this.ad = ((ImageView)findViewById(2131624144));
        this.ad.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.y = ((ListView)findViewById(2131624105));
        this.z = new ArrayList();
        this.x = new DeviceListAdapter(this.z);
        this.y.setAdapter(this.x);
        this.y.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                try
                {
                    if (!DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).a(DeviceRegistBluetoothActivity.this.V))
                    {
                        DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).a();
                        return;
                    }
                    if (DeviceRegistBluetoothActivity.b(DeviceRegistBluetoothActivity.this) != null)
                    {
                        DeviceRegistBluetoothActivity.b(DeviceRegistBluetoothActivity.this).cancel();
                        DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).a(true);
                    }
                    Alert.a(DeviceRegistBluetoothActivity.this.V);
                    DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this, DeviceRegistBluetoothActivity.c(DeviceRegistBluetoothActivity.this).getItem(paramAnonymousInt).getBluetoothMacAddress());
                    DeviceRegistBluetoothActivity.a(DeviceRegistBluetoothActivity.this).g(DeviceRegistBluetoothActivity.c(DeviceRegistBluetoothActivity.this).getItem(paramAnonymousInt).getBluetoothMacAddress());
                    return;
                }
                catch (Exception paramAnonymousAdapterView)
                {
                    paramAnonymousAdapterView.printStackTrace();
                }
            }
        });
    }

    public void k()
    {
        a(4);
        setmActionBarTitle(getStr(2131230806));
        setRightButtonTitle(getStr(2131231123));
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        if (paramInt1 == 101)
        {
            if (paramInt2 == -1)
            {
                LOG.c(TAG, "\nDevice can use");
                n();
            }
        }
        else {
            return;
        }
        LOG.c(TAG, "\nDevice can not use");
        finish();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968643);
        w();
        this.V = this;
        LOG.c(TAG, "TEST ==== hasPermission1: " + this.aj);
        k();
        j();
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }))
            {
                LOG.c(TAG, "TEST ==== hasPermission2: " + this.aj);
                m();
                this.aj = true;
                return;
            }
            LOG.c(TAG, "???? ????");
            this.aj = false;
            return;
        }
        m();
        this.aj = true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (this.mBluetoothService != null)
        {
            if (this.mBluetoothService.h != null) {
                this.mBluetoothService.a(true);
            }
            if ((this.mBluetoothService.getState() == 3) && (!this.A) && (this.ac != null) && (!this.ac.isEmpty())) {
                this.mBluetoothService.h(this.ac);
            }
            this.mBluetoothService.c(this);
        }
        if (this.af != null) {
            this.af.cancel();
        }
    }

    public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
        switch (paramInt)
        {
            default:
                return;
        }
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
        {
            this.aj = true;
            m();
            n();
            return;
        }
        this.aj = false;
        finish();
    }

    public void onResume()
    {
        super.onResume();
        if (this.aj) {
            n();
        }
    }

    public void onStop()
    {
        super.onStop();
        if (this.af != null)
        {
            this.af.cancel();
            this.mBluetoothService.a(true);
        }
        finish();
    }

    public void rightBtnClick(View paramView)
    {
        this.z.clear();
        this.ah = new HashMap();
        this.ai = new HashMap();
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                DeviceRegistBluetoothActivity.c(DeviceRegistBluetoothActivity.this).notifyDataSetChanged();
            }
        });
        r();
        this.mBluetoothService.a(true);
        n();
    }
}

