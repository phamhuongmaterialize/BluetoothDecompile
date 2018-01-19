package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;

import java.util.ArrayList;

public class DeviceRegistLocaleActivity
        extends BaseActivity
{
    private static final String w = DeviceRegistLocaleActivity.class.getSimpleName();
    private ArrayAdapter A;
    private ImageView ab;
    private boolean ac = false;
    String u = "";
    IBluetoothCallback v = new IBluetoothCallback()
    {
        public void a() {}

        public void a(int paramAnonymousInt) {}

        public void a(String paramAnonymousString)
        {
            Alert.a();
            Toast.makeText(DeviceRegistLocaleActivity.this.V, DeviceRegistLocaleActivity.this.getString(2131231133), 0).show();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2) {}

        public void b()
        {
            if (DeviceRegistLocaleActivity.b(DeviceRegistLocaleActivity.this).getState() == 3) {
                Toast.makeText(DeviceRegistLocaleActivity.this.V, DeviceRegistLocaleActivity.this.getString(2131231133), 0).show();
            }
        }

        public void b(int paramAnonymousInt)
        {
            LOG.c(DeviceRegistLocaleActivity.l(), "disconnect failCode: " + paramAnonymousInt);
            if (paramAnonymousInt == 2002)
            {
                Alert.a();
                Toast.makeText(DeviceRegistLocaleActivity.this.V, DeviceRegistLocaleActivity.this.getString(2131231000), 0).show();
                DeviceRegistLocaleActivity.this.finish();
            }
        }

        public void b(String paramAnonymousString)
        {
            Alert.a();
            LOG.c(DeviceRegistLocaleActivity.l(), "responseMessage ::: " + paramAnonymousString);
            BlueToothMessageVO localBlueToothMessageVO = GsonService.b(paramAnonymousString);
            if (localBlueToothMessageVO == null) {
                GsonService.c(paramAnonymousString);
            }
            do
            {
                return;
                paramAnonymousString = localBlueToothMessageVO.getCode();
            } while (!localBlueToothMessageVO.getMessageType().equals("responseSetLanguage"));
            int i = -1;
            switch (paramAnonymousString.hashCode())
            {
            }
            for (;;)
            {
                switch (i)
                {
                    default:
                        return;
                }
                paramAnonymousString = localBlueToothMessageVO.getData().toString();
                LOG.c(DeviceRegistLocaleActivity.l(), "dataStar :: " + paramAnonymousString);
                paramAnonymousString = new Intent(DeviceRegistLocaleActivity.this, DeviceRegistTimeZoneActivity.class);
                paramAnonymousString.putExtra("registeringDeviceBluetoothMac", DeviceRegistLocaleActivity.this.u);
                DeviceRegistLocaleActivity.this.a(paramAnonymousString, 0, 0);
                DeviceRegistLocaleActivity.a(DeviceRegistLocaleActivity.this, true);
                DeviceRegistLocaleActivity.this.finish();
                return;
                if (paramAnonymousString.equals("00")) {
                    i = 0;
                }
            }
        }
    };
    private BluetoothService x;
    private ListView y;
    private ArrayList<String> z;

    private void m()
    {
        this.x = BluetoothService.a(this, this.v);
    }

    public void j()
    {
        this.ab = ((ImageView)findViewById(2131624144));
        this.ab.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.V = this;
        this.y = ((ListView)findViewById(2131624105));
        this.z = new ArrayList();
        this.z.add(getResources().getString(2131230950));
        this.z.add(getResources().getString(2131230936));
        this.z.add(getResources().getString(2131230949));
        this.z.add(getResources().getString(2131230809));
        this.A = new ArrayAdapter(this, 2130968725, this.z);
        this.y.setAdapter(this.A);
        this.y.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
            {
                Alert.a(DeviceRegistLocaleActivity.this.V);
                new Thread(new Runnable()
                {
                    public void run()
                    {
                        String str = (String)DeviceRegistLocaleActivity.a(DeviceRegistLocaleActivity.this).getItemAtPosition(paramAnonymousInt);
                        LOG.c(DeviceRegistLocaleActivity.l(), "selected lang : " + str);
                        if (str.equals(DeviceRegistLocaleActivity.this.getStr(2131230950))) {
                            str = "ko";
                        }
                        for (;;)
                        {
                            DeviceRegistLocaleActivity.b(DeviceRegistLocaleActivity.this).setLocale(str);
                            return;
                            if (str.equals(DeviceRegistLocaleActivity.this.getStr(2131230936))) {
                                str = "en";
                            } else if (str.equals(DeviceRegistLocaleActivity.this.getStr(2131230949))) {
                                str = "ja";
                            } else if (str.equals(DeviceRegistLocaleActivity.this.getStr(2131230809))) {
                                str = "zh";
                            } else {
                                str = null;
                            }
                        }
                    }
                }).start();
            }
        });
        this.u = getIntent().getStringExtra("registeringDeviceBluetoothMac");
    }

    public void k()
    {
        a(3);
        setmActionBarTitle(getStr(2131230951));
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968645);
        w();
        this.V = this;
        k();
        j();
        m();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if ((this.x != null) && (this.x.getState() == 3) && (!this.ac) && (this.u != null) && (!this.u.isEmpty())) {
            this.x.h(this.u);
        }
    }

    public void onStop()
    {
        super.onStop();
        finish();
    }
}
