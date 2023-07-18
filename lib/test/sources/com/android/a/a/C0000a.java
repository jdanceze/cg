package com.android.a.a;

import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.util.Xml;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;
/* renamed from: com.android.a.a.a  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0000a {
    private static final String a = C0000a.class.getSimpleName();
    private static final String[] b = {GridView.class.getName(), GridLayout.class.getName(), ListView.class.getName(), TableLayout.class.getName()};

    private static String a(CharSequence charSequence) {
        return charSequence == null ? "" : b(charSequence);
    }

    public static void a(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2, int i3) {
        File file = new File(Environment.getDataDirectory(), "local");
        if (!file.exists()) {
            file.mkdir();
            file.setExecutable(true, false);
            file.setWritable(true, false);
            file.setReadable(true, false);
        }
        a(accessibilityNodeInfo, new File(new File(Environment.getDataDirectory(), "local"), "window_dump.xml"), i, i2, i3);
    }

    public static void a(AccessibilityNodeInfo accessibilityNodeInfo, File file, int i, int i2, int i3) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            FileWriter fileWriter = new FileWriter(file);
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument("UTF-8", true);
            newSerializer.startTag("", "hierarchy");
            newSerializer.attribute("", "rotation", Integer.toString(i));
            a(accessibilityNodeInfo, newSerializer, 0, i2, i3);
            newSerializer.endTag("", "hierarchy");
            newSerializer.endDocument();
            fileWriter.write(stringWriter.toString());
            fileWriter.close();
        } catch (IOException e) {
            Log.e(a, "failed to dump window to file", e);
        }
        Log.w(a, "Fetch time: " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    private static void a(AccessibilityNodeInfo accessibilityNodeInfo, XmlSerializer xmlSerializer, int i, int i2, int i3) {
        xmlSerializer.startTag("", "node");
        if (!c(accessibilityNodeInfo) && !b(accessibilityNodeInfo)) {
            xmlSerializer.attribute("", "NAF", Boolean.toString(true));
        }
        xmlSerializer.attribute("", "index", Integer.toString(i));
        xmlSerializer.attribute("", "text", a(accessibilityNodeInfo.getText()));
        xmlSerializer.attribute("", "resource-id", a(accessibilityNodeInfo.getViewIdResourceName()));
        xmlSerializer.attribute("", "class", a(accessibilityNodeInfo.getClassName()));
        xmlSerializer.attribute("", "package", a(accessibilityNodeInfo.getPackageName()));
        xmlSerializer.attribute("", "content-desc", a(accessibilityNodeInfo.getContentDescription()));
        xmlSerializer.attribute("", "checkable", Boolean.toString(accessibilityNodeInfo.isCheckable()));
        xmlSerializer.attribute("", "checked", Boolean.toString(accessibilityNodeInfo.isChecked()));
        xmlSerializer.attribute("", "clickable", Boolean.toString(accessibilityNodeInfo.isClickable()));
        xmlSerializer.attribute("", "enabled", Boolean.toString(accessibilityNodeInfo.isEnabled()));
        xmlSerializer.attribute("", "focusable", Boolean.toString(accessibilityNodeInfo.isFocusable()));
        xmlSerializer.attribute("", "focused", Boolean.toString(accessibilityNodeInfo.isFocused()));
        xmlSerializer.attribute("", "scrollable", Boolean.toString(accessibilityNodeInfo.isScrollable()));
        xmlSerializer.attribute("", "long-clickable", Boolean.toString(accessibilityNodeInfo.isLongClickable()));
        xmlSerializer.attribute("", "password", Boolean.toString(accessibilityNodeInfo.isPassword()));
        xmlSerializer.attribute("", "selected", Boolean.toString(accessibilityNodeInfo.isSelected()));
        xmlSerializer.attribute("", "bounds", C0001b.a(accessibilityNodeInfo, i2, i3).toShortString());
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
            if (child == null) {
                Log.i(a, String.format("Null child %d/%d, parent: %s", Integer.valueOf(i4), Integer.valueOf(childCount), accessibilityNodeInfo.toString()));
            } else if (child.isVisibleToUser()) {
                a(child, xmlSerializer, i4, i2, i3);
                child.recycle();
            } else {
                Log.i(a, String.format("Skipping invisible child: %s", child.toString()));
            }
        }
        xmlSerializer.endTag("", "node");
    }

    private static boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (!a(child.getContentDescription()).isEmpty() || !a(child.getText()).isEmpty() || a(child)) {
                return true;
            }
        }
        return false;
    }

    private static String b(CharSequence charSequence) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if ((charAt < 1 || charAt > '\b') && ((charAt < 11 || charAt > '\f') && ((charAt < 14 || charAt > 31) && ((charAt < 127 || charAt > 132) && ((charAt < 134 || charAt > 159) && ((charAt < 64976 || charAt > 64991) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && ((charAt < 65534 || charAt > 65535) && (charAt < 65534 || charAt > 65535)))))))))))))))))))))) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append(".");
            }
        }
        return stringBuffer.toString();
    }

    private static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled() && a(accessibilityNodeInfo.getContentDescription()).isEmpty() && a(accessibilityNodeInfo.getText()).isEmpty()) {
            return a(accessibilityNodeInfo);
        }
        return true;
    }

    private static boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        String a2 = a(accessibilityNodeInfo.getClassName());
        for (String str : b) {
            if (a2.endsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
