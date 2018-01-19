package com.example.phamt.bluetoothdecompile;

/**
 * Created by phamt on 2018/01/19.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phamt.bluetoothdecompile.util.LOG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimerTask;

public class DeviceOptionHomeActivity
        extends BaseActivity
{
    private static final int af = 1001;
    private static final String z = DeviceOptionHomeActivity.class.getSimpleName();
    private String A = "OPTION_MEMORY";
    private String ab = "OPTION_NAME";
    private String ac = "OPTION_EMPTY";
    private String ad = "OPTION_ON_OFF";
    private int ae = 0;
    private DeviceOptionListAdapter ag;
    private ListView ah;
    private ArrayList<DeviceOptionVo> ai = new ArrayList();
    private boolean aj = true;
    private int ak = 0;
    private boolean al = false;
    private int am;
    private int[] an = { 2130837678, 2130837681, 2130837682, 2130837683, 2130837684, 2130837685, 2130837686, 2130837687, 2130837688, 2130837679, 2130837680, 2130837674, 2130837681 };
    private View.OnClickListener ao = new View.OnClickListener()
    {
        public void onClick(View paramAnonymousView)
        {
            Alert.a(DeviceOptionHomeActivity.this);
            DeviceOptionHomeActivity.e(DeviceOptionHomeActivity.this);
        }
    };
    private View.OnClickListener ap = new View.OnClickListener()
    {
        public void onClick(View paramAnonymousView)
        {
            DeviceOptionHomeActivity.f(DeviceOptionHomeActivity.this);
        }
    };
    private View.OnClickListener aq = new View.OnClickListener()
    {
        public void onClick(View paramAnonymousView)
        {
            DeviceOptionHomeActivity.this.W.dismiss();
        }
    };
    private View.OnClickListener ar = new View.OnClickListener()
    {
        public void onClick(View paramAnonymousView)
        {
            DeviceOptionHomeActivity.this.W.dismiss();
            DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
            DeviceOptionHomeActivity.this.finish();
        }
    };
    private DialogInterface.OnCancelListener as = new DialogInterface.OnCancelListener()
    {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
            DeviceOptionHomeActivity.this.W.dismiss();
            DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
            DeviceOptionHomeActivity.this.finish();
        }
    };
    public TimerTask u = new TimerTask()
    {
        public void run() {}
    };
    IAsyncTaskCallback v = new IAsyncTaskCallback()
    {
        public void a()
        {
            DeviceOptionHomeActivity.this.W.dismiss();
        }

        public void a(Object paramAnonymousObject)
        {
            LOG.c(DeviceOptionHomeActivity.l(), "onPreExecute");
        }

        public void a(String paramAnonymousString)
        {
            try
            {
                LOG.c(DeviceOptionHomeActivity.l(), "result: " + paramAnonymousString);
                if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
                {
                    LOG.c(DeviceOptionHomeActivity.l(), "onPostExecute error ");
                    DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
                    DeviceOptionHomeActivity.this.finish();
                    return;
                }
                paramAnonymousString = GsonService.a(paramAnonymousString);
                if (paramAnonymousString.getCode().equals("00"))
                {
                    DeviceOptionHomeActivity.this.W.dismiss();
                    DeviceOptionHomeActivity.g(DeviceOptionHomeActivity.this);
                    return;
                }
            }
            catch (Exception paramAnonymousString)
            {
                paramAnonymousString.printStackTrace();
                DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
                DeviceOptionHomeActivity.this.finish();
                return;
            }
            if (paramAnonymousString.getCode().equals("66"))
            {
                DeviceOptionHomeActivity.this.W.dismiss();
                DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231131));
                return;
            }
            if (paramAnonymousString.getCode().equals("90"))
            {
                DeviceOptionHomeActivity.this.W.dismiss();
                DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
                DeviceOptionHomeActivity.this.finish();
                return;
            }
            DeviceOptionHomeActivity.this.W.dismiss();
            DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231133));
        }

        public void b()
        {
            DeviceOptionHomeActivity.this.W.dismiss();
        }
    };
    IAsyncTaskCallback w = new IAsyncTaskCallback()
    {
        public void a() {}

        public void a(Object paramAnonymousObject)
        {
            LOG.c(DeviceOptionHomeActivity.l(), "onPreExecute");
        }

        public void a(String paramAnonymousString)
        {
            if (paramAnonymousString != null) {}
            try
            {
                if (paramAnonymousString.equals(""))
                {
                    LOG.c(DeviceOptionHomeActivity.l(), "onPostExecute error ");
                    DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
                    DeviceOptionHomeActivity.this.finish();
                    return;
                }
                paramAnonymousString = GsonService.a(paramAnonymousString);
                if (paramAnonymousString.getCode().equals("00"))
                {
                    DeviceOptionHomeActivity.this.W.dismiss();
                    Toast.makeText(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231009), 1).show();
                    return;
                }
            }
            catch (Exception paramAnonymousString)
            {
                paramAnonymousString.printStackTrace();
                DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
                DeviceOptionHomeActivity.this.finish();
                return;
            }
            if (paramAnonymousString.getCode().equals("66"))
            {
                DeviceOptionHomeActivity.this.W.dismiss();
                DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231131));
                return;
            }
            if (paramAnonymousString.getCode().equals("90"))
            {
                DeviceOptionHomeActivity.this.W.dismiss();
                DeviceOptionHomeActivity.this.a(DeviceListActivity.class, true);
                DeviceOptionHomeActivity.this.finish();
                return;
            }
            DeviceOptionHomeActivity.this.W.dismiss();
            DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231133));
        }

        public void b() {}
    };
    IAsyncTaskCallback x = new IAsyncTaskCallback()
    {
        public void a() {}

        public void a(Object paramAnonymousObject) {}

        public void a(String paramAnonymousString)
        {
            if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
            {
                LOG.c(DeviceOptionHomeActivity.l(), "onPostExecute error ");
                return;
            }
            if (GsonService.a(paramAnonymousString).getCode().equals("00"))
            {
                DeviceOptionHomeActivity.this.s();
                DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131230897));
                return;
            }
            DeviceOptionHomeActivity.this.s();
            DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131230895));
        }

        public void b() {}
    };
    IAsyncTaskCallback y = new IAsyncTaskCallback()
    {
        public void a() {}

        public void a(Object paramAnonymousObject)
        {
            LOG.c(DeviceOptionHomeActivity.l(), "onPreExecute");
        }

        public void a(String paramAnonymousString)
        {
            if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
            {
                LOG.c(DeviceOptionHomeActivity.l(), "onPostExecute error ");
                return;
            }
            LOG.c(DeviceOptionHomeActivity.l(), "result : " + paramAnonymousString);
            paramAnonymousString = GsonService.a(paramAnonymousString);
            if (paramAnonymousString.getCode().equals("00"))
            {
                if (DeviceOptionHomeActivity.h(DeviceOptionHomeActivity.this) <= 10)
                {
                    DeviceOptionHomeActivity.i(DeviceOptionHomeActivity.this);
                    new Handler().postDelayed(new Runnable()
                    {
                        public void run()
                        {
                            LOG.c(DeviceOptionHomeActivity.l(), "apiGetDiveList() resetTryCount :" + DeviceOptionHomeActivity.h(DeviceOptionHomeActivity.this));
                            DeviceOptionHomeActivity.g(DeviceOptionHomeActivity.this);
                        }
                    }, 5000L);
                    return;
                }
                DeviceOptionHomeActivity.a(DeviceOptionHomeActivity.this, 0);
                Alert.a();
                DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231133));
                return;
            }
            if (paramAnonymousString.getCode().equals("02"))
            {
                Alert.a();
                DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231006), DeviceOptionHomeActivity.j(DeviceOptionHomeActivity.this), DeviceOptionHomeActivity.k(DeviceOptionHomeActivity.this));
                return;
            }
            Alert.a();
            DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231133));
        }

        public void b()
        {
            Alert.a();
            DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231132));
        }
    };

    private DeviceOptionVo a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
    {
        DeviceOptionVo localDeviceOptionVo = new DeviceOptionVo();
        localDeviceOptionVo.setDeviceOptionName(paramString1);
        localDeviceOptionVo.setIconId(paramInt1);
        localDeviceOptionVo.setUseSize(paramInt2);
        localDeviceOptionVo.setMaxSize(paramInt3);
        localDeviceOptionVo.setType(paramString2);
        return localDeviceOptionVo;
    }

    private DeviceOptionVo a(String paramString1, int paramInt, String paramString2, String paramString3)
    {
        DeviceOptionVo localDeviceOptionVo = new DeviceOptionVo();
        localDeviceOptionVo.setDeviceOptionName(paramString1);
        localDeviceOptionVo.setIconId(paramInt);
        localDeviceOptionVo.setSubName(paramString2);
        localDeviceOptionVo.setType(paramString3);
        return localDeviceOptionVo;
    }

    private void m()
    {
        this.am = this.U.selectedDeviceVo.getDeviceId();
        HashMap localHashMap = new HashMap();
        localHashMap.put("deviceId", this.am + "");
        localHashMap.put("userId", this.U.myUserInfo.getUserId() + "");
        localHashMap.put("locale", Constant.SYSTEM_LOCALE);
        new HttpAsyncTask(this.v, localHashMap).execute(new String[] { "http://api.bluecanvas.com/mobileDeviceResetPushMsg.do" });
    }

    private void n()
    {
        HashMap localHashMap = new HashMap();
        localHashMap.put("deviceId", "" + this.U.selectedDeviceVo.getDeviceId());
        localHashMap.put("locale", Constant.SYSTEM_LOCALE);
        LOG.c(z, "call apiCallRestartDevice : " + this.U.selectedDeviceVo.getDeviceId());
        LOG.c(z, "Constant.SYSTEM_LOCALE : " + Constant.SYSTEM_LOCALE);
        LOG.c(z, "Constant.DEVICE_RESTART_DEVICE : http://api.bluecanvas.com/mobileDeviceReStartPush.do");
        new HttpAsyncTask(this.w, localHashMap, this, getStr(2131230788)).execute(new String[] { "http://api.bluecanvas.com/mobileDeviceReStartPush.do" });
    }

    private void o()
    {
        if (Alert.isAlertShowing())
        {
            HashMap localHashMap = new HashMap();
            localHashMap.put("locale", Constant.SYSTEM_LOCALE);
            localHashMap.put("userId", this.U.myUserInfo.getUserId() + "");
            localHashMap.put("deviceId", this.am + "");
            new HttpAsyncTask(this.y, localHashMap).execute(new String[] { "http://api.bluecanvas.com/mobileUserDeviceInfo.do" });
            return;
        }
        this.ak = 0;
    }

    private void y()
    {
        this.ai.clear();
        Object localObject2;
        if (this.U.selectedDeviceVo.getVersionCode() < this.U.selectedDeviceVo.getLastVersionCode())
        {
            LOG.c(z, "TEST ==== ??????");
            this.ai.add(a(getStr(2131230898), 2130837698, getStr(2131231149), this.ab));
            this.ai.add(a(getStr(2131231031), 2130837681, this.U.selectedDeviceVo.getDeviceName(), this.ab));
            this.ai.add(a(getStr(2131231032), 2130837682, this.U.selectedDeviceVo.getWifiSsid(), this.ab));
            this.ai.add(a(getStr(2131231039), 2130837683, this.U.selectedDeviceVo.getSpeakerName(), this.ab));
            double d = Double.valueOf(this.U.selectedDeviceVo.getBrightness()).doubleValue() / 255.0D;
            this.ai.add(a(getStr(2131231026), 2130837674, Math.round(Double.valueOf(d * 100.0D).doubleValue()) + "%", this.ab));
            localObject2 = "";
            if (!"Y".equals(this.U.selectedDeviceVo.getScheduleYN())) {
                break label950;
            }
            localObject1 = localObject2;
            if (this.U.selectedDeviceVo.getShowStartTime() != null)
            {
                localObject1 = localObject2;
                if (!this.U.selectedDeviceVo.getShowStartTime().equals(this.U.selectedDeviceVo.getSleepStartTime())) {
                    localObject1 = this.U.selectedDeviceVo.getShowStartTime() + " ~ " + this.U.selectedDeviceVo.getSleepStartTime();
                }
            }
            label371:
            this.ai.add(a(getStr(2131231037), 2130837684, (String)localObject1, this.ab));
            if (!this.U.selectedDeviceVo.getSlideShowAnimationType().equals("fade")) {
                break label962;
            }
            this.ai.add(a(getStr(2131231038), 2130837685, getStr(2131231012), this.ab));
            label449:
            this.ai.add(a(getStr(2131231028), 2130837686, this.U.selectedDeviceVo.getSlideShowInterval() / 60 + getStr(2131231018) + " " + this.U.selectedDeviceVo.getSlideShowInterval() % 60 + getStr(2131231019), this.ab));
            if (!this.U.selectedDeviceVo.getScaleType().equals("FIT_CENTER")) {
                break label997;
            }
            this.ai.add(a(getStr(2131231029), 2130837687, getStr(2131230992), this.ab));
            label593:
            if (!this.U.selectedDeviceVo.getDeviceHeight().equals(this.U.selectedDeviceVo.getDeviceWidth())) {
                if (1 != this.U.selectedDeviceVo.getOrientation()) {
                    break label1032;
                }
            }
        }
        label950:
        String str;
        label962:
        label997:
        label1032:
        for (Object localObject1 = getStr(2131231236);; str = getStr(2131231237))
        {
            this.ai.add(a(getStr(2131231036), 2130837689, (String)localObject1 + "", this.ab));
            this.ai.add(a(getStr(2131231034), 2130837679, "", this.ac));
            this.ai.add(a(getStr(2131231035), 2130837688, "", this.ac));
            this.ag = new DeviceOptionListAdapter();
            this.ag.setItem(this.ai);
            this.ah.setAdapter(this.ag);
            this.ah.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                {
                    paramAnonymousAdapterView = (ListView)paramAnonymousAdapterView;
                    switch (paramAnonymousInt)
                    {
                        default:
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            do
                            {
                                do
                                {
                                    return;
                                    if (DeviceOptionHomeActivity.this.U.selectedDeviceVo.getVersionCode() < DeviceOptionHomeActivity.this.U.selectedDeviceVo.getLastVersionCode())
                                    {
                                        DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131230896), "DIALOG_OK_CANCEL", new View.OnClickListener()
                                        {
                                            public void onClick(View paramAnonymous2View)
                                            {
                                                paramAnonymous2View = new HashMap();
                                                paramAnonymous2View.put("locale", Constant.SYSTEM_LOCALE);
                                                paramAnonymous2View.put("deviceId", DeviceOptionHomeActivity.this.U.selectedDeviceVo.getDeviceId() + "");
                                                new HttpAsyncTask(DeviceOptionHomeActivity.this.x, paramAnonymous2View).execute(new String[] { "http://api.bluecanvas.com/mobileLauncherAppUpdate.do" });
                                            }
                                        }, DeviceOptionHomeActivity.a(DeviceOptionHomeActivity.this));
                                        return;
                                    }
                                    Toast.makeText(DeviceOptionHomeActivity.this.V, DeviceOptionHomeActivity.this.getStr(2131231145), 0).show();
                                    return;
                                    paramAnonymousAdapterView = new Intent(DeviceOptionHomeActivity.this.V, DeviceOptionNameChangeActivity.class);
                                    DeviceOptionHomeActivity.this.startActivityForResult(paramAnonymousAdapterView, DeviceOptionHomeActivity.b(DeviceOptionHomeActivity.this));
                                    return;
                                } while (!BluetoothService.b(DeviceOptionHomeActivity.this));
                                DeviceOptionHomeActivity.this.b(DeviceOptionNetworkSelectBluetoothActivity.class);
                                return;
                            } while (!BluetoothService.b(DeviceOptionHomeActivity.this));
                            DeviceOptionHomeActivity.this.b(DeviceOptionSpeakerSelectBluetoothActivity.class);
                            return;
                        case 4:
                            paramAnonymousAdapterView = new Intent(DeviceOptionHomeActivity.this.V, DeviceOptionBrightnessChangeActivity.class);
                            DeviceOptionHomeActivity.this.startActivityForResult(paramAnonymousAdapterView, DeviceOptionHomeActivity.b(DeviceOptionHomeActivity.this));
                            return;
                        case 5:
                            paramAnonymousAdapterView = new Intent(DeviceOptionHomeActivity.this.V, DeviceOptionScheduleActivity.class);
                            DeviceOptionHomeActivity.this.startActivityForResult(paramAnonymousAdapterView, DeviceOptionHomeActivity.b(DeviceOptionHomeActivity.this));
                            return;
                        case 6:
                            paramAnonymousAdapterView = new Intent(DeviceOptionHomeActivity.this.V, DeviceOptionSlideEffectActivity.class);
                            DeviceOptionHomeActivity.this.startActivityForResult(paramAnonymousAdapterView, DeviceOptionHomeActivity.b(DeviceOptionHomeActivity.this));
                            return;
                        case 7:
                            paramAnonymousAdapterView = new Intent(DeviceOptionHomeActivity.this.V, DeviceOptionSlideTimeActivity.class);
                            DeviceOptionHomeActivity.this.startActivityForResult(paramAnonymousAdapterView, DeviceOptionHomeActivity.b(DeviceOptionHomeActivity.this));
                            return;
                        case 8:
                            paramAnonymousAdapterView = new Intent(DeviceOptionHomeActivity.this.V, DeviceOptionImageScaleActivity.class);
                            DeviceOptionHomeActivity.this.startActivityForResult(paramAnonymousAdapterView, DeviceOptionHomeActivity.b(DeviceOptionHomeActivity.this));
                            return;
                        case 9:
                            if (!DeviceOptionHomeActivity.this.U.selectedDeviceVo.getDeviceHeight().equals(DeviceOptionHomeActivity.this.U.selectedDeviceVo.getDeviceWidth()))
                            {
                                paramAnonymousAdapterView = new Intent(DeviceOptionHomeActivity.this.V, DeviceOptionRotationActivity.class);
                                DeviceOptionHomeActivity.this.startActivityForResult(paramAnonymousAdapterView, DeviceOptionHomeActivity.b(DeviceOptionHomeActivity.this));
                                return;
                            }
                            DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231008), "DIALOG_OK_CANCEL", DeviceOptionHomeActivity.c(DeviceOptionHomeActivity.this), DeviceOptionHomeActivity.a(DeviceOptionHomeActivity.this));
                            return;
                        case 10:
                            if (!DeviceOptionHomeActivity.this.U.selectedDeviceVo.getDeviceHeight().equals(DeviceOptionHomeActivity.this.U.selectedDeviceVo.getDeviceWidth()))
                            {
                                DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231008), "DIALOG_OK_CANCEL", DeviceOptionHomeActivity.c(DeviceOptionHomeActivity.this), DeviceOptionHomeActivity.a(DeviceOptionHomeActivity.this));
                                return;
                            }
                            DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231005), "DIALOG_OK_CANCEL", DeviceOptionHomeActivity.d(DeviceOptionHomeActivity.this), DeviceOptionHomeActivity.a(DeviceOptionHomeActivity.this));
                            return;
                    }
                    DeviceOptionHomeActivity.this.a(DeviceOptionHomeActivity.this, DeviceOptionHomeActivity.this.getStr(2131231005), "DIALOG_OK_CANCEL", DeviceOptionHomeActivity.d(DeviceOptionHomeActivity.this), DeviceOptionHomeActivity.a(DeviceOptionHomeActivity.this));
                }
            });
            return;
            LOG.c(z, "TEST ==== ????");
            try
            {
                String[] arrayOfString = this.U.selectedDeviceVo.getAppVersion().split("\\.");
                localObject1 = "20";
                int i = 0;
                for (;;)
                {
                    localObject2 = localObject1;
                    if (i >= 3) {
                        break;
                    }
                    localObject2 = (String)localObject1 + arrayOfString[(i + 2)];
                    localObject1 = localObject2;
                    if (i != 2) {
                        localObject1 = (String)localObject2 + ".";
                    }
                    i += 1;
                }
            }
            catch (Exception localException)
            {
                localException.printStackTrace();
                localObject2 = this.U.selectedDeviceVo.getAppVersion();
                this.ai.add(a(getStr(2131230898), 2130837698, (String)localObject2, this.ab));
            }
            str = getStr(2131231049);
            break label371;
            this.ai.add(a(getStr(2131231038), 2130837685, getStr(2131231013), this.ab));
            break label449;
            this.ai.add(a(getStr(2131231029), 2130837687, getStr(2131230991), this.ab));
            break label593;
        }
    }

    public void j()
    {
        this.ah = ((ListView)findViewById(2131624105));
        findViewById(2131624206).setVisibility(0);
    }

    public void k()
    {
        a(3);
        setmActionBarTitle(getStr(2131230892));
    }

    public void leftBtnClick(View paramView)
    {
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        LOG.c(z, "requestCode: " + paramInt1);
        LOG.c(z, "resultCode: " + paramInt2);
        if ((paramInt1 == this.ae) && (paramInt2 == -1))
        {
            a(DeviceListActivity.class, true);
            finish();
        }
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130968632);
        w();
        this.V = this;
        k();
        j();
    }

    public void onResume()
    {
        super.onResume();
        y();
    }

    class DeviceOptionListAdapter
            extends BaseAdapter
    {
        private ArrayList<DeviceOptionVo> b;

        DeviceOptionListAdapter() {}

        public int getCount()
        {
            return this.b.size();
        }

        public DeviceOptionVo getItem(int paramInt)
        {
            return (DeviceOptionVo)this.b.get(paramInt);
        }

        public long getItemId(int paramInt)
        {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
        {
            DeviceOptionVo localDeviceOptionVo = (DeviceOptionVo)this.b.get(paramInt);
            View localView;
            if (paramView == null)
            {
                localView = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater")).inflate(2130968720, paramViewGroup, false);
                paramView = new DeviceOptionHomeActivity.ViewHolder();
                paramView.a = ((TextView)localView.findViewById(2131624435));
                paramView.b = ((ImageView)localView.findViewById(2131624060));
                paramView.f = ((LinearLayout)localView.findViewById(2131624437));
                paramView.g = ((LinearLayout)localView.findViewById(2131624440));
                paramView.e = ((ProgressBar)localView.findViewById(2131624439));
                paramView.d = ((TextView)localView.findViewById(2131624438));
                paramView.c = ((TextView)localView.findViewById(2131624441));
                paramView.h = ((FrameLayout)localView.findViewById(2131624436));
                paramView.j = ((ImageView)localView.findViewById(2131624442));
                paramView.c = ((TextView)localView.findViewById(2131624441));
                paramView.i = ((FrameLayout)localView.findViewById(2131624433));
                paramView.b.setImageResource(localDeviceOptionVo.getIconId());
                paramView.a.setText(localDeviceOptionVo.getDeviceOptionName());
                if (localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.l(DeviceOptionHomeActivity.this)))
                {
                    paramView.g.setVisibility(0);
                    paramView.c.setText(localDeviceOptionVo.getSubName());
                    localView.setTag(paramView);
                    paramViewGroup = paramView;
                    label270:
                    paramViewGroup.b.setImageResource(localDeviceOptionVo.getIconId());
                    paramViewGroup.a.setText(localDeviceOptionVo.getDeviceOptionName());
                    if (!localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.l(DeviceOptionHomeActivity.this))) {
                        break label562;
                    }
                    paramViewGroup.g.setVisibility(0);
                    paramViewGroup.c.setText(localDeviceOptionVo.getSubName());
                }
            }
            for (;;)
            {
                if (paramInt == 0) {
                    paramViewGroup.j.setVisibility(8);
                }
                if (paramInt == 11)
                {
                    paramViewGroup.g.setVisibility(4);
                    paramViewGroup.j.setVisibility(4);
                }
                if (StringUtils.a(DeviceOptionHomeActivity.this).equals("ja"))
                {
                    if (paramInt != 1) {
                        break label711;
                    }
                    paramViewGroup.a.setTextScaleX(0.75F);
                }
                return localView;
                float f;
                if (localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.m(DeviceOptionHomeActivity.this)))
                {
                    paramView.f.setVisibility(0);
                    paramView.e.setMax(localDeviceOptionVo.getMaxSize());
                    paramView.e.setProgress(localDeviceOptionVo.getUseSize());
                    f = (float)(Math.round(localDeviceOptionVo.getUseSize() / localDeviceOptionVo.getMaxSize() * 100.0F * 100.0F) / 100.0D);
                    paramView.d.setText(f + "%");
                    break;
                }
                if ((localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.n(DeviceOptionHomeActivity.this))) || (!localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.o(DeviceOptionHomeActivity.this)))) {
                    break;
                }
                break;
                paramViewGroup = (DeviceOptionHomeActivity.ViewHolder)paramView.getTag();
                localView = paramView;
                break label270;
                label562:
                if (localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.m(DeviceOptionHomeActivity.this)))
                {
                    paramViewGroup.f.setVisibility(0);
                    paramViewGroup.e.setMax(localDeviceOptionVo.getMaxSize());
                    paramViewGroup.e.setProgress(localDeviceOptionVo.getUseSize());
                    f = (float)(Math.round(localDeviceOptionVo.getUseSize() / localDeviceOptionVo.getMaxSize() * 100.0F * 100.0F) / 100.0D);
                    paramViewGroup.d.setText(f + "%");
                }
                else if ((localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.n(DeviceOptionHomeActivity.this))) || (!localDeviceOptionVo.getType().equals(DeviceOptionHomeActivity.o(DeviceOptionHomeActivity.this)))) {}
            }
            label711:
            paramViewGroup.a.setTextScaleX(1.0F);
            return localView;
        }

        public void setItem(ArrayList<DeviceOptionVo> paramArrayList)
        {
            this.b = paramArrayList;
        }
    }

    static class ViewHolder
    {
        TextView a;
        ImageView b;
        TextView c;
        TextView d;
        ProgressBar e;
        LinearLayout f;
        LinearLayout g;
        FrameLayout h;
        FrameLayout i;
        ImageView j;
    }
}

