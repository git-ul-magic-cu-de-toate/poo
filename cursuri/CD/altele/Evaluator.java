package com.company;

public class Evaluator {

    // old version - works fine

    public int evaluateProblem() {
        return 1;
    }

    public int evaluateTest(int noProblems) {
        int total = 0;
        for (int i=0; i<noProblems; i++) {
            total += evaluateProblem();
        }
        return total;
    }


    // new version - error if OOPEvaluator is not changed as well

//    public int evaluateProblem() {
//        return evaluateTest(1);
//    }
//
//    public int evaluateTest(int noProblems) {
//        // connect to server to get solutions
//        int total = 0;
//        for (int i=0; i<noProblems; i++) {
//            total += 1;
//        }
//        return total;
//    }

}
