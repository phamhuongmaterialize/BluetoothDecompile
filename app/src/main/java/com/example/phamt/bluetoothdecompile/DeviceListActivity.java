package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.phamt.bluetoothdecompile.util.LOG;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.DeviceVo;

import java.util.ArrayList;
import java.util.HashMap;

public class DeviceListActivity
        extends BaseActivity
{
    public static String u = "device_address";
    private static final String w = DeviceListActivity.class.getSimpleName();
    private static final int x = 1001;
    private ArrayList<String> A = new ArrayList();
    private boolean ab = true;
    private LinearLayout ac;
    private FrameLayout ad;
    private final int ae = 1;
    IAsyncTaskCallback v = new IAsyncTaskCallback()
    {
        public void a()
        {
            LOG.c(DeviceListActivity.l(), "Failed");
        }

        public void a(Object paramAnonymousObject)
        {
            LOG.c(DeviceListActivity.l(), "onPreExecute");
        }

        public void a(String paramAnonymousString)
        {
            int i = 0;
            if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
            {
                LOG.c(DeviceListActivity.l(), "onPostExecute error ");
                return;
            }
            LOG.c(DeviceListActivity.l(), "result: " + paramAnonymousString);
            paramAnonymousString = GsonService.a(paramAnonymousString);
            if (paramAnonymousString.getCode().equals("00"))
            {
                DeviceListActivity.this.U.myDeivceList = DeviceListUtils.a(GsonService.a(paramAnonymousString));
                LOG.c(DeviceListActivity.l(), "model.myDeivceList =======" + DeviceListActivity.this.U.myDeivceList);
                DeviceListActivity.this.X.d(DeviceListActivity.this.U.editor, DeviceListActivity.this.U.myDeivceList.size() + "");
                DeviceListActivity.this.U.myUserInfo.setDeviceCount(DeviceListActivity.this.U.myDeivceList.size() + "");
                if (DeviceListActivity.this.U.myDeivceList.size() != 0) {
                    break label265;
                }
                DeviceListActivity.a(DeviceListActivity.this).setVisibility(0);
                DeviceListActivity.b(DeviceListActivity.this).setVisibility(8);
            }
            for (;;)
            {
                DeviceListActivity.this.w();
                return;
                label265:
                DeviceListActivity.a(DeviceListActivity.this).setVisibility(8);
                DeviceListActivity.b(DeviceListActivity.this).setVisibility(0);
                while (i < DeviceListActivity.this.U.myDeivceList.size())
                {
                    DeviceListActivity.this.U.myDeivceList.get(i);
                    i += 1;
                }
                DeviceListActivity.c(DeviceListActivity.this).clear();
                paramAnonymousString = DeviceListActivity.this.U.myDeivceList.iterator();
                while (paramAnonymousString.hasNext())
                {
                    DeviceVo localDeviceVo = (DeviceVo)paramAnonymousString.next();
                    DeviceListActivity.d(DeviceListActivity.this).a(localDeviceVo.getDeviceName());
                }
                DeviceListActivity.e(DeviceListActivity.this).setAdapter(DeviceListActivity.d(DeviceListActivity.this));
            }
        }

        public void b() {}
    };
    private DevicenNameAdapter y;
    private ListView z;

    public void j()
    {
        this.ac = ((LinearLayout)findViewById(2131624126));
        this.ad = ((FrameLayout)findViewById(2131624206));
        this.z = ((ListView)findViewById(2131624105));
        this.z.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                paramAnonymousAdapterView = (String)((ListView)paramAnonymousAdapterView).getItemAtPosition(paramAnonymousInt);
                LOG.c(DeviceListActivity.l(), ">>>>>>> position : " + paramAnonymousInt + " /  name : " + paramAnonymousAdapterView);
                DeviceListActivity.this.U.selectedDeviceVo = ((DeviceVo)DeviceListActivity.this.U.myDeivceList.get(paramAnonymousInt));
                DeviceListActivity.this.U.selectedDeviceVo.setSpeakerName(DeviceListActivity.this.U.pref.getString(DeviceListActivity.this.U.selectedDeviceVo.getDeviceId() + "SpearkerName", ""));
                DeviceListActivity.this.U.selectedDeviceVo.setSpeakerADDR(DeviceListActivity.this.U.pref.getString(DeviceListActivity.this.U.selectedDeviceVo.getDeviceId() + "SpearkerADDR", ""));
                LOG.c(DeviceListActivity.l(), "model.selectedDeviceVo.getSpeakerName() ::: " + DeviceListActivity.this.U.pref.getString(new StringBuilder().append(DeviceListActivity.this.U.selectedDeviceVo.getDeviceId()).append("SpearkerName").toString(), "") + " / " + DeviceListActivity.this.U.selectedDeviceVo.getSpeakerName());
                paramAnonymousAdapterView = new Intent(DeviceListActivity.this.V, DeviceHomeActivity.class);
                DeviceListActivity.this.startActivityForResult(paramAnonymousAdapterView, 1);
            }
        });
    }

    public void k()
    {
        a(4);
        setmActionBarTitle(getStr(2131230892));
        setRightButtonTitle(getStr(2131230996));
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        LOG.c(w, "dsds1: " + paramInt1);
        LOG.c(w, "dsds2: " + paramInt2);
        if ((paramInt1 == 1) && (paramInt2 == -1))
        {
            b(MypageHomeActivity.class);
            finish();
        }
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968632);
        this.V = this;
        k();
        j();
    }

    public void onPurchaseClick(View paramView)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.bluecanvas.com/product/bluecanvas/list")));
    }

    public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
        switch (paramInt)
        {
        }
        do
        {
            return;
        } while ((paramArrayOfInt.length <= 0) || (paramArrayOfInt[0] != 0));
        if (Integer.parseInt(this.U.myUserInfo.getDeviceCount()) >= this.U.myUserInfo.getMaxDeviceCnt())
        {
            a(this, a(2131230983, new Object[] { Integer.valueOf(this.U.myUserInfo.getMaxDeviceCnt()) }));
            return;
        }
        b(DeviceRegistQrScanActivity.class);
    }

    public void onResume()
    {
        LOG.c(w, "-- ON Resume --" + this.ab);
        super.onResume();
        this.y = new DevicenNameAdapter(null);
        HashMap localHashMap = new HashMap();
        localHashMap.put("locale", Constant.SYSTEM_LOCALE);
        localHashMap.put("userId", "" + this.U.myUserInfo.getUserId());
        new HttpAsyncTask(this.v, localHashMap).execute(new String[] { "http://api.bluecanvas.com/mobileUserDeviceList.do" });
    }

    public void rightBtnClick(View paramView)
    {
        if (this.U.myDeivceList != null)
        {
            if (a(new String[] { "android.permission.CAMERA" }))
            {
                if (Integer.parseInt(this.U.myUserInfo.getDeviceCount()) < this.U.myUserInfo.getMaxDeviceCnt()) {
                    break label85;
                }
                a(this, a(2131230983, new Object[] { Integer.valueOf(this.U.myUserInfo.getMaxDeviceCnt()) }));
            }
            label85:
            while (!BluetoothService.b(this)) {
                return;
            }
            b(DeviceRegistQrScanActivity.class);
            return;
        }
        LOG.c(w, "model.myDeivceList is null");
    }

    private class DevicenNameAdapter
            extends BaseAdapter
    {
        private ArrayList<String> b = new ArrayList();

        private DevicenNameAdapter() {}

        public void a(String paramString)
        {
            this.b.add(paramString);
        }

        public int getCount()
        {
            return this.b.size();
        }

        public String getItem(int paramInt)
        {
            return (String)this.b.get(paramInt);
        }

        public long getItemId(int paramInt)
        {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
        {
            View localView = paramView;
            if (paramView == null) {
                localView = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater")).inflate(2130968726, paramViewGroup, false);
            }
            ((TextView)localView.findViewById(2131624208)).setText((CharSequence)this.b.get(paramInt));
            return localView;
        }
    }
}
