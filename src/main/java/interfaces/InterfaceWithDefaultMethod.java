package interfaces;

import java.util.Collections;

public interface InterfaceWithDefaultMethod {

    public default void bar() {
        System.out.println("Itf -> bar() [default]");
    }

    /** Implémentation par défaut, non surchargée dans la classe fille */
    public default void baz() {
        System.out.println("Itf -> baz() [default]");
    }
}
