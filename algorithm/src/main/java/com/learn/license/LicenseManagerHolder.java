package com.learn.license;


import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * @author lianshun
 * @date 2021/6/28 4:53 下午
 * @description
 */
public class LicenseManagerHolder {
    private static volatile LicenseManager licenseManager = null;

    private LicenseManagerHolder() {
    }

    public static LicenseManager getLicenseManager(LicenseParam param) {
        if (licenseManager == null) {
            synchronized (LicenseManagerHolder.class) {
                if (licenseManager == null) {
                    licenseManager = new LicenseManager(param);
                }
            }
        }
        return licenseManager;
    }
}
