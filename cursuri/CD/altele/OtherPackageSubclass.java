package com.company.package2;

import com.company.package1.BaseClass;

public class OtherPackageSubclass extends BaseClass {

    public void doWork() {
        publicField++;
        privateField++;
        protectedField++;
        defaultField++;
    }

}
