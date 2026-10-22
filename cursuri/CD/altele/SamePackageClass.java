package com.company.package1;

public class SamePackageClass {

    private BaseClass baseObject;

    public void doWork() {
        baseObject.publicField++;
        baseObject.privateField++;
        baseObject.protectedField++;
        baseObject.defaultField++;
    }
}
