package com.worldofthings.protocol.binding;

import java.net.*;
import java.util.Collections;
import java.util.List;

/**
 * Tools and helper Functions for Protocol Binding
 * Created by Johannes on 06.07.2016.
 */
public class BindingTools {


    /**
     * Loops through all addresses of all interfaces and returns the first one that is non-local and IPv4
     * @return candidate IP
     * @throws UnknownHostException bubbled up from deep withing java, can happen if the hostname is not in /etc/hosts
     * @throws SocketException something is borked with the socket
     */
    public static String getIpAddress() throws UnknownHostException, SocketException {
        if(!InetAddress.getLocalHost().isLoopbackAddress())
            return InetAddress.getLocalHost().getHostAddress();
        else {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    //filter to non-local IPv4 (uri constructor is not coping with v6)
                    if (!addr.isLoopbackAddress() && addr instanceof Inet4Address) {
                        //first catch is the best catch
                        return addr.getHostAddress();
                    }
                }
            }
        }
        //return "localhost";

        // well - we tried. but it seems there is only loopback
        return InetAddress.getLocalHost().getHostAddress();
    }
}
