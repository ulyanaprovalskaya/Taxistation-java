package serialization;

import com.thoughtworks.xstream.XStream;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.*;

public class Serializer<T> {
    private static final Logger logger = LogManager.getLogger(Serializer.class);
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

    public void serialize(T obj, String filepath) {
        try {
            FileOutputStream writer = new FileOutputStream(filepath);
            xs.toXML(obj, writer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("File wasn't found");
        }
    }

    public void deserialize(T obj, String filepath){
        try{
            FileInputStream reader = new FileInputStream(filepath);
            xs.fromXML(reader, obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("File wasn't found");
        }

    }

}
