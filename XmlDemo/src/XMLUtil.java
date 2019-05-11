import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class XMLUtil {
    public static Document getDocument(){
        try {
            Document document=new SAXReader().read("f:/info.xml");
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void write2xml(Document document){
        try {
            OutputStream outputStream =new FileOutputStream("f:/info.xml");
            OutputFormat format=new OutputFormat().createPrettyPrint();
            format.setEncoding("utf-8");
            XMLWriter xmlWriter=new XMLWriter(outputStream,format);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
