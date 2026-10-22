package com.company;

public class OOPEvaluator2 { // varianta cu compunere

    final private Evaluator e;

    public OOPEvaluator2(Evaluator e) {
        this.e = e;
    }

    public int evaluateTest(int noProblems) {
        int total = e.evaluateTest(noProblems);
        return total+1;
    }
}
