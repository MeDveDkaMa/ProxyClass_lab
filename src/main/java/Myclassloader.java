import java.io.*;

public class Myclassloader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream ins = null;

        File f = new File(name+".class");
        if(!f.isFile())
            throw new ClassNotFoundException("Нет такого класса " + name);
        try{
            //С помощью потока считываем файл в массив байт
            ins = new BufferedInputStream(new FileInputStream(f));
            byte[]b = new byte[(int)f.length()];
            ins.read(b);
            //С помощью функции defineClass загружаем класс
            Class c = defineClass("MyClass", b, 0, b.length);
            return c;
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }
        finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

