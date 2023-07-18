package com.android.a.a;

import android.app.UiAutomation;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements UiAutomation.OnAccessibilityEventListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // android.app.UiAutomation.OnAccessibilityEventListener
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Object obj;
        boolean z;
        String str;
        String str2;
        Object obj2;
        obj = this.a.f;
        synchronized (obj) {
            switch (accessibilityEvent.getEventType()) {
                case 32:
                    if (accessibilityEvent.getText() != null && accessibilityEvent.getText().size() > 0 && accessibilityEvent.getText().get(0) != null) {
                        this.a.d = accessibilityEvent.getText().get(0).toString();
                        break;
                    }
                    break;
                case 131072:
                    if (accessibilityEvent.getText() != null && accessibilityEvent.getText().size() > 0 && accessibilityEvent.getText().get(0) != null) {
                        this.a.e = accessibilityEvent.getText().get(0).toString();
                    }
                    z = k.a;
                    if (z) {
                        str = k.b;
                        StringBuilder append = new StringBuilder().append("Last text selection reported: ");
                        str2 = this.a.e;
                        Log.d(str, append.append(str2).toString());
                        break;
                    }
                    break;
            }
            obj2 = this.a.f;
            obj2.notifyAll();
        }
    }
}
