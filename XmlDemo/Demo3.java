package Demo3;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

class Reader{
    public static void read()throws Exception{
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("src/1.xml");
        Element rootElement=document.getRootElement();
        StringBuffer sb=new StringBuffer();
        parseXML(rootElement,sb);
        System.out.println(sb.toString());

    }
    public static void parseXML(Element element,StringBuffer sb){
        sb.append("<"+element.getName());
        List<Attribute> attributes=element.attributes();
            for(Attribute a:attributes){
                sb.append(a.getName()+"=\""+a.getValue()+"\"");
            }
            sb.append(">");
        Iterator<Node> iterator=element.nodeIterator();
            while (iterator.hasNext()){
                Node node=iterator.next();
                if(node instanceof Text){
                    Text text=(Text)node;
                    sb.append(text.getText());
                }else if(node instanceof  Element){
                    Element element1=(Element) node;
                    parseXML(element1,sb);
                }

            }
    }
}
public class Demo3 {
    public static void main(String[] args)throws Exception {
        Reader.read();
    }
}
