package com.example.testUnit;

public class M {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize");
    }
}
