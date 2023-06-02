package dragunovskiy_sergey.xml_serializer;

import dragunovskiy_sergey.xml_serializer.annotation.XmlElement;
import dragunovskiy_sergey.xml_serializer.annotation.XmlSerializable;

@XmlSerializable(key = "Person")
public class Person {
    @XmlElement(key = "firstName")
    private String name;
    @XmlElement(key = "lastName")
    private String surname;
    @XmlElement
    private String address;

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
