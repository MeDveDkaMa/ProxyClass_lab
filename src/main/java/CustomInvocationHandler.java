import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class CustomInvocationHandler implements InvocationHandler {


    private MyClass myClassOriginal;

    public CustomInvocationHandler(MyClass myClass) {
        this.myClassOriginal = myClass;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Invoke: " + method.getName());

        Method mth = myClassOriginal.getClass().getMethod(method.getName(),(Class<?>[]) method.getParameterTypes());

        Logged logged = mth.getAnnotation(Logged.class);

        Logger logger = LogManager.getLogger(logged.nameOfClass());

        switch (logged.type()){
            case ERROR:
                logger.error(mth);
                break;
            case INFO:
                logger.info(mth);
                break;
            case WARN:
                logger.warn(mth);
                break;
        }
     return method.invoke(myClassOriginal,args);
    }
}
