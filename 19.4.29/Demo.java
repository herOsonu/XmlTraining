public class Demo {
    public static void main(String[] args)throws Exception {
        XmlBuild.build("F:/users.xml");
        XmlBuild.signUp("zhang","zhang123");
        XmlBuild.signIn("zhang","zhang123");
        XmlBuild.signOut("zhang");
        XmlBuild.userCount();
    }
}
