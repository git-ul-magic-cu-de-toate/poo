package com.company;

public class OOPEvaluator extends Evaluator { // varianta cu mostenire

    @Override
    public int evaluateTest(int noProblems) {
        int total = super.evaluateTest(noProblems);
        return total + 1; // add lecture bonus
    }

}
