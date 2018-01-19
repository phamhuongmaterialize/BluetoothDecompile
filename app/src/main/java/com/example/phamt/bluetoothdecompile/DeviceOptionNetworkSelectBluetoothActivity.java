package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class DeviceOptionNetworkSelectBluetoothActivity
        extends BaseActivity
{
    private static final int af = 1001;
    private static final String w = DeviceOptionNetworkSelectBluetoothActivity.class.getSimpleName();
    private boolean A = false;
    private String ab = null;
    private LinearLayout ac;
    private LinearLayout ad;
    private ImageView ae;
    private ImageView ag;
    private int ah = 0;
    private Timer ai;
    private int aj = 0;
    private HashMap<String, String> ak = new HashMap();
    private HashMap<String, String> al = new HashMap();
    private boolean am = false;
    private boolean an = false;
    private Timer ao;
    private int ap = 0;
    BluetoothService u;
    IBluetoothCallback v = new IBluetoothCallback()
    {
        public void a()
        {
            DeviceOptionNetworkSelectBluetoothActivity.a(DeviceOptionNetworkSelectBluetoothActivity.this, true);
            Alert.a();
            DeviceOptionNetworkSelectBluetoothActivity.j(DeviceOptionNetworkSelectBluetoothActivity.this).setVisibility(8);
            DeviceOptionNetworkSelectBluetoothActivity.k(DeviceOptionNetworkSelectBluetoothActivity.this).setVisibility(0);
            DeviceOptionNetworkSelectBluetoothActivity.l(DeviceOptionNetworkSelectBluetoothActivity.this);
            DeviceOptionNetworkSelectBluetoothActivity.m(DeviceOptionNetworkSelectBluetoothActivity.this);
            DeviceOptionNetworkSelectBluetoothActivity.this.k();
            if (DeviceOptionNetworkSelectBluetoothActivity.n(DeviceOptionNetworkSelectBluetoothActivity.this))
            {
                DeviceOptionNetworkSelectBluetoothActivity.o(DeviceOptionNetworkSelectBluetoothActivity.this);
                if (DeviceOptionNetworkSelectBluetoothActivity.p(DeviceOptionNetworkSelectBluetoothActivity.this) < 5) {
                    break label118;
                }
                Toast.makeText(DeviceOptionNetworkSelectBluetoothActivity.this.V, DeviceOptionNetworkSelectBluetoothActivity.this.getString(2131230804), 0).show();
            }
            for (;;)
            {
                DeviceOptionNetworkSelectBluetoothActivity.a(DeviceOptionNetworkSelectBluetoothActivity.this, true);
                return;
                label118:
                Toast.makeText(DeviceOptionNetworkSelectBluetoothActivity.this.V, DeviceOptionNetworkSelectBluetoothActivity.this.getString(2131231133), 0).show();
            }
        }

        public void a(int paramAnonymousInt)
        {
            switch (paramAnonymousInt)
            {
                default:
                    return;
            }
            LOG.c(DeviceOptionNetworkSelectBluetoothActivity.l(), "BLUETOOTH ?? ??");
            new Thread()
            {
                public void run()
                {
                    DeviceOptionNetworkSelectBluetoothActivity.this.u.b("" + DeviceOptionNetworkSelectBluetoothActivity.this.U.myUserInfo.getUserId());
                }
            }.start();
        }

        public void a(String paramAnonymousString)
        {
            Toast.makeText(DeviceOptionNetworkSelectBluetoothActivity.this.V, DeviceOptionNetworkSelectBluetoothActivity.this.getString(2131231133), 0).show();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2)
        {
            DeviceOptionNetworkSelectBluetoothActivity.a(DeviceOptionNetworkSelectBluetoothActivity.this, paramAnonymousString1, paramAnonymousString2);
        }

        public void b()
        {
            if (DeviceOptionNetworkSelectBluetoothActivity.this.u.getState() == 3) {
                new Thread()
                {
                    public void run()
                    {
                        DeviceOptionNetworkSelectBluetoothActivity.this.u.b("" + DeviceOptionNetworkSelectBluetoothActivity.this.U.myUserInfo.getUserId());
                    }
                }.start();
            }
        }

        public void b(int paramAnonymousInt)
        {
            if (paramAnonymousInt == 2002)
            {
                Toast.makeText(DeviceOptionNetworkSelectBluetoothActivity.this.V, DeviceOptionNetworkSelectBluetoothActivity.this.getString(2131231000), 0).show();
                DeviceOptionNetworkSelectBluetoothActivity.this.finish();
            }
        }

        public void b(String paramAnonymousString)
        {
            Alert.a();
            LOG.c(DeviceOptionNetworkSelectBluetoothActivity.l(), "response msg :::: " + paramAnonymousString);
            Object localObject = GsonService.b(paramAnonymousString);
            String str;
            do
            {
                for (;;)
                {
                    int j;
                    try
                    {
                        str = ((BlueToothMessageVO)localObject).getMessageType();
                        localObject = ((BlueToothMessageVO)localObject).getCode();
                        j = -1;
                        i = j;
                        switch (((String)localObject).hashCode())
                        {
                            default:
                                i = j;
                            case 1537:
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
                        Toast.makeText(DeviceOptionNetworkSelectBluetoothActivity.this.V, DeviceOptionNetworkSelectBluetoothActivity.this.getStr(2131230889), 0).show();
                        DeviceOptionNetworkSelectBluetoothActivity.this.finish();
                        return;
                    }
                    int i = j;
                    if (((String)localObject).equals("00"))
                    {
                        i = 0;
                        continue;
                        i = j;
                        if (((String)localObject).equals("03"))
                        {
                            i = 1;
                            continue;
                            i = j;
                            if (((String)localObject).equals("02")) {
                                i = 2;
                            }
                        }
                    }
                }
            } while (!str.equals("responseWifiList"));
            DeviceOptionNetworkSelectBluetoothActivity.b(DeviceOptionNetworkSelectBluetoothActivity.this, paramAnonymousString);
            return;
            Toast.makeText(DeviceOptionNetworkSelectBluetoothActivity.this.V, DeviceOptionNetworkSelectBluetoothActivity.this.getStr(2131230982), 0).show();
            DeviceOptionNetworkSelectBluetoothActivity.this.finish();
            return;
            LOG.c(DeviceOptionNetworkSelectBluetoothActivity.l(), "??? ???? ??????");
            DeviceOptionNetworkSelectBluetoothActivity.b(DeviceOptionNetworkSelectBluetoothActivity.this, paramAnonymousString);
        }
    };
    private DeviceListAdapter x;
    private ListView y;
    private ArrayList<DeviceVo> z;

    private void A()
    {
        LOG.c(w, "TEST ============ ???? ?? ?? ?? ??? ??? ??? ???? ?? ?? ??");
        int i = 0;
        while (i < this.z.size())
        {
            if (!this.ak.containsKey(((DeviceVo)this.z.get(i)).getBluetoothMacAddress()))
            {
                LOG.c(w, "TEST ============ ????!! : " + ((DeviceVo)this.z.get(i)).getDeviceName() + " === " + ((DeviceVo)this.z.get(i)).getBluetoothMacAddress());
                this.al.remove(((DeviceVo)this.z.get(i)).getBluetoothMacAddress());
                this.z.remove(i);
            }
            i += 1;
        }
        this.ak = new HashMap();
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                if (DeviceOptionNetworkSelectBluetoothActivity.d(DeviceOptionNetworkSelectBluetoothActivity.this) != null) {
                    DeviceOptionNetworkSelectBluetoothActivity.d(DeviceOptionNetworkSelectBluetoothActivity.this).notifyDataSetChanged();
                }
            }
        });
        LOG.c(w, "TEST ============ ???? ?? ?? ?? ??? ??? ??? ???? ?? ?? ?");
    }

    private void a(String paramString)
    {
        if (!isDestroyed())
        {
            Intent localIntent = new Intent(this, DeviceOptionNetworkChangeWifiActivity.class);
            localIntent.putExtra("wifiList", paramString);
            localIntent.putExtra("wifiChangeFlag", "N");
            localIntent.putExtra("registeringDeviceBluetoothMac", this.ab);
            a(localIntent, 1001, 0);
            this.A = true;
            finish();
        }
    }

    private void a(String paramString1, String paramString2)
    {
        LOG.c(w, "=============  paired Device Find: " + paramString1 + " - " + paramString2);
        String str = paramString1;
        if (paramString1 == null) {
            str = "noname";
        }
        if (!this.ak.containsKey(paramString2)) {
            this.ak.put(paramString2, str);
        }
        if (!this.al.containsKey(paramString2))
        {
            if (this.ap < 15) {
                try
                {
                    if ((this.ab == null) || (this.ab.isEmpty()))
                    {
                        if (!this.U.selectedDeviceVo.getDeviceName().equals(str)) {
                            return;
                        }
                        LOG.c(w, "TEST =============  ???? ?????? ??? ???? ???? ??? allScanmodeTime: " + this.ap);
                        b(str, paramString2);
                        return;
                    }
                    if (!this.ab.equals(paramString2)) {
                        return;
                    }
                    LOG.c(w, "TEST =============  ???? ?????? ??? allScanmodeTime: " + this.ap);
                    b(str, paramString2);
                    return;
                }
                catch (Exception paramString1)
                {
                    b(str, paramString2);
                    paramString1.printStackTrace();
                    return;
                }
            }
            LOG.c(w, "TEST =============  15?? ??? ????: " + this.ap);
            b(str, paramString2);
        }
    }

    private void b(String paramString1, String paramString2)
    {
        this.al.put(paramString2, paramString1);
        this.z.add(new DeviceVo(paramString1, paramString2));
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                if (DeviceOptionNetworkSelectBluetoothActivity.d(DeviceOptionNetworkSelectBluetoothActivity.this) != null) {
                    DeviceOptionNetworkSelectBluetoothActivity.d(DeviceOptionNetworkSelectBluetoothActivity.this).notifyDataSetChanged();
                }
            }
        });
    }

    private void m()
    {
        if (this.am)
        {
            if (this.ao != null) {
                this.ao.cancel();
            }
            this.ao = new Timer();
            this.ao.schedule(new TimerTask()
            {
                public void run()
                {
                    DeviceOptionNetworkSelectBluetoothActivity.a(DeviceOptionNetworkSelectBluetoothActivity.this);
                    LOG.c(DeviceOptionNetworkSelectBluetoothActivity.l(), "TEST ==== allScanmodeTime: " + DeviceOptionNetworkSelectBluetoothActivity.b(DeviceOptionNetworkSelectBluetoothActivity.this));
                }
            }, 0L, 1000L);
        }
    }

    private void n()
    {
        if (this.U.selectedDeviceVo.getBluetoothMacAddress() == null) {
            this.am = true;
        }
        for (;;)
        {
            LOG.c(w, "checkBluetoothMacAddress ====isScanMode // model.selectedDeviceVo.getBluetoothMacAddress(): " + this.am + " // " + this.U.selectedDeviceVo.getBluetoothMacAddress());
            return;
            if (this.U.selectedDeviceVo.getBluetoothMacAddress().isEmpty())
            {
                this.am = true;
            }
            else
            {
                this.am = false;
                try
                {
                    this.ab = this.U.selectedDeviceVo.getBluetoothMacAddress().toUpperCase();
                }
                catch (Exception localException)
                {
                    localException.printStackTrace();
                }
            }
        }
    }

    private void o()
    {
        this.u = BluetoothService.a(this, this.v);
        this.u.d(this);
        if ((this.u.a(this.V)) && (!this.am)) {
            new Handler().postDelayed(new Runnable()
            {
                public void run()
                {
                    DeviceOptionNetworkSelectBluetoothActivity.this.u.g(DeviceOptionNetworkSelectBluetoothActivity.e(DeviceOptionNetworkSelectBluetoothActivity.this));
                }
            }, 1000L);
        }
        this.u.a();
    }

    private void y()
    {
        if (this.u.a(this.V))
        {
            if (this.ai != null) {
                this.ai.cancel();
            }
            this.aj = 0;
            this.ai = new Timer();
            this.ai.schedule(new TimerTask()
            {
                public void run()
                {
                    if (DeviceOptionNetworkSelectBluetoothActivity.f(DeviceOptionNetworkSelectBluetoothActivity.this) >= 10)
                    {
                        DeviceOptionNetworkSelectBluetoothActivity.this.u.a(true);
                        DeviceOptionNetworkSelectBluetoothActivity.g(DeviceOptionNetworkSelectBluetoothActivity.this);
                        DeviceOptionNetworkSelectBluetoothActivity.a(DeviceOptionNetworkSelectBluetoothActivity.this, 0);
                    }
                    DeviceOptionNetworkSelectBluetoothActivity.h(DeviceOptionNetworkSelectBluetoothActivity.this);
                    DeviceOptionNetworkSelectBluetoothActivity.i(DeviceOptionNetworkSelectBluetoothActivity.this);
                }
            }, 0L, 1000L);
        }
    }

    private void z()
    {
        if (this.u != null)
        {
            ArrayList localArrayList = this.u.getPairingDeivce();
            int i = 0;
            while (i < localArrayList.size())
            {
                BluetoothDevice localBluetoothDevice = (BluetoothDevice)localArrayList.get(i);
                a(localBluetoothDevice.getName(), localBluetoothDevice.getAddress());
                i += 1;
            }
            this.u.b();
        }
    }

    public void j()
    {
        this.ae = ((ImageView)findViewById(2131624255));
        this.ae.setLayoutParams(new LinearLayout.LayoutParams(this.U.deviceWidth / 4 * 3, this.U.deviceWidth / 2));
        this.ac = ((LinearLayout)findViewById(2131624136));
        this.ad = ((LinearLayout)findViewById(2131624254));
        this.ag = ((ImageView)findViewById(2131624144));
        this.ag.setBackground(null);
        this.ag.destroyDrawingCache();
        this.ag.setBackground(getDraw(2130837690));
        this.ag = ((ImageView)findViewById(2131624144));
        this.ag.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.y = ((ListView)findViewById(2131624105));
        this.z = new ArrayList();
        this.x = new DeviceListAdapter(this.z);
        this.y.setAdapter(this.x);
        if (this.am)
        {
            this.ac.setVisibility(0);
            this.ad.setVisibility(8);
        }
        for (;;)
        {
            a(this.ae, 2130837601, 2, this.U.deviceWidth / 4 * 3, this.U.deviceWidth / 2);
            this.y.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                {
                    try
                    {
                        if (!DeviceOptionNetworkSelectBluetoothActivity.this.u.a(DeviceOptionNetworkSelectBluetoothActivity.this.V))
                        {
                            DeviceOptionNetworkSelectBluetoothActivity.this.u.a();
                            return;
                        }
                        if (DeviceOptionNetworkSelectBluetoothActivity.c(DeviceOptionNetworkSelectBluetoothActivity.this) != null)
                        {
                            DeviceOptionNetworkSelectBluetoothActivity.c(DeviceOptionNetworkSelectBluetoothActivity.this).cancel();
                            DeviceOptionNetworkSelectBluetoothActivity.this.u.a(true);
                        }
                        Alert.a(DeviceOptionNetworkSelectBluetoothActivity.this.V);
                        DeviceOptionNetworkSelectBluetoothActivity.a(DeviceOptionNetworkSelectBluetoothActivity.this, DeviceOptionNetworkSelectBluetoothActivity.d(DeviceOptionNetworkSelectBluetoothActivity.this).getItem(paramAnonymousInt).getBluetoothMacAddress());
                        DeviceOptionNetworkSelectBluetoothActivity.this.u.g(DeviceOptionNetworkSelectBluetoothActivity.d(DeviceOptionNetworkSelectBluetoothActivity.this).getItem(paramAnonymousInt).getBluetoothMacAddress());
                        return;
                    }
                    catch (Exception paramAnonymousAdapterView)
                    {
                        paramAnonymousAdapterView.printStackTrace();
                    }
                }
            });
            return;
            this.ac.setVisibility(8);
            this.ad.setVisibility(0);
        }
    }

    public void k()
    {
        if (this.am)
        {
            a(4);
            setRightButtonTitle(getStr(2131231123));
        }
        for (;;)
        {
            setmActionBarTitle(getStr(2131230806));
            q();
            return;
            a(3);
        }
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        if (paramInt1 == 101)
        {
            if (paramInt2 != -1) {
                break label36;
            }
            LOG.c(w, "\nDevice can use");
            o();
            if (this.am) {
                y();
            }
        }
        return;
        label36:
        LOG.c(w, "\nDevice can not use");
        finish();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968643);
        w();
        this.V = this;
        n();
        k();
        j();
        if (Build.VERSION.SDK_INT >= 23) {
            if (a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }))
            {
                LOG.c(w, "TEST ==== hasPermission2: " + this.an);
                o();
                this.an = true;
            }
        }
        for (;;)
        {
            m();
            return;
            LOG.c(w, "???? ????");
            this.an = false;
            continue;
            o();
            this.an = true;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (this.u != null)
        {
            if (this.u.h != null) {
                this.u.a(true);
            }
            if ((this.u.getState() == 3) && (!this.A) && (this.ab != null) && (!this.ab.isEmpty())) {
                this.u.h(this.ab);
            }
            this.u.c(this);
        }
        if (this.ai != null)
        {
            this.ai.cancel();
            this.ai = new Timer();
        }
        if (this.ao != null)
        {
            this.ao.cancel();
            this.ao = new Timer();
        }
    }

    public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
        switch (paramInt)
        {
        }
        do
        {
            return;
            if ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != 0)) {
                break;
            }
            this.an = true;
            o();
        } while (!this.am);
        y();
        return;
        this.an = false;
        finish();
    }

    public void onResume()
    {
        super.onResume();
        if ((this.am) && (this.an)) {
            y();
        }
    }

    public void onStop()
    {
        super.onStop();
        if ((this.am) && (this.ai != null))
        {
            this.ai.cancel();
            this.u.a(true);
        }
        finish();
    }

    public void rightBtnClick(View paramView)
    {
        this.z.clear();
        this.ak = new HashMap();
        this.al = new HashMap();
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                DeviceOptionNetworkSelectBluetoothActivity.d(DeviceOptionNetworkSelectBluetoothActivity.this).notifyDataSetChanged();
            }
        });
        r();
        this.u.a(true);
        y();
    }
}
