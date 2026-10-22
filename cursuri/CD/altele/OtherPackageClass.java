package com.company.package2;

import com.company.package1.BaseClass;

public class OtherPackageClass {

    private BaseClass baseObject;

    public void doWork() {
        baseObject.publicField++;
        baseObject.privateField++;
        baseObject.protectedField++;
        baseObject.defaultField++;
    }

}
