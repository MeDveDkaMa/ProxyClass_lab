import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Information {

    public static StringBuilder sb = new StringBuilder();

    public void getInfo(Class clazz) {
        getAnnotation(clazz);
        getNameClass(clazz);
        getFields(clazz);
        getMethods(clazz);
        getInterfaces(clazz);
        getParent(clazz);

    }

    public void printClass(){
        System.out.println(Information.sb);

    }

    private void getFields(Class clazz) {
        Field[] field = clazz.getDeclaredFields();
        int cout = field.length;
        sb.append("\nFields: " + getNameClass(clazz) + "\n==========================" + "\t ").append(cout).append("\n");
        for (int i = 0; i < field.length; i++) {
            sb.append(field[i]).append("\n");
        }
    }

    private String getNameClass(Class clazz){
        StringBuffer temp = new StringBuffer();
        temp.append(clazz.getName()).toString();
        return String.valueOf(temp);
    }

    private void getInterfaces(Class clazz) {
        Class[] field = clazz.getInterfaces();
        int cout = field.length;
        sb.append("\nInterfaces: " + getNameClass(clazz) + "\n==========================" + "\t ").append(cout).append("\n");
        for (int i = 0; i < field.length; i++) {
            sb.append(field[i]).append("\n");
        }
    }

    private void getMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        int cout = methods.length;
        sb.append("\nMethods: " + getNameClass(clazz) + "\n==========================" + "\t ").append(cout).append("\n");
        for (int i = 0; i < methods.length; i++) {
            sb.append(methods[i]).append("\n");
        }
    }

    private void getParent(Class clazz) {
        if (clazz.getSuperclass() != null) {
            sb.append("\nSuperclass: " + getNameClass(clazz) + "\n==========================\n" + clazz.getSuperclass().getName()).append("\n");
            getInfo(clazz.getSuperclass());
        }
    }

    private void getAnnotation(Class clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        int cout = annotations.length;
        sb.append("\nAnnotations: " + getNameClass(clazz) + "\n==========================" + "\t ").append(cout).append("\n");
        for (int i = 0; i < annotations.length; i++) {
            sb.append(annotations[i].toString()).append("\n");
        }
    }
}