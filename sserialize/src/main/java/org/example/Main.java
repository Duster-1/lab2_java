package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class XmlUser {
    private String name;
    private int age;

    public XmlUser() {
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "XmlUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public XmlUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
}



@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class XmlProduct {
    private String name;
    private double price;

    public XmlProduct() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "XmlProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public XmlProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }
}



public class Main {
    public static void main(String[] args) throws IOException {
        EntitySerializer<XmlUser> jsonSerializer = new JsonEntitySerializer<>(XmlUser.class);
        EntitySerializer<XmlUser> xmlSerializer = new XmlEntitySerializer<>(XmlUser.class);
        EntitySerializer<XmlUser> txtSerializer = new TxtEntitySerializer<>(XmlUser.class);
        EntitySerializer<XmlProduct> jsonProductSerializer = new JsonEntitySerializer<>(XmlProduct.class);
        EntitySerializer<XmlProduct> xmlProductSerializer = new XmlEntitySerializer<>(XmlProduct.class);
        EntitySerializer<XmlProduct> txtProductSerializer = new TxtEntitySerializer<>(XmlProduct.class);

        XmlUser user1 = new XmlUser("John Doe", 30);
        XmlUser user2 = new XmlUser("Jane Smith", 25);
        XmlUser user3 = new XmlUser("Bob Johnson", 40);

        XmlProduct product1 = new XmlProduct("Laptop", 1500.0);
        XmlProduct product2 = new XmlProduct("Smartphone", 800.0);
        XmlProduct product3 = new XmlProduct("Tablet", 600.0);

        jsonSerializer.saveToFile(user1, "user1.json");
        jsonSerializer.saveToFile(user2, "user2.json");
        jsonSerializer.saveToFile(user3, "user3.json");

        jsonProductSerializer.saveToFile(product1, "product1.json");
        jsonProductSerializer.saveToFile(product2, "product2.json");
        jsonProductSerializer.saveToFile(product3, "product3.json");

        xmlSerializer.saveToFile(user1, "user1.xml");
        xmlSerializer.saveToFile(user2, "user2.xml");
        xmlSerializer.saveToFile(user3, "user3.xml");

        xmlProductSerializer.saveToFile(product1, "product1.xml");
        xmlProductSerializer.saveToFile(product2, "product2.xml");
        xmlProductSerializer.saveToFile(product3, "product3.xml");

        txtSerializer.saveToFile(user1, "user1.txt");
        txtSerializer.saveToFile(user2, "user2.txt");
        txtSerializer.saveToFile(user3, "user3.txt");

        txtProductSerializer.saveToFile(product1, "product1.txt");
        txtProductSerializer.saveToFile(product2, "product2.txt");
        txtProductSerializer.saveToFile(product3, "product3.txt");

        XmlUser loadedUser1FromJsonFile = jsonSerializer.loadFromFile("user1.json");
        XmlUser loadedUser2FromJsonFile = jsonSerializer.loadFromFile("user2.json");
        XmlUser loadedUser3FromJsonFile = jsonSerializer.loadFromFile("user3.json");

        XmlProduct loadedProduct1FromJsonFile = jsonProductSerializer.loadFromFile("product1.json");
        XmlProduct loadedProduct2FromJsonFile = jsonProductSerializer.loadFromFile("product2.json");
        XmlProduct loadedProduct3FromJsonFile = jsonProductSerializer.loadFromFile("product3.json");

        XmlUser loadedUser1FromXmlFile = xmlSerializer.loadFromFile("user1.xml");
        XmlUser loadedUser2FromXmlFile = xmlSerializer.loadFromFile("user2.xml");
        XmlUser loadedUser3FromXmlFile = xmlSerializer.loadFromFile("user3.xml");

        XmlProduct loadedProduct1FromXmlFile = xmlProductSerializer.loadFromFile("product1.xml");
        XmlProduct loadedProduct2FromXmlFile = xmlProductSerializer.loadFromFile("product2.xml");
        XmlProduct loadedProduct3FromXmlFile = xmlProductSerializer.loadFromFile("product3.xml");

        XmlUser loadedUser1FromTxtFile = txtSerializer.loadFromFile("user1.txt");
        XmlUser loadedUser2FromTxtFile = txtSerializer.loadFromFile("user2.txt");
        XmlUser loadedUser3FromTxtFile = txtSerializer.loadFromFile("user3.txt");

        XmlProduct loadedProduct1FromTxtFile = txtProductSerializer.loadFromFile("product1.txt");
        XmlProduct loadedProduct2FromTxtFile = txtProductSerializer.loadFromFile("product2.txt");
        XmlProduct loadedProduct3FromTxtFile = txtProductSerializer.loadFromFile("product3.txt");

        System.out.println("Loaded User1 from JSON: " + loadedUser1FromJsonFile);
        System.out.println("Loaded User2 from JSON: " + loadedUser2FromJsonFile);
        System.out.println("Loaded User3 from JSON: " + loadedUser3FromJsonFile);

        System.out.println("Loaded Product1 from JSON: " + loadedProduct1FromJsonFile);
        System.out.println("Loaded Product2 from JSON: " + loadedProduct2FromJsonFile);
        System.out.println("Loaded Product3 from JSON: " + loadedProduct3FromJsonFile);

        System.out.println("Loaded User1 from XML: " + loadedUser1FromXmlFile);
        System.out.println("Loaded User2 from XML: " + loadedUser2FromXmlFile);
        System.out.println("Loaded User3 from XML: " + loadedUser3FromXmlFile);

        System.out.println("Loaded Product1 from XML: " + loadedProduct1FromXmlFile);
        System.out.println("Loaded Product2 from XML: " + loadedProduct2FromXmlFile);
        System.out.println("Loaded Product3 from XML: " + loadedProduct3FromXmlFile);

        System.out.println("Loaded User1 from TXT: " + loadedUser1FromTxtFile);
        System.out.println("Loaded User2 from TXT: " + loadedUser2FromTxtFile);
        System.out.println("Loaded User3 from TXT: " + loadedUser3FromTxtFile);

        System.out.println("Loaded Product1 from TXT: " + loadedProduct1FromTxtFile);
        System.out.println("Loaded Product2 from TXT: " + loadedProduct2FromTxtFile);
        System.out.println("Loaded Product3 from TXT: " + loadedProduct3FromTxtFile);
    }
}



class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


}

class Product {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


}

interface EntitySerializer<T> {
    String serialize(T entity);

    T deserialize(String data);

    void saveToFile(T entity, String filename) throws IOException;

    T loadFromFile(String filename) throws IOException;
}

class JsonEntitySerializer<T> implements EntitySerializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> clazz;

    public JsonEntitySerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String serialize(T entity) {
        try {
            String jsonString = objectMapper.writeValueAsString(entity);
            System.out.println("Serialized JSON: " + jsonString);
            return jsonString;
        } catch (IOException e) {
            throw new RuntimeException("Error serializing to JSON", e);
        }
    }

    @Override
    public T deserialize(String data) {
        try {
            T deserializedObject = objectMapper.readValue(data, clazz);
            System.out.println("Deserialized JSON: " + deserializedObject);
            return deserializedObject;
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing from JSON", e);
        }
    }

    @Override
    public void saveToFile(T entity, String filename) throws IOException {
        objectMapper.writeValue(new File(filename), entity);
    }

    @Override
    public T loadFromFile(String filename) throws IOException {
        T loadedObject = objectMapper.readValue(new File(filename), clazz);
        System.out.println("Loaded from JSON file: " + loadedObject);
        return loadedObject;
    }
}


class XmlEntitySerializer<T> implements EntitySerializer<T> {
    private final XmlMapper xmlMapper = new XmlMapper();
    private final Class<T> clazz;

    public XmlEntitySerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String serialize(T entity) {
        try {
            String xmlString = xmlMapper.writeValueAsString(entity);
            System.out.println("Serialized XML: " + xmlString);
            return xmlString;
        } catch (IOException e) {
            throw new RuntimeException("Error serializing to XML", e);
        }
    }

    @Override
    public T deserialize(String data) {
        try {
            T deserializedObject = xmlMapper.readValue(data, clazz);
            System.out.println("Deserialized XML: " + deserializedObject);
            return deserializedObject;
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing from XML", e);
        }
    }

    @Override
    public void saveToFile(T entity, String filename) throws IOException {
        xmlMapper.writeValue(new File(filename), entity);
    }

    @Override
    public T loadFromFile(String filename) throws IOException {
        T loadedObject = xmlMapper.readValue(new File(filename), clazz);
        System.out.println("Loaded from XML file: " + loadedObject);
        return loadedObject;
    }
}

class TxtEntitySerializer<T> implements EntitySerializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> clazz;

    public TxtEntitySerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String serialize(T entity) {
        if (entity instanceof XmlProduct) {
            XmlProduct product = (XmlProduct) entity;
            return "Product: " + product.getName() + ", Price: " + product.getPrice();
        } else if (entity instanceof XmlUser) {
            XmlUser user = (XmlUser) entity;
            return "User: " + user.getName() + ", Age: " + user.getAge();
        } else {
            throw new UnsupportedOperationException("Unsupported type: " + entity.getClass());
        }
    }

    @Override
    public T deserialize(String data) {
        try {
            String[] parts = data.split(", ");
            String type = parts[0].substring(0, parts[0].indexOf(":")).trim();
            Map<String, String> values = new LinkedHashMap<>();

            for (int i = 1; i < parts.length; i++) {
                String[] pair = parts[i].split(": ");
                values.put(pair[0].trim(), pair[1].trim());
            }

            if (type.equals("User")) {
                return (T) new XmlUser(values.get("name"), Integer.parseInt(values.get("Age")));
            } else if (type.equals("Product")) {
                return (T) new XmlProduct(values.get("name"), Double.parseDouble(values.get("Price")));
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + type);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing from TXT", e);
        }
    }

    @Override
    public void saveToFile(T entity, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(new File(filename))) {
            writer.write(serialize(entity));
        }
    }

    @Override
    public T loadFromFile(String filename) throws IOException {
        String data;
        try (Scanner scanner = new Scanner(new File(filename))) {
            data = scanner.useDelimiter("\\Z").next();
        }

        System.out.println("Loaded from TXT file: " + data);
        T loadedObject = deserialize(data);
        System.out.println("Deserialized object: " + loadedObject);
        return loadedObject;
    }
}

