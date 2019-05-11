package Demo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

class Reader{
    public static void reader(Element element){
        Iterator<Element> iterator=element.elementIterator();
        while (iterator.hasNext()){
            Element element1=iterator.next();
            reader(element1);
        }

        for(Iterator<Element> iterator1=element.elementIterator();iterator1.hasNext();){
            Element element1=iterator1.next();
            reader(element1);
        }
    }
}
public class Demo{
    public static void main(String[] args)throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("./src/03.contact.xml");
        Element element=document.getRootElement();
        element.element("contact");
        element.elementIterator("contact");
        element.elements();
        element.nodeIterator();
        Element nameElement=element.element("contact").element("name");


        /*
        * element（"args"）指定名称的第一个子标签
        * elementIterator（"args"）指定名称的所有子标签
        * elements() 所有字标签
        * document.getRootElement() 跟标签
        * Element.nodeIterator() Element下所有的子节点
        * */
        //深层标签，只能一层层的获取一连串操作

    }
}
