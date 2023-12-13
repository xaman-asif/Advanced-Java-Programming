package org.advancedJavaProgramming.chapter2.scope;

public class ScopeExample {
    public int x = 0;

    public void print() {
        int x = 1;
        System.out.println(x);
        System.out.println(this.x);
    }

    public static void main(String[] args) {
        ScopeExample example = new ScopeExample();
        example.print();
    }
}
