import javax.xml.bind.annotation.XmlElement;

public class MyClass implements TestInterface{

    private int a;

    @Logged(type = Type.ERROR, nameOfClass = MyClass.class)
    public void PrintMessage(String message) {

        System.out.println(message + " from first class");
    }

    @Logged(type = Type.INFO, nameOfClass = MyClass.class)
    public void PrintMessage2() {
        System.out.println("Test PrintMessage2");

    }

    @XmlElement
    public static void  CallTest(){

        System.out.println("Hello from MyClass");

    }

}
