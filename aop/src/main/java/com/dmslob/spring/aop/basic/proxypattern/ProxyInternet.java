package com.dmslob.spring.aop.basic.proxypattern;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {

    // CTW - compile time weaving
    // RTW - runtime
    // LTW - load time

    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception("Access Denied");
        }
        internet.connectTo(serverHost);
    }
}
