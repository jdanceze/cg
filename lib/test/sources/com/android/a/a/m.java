package com.android.a.a;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.app.UiAutomation;
import android.content.IContentProvider;
import android.database.Cursor;
import android.hardware.display.DisplayManagerGlobal;
import android.os.Binder;
import android.os.ICancellationSignal;
import android.os.IPowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.IWindowManager;
/* loaded from: classes.dex */
public class m extends w {
    private static final String a = m.class.getSimpleName();

    public m(UiAutomation uiAutomation) {
        super(uiAutomation);
    }

    @Override // com.android.a.a.w
    public Display a() {
        return DisplayManagerGlobal.getInstance().getRealDisplay(0);
    }

    @Override // com.android.a.a.w
    public int b() {
        try {
            return IWindowManager.Stub.asInterface(ServiceManager.getService("window")).getRotation();
        } catch (RemoteException e) {
            Log.e(a, "Error getting screen rotation", e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.android.a.a.w
    public long c() {
        Cursor cursor;
        Cursor query;
        IContentProvider iContentProvider = null;
        try {
            IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            String authority = Settings.Secure.CONTENT_URI.getAuthority();
            Binder binder = new Binder();
            try {
                IActivityManager.ContentProviderHolder contentProviderExternal = iActivityManager.getContentProviderExternal(authority, 0, binder);
                if (contentProviderExternal == null) {
                    throw new IllegalStateException("Could not find provider: " + authority);
                }
                IContentProvider iContentProvider2 = contentProviderExternal.provider;
                try {
                    query = iContentProvider2.query((String) null, Settings.Secure.CONTENT_URI, new String[]{"value"}, "name=?", new String[]{"long_press_timeout"}, (String) null, (ICancellationSignal) null);
                } catch (Throwable th) {
                    cursor = null;
                    iContentProvider = iContentProvider2;
                    th = th;
                }
                try {
                    long j = query.moveToFirst() ? query.getInt(0) : 0L;
                    if (query != null) {
                        query.close();
                    }
                    if (iContentProvider2 != null) {
                        iActivityManager.removeContentProviderExternal(authority, binder);
                    }
                    return j;
                } catch (Throwable th2) {
                    iContentProvider = iContentProvider2;
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (iContentProvider != null) {
                        iActivityManager.removeContentProviderExternal(authority, binder);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } catch (RemoteException e) {
            Log.e(a, "Error reading long press timeout setting.", e);
            throw new RuntimeException("Error reading long press timeout setting.", e);
        }
    }

    @Override // com.android.a.a.w
    public boolean d() {
        try {
            return IPowerManager.Stub.asInterface(ServiceManager.getService("power")).isScreenOn();
        } catch (RemoteException e) {
            Log.e(a, "Error getting screen status", e);
            throw new RuntimeException(e);
        }
    }
}
