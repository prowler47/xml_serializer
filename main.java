package dragunovskiy_sergey.xml_serializer;

import dragunovskiy_sergey.xml_serializer.exceptions.XmlSerializableException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, XmlSerializableException, XmlSerializableException {
        Person ivan = new Person("Ivan", "Ivanov", "Ivanovo");
        Person petr = new Person("Petr", "Petrov", "Petrovo");
        Person maxin = new Person("Maxim", "Maximov", "Maximovo");
        List<Person> listOfObjects = new ArrayList<>();
        listOfObjects.add(ivan);
        listOfObjects.add(petr);
        listOfObjects.add(maxin);
        XmlSerializer<Person> xmlSerializer = new XmlSerializer();
        xmlSerializer.serialize(listOfObjects);
    }

}
