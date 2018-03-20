package singleton;

public final class SingletonSansSolution {

    private static SingletonSansSolution theInstance = null;

    private SingletonSansSolution () {

    }

    public static final synchronized SingletonSansSolution getInstance () {
        if (theInstance == null) {
            theInstance =  new SingletonSansSolution ();
        }
        return theInstance ;
    }
}
