package com.android.commands.motifcore;

import android.content.pm.IPackageManager;
import android.os.RemoteException;
import android.os.UserHandle;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class aj implements InterfaceC0030y {
    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        IPackageManager iPackageManager;
        Class c;
        Field[] fields;
        AccessibilityNodeInfo rootInActiveWindow = W.a.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return new C0031z(false, "No accessibility event has occured yet");
        }
        String obj = rootInActiveWindow.getPackageName().toString();
        try {
            iPackageManager = W.k;
            c = W.c(obj, iPackageManager.getApplicationInfo(obj, 0, UserHandle.myUserId()).sourceDir);
            StringBuilder sb = new StringBuilder();
            int length = c.getFields().length;
            for (int i = 0; i < length; i++) {
                sb.append(fields[i].getName() + " ");
            }
            return new C0031z(true, sb.toString());
        } catch (RemoteException e) {
            return new C0031z(false, "Unable to retrieve application info from PackageManager");
        } catch (ClassNotFoundException e2) {
            return new C0031z(false, "Error retrieving class information");
        }
    }
}
