package com.demo.interfaces;

public interface MyPermCombi {
    private int factorial(int n){
        int fact=1;
        for(int i=1;i<n;i++){
              fact=fact*i;
            }
            return fact;
        }

    default float combination(int n, int r){
        return factorial(n)/(factorial(r)*factorial(n-r));
    }
    default float permutation(int n, int r){
        return factorial(n)/factorial(n-r);
    }
}
