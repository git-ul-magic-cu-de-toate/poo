package com.company;

public class SingletonLazy {
    private static SingletonLazy instance = null;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }


    public void doMagic(){

    }

    public void doMagic2(){

    }
}
