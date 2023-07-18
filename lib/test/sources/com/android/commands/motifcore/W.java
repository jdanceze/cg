package com.android.commands.motifcore;

import android.app.UiAutomation;
import android.app.UiAutomationConnection;
import android.content.pm.IPackageManager;
import android.os.HandlerThread;
import android.os.ServiceManager;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityNodeInfo;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class W {
    protected static UiAutomation a = null;
    private static final String b = "Error retrieving class information";
    private static final String d = "UiAutomationHandlerThread";
    private static final String e = "No accessibility event has occured yet";
    private static final String f = "Failed to connect to AccessibilityService, try restarting Monkey";
    private static final String g = "Node with given ID does not exist";
    private static final String h = "Unable to retrieve application info from PackageManager";
    private static final HandlerThread j;
    private static IPackageManager k = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
    private static Map i = new HashMap();
    private static final Map c = new HashMap();

    static {
        c.put("getlocation", new ad());
        c.put("gettext", new ah());
        c.put("getclass", new aa());
        c.put("getchecked", new Y());
        c.put("getenabled", new ab());
        c.put("getselected", new ag());
        c.put("setselected", new am());
        c.put("getfocused", new ac());
        c.put("setfocused", new al());
        c.put("getparent", new ae());
        c.put("getchildren", new Z());
        c.put("getaccessibilityids", new X());
        j = new HandlerThread(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccessibilityNodeInfo b(String str) {
        List findAccessibilityNodeInfosByViewId = AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfosByViewId(a.getConnectionId(), -1, AccessibilityNodeInfo.ROOT_NODE_ID, str);
        if (findAccessibilityNodeInfosByViewId.isEmpty()) {
            return null;
        }
        return (AccessibilityNodeInfo) findAccessibilityNodeInfosByViewId.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class c(String str, String str2) {
        Class cls = (Class) i.get(str);
        if (cls == null) {
            Class loadClass = new DexClassLoader(str2, "/data/local/tmp", null, ClassLoader.getSystemClassLoader()).loadClass(str + ".R$id");
            i.put(str, loadClass);
            return loadClass;
        }
        return cls;
    }

    public static void c() {
        j.setDaemon(true);
        j.start();
        a = new UiAutomation(j.getLooper(), new UiAutomationConnection());
        a.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccessibilityNodeInfo d(String str, String str2) {
        int parseInt = Integer.parseInt(str);
        int parseInt2 = Integer.parseInt(str2);
        return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(a.getConnectionId(), parseInt, parseInt2, false, 0);
    }

    public static void d() {
        j.quit();
    }
}
