package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.app.IApplicationThread;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.IWindowManager;
import java.io.IOException;
/* renamed from: com.android.commands.motifcore.a  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0006a extends AbstractC0008c {
    long a;
    private ComponentName o;

    public C0006a(ComponentName componentName) {
        super(4);
        this.a = 0L;
        this.o = componentName;
    }

    public C0006a(ComponentName componentName, long j) {
        super(4);
        this.a = 0L;
        this.o = componentName;
        this.a = j;
    }

    private Intent e() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(this.o);
        intent.addFlags(270532608);
        return intent;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        Intent e = e();
        if (i > 0) {
            System.out.println(":Switch: " + e.toUri(0));
        }
        if (this.a != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("alarmTime", this.a);
            e.putExtras(bundle);
        }
        try {
            iActivityManager.startActivity((IApplicationThread) null, (String) null, e, (String) null, (IBinder) null, (String) null, 0, 0, (String) null, (ParcelFileDescriptor) null, (Bundle) null);
            if (!Motifcore.g) {
                try {
                    a(e);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return 1;
        } catch (RemoteException e3) {
            System.err.println("** Failed talking with activity manager!");
            return -1;
        } catch (SecurityException e4) {
            if (i > 0) {
                System.out.println("** Permissions error starting activity " + e.toUri(0));
            }
            return -2;
        }
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public void a(Intent intent) {
        StringBuffer stringBuffer = new StringBuffer();
        ComponentName component = intent.getComponent();
        String className = component.getClassName();
        String packageName = component.getPackageName();
        stringBuffer.append("LaunchActivity(");
        stringBuffer.append(packageName + ",");
        stringBuffer.append(className + ")\n");
        Motifcore.e.write(stringBuffer.toString());
    }
}
