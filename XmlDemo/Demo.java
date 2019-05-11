package Demo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Contact{
    private String id;
    private String name;
    private String age;
    private String email;
    private String qq;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
public class Demo {
    public static void main(String[] args)throws Exception {
        List<Contact> list=new ArrayList<Contact>();
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("./03.contact.xml");

        List<Element> list1=document.getRootElement().elements();
        for(Element l:list1){
            Contact contact=new Contact();
            contact.setPhone(l.attributeValue("phone"));
            contact.setEmail(element.elementText("email"));
            contact.setAge(element.elementText("age"));
            list.add(contact);
        }

       /* Iterator<Element> iterator =document.getRootElement().elementIterator();
        while (iterator.hasNext()){
            Element element=iterator.next();
            Contact contact=new Contact();
            contact.setId(element.attributeValue("id"));
            contact.setName(element.elementText("name"));
            contact.setPhone(element.elementText("phone"));
            contact.setQq(element.elementText("qq"));
            contact.setEmail(element.elementText("email"));
            contact.setAge(element.elementText("age"));
            list.add(contact);
        }*/
        for(Contact contact:list){
            System.out.println(contact);

        }
    }
}
