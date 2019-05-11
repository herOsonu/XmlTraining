import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

public class GetAttribute{
    public static void main(String[] args)throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("./03.contact.xml");
        Element element=document.getRootElement();
        //先得到标签对象
        Element contactElement=element.element("contact");
        //得到属性
        String value=contactElement.attributeValue("id");
        System.out.println(value);
        //得到属性对象
        Attribute attribute=contactElement.attribute("id");
        System.out.println(attribute.getName()+"="+attribute.getValue());
        //不知道属性的名字,得到属性对象
        List<Attribute> list=contactElement.attributes();
        for(Attribute l:list){
            System.out.println("=====================================");
            System.out.println(l.getName()+"="+l.getValue());
        }
        Iterator<Attribute> iterator=contactElement.attributeIterator();{
            while (iterator.hasNext()){
                Attribute attribute1=iterator.next();
                System.out.println(attribute.getName()+"="+attribute.getValue());
            }
        }
    }
}
/*
*String Element.attributeValue("属性名")  获取指定属性名的属性
* Attribute element.element（"属性名"）  获取指定属性名属性对象
* Atrribute.getName()  获取属性名称
* Atrribute。getValue（）
* List Attributes()
* Iterator attributeIterator（）
*
*
* */