import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InfoOperatorImpl implements InfoOperator{

    public void addInfo(Info info){
        File file=new File("f:/info.xml");
        Document document=null;
        Element rootElment=null;
        if(file.exists()){
            document=XMLUtil.getDocument();
            rootElment=document.getRootElement();
        }else{
            document= DocumentHelper.createDocument();
            rootElment=document.addElement("infoList");
        }
        Element infoElement=rootElment.addElement("userInfo");
        infoElement.addAttribute("id",info.getId());
        infoElement.addElement("name").setText(info.getName());
        infoElement.addElement("gender").setText(info.getGender());
        infoElement.addElement("age").setText(info.getAge()+"");
        infoElement.addElement("school").setText(info.getSchool());

        XMLUtil.write2xml(document);
    }

    public void deleteInfo(String id){
        Document document=XMLUtil.getDocument();
        Element infoElement = (Element)document.selectSingleNode("//userInfo[@id='"+id+"']");
        infoElement.detach();

        XMLUtil.write2xml(document);
    }

    public void modifyInfo(Info info){
        Document document=XMLUtil.getDocument();
        Element infoElement = (Element)document.selectSingleNode("//userInfo[@id='"+info.getId()+"']");
        infoElement.element("name").setText(info.getName());
        infoElement.element("gender").setText(info.getGender());
        infoElement.element("school").setText(info.getSchool());
        infoElement.element("age").setText(info.getAge()+"");

        XMLUtil.write2xml(document);
    }

    public List<Info> listAll(){
        Document document=XMLUtil.getDocument();
        List<Info> list=new ArrayList<>();
        List<Element> infoList=(List) document.selectNodes("//userInfo");
        for (Element e:infoList){
            Info c = new Info();
            c.setId(e.attributeValue("id"));
            c.setName(e.elementText("name"));
            c.setGender(e.elementText("gender"));
            c.setAge(Integer.parseInt(e.elementText("age")));
            c.setSchool(e.elementText("school"));
            list.add(c);
        }
        return list;
    }

}
