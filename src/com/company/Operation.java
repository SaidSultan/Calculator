package com.company;

public class Operation {

    public static  int Sum(int a, int b, char op){
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '/':
                result = a / b;
                break;
            case '*':
                result = a * b;
                break;
            default:
                new Exception("Арифметический символ не распознан. программа завершается");
                break;
        }
        return result;
    }
}
