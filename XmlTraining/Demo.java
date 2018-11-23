package XmlTraining;


import static XmlTraining.XmlBuild.*;



public class Demo {
    public static void main(String[] args)throws Exception {

        XmlTraining.XmlBuild.bulid("C:\\Users\\Administor\\Desktop\\users.xml"); //创建xml文件

        signUp("lisi","li123");//用户注册
        signUp("sunwu","sun123");//用户注册

        xmlLoad();//输出xml信息
        logIn("sunwu","sun123");//用户登陆
        out("sunwu");//退出登陆
        count();//输出当前用户数量






    }
}
