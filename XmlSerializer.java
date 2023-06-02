package dragunovskiy_sergey.xml_serializer;


import dragunovskiy_sergey.xml_serializer.annotation.XmlElement;
import dragunovskiy_sergey.xml_serializer.annotation.XmlSerializable;
import dragunovskiy_sergey.xml_serializer.exceptions.XmlSerializableException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class XmlSerializer<T> {
    public List<String> serialize(List<T> objects) throws ClassNotFoundException, IllegalAccessException, XmlSerializableException {
        List<T> listOfObjects = new ArrayList<>();
        List<String> XmlList = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            T objectToCheck = objects.get(i);
            Class<?> clazz = Class.forName(objectToCheck.getClass().getName());
            if (clazz.isAnnotationPresent(XmlSerializable.class)) {
                listOfObjects.add(objectToCheck);
            } else {
                throw new XmlSerializableException("The class with name <" + clazz.getSimpleName() + "> " +
                        "is not annotated with @XmlSerializable");
            }
        }
        for (int i = 0; i < listOfObjects.size(); i++) {
            Field[] fields = listOfObjects.get(i).getClass().getDeclaredFields();
            XmlList.add("<" + listOfObjects.get(i).getClass().getSimpleName() + ">");
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                String valueOfField = (String) fields[j].get(listOfObjects.get(i));
                if (fields[j].isAnnotationPresent(XmlElement.class)) {
                    if (fields[j].getAnnotation(XmlElement.class).key().equals("")) {
                        XmlList.add("<" + fields[j].getName() + ">" + valueOfField + "<" + fields[j].getName() + "/>");
                    } else {
                        XmlList.add("<" + fields[j].getAnnotation(XmlElement.class).key() + ">"
                                + valueOfField + "<"
                                + fields[j].getAnnotation(XmlElement.class).key() + "/>");
                    }
                }
            }
            XmlList.add("<" + listOfObjects.get(i).getClass().getSimpleName() + "/>" + "\n");
        }
        return XmlList;
    }
}

