package test.interfaces;

import java.util.Collections;

@FunctionalInterface
public interface FunctionalInterfaceTest {

     void toto() ;

    static void titi() {
    }

    static void tutu() {
        System.out.println("je teste");
    }

    public default void foo() {
        System.out.println("Default implementation of foo()");
    }

    public default void fodo() {
        System.out.println("Second Default implementation of foo()");
    }
}
