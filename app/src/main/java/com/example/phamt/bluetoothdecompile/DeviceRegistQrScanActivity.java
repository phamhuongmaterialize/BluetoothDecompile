package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.callback.IBluetoothCallback;
import com.example.phamt.bluetoothdecompile.util.LOG;
import com.example.phamt.bluetoothdecompile.vo.bluetooth.BlueToothMessageVO;

public class DeviceRegistQrScanActivity
        extends BaseActivity
{
    private static final String v = DeviceRegistBluetoothActivity.class.getSimpleName();
    private static final int w = 1001;
    private LinearLayout A;
    private ImageView ab;
    private SpinKitView ac;
    private BluetoothService ad;
    private String ae = "";
    private boolean af = false;
    private boolean ag = false;
    private boolean ah = false;
    private int ai = 0;
    private boolean aj = false;
    private final String ak = "^([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])$";
    private SurfaceView al;
    private QREader am;
    private boolean an = false;
    IBluetoothCallback u = new IBluetoothCallback()
    {
        public void a()
        {
            DeviceRegistQrScanActivity.c(DeviceRegistQrScanActivity.this, false);
            DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this, false);
            DeviceRegistQrScanActivity.f(DeviceRegistQrScanActivity.this);
            if (DeviceRegistQrScanActivity.g(DeviceRegistQrScanActivity.this) >= 5)
            {
                Toast.makeText(DeviceRegistQrScanActivity.this.V, DeviceRegistQrScanActivity.this.getString(2131230804), 0).show();
                return;
            }
            Toast.makeText(DeviceRegistQrScanActivity.this.V, DeviceRegistQrScanActivity.this.getString(2131231133), 0).show();
        }

        public void a(int paramAnonymousInt)
        {
            switch (paramAnonymousInt)
            {
                default:
                    return;
            }
            LOG.c(DeviceRegistQrScanActivity.l(), "BLUETOOTH ?? ??");
            DeviceRegistQrScanActivity.c(DeviceRegistQrScanActivity.this, false);
            DeviceRegistQrScanActivity.d(DeviceRegistQrScanActivity.this, true);
            new Thread()
            {
                public void run()
                {
                    DeviceRegistQrScanActivity.d(DeviceRegistQrScanActivity.this).a("" + DeviceRegistQrScanActivity.this.U.myUserInfo.getUserId());
                }
            }.start();
        }

        public void a(String paramAnonymousString)
        {
            DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this, false);
            Toast.makeText(DeviceRegistQrScanActivity.this.V, DeviceRegistQrScanActivity.this.getString(2131231133), 0).show();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2) {}

        public void b()
        {
            DeviceRegistQrScanActivity.c(DeviceRegistQrScanActivity.this, false);
            if (DeviceRegistQrScanActivity.d(DeviceRegistQrScanActivity.this).getState() == 3) {
                new Thread()
                {
                    public void run()
                    {
                        DeviceRegistQrScanActivity.d(DeviceRegistQrScanActivity.this).a("" + DeviceRegistQrScanActivity.this.U.myUserInfo.getUserId());
                    }
                }.start();
            }
        }

        public void b(int paramAnonymousInt)
        {
            DeviceRegistQrScanActivity.c(DeviceRegistQrScanActivity.this, false);
            if (paramAnonymousInt == 2002)
            {
                DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this, false);
                Toast.makeText(DeviceRegistQrScanActivity.this.V, DeviceRegistQrScanActivity.this.getString(2131231000), 0).show();
                DeviceRegistQrScanActivity.this.finish();
            }
        }

        public void b(String paramAnonymousString)
        {
            int j = -1;
            DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this, false);
            LOG.c(DeviceRegistQrScanActivity.l(), "response msg :::: " + paramAnonymousString);
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
                    Toast.makeText(DeviceRegistQrScanActivity.this.V, DeviceRegistQrScanActivity.this.getStr(2131230889), 0).show();
                    DeviceRegistQrScanActivity.this.finish();
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
                        DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this, paramAnonymousString);
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
            LOG.c(DeviceRegistQrScanActivity.l(), "??? ???? ??????");
            return;
            LOG.c(DeviceRegistQrScanActivity.l(), "?? ??? ??");
            return;
            Toast.makeText(DeviceRegistQrScanActivity.this.V, DeviceRegistQrScanActivity.this.getStr(2131230982), 0).show();
            DeviceRegistQrScanActivity.this.finish();
        }
    };
    private TextView x;
    private ProgressWheel y;
    private LinearLayout z;

    private void a(String paramString)
    {
        Intent localIntent = new Intent(this.V, DeviceRegistWifiActivity.class);
        localIntent.putExtra("wifiList", paramString);
        localIntent.putExtra("wifiChangeFlag", "N");
        localIntent.putExtra("registeringDeviceBluetoothMac", this.ae);
        a(localIntent, 1001, 0);
        this.af = true;
        finish();
    }

    private void m()
    {
        this.ad = BluetoothService.a(this, this.u);
        this.ad.d(this);
        this.ad.a();
    }

    private void setLoading(boolean paramBoolean)
    {
        if (paramBoolean)
        {
            this.ac.setVisibility(0);
            this.z.setVisibility(0);
            this.z.setBackgroundColor(-16777216);
            this.z.getBackground().setAlpha(200);
            this.A.setVisibility(0);
            this.A.setBackgroundColor(-16777216);
            this.A.getBackground().setAlpha(200);
            a(true, 200);
            if (this.am.isCameraRunning()) {
                this.am.stop();
            }
        }
        for (;;)
        {
            return;
            this.ac.setVisibility(4);
            this.z.setVisibility(8);
            this.z.getBackground().setAlpha(0);
            this.A.setVisibility(8);
            this.A.getBackground().setAlpha(0);
            a(false, 200);
            try
            {
                if (!this.am.isCameraRunning())
                {
                    this.am.start();
                    return;
                }
            }
            catch (Exception localException)
            {
                localException.printStackTrace();
            }
        }
    }

    public void j()
    {
        this.ac = ((SpinKitView)findViewById(2131624263));
        this.ab = ((ImageView)findViewById(2131624144));
        this.ab.setLayoutParams(new FrameLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.z = ((LinearLayout)findViewById(2131624256));
        this.A = ((LinearLayout)findViewById(2131624262));
        this.y = ((ProgressWheel)findViewById(2131624194));
        this.y.setBarColor(getCol(2131558499));
        this.y.setSpinSpeed(1.5F);
        this.y.c();
        this.x = ((TextView)findViewById(2131624261));
        if (Build.VERSION.SDK_INT > 24) {
            this.x.setText(Html.fromHtml("<u>" + getStr(2131230891) + "</u>", 0));
        }
        for (;;)
        {
            this.al = ((SurfaceView)findViewById(2131624257));
            this.am = new QREader.Builder(this, this.al, new QRDataListener()
            {
                public void onDetected(String paramAnonymousString)
                {
                    LOG.c(DeviceRegistQrScanActivity.l(), "QR?? TEST - 1 isConnecting: " + DeviceRegistQrScanActivity.a(DeviceRegistQrScanActivity.this) + " ///  isConnect: " + DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this) + "  ///  mac address: " + paramAnonymousString);
                    DeviceRegistQrScanActivity.a(DeviceRegistQrScanActivity.this, paramAnonymousString);
                    try
                    {
                        if ((DeviceRegistQrScanActivity.a(DeviceRegistQrScanActivity.this)) || (DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this)))
                        {
                            LOG.c(DeviceRegistQrScanActivity.l(), "QR?? TEST - 2 isConnecting: " + DeviceRegistQrScanActivity.a(DeviceRegistQrScanActivity.this) + " ///  isConnect: " + DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this) + "  ///  mac address: " + paramAnonymousString);
                            return;
                        }
                        if ((!paramAnonymousString.matches("^([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])$")) || (DeviceRegistQrScanActivity.c(DeviceRegistQrScanActivity.this))) {
                            return;
                        }
                        if (!DeviceRegistQrScanActivity.d(DeviceRegistQrScanActivity.this).a(DeviceRegistQrScanActivity.this.V))
                        {
                            DeviceRegistQrScanActivity.a(DeviceRegistQrScanActivity.this, true);
                            DeviceRegistQrScanActivity.d(DeviceRegistQrScanActivity.this).a();
                            return;
                        }
                    }
                    catch (Exception paramAnonymousString)
                    {
                        paramAnonymousString.printStackTrace();
                        return;
                    }
                    DeviceRegistQrScanActivity.this.runOnUiThread(new Runnable()
                    {
                        public void run()
                        {
                            DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this, true);
                        }
                    });
                    DeviceRegistQrScanActivity.c(DeviceRegistQrScanActivity.this, true);
                    DeviceRegistQrScanActivity.a(DeviceRegistQrScanActivity.this, paramAnonymousString);
                    LOG.c(DeviceRegistQrScanActivity.l(), "QR?? TEST - 3 isConnecting: " + DeviceRegistQrScanActivity.a(DeviceRegistQrScanActivity.this) + " ///  isConnect: " + DeviceRegistQrScanActivity.b(DeviceRegistQrScanActivity.this) + "  ///  mac address: " + paramAnonymousString);
                    DeviceRegistQrScanActivity.d(DeviceRegistQrScanActivity.this).g(paramAnonymousString);
                }
            }).enableAutofocus(true).facing(0).height(this.al.getHeight()).width(this.al.getWidth()).build();
            this.al.post(new Runnable()
            {
                public void run()
                {
                    DeviceRegistQrScanActivity.e(DeviceRegistQrScanActivity.this).setLayoutParams(new FrameLayout.LayoutParams(DeviceRegistQrScanActivity.e(DeviceRegistQrScanActivity.this).getHeight(), -1));
                }
            });
            return;
            this.x.setText(Html.fromHtml("<u>" + getStr(2131230891) + "</u>"));
        }
    }

    public void k()
    {
        a(3);
        setmActionBarTitle(getStr(2131230806));
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
                LOG.c(v, "\nDevice can use");
                this.an = false;
                finish();
            }
        }
        else {
            return;
        }
        LOG.c(v, "\nDevice can not use");
        finish();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968646);
        w();
        GooglePlayServiceUtils.a(this);
        this.V = this;
        k();
        j();
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }))
            {
                m();
                this.aj = true;
                return;
            }
            LOG.c(v, "???? ????");
            this.aj = false;
            return;
        }
        m();
        this.aj = true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (this.ad != null)
        {
            if (this.ad.h != null) {
                this.ad.a(true);
            }
            if ((this.ad.getState() == 3) && (!this.af) && (this.ae != null) && (!this.ae.isEmpty())) {
                this.ad.h(this.ae);
            }
            this.ad.c(this);
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
            return;
        }
        this.aj = false;
        finish();
    }

    public void onResume()
    {
        super.onResume();
        this.am.initAndStart(this.al);
        LOG.c(v, "TEST ===================== isCameraRunning" + this.am.isCameraRunning());
        try
        {
            if (this.am.isCameraRunning())
            {
                this.am.stop();
                return;
            }
            this.am.start();
            return;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }

    public void onScanModeClick(View paramView)
    {
        b(DeviceRegistBluetoothActivity.class);
        finish();
    }

    public void onStop()
    {
        super.onStop();
        if (this.aj) {
            this.am.releaseAndCleanup();
        }
        finish();
    }
}
