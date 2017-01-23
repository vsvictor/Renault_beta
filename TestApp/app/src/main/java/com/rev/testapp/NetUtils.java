package com.rev.testapp;

import android.text.format.Formatter;
import android.util.Log;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by victor on 16.01.17.
 */

public class NetUtils {
    private static final String TAG = NetUtils.class.getSimpleName();

        public static String getLocalIpAddress () {
            try {
                for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                    NetworkInterface intf = en.nextElement();
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            //String ip = Formatter.formatIpAddress(inetAddress.hashCode());
                            //Log.i(TAG, "***** IP=" + ip);
                           return inetAddress.toString();
                        }
                    }
                }
            } catch (SocketException ex) {
                Log.e(TAG, ex.toString());
            }
            return null;
        }
    }
