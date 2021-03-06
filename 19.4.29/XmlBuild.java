
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;
import java.util.List;


public class XmlBuild {

    private static SAXReader saxReader=new SAXReader();
    private static String PATH="F:\\users.xml";
    //写入
    public static void functionWrite(String path,Document document)throws Exception{
        Writer fileWriter = new FileWriter(PATH);
        OutputFormat format=OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter xmlWriter = new XMLWriter(fileWriter,format);
        xmlWriter.write(document);
        xmlWriter.close();
    }

    //生成xml文件(创建xml文件，初始化user节点，建立一个用户)
    public static void build(String path)throws Exception {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("users");
            Element nameElement = root.addElement("name");
            nameElement.addAttribute("name","zhangsan");
            nameElement.addAttribute("password","zhang123");
            nameElement.addAttribute("status","offline");
            System.out.println("xml文档创建成功！\n");
            functionWrite(PATH,document);
    }

    //读取xml文件，输出当前用户信息
    public static void xmlLoad() throws Exception {
        List<Element> list=saxReader.read(PATH).getRootElement().elements();
        for(Element l:list){
            Iterator<Element> iterator=l.elementIterator();
            while (iterator.hasNext()){
                Element element1=iterator.next();
                System.out.println(element1.getName()+":"+element1.getText());
            }
            System.out.println();
        }
    }


    //注册（在user下添加name节点，name下增加password跟status节点，最后写入到xml文档）
    public static void signUp(String name, String passWord) throws Exception {
        Document document = saxReader.read(new File(PATH));
        Element root = document.getRootElement();
        Element nameElement = root.addElement("name");
        nameElement.addAttribute("name",name);
        nameElement.addAttribute("password",passWord);
        nameElement.addAttribute("status","offline");
        System.out.println("用户："+name+" 注册成功~\n");
        functionWrite(PATH,document);
    }


    //登陆（若正确匹配姓名、密码，输出“登陆成功”，将status改为online）
    public static void signIn(String name,String passWord) throws Exception {
        Document document=saxReader.read("F:\\users.xml");
        Element element1=document.getRootElement();
        Iterator<Element> it = element1.elementIterator();
        while (it.hasNext()) {
            Element element = it.next();
            if (element.attributeValue("name").equals(name) && element.attributeValue("password").equals(passWord)) {
                if(element.attributeValue("status").equals("offline")){
                    Attribute attribute=element.attribute("status");
                    attribute.setValue("online");
                    functionWrite(PATH,document);
                    System.out.println("user:"+name+" SignIn succeed!\n");
                }else{
                    System.out.println("user:"+name+" already SignIn\n");
                }
                return;
            }
        }
        System.out.println("SignIn failed!\n");
    }

    //退出登陆
    public static void signOut(String name) throws Exception {
        Document document=saxReader.read(PATH);
        Iterator it = document.getRootElement().elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.attributeValue("name").equals(name)&&element.attributeValue("status").equals("online")){
                System.out.println("user:"+name+" SignOut succeed！\n");
                Attribute attribute=element.attribute("status");
                attribute.setValue("offline");
                FileOutputStream fileOutputStream=new FileOutputStream(PATH);
                XMLWriter writer=new XMLWriter(fileOutputStream);
                writer.write(document);
                writer.close();
                return;
            }
        }
        System.out.println("用户："+name+" 未登录\n");
    }

    //输出当前用户数量
    public static void userCount()throws Exception{
        List<Element> list = saxReader.read(PATH).getRootElement().elements();
        System.out.println("用户数量："+list.size()+"\n");
    }
}












