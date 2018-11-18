package classes;

import interfaces.InterfaceWithDefaultMethod;

public class ClassForInterface implements InterfaceWithDefaultMethod {


    public void foo() {
        System.out.println("Cls -> foo()");
    }

    @Override
    public void bar() {
        System.out.println("Cls -> bar()");
    }


    @Override
    public void baz() {
        System.out.println("Cls -> baz()");
    }


}