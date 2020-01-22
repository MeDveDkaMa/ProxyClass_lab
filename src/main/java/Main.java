import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Main {

    private static final String CLASSFORTEST = "java.lang.String";
    //private static final String CLASSFORTEST = "java.lang.reflect.Method";

    public static void main(String[] args) {
        Information info = new Information();

        MyClass myClass = new MyClass();
        ClassLoader classLoader = myClass.getClass().getClassLoader();
        Class<?>[] interfaces = myClass.getClass().getInterfaces();
        TestInterface myClass2 = (TestInterface) Proxy.newProxyInstance(classLoader,interfaces,new CustomInvocationHandler(new MyClass()));
        myClass2.PrintMessage2();
        myClass2.PrintMessage("DS");


        info.getInfo(MyClass.class);
        info.printClass();

        }
}
