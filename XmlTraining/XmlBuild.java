package XmlTraining;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;
import java.util.List;


class XmlBuild {


    //生成xml文件(在桌面创建xml文件，初始化user节点，建立一个用户)
    public static void bulid(String path) {
        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("users");
            root.setText("这个是users标签的文本信息");
            //Element userElement = root.addElement("user");
            Element nameElement = root.addElement("name");
            nameElement.setText("zhangsan");
            Element nameElement1=nameElement.addElement("name");
            nameElement1.setText("zhangsan");
            Element passwordElement = nameElement.addElement("password");
            passwordElement.setText("zhang123");
            Element satusElement=nameElement.addElement("status");
            satusElement.setText("offline");
            System.out.println(document.asXML()); //将document文档对象直接转换成字符串输出
            Writer fileWriter = new FileWriter(path);   //输入地址
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
            System.out.println("xml文档创建成功！");
            System.out.println(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //读取xml文件，输出当前用户信息
    public static void xmlLoad() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\Users\\Administor\\Desktop\\users.xml"));
        Element root = document.getRootElement();

        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();


            //未知属性名称情况下
            Iterator attrIt = element.attributeIterator();
            while (attrIt.hasNext()) {
                Attribute a = (Attribute) attrIt.next();
                System.out.println(a.getValue());

            }

            //未知元素名情况下
            Iterator eleIt = element.elementIterator();
            while (eleIt.hasNext()) {
                Element e = (Element) eleIt.next();
                System.out.println(e.getName() + ": " + e.getText());
            }
            System.out.println();

        }
    }


    //注册（在user下添加name节点，name下增加password跟status节点，最后写入到xml文档）
    public static void signUp(String nodeName, String nodepassWord) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\Users\\Administor\\Desktop\\users.xml"));
        Element root = document.getRootElement();
        //Element node=root.element("users");
        //Iterator it = root.elementIterator();
        Element nameElement = root.addElement("name");//对指定的节点node新增子节点,名为nodeName
        nameElement.setText(nodeName);//对新增的节点添加文本内容content
        Element name=nameElement.addElement("name");
        name.setText(nodeName);
        Element password = nameElement.addElement("passWord");//对指定的节点node新增子节点,名为nodeName
        password.setText(nodepassWord);//对新增的节点添加文本内容content
        Element statusElement=nameElement.addElement("status");
        statusElement.setText("offline");
        System.out.println("用户："+nodeName+"注册成功~");
        Writer osWrite=new OutputStreamWriter(new FileOutputStream("C:\\Users\\Administor\\Desktop\\users.xml"));//创建输出流
        OutputFormat format = OutputFormat.createPrettyPrint();  //获取输出的指定格式
        format.setEncoding("UTF-8");//设置编码 ，确保解析的xml为UTF-8格式
        XMLWriter writer = new XMLWriter(osWrite,format);//XMLWriter 指定输出文件以及格式
        writer.write(document);//把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)
        writer.flush();
        writer.close();
    }


    //登陆（若正确匹配姓名、密码，输出“登陆成功”，将status改为online）
    public static void logIn(String name,String passWord) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\Users\\Administor\\Desktop\\users.xml"));
        Element root = document.getRootElement();

        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();


            //未知属性名称情况下
            Iterator attrIt = element.attributeIterator();
            while (attrIt.hasNext()) {
                Attribute a = (Attribute) attrIt.next();
                System.out.println(a.getValue());

            }

            //未知元素名情况下
            Iterator eleIt = element.elementIterator();

            while (eleIt.hasNext()) {
                Element e = (Element) eleIt.next();
                //System.out.println(e.getName() + ": " + e.getText());
                if(e.getText().equals(name)){
                    Element a= (Element) eleIt.next();
                    if(a.getText().equals(passWord)){
                        System.out.println("登陆成功");
                        ((Element) eleIt.next()).setText("online");
                        Writer osWrite=new OutputStreamWriter(new FileOutputStream("C:\\Users\\Administor\\Desktop\\users.xml"));//创建输出流
                        OutputFormat format = OutputFormat.createPrettyPrint();  //获取输出的指定格式
                        format.setEncoding("UTF-8");//设置编码 ，确保解析的xml为UTF-8格式
                        XMLWriter writer = new XMLWriter(osWrite,format);//XMLWriter 指定输出文件以及格式
                        writer.write(document);//把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)
                        writer.flush();
                        writer.close();
                        return;
                    }else{
                        continue;
                    }
                }else{
                    continue;
                }
            }
            //System.out.println();
        }
        System.out.println("登陆失败");
    }


    //退出登陆（注册时用户名不能重复）
    public static void out(String name) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\Users\\Administor\\Desktop\\users.xml"));
        Element root = document.getRootElement();

        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();


            //未知属性名称情况下
            Iterator attrIt = element.attributeIterator();
            while (attrIt.hasNext()) {
                Attribute a = (Attribute) attrIt.next();
                System.out.println(a.getValue());

            }

            //未知元素名情况下
            Iterator eleIt = element.elementIterator();

            while (eleIt.hasNext()) {
                Element e = (Element) eleIt.next();
                //System.out.println(e.getName() + ": " + e.getText());
                if(e.getText().equals(name)){
                    Element a= (Element) eleIt.next();
                    System.out.println("退出成功");
                    ((Element) eleIt.next()).setText("offline");
                    Writer osWrite=new OutputStreamWriter(new FileOutputStream("C:\\Users\\Administor\\Desktop\\users.xml"));//创建输出流
                    OutputFormat format = OutputFormat.createPrettyPrint();  //获取输出的指定格式
                    format.setEncoding("UTF-8");//设置编码 ，确保解析的xml为UTF-8格式
                    XMLWriter writer = new XMLWriter(osWrite,format);//XMLWriter 指定输出文件以及格式
                    writer.write(document);//把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)
                    writer.flush();
                    writer.close();
                    return;

                }else{
                    continue;
                }
            }
            //System.out.println();
        }
    }
    //输出当前用户数量
    public static void count()throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\Users\\Administor\\Desktop\\users.xml"));
        Element root = document.getRootElement();
        int count=0;
        List<Element> list = root.elements() ;
              //遍历List的方法
              for (Element e:list){
                      count++;
                  }
        System.out.println(" ");
        System.out.println("当前用户数量："+count);
    }
}












