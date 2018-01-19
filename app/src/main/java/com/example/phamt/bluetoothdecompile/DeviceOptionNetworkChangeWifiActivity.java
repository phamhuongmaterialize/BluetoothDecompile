package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DeviceOptionNetworkChangeWifiActivity
        extends BaseActivity
{
    private static final String ab = DeviceOptionNetworkChangeWifiActivity.class.getSimpleName();
    private static final int an = 220000;
    private static final int ao = 20000;
    IBluetoothCallback A = new IBluetoothCallback()
    {
        public void a() {}

        public void a(int paramAnonymousInt) {}

        public void a(String paramAnonymousString)
        {
            Alert.a();
            Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getString(2131231133), 0).show();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2) {}

        public void b()
        {
            if (DeviceOptionNetworkChangeWifiActivity.this.u.getState() == 3) {
                Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getString(2131231133), 0).show();
            }
        }

        public void b(int paramAnonymousInt)
        {
            if (paramAnonymousInt == 2002)
            {
                Alert.a();
                Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getString(2131231000), 0).show();
                DeviceOptionNetworkChangeWifiActivity.this.finish();
            }
        }

        public void b(String paramAnonymousString)
        {
            LOG.c(DeviceOptionNetworkChangeWifiActivity.l(), "responseMessage ::: " + paramAnonymousString);
            BlueToothMessageVO localBlueToothMessageVO = GsonService.b(paramAnonymousString);
            Alert.a();
            paramAnonymousString = "";
            Object localObject2 = "";
            int i;
            try
            {
                String str1 = localBlueToothMessageVO.getMessageType();
                paramAnonymousString = str1;
                String str2 = localBlueToothMessageVO.getCode();
                paramAnonymousString = str2;
                localObject2 = str1;
                str1 = paramAnonymousString;
            }
            catch (NullPointerException localNullPointerException)
            {
                for (;;)
                {
                    LOG.a(DeviceOptionNetworkChangeWifiActivity.l(), "NullPointerException");
                    localObject1 = localObject2;
                    localObject2 = paramAnonymousString;
                    continue;
                    if (((String)localObject2).equals("responseWifiConnect")) {
                        i = 0;
                    }
                }
                switch (((String)localObject1).hashCode())
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
            switch (((String)localObject2).hashCode())
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
            for (;;)
            {
                Object localObject1;
                DeviceOptionNetworkChangeWifiActivity.c(DeviceOptionNetworkChangeWifiActivity.this, true);
                Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this, DeviceOptionNetworkChangeWifiActivity.this.getStr(2131231001), 1).show();
                DeviceOptionNetworkChangeWifiActivity.this.U.selectedDeviceVo.setWifiSsid(DeviceOptionNetworkChangeWifiActivity.i(DeviceOptionNetworkChangeWifiActivity.this));
                if (DeviceOptionNetworkChangeWifiActivity.this.U.selectedDeviceVo.getDeviceName() != null) {
                    DeviceOptionNetworkChangeWifiActivity.this.u.h(DeviceOptionNetworkChangeWifiActivity.k(DeviceOptionNetworkChangeWifiActivity.this));
                }
                DeviceOptionNetworkChangeWifiActivity.this.a(DeviceOptionHomeActivity.class, true);
                DeviceOptionNetworkChangeWifiActivity.this.finish();
                return;
                if (((String)localObject1).equals("00"))
                {
                    i = 0;
                    continue;
                    if (((String)localObject1).equals("01")) {
                        i = 1;
                    }
                }
            }
            Alert.a();
            if (localBlueToothMessageVO.getData().toString().contains("No network has a name."))
            {
                Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getStr(2131231226) + " (" + DeviceOptionNetworkChangeWifiActivity.i(DeviceOptionNetworkChangeWifiActivity.this) + ")", 1).show();
                return;
            }
            Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getStr(2131231168), 1).show();
        }
    };
    private WifiListAdapter ac;
    private ExpandableHeightListView ad;
    private List<WifiInfoVO> ae = new ArrayList();
    private WifiManager af;
    private boolean ag = false;
    private List<ScanResult> ah;
    private String ai = "";
    private ImageView aj;
    private boolean ak = true;
    private boolean al = false;
    private AVLoadingIndicatorView am;
    private boolean ap = false;
    private String aq = "";
    private ScrollView ar;
    private boolean as = false;
    private BroadcastReceiver at = new BroadcastReceiver()
    {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
            paramAnonymousContext = paramAnonymousIntent.getAction();
            if (paramAnonymousContext.equals("android.net.wifi.SCAN_RESULTS"))
            {
                DeviceOptionNetworkChangeWifiActivity.a(DeviceOptionNetworkChangeWifiActivity.this, DeviceOptionNetworkChangeWifiActivity.a(DeviceOptionNetworkChangeWifiActivity.this).getScanResults());
                LOG.c(DeviceOptionNetworkChangeWifiActivity.l(), "scan wifi list ======= " + DeviceOptionNetworkChangeWifiActivity.b(DeviceOptionNetworkChangeWifiActivity.this).toString());
                paramAnonymousContext = DeviceOptionNetworkChangeWifiActivity.b(DeviceOptionNetworkChangeWifiActivity.this, DeviceOptionNetworkChangeWifiActivity.b(DeviceOptionNetworkChangeWifiActivity.this));
                DeviceOptionNetworkChangeWifiActivity.c(DeviceOptionNetworkChangeWifiActivity.this, paramAnonymousContext);
            }
            while (!paramAnonymousContext.equals("android.net.wifi.STATE_CHANGE")) {
                return;
            }
            DeviceOptionNetworkChangeWifiActivity.this.sendBroadcast(new Intent("wifi.ON_NETWORK_STATE_CHANGED"));
        }
    };
    private View.OnClickListener au = new View.OnClickListener()
    {
        public void onClick(final View paramAnonymousView)
        {
            paramAnonymousView = paramAnonymousView.getRootView();
            if (paramAnonymousView != null)
            {
                if (DeviceOptionNetworkChangeWifiActivity.h(DeviceOptionNetworkChangeWifiActivity.this))
                {
                    EditText localEditText = (EditText)paramAnonymousView.findViewById(2131624382);
                    DeviceOptionNetworkChangeWifiActivity.a(DeviceOptionNetworkChangeWifiActivity.this, localEditText.getText().toString());
                    if (DeviceOptionNetworkChangeWifiActivity.i(DeviceOptionNetworkChangeWifiActivity.this).isEmpty())
                    {
                        Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getStr(2131231227), 0).show();
                        return;
                    }
                }
                DeviceOptionNetworkChangeWifiActivity.this.W.dismiss();
                DeviceOptionNetworkChangeWifiActivity.this.runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        Alert.a(DeviceOptionNetworkChangeWifiActivity.this.V);
                    }
                });
                paramAnonymousView = (EditText)paramAnonymousView.findViewById(2131624383);
                LOG.c(DeviceOptionNetworkChangeWifiActivity.l(), "data :::::: " + paramAnonymousView.getText());
                paramAnonymousView = paramAnonymousView.getText().toString();
                if (("".equals(paramAnonymousView)) && (DeviceOptionNetworkChangeWifiActivity.j(DeviceOptionNetworkChangeWifiActivity.this)))
                {
                    DeviceOptionNetworkChangeWifiActivity.b(DeviceOptionNetworkChangeWifiActivity.this, true);
                    Toast.makeText(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getStr(2131230921), 1).show();
                    Alert.a();
                    return;
                }
                DeviceOptionNetworkChangeWifiActivity.b(DeviceOptionNetworkChangeWifiActivity.this, true);
                new Thread(new Runnable()
                {
                    public void run()
                    {
                        DeviceOptionNetworkChangeWifiActivity.this.u.a(DeviceOptionNetworkChangeWifiActivity.this.U.myUserInfo.getUserId(), DeviceOptionNetworkChangeWifiActivity.i(DeviceOptionNetworkChangeWifiActivity.this), paramAnonymousView);
                    }
                }).start();
            }
            DeviceOptionNetworkChangeWifiActivity.this.W.dismiss();
        }
    };
    private View.OnClickListener av = new View.OnClickListener()
    {
        public void onClick(View paramAnonymousView)
        {
            DeviceOptionNetworkChangeWifiActivity.this.W.dismiss();
        }
    };
    private CompoundButton.OnCheckedChangeListener aw = new CompoundButton.OnCheckedChangeListener()
    {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
            boolean bool2 = true;
            paramAnonymousCompoundButton = (EditText)paramAnonymousCompoundButton.getRootView().findViewById(2131624383);
            DeviceOptionNetworkChangeWifiActivity localDeviceOptionNetworkChangeWifiActivity;
            if (!paramAnonymousBoolean)
            {
                bool1 = true;
                paramAnonymousCompoundButton.setEnabled(bool1);
                localDeviceOptionNetworkChangeWifiActivity = DeviceOptionNetworkChangeWifiActivity.this;
                if (paramAnonymousBoolean) {
                    break label63;
                }
            }
            label63:
            for (boolean bool1 = bool2;; bool1 = false)
            {
                DeviceOptionNetworkChangeWifiActivity.b(localDeviceOptionNetworkChangeWifiActivity, bool1);
                if (paramAnonymousBoolean) {
                    paramAnonymousCompoundButton.setText("");
                }
                return;
                bool1 = false;
                break;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener ax = new CompoundButton.OnCheckedChangeListener()
    {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
            paramAnonymousCompoundButton = (EditText)paramAnonymousCompoundButton.getRootView().findViewById(2131624383);
            if (!paramAnonymousBoolean) {
                paramAnonymousCompoundButton.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            for (;;)
            {
                paramAnonymousCompoundButton.setSelection(paramAnonymousCompoundButton.length());
                return;
                paramAnonymousCompoundButton.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        }
    };
    BluetoothService u;
    HashMap<String, Object> v = new HashMap();
    List<WifiInfoVO> w;
    List<WifiInfoVO> x = new ArrayList();
    Thread y;
    CountDownTimer z;

    private List<WifiInfoVO> a(List<ScanResult> paramList)
    {
        ArrayList localArrayList = new ArrayList();
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
            ScanResult localScanResult = (ScanResult)paramList.get(i);
            WifiInfoVO localWifiInfoVO = new WifiInfoVO();
            localWifiInfoVO.setLevel(localScanResult.level);
            localWifiInfoVO.setSsid(localScanResult.SSID);
            localWifiInfoVO.setCapablities(localScanResult.capabilities);
            LOG.c(ab, "SSID : " + localScanResult.SSID + " / level : " + localScanResult.level + " / " + localScanResult.capabilities + " / " + localWifiInfoVO.getPower() + " / " + localWifiInfoVO.isLock());
            if (!localScanResult.SSID.equals("")) {
                localArrayList.add(localWifiInfoVO);
            }
            i += 1;
        }
        y();
        return localArrayList;
    }

    private void b(List<WifiInfoVO> paramList)
    {
        LOG.c(ab, "setWifiListView ..................... " + paramList);
        this.am.setVisibility(4);
        this.v = new HashMap();
        this.ae.clear();
        int i = 0;
        while (i < paramList.size())
        {
            this.v.put(((WifiInfoVO)paramList.get(i)).getSsid(), Integer.valueOf(((WifiInfoVO)paramList.get(i)).getLevel()));
            i += 1;
        }
        if (this.w != null)
        {
            i = 0;
            while (i < this.w.size())
            {
                paramList = ((WifiInfoVO)this.w.get(i)).getSsid();
                if (!this.v.containsKey(paramList)) {
                    this.v.put(((WifiInfoVO)this.w.get(i)).getSsid(), Integer.valueOf(((WifiInfoVO)this.w.get(i)).getLevel()));
                }
                i += 1;
            }
        }
        i = 0;
        while (i < this.x.size())
        {
            paramList = ((WifiInfoVO)this.x.get(i)).getSsid();
            if (!this.v.containsKey(paramList)) {
                this.v.put(((WifiInfoVO)this.x.get(i)).getSsid(), Integer.valueOf(((WifiInfoVO)this.x.get(i)).getLevel()));
            }
            i += 1;
        }
        paramList = new ArrayList();
        Iterator localIterator = this.v.entrySet().iterator();
        for (;;)
        {
            if (localIterator.hasNext())
            {
                Object localObject1 = (Map.Entry)localIterator.next();
                String str = (String)((Map.Entry)localObject1).getKey();
                Object localObject2 = ((Map.Entry)localObject1).getValue();
                localObject1 = new WifiInfoVO();
                ((WifiInfoVO)localObject1).setSsid(str);
                try
                {
                    i = ((Integer)localObject2).intValue();
                    ((WifiInfoVO)localObject1).setLevel(i);
                    paramList.add(localObject1);
                }
                catch (Exception localException)
                {
                    for (;;)
                    {
                        i = -70;
                    }
                }
            }
        }
        this.ac.addAll(paramList);
        this.ac.notifyDataSetChanged();
        z();
        this.ar.scrollTo(0, 0);
    }

    private void m()
    {
        this.u = BluetoothService.a(this, this.A);
    }

    @SuppressLint({"WifiManagerLeak"})
    private void n()
    {
        this.af = ((WifiManager)getSystemService("wifi"));
        LOG.c(ab, "initWifiList ....... " + this.af.isWifiEnabled());
        if (!this.af.isWifiEnabled())
        {
            this.ag = true;
            this.af.setWifiEnabled(true);
        }
        for (;;)
        {
            new TypeToken() {}.getType();
            Object localObject1 = getIntent().getStringExtra("wifiList");
            Object localObject2 = GsonService.b((String)localObject1);
            if ((localObject1 != null) && (!((String)localObject1).equals("null")))
            {
                LOG.c(ab, "jsonStr : " + (String)localObject1);
                this.w = GsonService.a(((BlueToothMessageVO)localObject2).getData());
                setWifiListView(this.w);
            }
            return;
            localObject1 = this.af.getConnectionInfo();
            LOG.c(ab, "SupplicantState.COMPLETED ....... " + SupplicantState.COMPLETED);
            if (((WifiInfo)localObject1).getSupplicantState() == SupplicantState.COMPLETED)
            {
                localObject2 = ((WifiInfo)localObject1).getSSID();
                WifiInfoVO localWifiInfoVO = new WifiInfoVO();
                localWifiInfoVO.setLevel(((WifiInfo)localObject1).getRssi());
                localWifiInfoVO.setSsid(((String)localObject2).replaceAll("\"", ""));
                this.x.add(localWifiInfoVO);
                setWifiListView(this.x);
            }
        }
    }

    private void o()
    {
        try
        {
            IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
            localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
            registerReceiver(this.at, localIntentFilter);
            this.af.startScan();
            return;
        }
        catch (Exception localException) {}
    }

    private void setWifiListView(List<WifiInfoVO> paramList)
    {
        LOG.c(ab, "setWifiListView ..................... " + paramList);
        this.am.setVisibility(4);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramList.size())
        {
            String str = ((WifiInfoVO)paramList.get(i)).getSsid();
            LOG.c(ab, "???? : " + str + " / " + this.v.containsKey(str));
            if (this.v.containsKey(str))
            {
                int j = 0;
                while (j < localArrayList.size())
                {
                    LOG.c(ab, ":::: " + localArrayList.size() + " / " + str + " / " + ((WifiInfoVO)localArrayList.get(j)).getSsid());
                    if (((WifiInfoVO)localArrayList.get(j)).getSsid().equals(str))
                    {
                        localArrayList.set(j, paramList.get(i));
                        this.v.put(str, Integer.valueOf(((WifiInfoVO)paramList.get(i)).getLevel()));
                    }
                    j += 1;
                }
            }
            localArrayList.add(paramList.get(i));
            this.v.put(str, Integer.valueOf(((WifiInfoVO)paramList.get(i)).getLevel()));
            i += 1;
        }
        this.ac.addAll(localArrayList);
        this.ac.notifyDataSetChanged();
        z();
        this.ar.scrollTo(0, 0);
    }

    private void y()
    {
        if ((this.ag) && (this.af != null)) {
            this.af.setWifiEnabled(false);
        }
    }

    private void z() {}

    public void j()
    {
        this.ar = ((ScrollView)findViewById(2131624264));
        this.aj = ((ImageView)findViewById(2131624144));
        this.aj.setBackground(null);
        this.aj.destroyDrawingCache();
        this.aj.setBackground(getDraw(2130837691));
        this.aj = ((ImageView)findViewById(2131624144));
        this.aj.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.V = this;
        this.ad = ((ExpandableHeightListView)findViewById(2131624105));
        this.ad.setExpanded(true);
        this.ac = new WifiListAdapter(this, 2130968730, this.ae, null);
        this.ad.setAdapter(this.ac);
        this.ad.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                paramAnonymousAdapterView = (WifiInfoVO)DeviceOptionNetworkChangeWifiActivity.c(DeviceOptionNetworkChangeWifiActivity.this).getItem(paramAnonymousInt);
                DeviceOptionNetworkChangeWifiActivity.a(DeviceOptionNetworkChangeWifiActivity.this, paramAnonymousAdapterView.getSsid());
                DeviceOptionNetworkChangeWifiActivity.a(DeviceOptionNetworkChangeWifiActivity.this, false);
                DeviceOptionNetworkChangeWifiActivity.this.W = new Alert(DeviceOptionNetworkChangeWifiActivity.this.V, DeviceOptionNetworkChangeWifiActivity.this.getResources().getString(2131230921), Alert.d, DeviceOptionNetworkChangeWifiActivity.d(DeviceOptionNetworkChangeWifiActivity.this), DeviceOptionNetworkChangeWifiActivity.e(DeviceOptionNetworkChangeWifiActivity.this), DeviceOptionNetworkChangeWifiActivity.f(DeviceOptionNetworkChangeWifiActivity.this), DeviceOptionNetworkChangeWifiActivity.g(DeviceOptionNetworkChangeWifiActivity.this), false);
                DeviceOptionNetworkChangeWifiActivity.this.W.show();
            }
        });
        this.am = ((AVLoadingIndicatorView)findViewById(2131624148));
    }

    public void k()
    {
        a(4);
        setmActionBarTitle(getStr(2131231115));
        setRightButtonTitle(getStr(2131231123));
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968648);
        w();
        this.V = this;
        this.aq = getIntent().getStringExtra("registeringDeviceBluetoothMac");
        k();
        j();
        m();
        n();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if ((this.u != null) && (this.u.getState() == 3) && (!this.as) && (this.aq != null) && (!this.aq.isEmpty())) {
            this.u.h(this.aq);
        }
    }

    public void onPause()
    {
        super.onPause();
        LOG.a(ab, "-- ON PAUSE --");
    }

    public void onResume()
    {
        super.onResume();
        LOG.a(ab, "-- ON Resume --");
        o();
    }

    public void onSelfInputClick(View paramView)
    {
        this.ap = true;
        this.W = new Alert(this.V, getResources().getString(2131230921), Alert.d, this.au, this.av, this.aw, this.ax, true);
        this.W.show();
    }

    public void onStop()
    {
        super.onStop();
        LOG.a(ab, "-- ON STOP --");
        try
        {
            unregisterReceiver(this.at);
            finish();
            return;
        }
        catch (Exception localException)
        {
            for (;;)
            {
                LOG.a(ab, "Exception : " + localException.getMessage());
            }
        }
    }

    public void rightBtnClick(View paramView)
    {
        this.am.setVisibility(0);
        z();
        this.ar.scrollTo(0, 0);
        o();
        r();
    }

    static class ViewHolder
    {
        TextView a;
        ImageView b;
        ImageView c;
    }

    class WifiListAdapter
            extends ArrayAdapter<WifiInfoVO>
    {
        private Context b;
        private int c;

        private WifiListAdapter(int paramInt, List<WifiInfoVO> paramList)
        {
            super(paramList, localList);
            this.c = paramList;
        }

        public long getItemId(int paramInt)
        {
            return paramInt;
        }

        @NonNull
        public View getView(int paramInt, View paramView, @NonNull ViewGroup paramViewGroup)
        {
            if (paramView == null)
            {
                paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.c, paramViewGroup, false);
                paramViewGroup = new DeviceOptionNetworkChangeWifiActivity.ViewHolder();
                paramViewGroup.a = ((TextView)paramView.findViewById(2131624450));
                paramViewGroup.b = ((ImageView)paramView.findViewById(2131624451));
                paramViewGroup.c = ((ImageView)paramView.findViewById(2131624452));
                paramView.setTag(paramViewGroup);
            }
            WifiInfoVO localWifiInfoVO;
            for (;;)
            {
                localWifiInfoVO = (WifiInfoVO)getItem(paramInt);
                paramViewGroup.a.setText(localWifiInfoVO.getSsid());
                if (localWifiInfoVO.isLock()) {
                    paramViewGroup.b.setVisibility(0);
                }
                if (localWifiInfoVO.getPower() != 3) {
                    break;
                }
                paramViewGroup.c.setImageDrawable(DeviceOptionNetworkChangeWifiActivity.this.getDraw(2130837850));
                return paramView;
                paramViewGroup = (DeviceOptionNetworkChangeWifiActivity.ViewHolder)paramView.getTag();
            }
            if (localWifiInfoVO.getPower() == 2)
            {
                paramViewGroup.c.setImageDrawable(DeviceOptionNetworkChangeWifiActivity.this.getDraw(2130837849));
                return paramView;
            }
            paramViewGroup.c.setImageDrawable(DeviceOptionNetworkChangeWifiActivity.this.getDraw(2130837848));
            return paramView;
        }
    }
}
