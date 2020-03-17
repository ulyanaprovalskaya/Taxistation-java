package connection.serialization;

import com.thoughtworks.xstream.XStream;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class Serializer<T> {
    private Class<T> rootClass;
    private Class[] classes;
    private XStream xs;

    public Serializer(Class<T> rootClass, Class[] classes){
        this.rootClass = rootClass;
        this.classes = classes;
        xs = new XStream();
        xs.processAnnotations(rootClass);
        xs.processAnnotations(classes);
    }

    public void serialize(T obj, String filepath) throws IOException {
        FileOutputStream writer = new FileOutputStream(filepath);
        xs.toXML(obj, writer);
    }

    public void deserialize(T obj, String filepath) throws IOException {
        FileInputStream reader = new FileInputStream(filepath);
        xs.fromXML(reader, obj);
    }

}
