package com.company;

public class Main {

    public static void main(String[] args) {

        Evaluator e = new Evaluator();
        //Evaluator oopev = new OOPEvaluator();
        OOPEvaluator2 oopev = new OOPEvaluator2(e);
        System.out.println(oopev.evaluateTest(10));


        SingletonLazy.getInstance().doMagic();
        SingletonLazy.doMagic();

    }
}
