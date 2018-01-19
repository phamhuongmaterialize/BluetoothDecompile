package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import  android.annotation.SuppressLint;
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
        import android.widget.ListView;
        import android.widget.ScrollView;
        import android.widget.TextView;
        import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.google.gson.reflect.TypeToken;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Map;
        import java.util.Map.Entry;
        import java.util.Set;

public class DeviceRegistWifiActivity
        extends BaseActivity
{
    private static final String w = DeviceRegistWifiActivity.class.getSimpleName();
    private WifiManager A;
    private boolean ab = false;
    private List<ScanResult> ac;
    private Map<String, Object> ad = new HashMap();
    private List<WifiInfoVO> ae;
    private List<WifiInfoVO> af = new ArrayList();
    private String ag = "";
    private String ah = "";
    private String ai = "";
    private ImageView aj;
    private boolean ak = true;
    private boolean al = true;
    private AVLoadingIndicatorView am;
    private boolean an = false;
    private ScrollView ao;
    private boolean ap = false;
    private BroadcastReceiver aq = new BroadcastReceiver()
    {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
            paramAnonymousContext = paramAnonymousIntent.getAction();
            if (paramAnonymousContext.equals("android.net.wifi.SCAN_RESULTS"))
            {
                DeviceRegistWifiActivity.a(DeviceRegistWifiActivity.this, DeviceRegistWifiActivity.a(DeviceRegistWifiActivity.this).getScanResults());
                LOG.c(DeviceRegistWifiActivity.l(), "scan wifi list ======= " + DeviceRegistWifiActivity.b(DeviceRegistWifiActivity.this).toString());
                paramAnonymousContext = DeviceRegistWifiActivity.b(DeviceRegistWifiActivity.this, DeviceRegistWifiActivity.b(DeviceRegistWifiActivity.this));
                DeviceRegistWifiActivity.c(DeviceRegistWifiActivity.this, paramAnonymousContext);
            }
            while (!paramAnonymousContext.equals("android.net.wifi.STATE_CHANGE")) {
                return;
            }
            DeviceRegistWifiActivity.this.sendBroadcast(new Intent("wifi.ON_NETWORK_STATE_CHANGED"));
        }
    };
    private AdapterView.OnItemClickListener ar = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
            paramAnonymousAdapterView = (WifiInfoVO)DeviceRegistWifiActivity.c(DeviceRegistWifiActivity.this).getItem(paramAnonymousInt);
            DeviceRegistWifiActivity.a(DeviceRegistWifiActivity.this, paramAnonymousAdapterView.getSsid());
        }
    };
    private View.OnClickListener as = new View.OnClickListener()
    {
        public void onClick(final View paramAnonymousView)
        {
            paramAnonymousView = paramAnonymousView.getRootView();
            if (paramAnonymousView != null)
            {
                if (DeviceRegistWifiActivity.h(DeviceRegistWifiActivity.this))
                {
                    EditText localEditText = (EditText)paramAnonymousView.findViewById(2131624382);
                    DeviceRegistWifiActivity.a(DeviceRegistWifiActivity.this, localEditText.getText().toString());
                    if (DeviceRegistWifiActivity.i(DeviceRegistWifiActivity.this).isEmpty()) {
                        Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getStr(2131231227), 0).show();
                    }
                }
            }
            else {
                return;
            }
            DeviceRegistWifiActivity.this.W.dismiss();
            DeviceRegistWifiActivity.this.runOnUiThread(new Runnable()
            {
                public void run()
                {
                    Alert.a(DeviceRegistWifiActivity.this.V);
                }
            });
            paramAnonymousView = (EditText)paramAnonymousView.findViewById(2131624383);
            LOG.c(DeviceRegistWifiActivity.l(), "data :::::: " + paramAnonymousView.getText());
            paramAnonymousView = paramAnonymousView.getText().toString();
            if (("".equals(paramAnonymousView)) && (DeviceRegistWifiActivity.j(DeviceRegistWifiActivity.this)))
            {
                DeviceRegistWifiActivity.b(DeviceRegistWifiActivity.this, true);
                Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getResources().getString(2131230921), 1).show();
                Alert.a();
                return;
            }
            DeviceRegistWifiActivity.b(DeviceRegistWifiActivity.this, true);
            new Thread(new Runnable()
            {
                public void run()
                {
                    DeviceRegistWifiActivity.this.u.a(DeviceRegistWifiActivity.this.U.myUserInfo.getUserId(), DeviceRegistWifiActivity.i(DeviceRegistWifiActivity.this), paramAnonymousView);
                }
            }).start();
        }
    };
    private View.OnClickListener at = new View.OnClickListener()
    {
        public void onClick(View paramAnonymousView)
        {
            DeviceRegistWifiActivity.this.W.dismiss();
        }
    };
    private CompoundButton.OnCheckedChangeListener au = new CompoundButton.OnCheckedChangeListener()
    {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
            boolean bool2 = true;
            paramAnonymousCompoundButton = (EditText)paramAnonymousCompoundButton.getRootView().findViewById(2131624383);
            DeviceRegistWifiActivity localDeviceRegistWifiActivity;
            if (!paramAnonymousBoolean)
            {
                bool1 = true;
                paramAnonymousCompoundButton.setEnabled(bool1);
                localDeviceRegistWifiActivity = DeviceRegistWifiActivity.this;
                if (paramAnonymousBoolean) {
                    break label63;
                }
            }
            label63:
            for (boolean bool1 = bool2;; bool1 = false)
            {
                DeviceRegistWifiActivity.b(localDeviceRegistWifiActivity, bool1);
                if (paramAnonymousBoolean) {
                    paramAnonymousCompoundButton.setText("");
                }
                return;
                bool1 = false;
                break;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener av = new CompoundButton.OnCheckedChangeListener()
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
    IBluetoothCallback v = new IBluetoothCallback()
    {
        public void a() {}

        public void a(int paramAnonymousInt) {}

        public void a(String paramAnonymousString)
        {
            Alert.a();
            Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getString(2131231133), 0).show();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2) {}

        public void b()
        {
            if (DeviceRegistWifiActivity.this.u.getState() == 3) {
                Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getString(2131231133), 0).show();
            }
        }

        public void b(int paramAnonymousInt)
        {
            if (paramAnonymousInt == 2002)
            {
                Alert.a();
                Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getString(2131231000), 0).show();
                DeviceRegistWifiActivity.this.finish();
            }
        }

        public void b(String paramAnonymousString)
        {
            int i = -1;
            LOG.c(DeviceRegistWifiActivity.l(), "responseMessage ::: " + paramAnonymousString);
            BlueToothMessageVO localBlueToothMessageVO = GsonService.b(paramAnonymousString);
            Object localObject = "";
            paramAnonymousString = (String)localObject;
            for (;;)
            {
                try
                {
                    str1 = localBlueToothMessageVO.getMessageType();
                    paramAnonymousString = str1;
                    localObject = str1;
                    str2 = localBlueToothMessageVO.getCode();
                    switch (str1.hashCode())
                    {
                        default:
                            j = -1;
                            label104:
                            return;
                    }
                }
                catch (NullPointerException localNullPointerException)
                {
                    String str1;
                    String str2;
                    int j;
                    localObject = paramAnonymousString;
                    localNullPointerException.printStackTrace();
                    localObject = paramAnonymousString;
                    DeviceRegistWifiActivity.this.finish();
                    switch (paramAnonymousString.hashCode())
                    {
                        default:
                            j = -1;
                            return;
                        switch ("".hashCode())
                        {
                            default:
                                return;
                            if (DeviceRegistWifiActivity.k(DeviceRegistWifiActivity.this) != true) {
                                continue;
                            }
                            Alert.a();
                            paramAnonymousString = new Intent(DeviceRegistWifiActivity.this, DeviceRegistLocaleActivity.class);
                            paramAnonymousString.putExtra("registeringDeviceBluetoothMac", DeviceRegistWifiActivity.l(DeviceRegistWifiActivity.this));
                            DeviceRegistWifiActivity.c(DeviceRegistWifiActivity.this, false);
                            DeviceRegistWifiActivity.this.a(paramAnonymousString, 0, 0);
                            DeviceRegistWifiActivity.d(DeviceRegistWifiActivity.this, true);
                            DeviceRegistWifiActivity.this.finish();
                            return;
                        }
                        case 1465139476:
                            if (!paramAnonymousString.equals("responseWifiConnect")) {
                                continue;
                            }
                            j = 0;
                            continue;
                            if (!"".equals("00")) {
                                continue;
                            }
                            i = 0;
                            continue;
                            if (!"".equals("01")) {
                                continue;
                            }
                            i = 1;
                            continue;
                            Alert.a();
                            if (!localBlueToothMessageVO.getData().toString().contains("No network has a name.")) {
                                continue;
                            }
                            Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getStr(2131231226) + " (" + DeviceRegistWifiActivity.i(DeviceRegistWifiActivity.this) + ")", 1).show();
                            return;
                        Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getStr(2131231168), 1).show();
                        return;
                    }
                }
                finally
                {
                    switch (((String)localObject).hashCode())
                    {
                    }
                }
                if (str1.equals("responseWifiConnect"))
                {
                    j = 0;
                    continue;
                    switch (str2.hashCode())
                    {
                    }
                    for (;;)
                    {
                        switch (i)
                        {
                            default:
                                return;
                            case 0:
                                if (DeviceRegistWifiActivity.k(DeviceRegistWifiActivity.this) != true) {
                                    break label104;
                                }
                                Alert.a();
                                paramAnonymousString = new Intent(DeviceRegistWifiActivity.this, DeviceRegistLocaleActivity.class);
                                paramAnonymousString.putExtra("registeringDeviceBluetoothMac", DeviceRegistWifiActivity.l(DeviceRegistWifiActivity.this));
                                DeviceRegistWifiActivity.c(DeviceRegistWifiActivity.this, false);
                                DeviceRegistWifiActivity.this.a(paramAnonymousString, 0, 0);
                                DeviceRegistWifiActivity.d(DeviceRegistWifiActivity.this, true);
                                DeviceRegistWifiActivity.this.finish();
                                return;
                            if (str2.equals("00"))
                            {
                                i = 0;
                                continue;
                                if (str2.equals("01")) {
                                    i = 1;
                                }
                            }
                            break;
                        }
                    }
                    Alert.a();
                    if (localBlueToothMessageVO.getData().toString().contains("No network has a name."))
                    {
                        Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getStr(2131231226) + " (" + DeviceRegistWifiActivity.i(DeviceRegistWifiActivity.this) + ")", 1).show();
                        return;
                    }
                    Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getStr(2131231168), 1).show();
                    return;
                }
            }
            i = -1;
            label746:
            switch (i)
            {
            }
            for (;;)
            {
                throw paramAnonymousString;
                if (!((String)localObject).equals("responseWifiConnect")) {
                    break;
                }
                i = 0;
                break label746;
                switch ("".hashCode())
                {
                    default:
                        label808:
                        i = -1;
                }
                for (;;)
                {
                    switch (i)
                    {
                        default:
                            break;
                        case 0:
                            if (DeviceRegistWifiActivity.k(DeviceRegistWifiActivity.this) != true) {
                                break;
                            }
                            Alert.a();
                            localObject = new Intent(DeviceRegistWifiActivity.this, DeviceRegistLocaleActivity.class);
                            ((Intent)localObject).putExtra("registeringDeviceBluetoothMac", DeviceRegistWifiActivity.l(DeviceRegistWifiActivity.this));
                            DeviceRegistWifiActivity.c(DeviceRegistWifiActivity.this, false);
                            DeviceRegistWifiActivity.this.a((Intent)localObject, 0, 0);
                            DeviceRegistWifiActivity.d(DeviceRegistWifiActivity.this, true);
                            DeviceRegistWifiActivity.this.finish();
                            break;
                        if (!"".equals("00")) {
                            break label808;
                        }
                        i = 0;
                        continue;
                        if (!"".equals("01")) {
                            break label808;
                        }
                        i = 1;
                    }
                }
                Alert.a();
                if (localBlueToothMessageVO.getData().toString().contains("No network has a name.")) {
                    Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getStr(2131231226) + " (" + DeviceRegistWifiActivity.i(DeviceRegistWifiActivity.this) + ")", 1).show();
                } else {
                    Toast.makeText(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getStr(2131231168), 1).show();
                }
            }
        }
    };
    private WifiListAdapter x;
    private ExpandableHeightListView y;
    private List<WifiInfoVO> z = new ArrayList();

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
            LOG.c(w, "SSID : " + localScanResult.SSID + " / level : " + localScanResult.level + " / " + localScanResult.capabilities + " / " + localWifiInfoVO.getPower() + " / " + localWifiInfoVO.isLock());
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
        LOG.c(w, "setWifiListView ..................... " + paramList);
        this.am.setVisibility(4);
        this.ad = new HashMap();
        this.z.clear();
        int i = 0;
        while (i < paramList.size())
        {
            this.ad.put(((WifiInfoVO)paramList.get(i)).getSsid(), Integer.valueOf(((WifiInfoVO)paramList.get(i)).getLevel()));
            i += 1;
        }
        if (this.ae != null)
        {
            i = 0;
            while (i < this.ae.size())
            {
                paramList = ((WifiInfoVO)this.ae.get(i)).getSsid();
                if (!this.ad.containsKey(paramList)) {
                    this.ad.put(((WifiInfoVO)this.ae.get(i)).getSsid(), Integer.valueOf(((WifiInfoVO)this.ae.get(i)).getLevel()));
                }
                i += 1;
            }
        }
        i = 0;
        while (i < this.af.size())
        {
            paramList = ((WifiInfoVO)this.af.get(i)).getSsid();
            if (!this.ad.containsKey(paramList)) {
                this.ad.put(((WifiInfoVO)this.af.get(i)).getSsid(), Integer.valueOf(((WifiInfoVO)this.af.get(i)).getLevel()));
            }
            i += 1;
        }
        paramList = new ArrayList();
        Iterator localIterator = this.ad.entrySet().iterator();
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
        this.x.addAll(paramList);
        this.x.notifyDataSetChanged();
        z();
        this.ao.scrollTo(0, 0);
    }

    private void m()
    {
        this.u = BluetoothService.a(this, this.v);
    }

    @SuppressLint({"WifiManagerLeak"})
    private void n()
    {
        this.A = ((WifiManager)getSystemService("wifi"));
        LOG.c(w, "initWifiList ....... " + this.A.isWifiEnabled());
        if (!this.A.isWifiEnabled())
        {
            this.ab = true;
            this.A.setWifiEnabled(true);
        }
        for (;;)
        {
            new TypeToken() {}.getType();
            Object localObject1 = getIntent().getStringExtra("wifiList");
            Object localObject2 = GsonService.b((String)localObject1);
            if ((localObject1 != null) && (!((String)localObject1).equals("null")))
            {
                LOG.c(w, "jsonStr : " + (String)localObject1);
                this.ae = GsonService.a(((BlueToothMessageVO)localObject2).getData());
                setWifiListView(this.ae);
            }
            return;
            localObject1 = this.A.getConnectionInfo();
            LOG.c(w, "SupplicantState.COMPLETED ....... " + SupplicantState.COMPLETED);
            if (((WifiInfo)localObject1).getSupplicantState() == SupplicantState.COMPLETED)
            {
                localObject2 = ((WifiInfo)localObject1).getSSID();
                WifiInfoVO localWifiInfoVO = new WifiInfoVO();
                localWifiInfoVO.setLevel(((WifiInfo)localObject1).getRssi());
                localWifiInfoVO.setSsid(((String)localObject2).replaceAll("\"", ""));
                this.af.add(localWifiInfoVO);
                setWifiListView(this.af);
            }
        }
    }

    private void o()
    {
        try
        {
            IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
            localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
            registerReceiver(this.aq, localIntentFilter);
            this.A.startScan();
            return;
        }
        catch (Exception localException) {}
    }

    private void setWifiListView(List<WifiInfoVO> paramList)
    {
        LOG.c(w, "setWifiListView ..................... " + paramList);
        this.am.setVisibility(4);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramList.size())
        {
            String str = ((WifiInfoVO)paramList.get(i)).getSsid();
            LOG.c(w, "???? : " + str + " / " + this.ad.containsKey(str));
            if (this.ad.containsKey(str))
            {
                int j = 0;
                while (j < localArrayList.size())
                {
                    LOG.c(w, ":::: " + localArrayList.size() + " / " + str + " / " + ((WifiInfoVO)localArrayList.get(j)).getSsid());
                    if (((WifiInfoVO)localArrayList.get(j)).getSsid().equals(str))
                    {
                        localArrayList.set(j, paramList.get(i));
                        this.ad.put(str, Integer.valueOf(((WifiInfoVO)paramList.get(i)).getLevel()));
                    }
                    j += 1;
                }
            }
            localArrayList.add(paramList.get(i));
            this.ad.put(str, Integer.valueOf(((WifiInfoVO)paramList.get(i)).getLevel()));
            i += 1;
        }
        this.x.addAll(localArrayList);
        this.x.notifyDataSetChanged();
        z();
        this.ao.scrollTo(0, 0);
    }

    private void y()
    {
        if ((this.ab) && (this.A != null)) {
            this.A.setWifiEnabled(false);
        }
    }

    private void z() {}

    public void j()
    {
        this.aj = ((ImageView)findViewById(2131624144));
        this.aj.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.V = this;
        this.ao = ((ScrollView)findViewById(2131624264));
        this.y = ((ExpandableHeightListView)findViewById(2131624105));
        this.y.setExpanded(true);
        this.x = new WifiListAdapter(this, 2130968730, this.z, null);
        this.y.setAdapter(this.x);
        this.y.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                paramAnonymousAdapterView = (ListView)paramAnonymousAdapterView;
                paramAnonymousAdapterView = (WifiInfoVO)DeviceRegistWifiActivity.c(DeviceRegistWifiActivity.this).getItem(paramAnonymousInt);
                DeviceRegistWifiActivity.a(DeviceRegistWifiActivity.this, paramAnonymousAdapterView.getSsid());
                DeviceRegistWifiActivity.a(DeviceRegistWifiActivity.this, false);
                DeviceRegistWifiActivity.this.W = new Alert(DeviceRegistWifiActivity.this.V, DeviceRegistWifiActivity.this.getResources().getString(2131230921), Alert.d, DeviceRegistWifiActivity.d(DeviceRegistWifiActivity.this), DeviceRegistWifiActivity.e(DeviceRegistWifiActivity.this), DeviceRegistWifiActivity.f(DeviceRegistWifiActivity.this), DeviceRegistWifiActivity.g(DeviceRegistWifiActivity.this), false);
                DeviceRegistWifiActivity.this.W.show();
            }
        });
        this.ah = getIntent().getStringExtra("registeringDeviceBluetoothMac");
        this.am = ((AVLoadingIndicatorView)findViewById(2131624148));
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

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968648);
        w();
        this.V = this;
        k();
        j();
        m();
        n();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if ((this.u != null) && (this.u.getState() == 3) && (!this.ap) && (this.ah != null) && (!this.ah.isEmpty())) {
            this.u.h(this.ah);
        }
    }

    public void onPause()
    {
        super.onPause();
        LOG.a(w, "-- ON PAUSE --");
    }

    public void onResume()
    {
        super.onResume();
        LOG.a(w, "-- ON Resume --");
        o();
    }

    public void onSelfInputClick(View paramView)
    {
        this.an = true;
        this.W = new Alert(this.V, getResources().getString(2131230921), Alert.d, this.as, this.at, this.au, this.av, true);
        this.W.show();
    }

    public void onStop()
    {
        super.onStop();
        LOG.a(w, "-- ON STOP --");
        try
        {
            unregisterReceiver(this.aq);
            finish();
            return;
        }
        catch (Exception localException)
        {
            for (;;)
            {
                LOG.a(w, "Exception : " + localException.getMessage());
            }
        }
    }

    public void rightBtnClick(View paramView)
    {
        this.am.setVisibility(0);
        z();
        this.ao.scrollTo(0, 0);
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
                paramViewGroup = new DeviceRegistWifiActivity.ViewHolder();
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
                paramViewGroup.c.setImageDrawable(DeviceRegistWifiActivity.this.getDraw(2130837850));
                return paramView;
                paramViewGroup = (DeviceRegistWifiActivity.ViewHolder)paramView.getTag();
            }
            if (localWifiInfoVO.getPower() == 2)
            {
                paramViewGroup.c.setImageDrawable(DeviceRegistWifiActivity.this.getDraw(2130837849));
                return paramView;
            }
            paramViewGroup.c.setImageDrawable(DeviceRegistWifiActivity.this.getDraw(2130837848));
            return paramView;
        }
    }
}
