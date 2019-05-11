import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetText{
    public static void main(String[] args)throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("./03.contact.xml");
        Element nameElement= document.getRootElement().element("contact").element("name");
        String text=nameElement.getText();
        //2  获取得到指定标签名的文本内容
        String text1=document.getRootElement().element("contact").elementText("name");
        System.out.println(text1);
        /*元素
         * element（"args"）指定名称的第一个子标签
         * elementIterator（"args"）指定名称的所有子标签
         * elements() 所有字标签
         * document.getRootElement() 跟标签
         * Element.nodeIterator() Element下所有的子节点
         * */
        //深层标签，只能一层层的获取一连串操作


        /*属性
         *String Element.attributeValue("属性名")  获取指定属性名的属性
         * Attribute element.element（"属性名"）  获取指定属性名属性对象
         * Atrribute.getName()  获取属性名称
         * Atrribute。getValue（）
         * List Attributes()
         * Iterator attributeIterator（）
         *
         *
         * */

        /*
        * 文本
        * element.getText();
        * element.elementText()
        *
        * */

    }
}
