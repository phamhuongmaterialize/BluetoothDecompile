package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DeviceOptionSpeakerSelectSpeakerActivity
        extends BaseActivity
{
    private static final int af = 1001;
    private static final String x = DeviceOptionSpeakerSelectSpeakerActivity.class.getSimpleName();
    private ArrayList<String> A = new ArrayList();
    private ArrayList<String> ab = new ArrayList();
    private ArrayList<String> ac = new ArrayList();
    private boolean ad = false;
    private ImageView ae;
    private AVLoadingIndicatorView ag;
    private String[] ah;
    private int ai = 0;
    private TextView aj;
    private boolean ak = false;
    private boolean al = false;
    private String am = "";
    BluetoothService u;
    Thread v;
    IBluetoothCallback w = new IBluetoothCallback()
    {
        public void a() {}

        public void a(int paramAnonymousInt)
        {
            switch (paramAnonymousInt)
            {
                default:
                    return;
            }
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "BLUETOOTH ?? ??");
        }

        public void a(String paramAnonymousString)
        {
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "error.....");
            if ((!DeviceOptionSpeakerSelectSpeakerActivity.f(DeviceOptionSpeakerSelectSpeakerActivity.this)) && (!DeviceOptionSpeakerSelectSpeakerActivity.g(DeviceOptionSpeakerSelectSpeakerActivity.this)))
            {
                DeviceOptionSpeakerSelectSpeakerActivity.this.runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        Alert.a();
                        Toast.makeText(DeviceOptionSpeakerSelectSpeakerActivity.this, DeviceOptionSpeakerSelectSpeakerActivity.this.getStr(2131231000), 1).show();
                    }
                });
                DeviceOptionSpeakerSelectSpeakerActivity.this.finish();
            }
            DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this, false);
            DeviceOptionSpeakerSelectSpeakerActivity.this.finish();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2)
        {
            DeviceOptionSpeakerSelectSpeakerActivity.this.a(paramAnonymousString1, paramAnonymousString2);
        }

        public void b() {}

        public void b(int paramAnonymousInt) {}

        public void b(String paramAnonymousString)
        {
            int j = -1;
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "response msg :::: " + paramAnonymousString);
            BlueToothMessageVO localBlueToothMessageVO = GsonService.b(paramAnonymousString);
            Object localObject2 = "";
            String str2 = "";
            Object localObject1 = str2;
            try
            {
                String str1 = localBlueToothMessageVO.getMessageType();
                localObject1 = str2;
                localObject2 = str1;
                str2 = localBlueToothMessageVO.getCode();
                localObject1 = str2;
                localObject2 = str1;
                LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "resultCode : " + str2);
                localObject2 = str1;
                localObject1 = str2;
            }
            catch (NullPointerException localNullPointerException)
            {
                for (;;)
                {
                    LOG.a(DeviceOptionSpeakerSelectSpeakerActivity.n(), "NullPointerException");
                    continue;
                    if (((String)localObject2).equals("responseBluetoothSpeakerSearching"))
                    {
                        i = 0;
                        continue;
                        if (((String)localObject2).equals("responseBluetoothSpeakerList"))
                        {
                            i = 1;
                            continue;
                            if (((String)localObject2).equals("responseBluetoothSpeakerConnect")) {
                                i = 2;
                            }
                        }
                    }
                }
                switch (((String)localObject1).hashCode())
                {
                    default:
                        i = j;
                        switch (i)
                        {
                            default:
                                return;
                        }
                        break;
                }
            }
            switch (((String)localObject2).hashCode())
            {
                default:
                    i = -1;
                    switch (i)
                    {
                        default:
                            Alert.a();
                            DeviceOptionSpeakerSelectSpeakerActivity.this.a(DeviceOptionSpeakerSelectSpeakerActivity.this, DeviceOptionSpeakerSelectSpeakerActivity.this.getStr(2131231133));
                            return;
                    }
                    break;
            }
            for (;;)
            {
                LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "??? ?? ??");
                return;
                i = j;
                if (((String)localObject1).equals("00"))
                {
                    i = 0;
                    continue;
                    i = j;
                    if (((String)localObject1).equals("01"))
                    {
                        i = 1;
                        continue;
                        i = j;
                        if (((String)localObject1).equals("02"))
                        {
                            i = 2;
                            continue;
                            i = j;
                            if (((String)localObject1).equals("03")) {
                                i = 3;
                            }
                        }
                    }
                }
            }
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "?????");
            Alert.a();
            return;
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "??? ??");
            Alert.a();
            return;
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "?? ??? ??");
            Alert.a();
            return;
            switch (((String)localObject1).hashCode())
            {
            }
            for (;;)
            {
                switch (j)
                {
                    default:
                        return;
                }
                if (!"[]".equals(localBlueToothMessageVO.getData().toString())) {
                    break label607;
                }
                Alert.a();
                if (DeviceOptionSpeakerSelectSpeakerActivity.h(DeviceOptionSpeakerSelectSpeakerActivity.this) >= 10) {
                    break;
                }
                DeviceOptionSpeakerSelectSpeakerActivity.i(DeviceOptionSpeakerSelectSpeakerActivity.this);
                new Handler().postDelayed(new Runnable()
                {
                    public void run()
                    {
                        DeviceOptionSpeakerSelectSpeakerActivity.this.v = new Thread(new Runnable()
                        {
                            public void run()
                            {
                                while (DeviceOptionSpeakerSelectSpeakerActivity.c(DeviceOptionSpeakerSelectSpeakerActivity.this)) {
                                    DeviceOptionSpeakerSelectSpeakerActivity.d(DeviceOptionSpeakerSelectSpeakerActivity.this);
                                }
                            }
                        });
                        DeviceOptionSpeakerSelectSpeakerActivity.this.v.start();
                    }
                }, 2000L);
                return;
                if (((String)localObject1).equals("00")) {
                    j = 0;
                }
            }
            DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this, 0);
            DeviceOptionSpeakerSelectSpeakerActivity.j(DeviceOptionSpeakerSelectSpeakerActivity.this);
            DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this, false);
            System.gc();
            DeviceOptionSpeakerSelectSpeakerActivity.this.a(DeviceOptionSpeakerSelectSpeakerActivity.this, DeviceOptionSpeakerSelectSpeakerActivity.this.getStr(2131231023));
            return;
            label607:
            DeviceOptionSpeakerSelectSpeakerActivity.j(DeviceOptionSpeakerSelectSpeakerActivity.this);
            DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this, false);
            DeviceOptionSpeakerSelectSpeakerActivity.this.l();
            paramAnonymousString = GsonService.d(paramAnonymousString);
            int i = 0;
            while (i < paramAnonymousString.size())
            {
                LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "??? ??? : name :" + paramAnonymousString.get(i));
                LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "??? ??? : name :" + ((SpeakerVO)paramAnonymousString.get(i)).getName() + " / " + ((SpeakerVO)paramAnonymousString.get(i)).getAddress());
                localObject1 = new HashSet(DeviceOptionSpeakerSelectSpeakerActivity.k(DeviceOptionSpeakerSelectSpeakerActivity.this));
                DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this, new ArrayList((Collection)localObject1));
                DeviceOptionSpeakerSelectSpeakerActivity.k(DeviceOptionSpeakerSelectSpeakerActivity.this).add(((SpeakerVO)paramAnonymousString.get(i)).getName() + " (" + ((SpeakerVO)paramAnonymousString.get(i)).getAddress() + ")");
                i += 1;
            }
            DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this, new ArrayAdapter(DeviceOptionSpeakerSelectSpeakerActivity.this, 17367043, DeviceOptionSpeakerSelectSpeakerActivity.k(DeviceOptionSpeakerSelectSpeakerActivity.this)));
            DeviceOptionSpeakerSelectSpeakerActivity.l(DeviceOptionSpeakerSelectSpeakerActivity.this).setAdapter(DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this));
            DeviceOptionSpeakerSelectSpeakerActivity.this.m();
            return;
            switch (((String)localObject1).hashCode())
            {
                case 1537:
                default:
                    label928:
                    i = -1;
            }
            for (;;)
            {
                switch (i)
                {
                    default:
                        return;
                    case 0:
                        LOG.a(DeviceOptionSpeakerSelectSpeakerActivity.n(), "??? ?? ??");
                        Alert.a();
                        DeviceOptionSpeakerSelectSpeakerActivity.b(DeviceOptionSpeakerSelectSpeakerActivity.this, true);
                        if (DeviceOptionSpeakerSelectSpeakerActivity.this.u != null) {
                            DeviceOptionSpeakerSelectSpeakerActivity.this.u.h(DeviceOptionSpeakerSelectSpeakerActivity.m(DeviceOptionSpeakerSelectSpeakerActivity.this));
                        }
                        DeviceOptionSpeakerSelectSpeakerActivity.this.X.a(DeviceOptionSpeakerSelectSpeakerActivity.this.U.editor, DeviceOptionSpeakerSelectSpeakerActivity.this.U.selectedDeviceVo.getDeviceId(), DeviceOptionSpeakerSelectSpeakerActivity.b(DeviceOptionSpeakerSelectSpeakerActivity.this)[0].toString(), DeviceOptionSpeakerSelectSpeakerActivity.b(DeviceOptionSpeakerSelectSpeakerActivity.this)[1].toString());
                        paramAnonymousString = new Intent(DeviceOptionSpeakerSelectSpeakerActivity.this, DeviceOptionSpeakerCompleteActivity.class);
                        DeviceOptionSpeakerSelectSpeakerActivity.this.a(paramAnonymousString, 0, 0);
                        DeviceOptionSpeakerSelectSpeakerActivity.this.finish();
                        return;
                    if (!((String)localObject1).equals("00")) {
                        break label928;
                    }
                    i = 0;
                    continue;
                    if (!((String)localObject1).equals("02")) {
                        break label928;
                    }
                    i = 1;
                    continue;
                    if (!((String)localObject1).equals("03")) {
                        break label928;
                    }
                    i = 2;
                }
            }
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "??? ???? ??????");
            paramAnonymousString = new Intent(DeviceOptionSpeakerSelectSpeakerActivity.this, DeviceOptionSpeakerCompleteActivity.class);
            DeviceOptionSpeakerSelectSpeakerActivity.this.a(paramAnonymousString, 0, 0);
            DeviceOptionSpeakerSelectSpeakerActivity.this.finish();
            return;
            LOG.c(DeviceOptionSpeakerSelectSpeakerActivity.n(), "?? ??? ??");
            Alert.a();
            DeviceOptionSpeakerSelectSpeakerActivity.this.finish();
        }
    };
    private ArrayAdapter<String> y;
    private ListView z;

    private void A()
    {
        this.ak = true;
        this.u = BluetoothService.a(this, this.w);
        this.u.d(this);
        new Handler().post(new Runnable()
        {
            public void run()
            {
                DeviceOptionSpeakerSelectSpeakerActivity.this.v = new Thread(new Runnable()
                {
                    public void run()
                    {
                        while (DeviceOptionSpeakerSelectSpeakerActivity.c(DeviceOptionSpeakerSelectSpeakerActivity.this)) {
                            try
                            {
                                DeviceOptionSpeakerSelectSpeakerActivity.d(DeviceOptionSpeakerSelectSpeakerActivity.this);
                            }
                            catch (Exception localException)
                            {
                                localException.printStackTrace();
                            }
                        }
                    }
                });
                DeviceOptionSpeakerSelectSpeakerActivity.this.v.start();
            }
        });
    }

    private void o()
    {
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                DeviceOptionSpeakerSelectSpeakerActivity.this.setRightButtonTitle(DeviceOptionSpeakerSelectSpeakerActivity.this.getStr(2131231191));
                DeviceOptionSpeakerSelectSpeakerActivity.e(DeviceOptionSpeakerSelectSpeakerActivity.this).setVisibility(0);
            }
        });
    }

    private void y()
    {
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                DeviceOptionSpeakerSelectSpeakerActivity.this.setRightButtonTitle(DeviceOptionSpeakerSelectSpeakerActivity.this.getStr(2131231125));
                DeviceOptionSpeakerSelectSpeakerActivity.e(DeviceOptionSpeakerSelectSpeakerActivity.this).setVisibility(4);
            }
        });
    }

    private void z()
    {
        this.u.d("" + this.U.myUserInfo.getUserId());
    }

    public void a(String paramString)
    {
        this.A.add(paramString);
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                if (DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this) != null) {
                    DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this).notifyDataSetChanged();
                }
            }
        });
    }

    public void a(String paramString1, String paramString2)
    {
        LOG.c(x, "=============  paired Device Find: " + paramString1 + " - " + paramString2);
        String str = paramString1;
        if (paramString1 == null) {
            str = "noname";
        }
        if ((!this.u.f(paramString2)) && (!str.equals(this.U.selectedDeviceVo.getDeviceName())))
        {
            this.u.j.put(paramString2, str);
            a(str + " (" + paramString2 + ")");
        }
    }

    @RequiresApi(b=18)
    public void getBluetoothDevice()
    {
        LOG.c(x, "getParedDevice...............");
        if (a(new String[] { "android.permission.ACCESS_COARSE_LOCATION" })) {
            this.u.b();
        }
    }

    public void j()
    {
        this.ae = ((ImageView)findViewById(2131624144));
        this.ae.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.aj = ((TextView)findViewById(2131624222));
        if (StringUtils.a(this).equals("ja")) {
            this.aj.setTextScaleX(0.8F);
        }
        this.z = ((ListView)findViewById(2131624105));
        this.y = new ArrayAdapter(this, 17367043, this.A);
        this.z.setAdapter(this.y);
        this.ag = ((AVLoadingIndicatorView)findViewById(2131624148));
        this.z.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
            {
                Alert.a(DeviceOptionSpeakerSelectSpeakerActivity.this.V);
                DeviceOptionSpeakerSelectSpeakerActivity.this.v = new Thread(new Runnable()
                {
                    public void run()
                    {
                        DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this, ((String)DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this).getItem(paramAnonymousInt)).split("[\\(\\)]"));
                        DeviceOptionSpeakerSelectSpeakerActivity.this.u.a(DeviceOptionSpeakerSelectSpeakerActivity.this.U.myUserInfo.getUserId(), DeviceOptionSpeakerSelectSpeakerActivity.b(DeviceOptionSpeakerSelectSpeakerActivity.this)[1].toString());
                    }
                });
                DeviceOptionSpeakerSelectSpeakerActivity.this.v.start();
            }
        });
    }

    public void k()
    {
        a(4);
        setmActionBarTitle(getStr(2131230893));
        q();
        setRightButtonTitle(getStr(2131231191));
    }

    public void l()
    {
        this.A.clear();
        this.ab.clear();
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                if (DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this) != null) {
                    DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this).notifyDataSetChanged();
                }
            }
        });
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    public void m()
    {
        runOnUiThread(new Runnable()
        {
            public void run()
            {
                if (DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this) != null) {
                    DeviceOptionSpeakerSelectSpeakerActivity.a(DeviceOptionSpeakerSelectSpeakerActivity.this).notifyDataSetChanged();
                }
            }
        });
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        this.al = true;
        this.ak = false;
        if ((getStr(2131231191).equals(getRightButtonTitle())) && (this.u != null)) {
            this.u.a(true);
        }
        if ((this.U.selectedDeviceVo.getDeviceName() != null) && (this.u.getState() == 3))
        {
            this.u.h(this.am);
            this.ad = false;
        }
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968639);
        w();
        this.V = this;
        this.am = getIntent().getStringExtra("registeringDeviceBluetoothMac");
        k();
        A();
        j();
    }

    public void onDestroy()
    {
        LOG.c(x, "-- ON Destroy --");
        super.onDestroy();
        if (this.u != null)
        {
            if ((this.U.selectedDeviceVo.getDeviceName() != null) && (this.u.getState() == 3) && (this.ad))
            {
                this.u.h(this.am);
                this.ad = false;
            }
            this.u.c(this);
        }
    }

    public void onRestart()
    {
        super.onRestart();
        if (this.u != null) {
            this.u.b();
        }
    }

    public void onStop()
    {
        super.onStop();
        finish();
    }

    public void rightBtnClick(View paramView)
    {
        if (getStr(2131231191).equals(getRightButtonTitle()))
        {
            y();
            this.ak = false;
            this.ai = 0;
            return;
        }
        this.ak = true;
        this.v = new Thread(new Runnable()
        {
            public void run()
            {
                while (DeviceOptionSpeakerSelectSpeakerActivity.c(DeviceOptionSpeakerSelectSpeakerActivity.this)) {
                    DeviceOptionSpeakerSelectSpeakerActivity.d(DeviceOptionSpeakerSelectSpeakerActivity.this);
                }
            }
        });
        this.v.start();
        o();
    }
}
