package com.android.commands.motifcore;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class au {
    private static final Date a = new Date();
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ");
    private static final Pattern c = Pattern.compile("<string(.+?)>(.+?)</string>");

    private au() {
    }

    public static Boolean a(String str) {
        try {
            Process exec = Runtime.getRuntime().exec("su");
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            dataOutputStream.writeBytes(str + "\n");
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            exec.waitFor();
            System.out.println("Here is the standard output of the command:\n");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return true;
                }
                System.out.println(readLine);
            }
        } catch (IOException e) {
            return false;
        } catch (InterruptedException e2) {
            return false;
        }
    }

    public static String a(long j) {
        String format;
        synchronized (au.class) {
            try {
                a.setTime(j);
                format = b.format(a);
            } catch (Throwable th) {
                throw th;
            }
        }
        return format;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean a(File file, File file2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        Exception e;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream2 = new FileInputStream(file2);
                try {
                    boolean a2 = a(fileInputStream, fileInputStream2);
                    a(fileInputStream);
                    a(fileInputStream2);
                    return a2;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        a(fileInputStream);
                        a(fileInputStream2);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        a(fileInputStream);
                        a(fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a(fileInputStream);
                    a(fileInputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = null;
            }
        } catch (Exception e4) {
            fileInputStream = null;
            fileInputStream2 = null;
            e = e4;
        } catch (Throwable th5) {
            fileInputStream = null;
            th = th5;
            fileInputStream2 = null;
        }
    }

    public static boolean a(InputStream inputStream, InputStream inputStream2) {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        int read = inputStream.read();
        while (true) {
            if (-1 != read) {
                if (read != inputStream2.read()) {
                    break;
                }
                read = inputStream.read();
            } else if (inputStream2.read() == -1) {
                return true;
            }
        }
        return false;
    }

    public static List b(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = c.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(2));
        }
        return arrayList;
    }

    public static String c(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        char[] cArr = new char[1024];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                bufferedReader.close();
                return stringBuffer.toString();
            }
            stringBuffer.append(String.valueOf(cArr, 0, read));
        }
    }
}
