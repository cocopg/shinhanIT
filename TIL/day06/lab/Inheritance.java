package com.shinhan.day06.lab;

class C2 extends B2{ 
    int meth()  { return 100; } 
    static int sMeth() { return 100; } 
} 

class B2 extends A2 { 
    int meth()  { return 10; } 
    static int sMeth() { return 10; } 
} 

class A2 { 
    int meth()  { return 1; } 
    static int sMeth() { return 1; } 
} 
 
public class Inheritance { 
    public static void main(String[] args){ 
        C2 c = new C2(); //객체생성은 C, 자식 생성시 부모도 생성
        B2 b = (B2) c; //강제형변환
        A2 a = (A2) c; //강제형변환
        
        if( a instanceof A2 ) {
            System.out.println( "a는 A의 인스턴스 이다.");
        }        
        if( a instanceof B2) {
            System.out.println( "a는 B의 인스턴스 이다.");
        }
        if( a instanceof C2) {
            System.out.println( "a는 C의 인스턴스 이다.");
        }
        
        System.out.println(a.meth() + " " + b.meth() + " " + c.meth()
                      + a.sMeth() + " " + b.sMeth() + " " + c.sMeth() ); 
        
        System.out.println();
    } 
}

