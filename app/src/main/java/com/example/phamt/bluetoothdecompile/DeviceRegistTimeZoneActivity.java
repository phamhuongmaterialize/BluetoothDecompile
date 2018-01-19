package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DeviceRegistTimeZoneActivity
        extends BaseActivity
{
    private static final int ad = 55000;
    private static final int ae = 5000;
    private static final String v = DeviceRegistTimeZoneActivity.class.getSimpleName();
    private String A = "";
    private boolean ab = true;
    private Thread ac;
    private CountDownTimer af;
    private boolean ag = false;
    private ImageView ah;
    IBluetoothCallback u = new IBluetoothCallback()
    {
        public void a() {}

        public void a(int paramAnonymousInt) {}

        public void a(String paramAnonymousString)
        {
            Alert.a();
            Toast.makeText(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this), DeviceRegistTimeZoneActivity.this.getString(2131231133), 0).show();
        }

        public void a(String paramAnonymousString1, String paramAnonymousString2) {}

        public void b()
        {
            if (DeviceRegistTimeZoneActivity.c(DeviceRegistTimeZoneActivity.this).getState() == 3) {
                Toast.makeText(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this), DeviceRegistTimeZoneActivity.this.getString(2131231133), 0).show();
            }
        }

        public void b(int paramAnonymousInt)
        {
            if ((paramAnonymousInt == 2002) && (!DeviceRegistTimeZoneActivity.f(DeviceRegistTimeZoneActivity.this)))
            {
                Alert.a();
                Toast.makeText(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this), DeviceRegistTimeZoneActivity.this.getString(2131231000), 0).show();
                DeviceRegistTimeZoneActivity.this.finish();
            }
        }

        public void b(String paramAnonymousString)
        {
            int i;
            do
            {
                for (;;)
                {
                    try
                    {
                        LOG.c(DeviceRegistTimeZoneActivity.l(), "responseMessage ::: " + paramAnonymousString);
                        str = GsonService.b(paramAnonymousString).getMessageType();
                        i = str.hashCode();
                        switch (i)
                        {
                            default:
                                i = -1;
                                switch (i)
                                {
                                    default:
                                        i = 0;
                                        if (i != -1) {
                                            continue;
                                        }
                                        Alert.a();
                                        Toast.makeText(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this), DeviceRegistTimeZoneActivity.this.getResources().getString(2131230792), 1).show();
                                        DeviceRegistTimeZoneActivity.this.setResult(0);
                                        DeviceRegistTimeZoneActivity.this.finish();
                                        return;
                                }
                                break;
                        }
                    }
                    catch (Exception localException)
                    {
                        String str;
                        boolean bool;
                        localException = localException;
                        localException.printStackTrace();
                        paramAnonymousString = GsonService.c(paramAnonymousString);
                        if (paramAnonymousString != null) {
                            break label550;
                        }
                        i = -1;
                        if (i != -1) {
                            continue;
                        }
                        Alert.a();
                        Toast.makeText(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this), DeviceRegistTimeZoneActivity.this.getResources().getString(2131230792), 1).show();
                        DeviceRegistTimeZoneActivity.this.setResult(0);
                        DeviceRegistTimeZoneActivity.this.finish();
                        return;
                        if (i != -2) {
                            continue;
                        }
                        Toast.makeText(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this), DeviceRegistTimeZoneActivity.this.getResources().getString(2131230793), 1).show();
                        return;
                        if (i != 1) {
                            continue;
                        }
                        DeviceRegistTimeZoneActivity.g(DeviceRegistTimeZoneActivity.this);
                        DeviceRegistTimeZoneActivity.h(DeviceRegistTimeZoneActivity.this).start();
                        return;
                        if (i != 2) {
                            continue;
                        }
                        Alert.a();
                        DeviceRegistTimeZoneActivity.this.setResult(-1);
                        paramAnonymousString = new Intent(DeviceRegistTimeZoneActivity.this, DeviceRegistCompleteActivity.class);
                        DeviceRegistTimeZoneActivity.this.a(paramAnonymousString, 0, 0);
                        DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this, true);
                        DeviceRegistTimeZoneActivity.this.finish();
                        return;
                    }
                    finally {}
                    if (str.equals("responseSetTimeZone"))
                    {
                        i = 0;
                        continue;
                        if (str.equals("responseNotUseDevice"))
                        {
                            i = 1;
                            continue;
                            if (str.equals("responseUseDevice"))
                            {
                                i = 2;
                                continue;
                                bool = str.equals("responseStartApp");
                                if (bool)
                                {
                                    i = 3;
                                    continue;
                                    i = -2;
                                    continue;
                                    i = -1;
                                    continue;
                                    i = 1;
                                    continue;
                                    i = 2;
                                }
                            }
                        }
                    }
                }
                if (i == -2)
                {
                    Toast.makeText(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this), DeviceRegistTimeZoneActivity.this.getResources().getString(2131230793), 1).show();
                    return;
                }
                if (i == 1)
                {
                    DeviceRegistTimeZoneActivity.g(DeviceRegistTimeZoneActivity.this);
                    DeviceRegistTimeZoneActivity.h(DeviceRegistTimeZoneActivity.this).start();
                    return;
                }
            } while (i != 2);
            Alert.a();
            DeviceRegistTimeZoneActivity.this.setResult(-1);
            paramAnonymousString = new Intent(DeviceRegistTimeZoneActivity.this, DeviceRegistCompleteActivity.class);
            DeviceRegistTimeZoneActivity.this.a(paramAnonymousString, 0, 0);
            DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this, true);
            DeviceRegistTimeZoneActivity.this.finish();
            return;
            for (;;)
            {
                label550:
                i = 0;
            }
        }
    };
    private BluetoothService w;
    private Context x;
    private TimeZoneAdapter y;
    private ListView z;

    private void m()
    {
        this.w = BluetoothService.a(this, this.u);
    }

    private void n()
    {
        this.af = new CountDownTimer(55000L, 5000L)
        {
            public void onFinish()
            {
                DeviceRegistTimeZoneActivity.d(DeviceRegistTimeZoneActivity.this).interrupt();
            }

            public void onTick(long paramAnonymousLong)
            {
                if (DeviceRegistTimeZoneActivity.e(DeviceRegistTimeZoneActivity.this))
                {
                    DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this, new Thread(new Runnable()
                    {
                        public void run()
                        {
                            DeviceRegistTimeZoneActivity.c(DeviceRegistTimeZoneActivity.this).c();
                        }
                    }));
                    DeviceRegistTimeZoneActivity.d(DeviceRegistTimeZoneActivity.this).start();
                }
                while ((DeviceRegistTimeZoneActivity.d(DeviceRegistTimeZoneActivity.this) == null) || (!DeviceRegistTimeZoneActivity.d(DeviceRegistTimeZoneActivity.this).isAlive())) {
                    return;
                }
                onFinish();
            }
        };
    }

    public void j()
    {
        this.ah = ((ImageView)findViewById(2131624144));
        this.ah.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.U.deviceWidth / 7.35D)));
        this.x = this;
        this.z = ((ListView)findViewById(2131624105));
        ArrayList localArrayList = new ArrayList();
        String[] arrayOfString = TimeZone.getAvailableIDs();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
            String str = arrayOfString[i];
            TimeZoneVo localTimeZoneVo = new TimeZoneVo();
            localTimeZoneVo.setTimeZone(str);
            localArrayList.add(localTimeZoneVo);
            i += 1;
        }
        this.y = new TimeZoneAdapter(this.x, 2130968728, localArrayList, null);
        this.z.setAdapter(this.y);
        this.z.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
            {
                Alert.a(DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this));
                DeviceRegistTimeZoneActivity.a(DeviceRegistTimeZoneActivity.this, new Thread(new Runnable()
                {
                    public void run()
                    {
                        TimeZoneVo localTimeZoneVo = (TimeZoneVo)DeviceRegistTimeZoneActivity.b(DeviceRegistTimeZoneActivity.this).getItem(paramAnonymousInt);
                        LOG.c(DeviceRegistTimeZoneActivity.l(), "select timezone =========== " + localTimeZoneVo.getTimeZone());
                        DeviceRegistTimeZoneActivity.c(DeviceRegistTimeZoneActivity.this).setTimeZone(localTimeZoneVo.getTimeZone());
                    }
                }));
                DeviceRegistTimeZoneActivity.d(DeviceRegistTimeZoneActivity.this).start();
            }
        });
        i = 0;
        for (;;)
        {
            if (i < localArrayList.size())
            {
                if (((TimeZoneVo)localArrayList.get(i)).getTimeZone().equals(TimeZone.getDefault().getID())) {
                    this.z.setSelection(i);
                }
            }
            else
            {
                this.A = getIntent().getStringExtra("registeringDeviceBluetoothMac");
                return;
            }
            i += 1;
        }
    }

    public void k()
    {
        a(3);
        setmActionBarTitle(getStr(2131231208));
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968647);
        w();
        this.x = this;
        k();
        j();
        m();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if ((this.w != null) && (this.w.getState() == 3) && (!this.ag) && (this.A != null) && (!this.A.isEmpty())) {
            this.w.h(this.A);
        }
        if (this.af != null) {
            this.af.cancel();
        }
    }

    public void onStop()
    {
        super.onStop();
        finish();
    }

    class TimeZoneAdapter
            extends ArrayAdapter<TimeZoneVo>
    {
        private Context b;
        private List<TimeZoneVo> c;
        private int d;

        private TimeZoneAdapter(int paramInt, List<TimeZoneVo> paramList)
        {
            super(paramList, localList);
            this.b = paramInt;
            this.d = paramList;
            this.c = localList;
        }

        @NonNull
        public View getView(int paramInt, View paramView, @NonNull ViewGroup paramViewGroup)
        {
            Object localObject;
            if (paramView == null)
            {
                localObject = new DeviceRegistTimeZoneActivity.ViewHolder();
                paramView = DeviceRegistTimeZoneActivity.this.getLayoutInflater().inflate(this.d, paramViewGroup, false);
                ((DeviceRegistTimeZoneActivity.ViewHolder)localObject).a = ((TextView)paramView.findViewById(2131624447));
                paramView.setTag(localObject);
            }
            for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (DeviceRegistTimeZoneActivity.ViewHolder)paramView.getTag())
            {
                localObject = (TimeZoneVo)this.c.get(paramInt);
                paramViewGroup.a.setText(((TimeZoneVo)localObject).getTimeZone());
                if (!((TimeZoneVo)localObject).getTimeZone().equals(TimeZone.getDefault().getID())) {
                    break;
                }
                paramViewGroup.a.setTextColor(DeviceRegistTimeZoneActivity.this.getCol(2131558499));
                paramViewGroup.a.setTypeface(Typeface.DEFAULT_BOLD);
                return paramView;
            }
            paramViewGroup.a.setTextColor(DeviceRegistTimeZoneActivity.this.getCol(2131558476));
            paramViewGroup.a.setTypeface(Typeface.DEFAULT);
            return paramView;
        }
    }

    static class ViewHolder
    {
        TextView a;
    }
}

