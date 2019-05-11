import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        try {
            navigationBar();
            InfoOperator ioi=new InfoOperatorImpl();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String command = bufferedReader.readLine();
                Info info=new Info();
                switch (command) {
                    case "1": {
                        System.out.println("请输入id：");
                        String id=bufferedReader.readLine();
                        System.out.println("请输入姓名：");
                        String name=bufferedReader.readLine();
                        System.out.println("请输入性别：");
                        String gender=bufferedReader.readLine();
                        System.out.println("请输入年龄：");
                        int age=Integer.parseInt(bufferedReader.readLine());
                        System.out.println("请输入学校：");
                        String school=bufferedReader.readLine();

                        info.setId(id);
                        info.setName(name);
                        info.setAge(age);
                        info.setGender(gender);
                        info.setSchool(school);

                        ioi.addInfo(info);
                        System.out.println("succeed!");
                        navigationBar();
                        break;
                    }
                    case "2": {
                        System.out.println("请输入需要修改的id：");
                        String id = bufferedReader.readLine();
                        System.out.println("请输入修改后的姓名：");
                        String name = bufferedReader.readLine();
                        System.out.println("请输入修改后的性别：");
                        String gender = bufferedReader.readLine();
                        System.out.println("请输入修改后的年龄：");
                        int age = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("请输入修改后的学校：");
                        String school = bufferedReader.readLine();

                        info.setId(id);
                        info.setSchool(school);
                        info.setAge(age);
                        info.setName(name);
                        info.setGender(gender);

                        ioi.modifyInfo(info);
                        System.out.println("succeed!");
                        navigationBar();
                        break;
                    }
                    case "3":{
                        System.out.println("请输入删除的id：");
                        String id=bufferedReader.readLine();
                        ioi.deleteInfo(id);

                        System.out.println("succeed!");
                        navigationBar();
                        break;
                    }
                    case "4":{
                        List<Info> list=ioi.listAll();
                        for (Info i:list){
                            System.out.println(i);
                        }
                        System.out.println("\n");
                        navigationBar();
                        break;
                    }
                    case "5":{
                        System.out.println("signOut succeed!");
                        System.exit(0);
                    }
                    default:
                        System.out.println("输入信息有误");
                        System.out.println("\n");
                        navigationBar();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void navigationBar(){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("[1]注册信息   [2]修改信息   [3]删除信息    [4]查看信息    [5]退出");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}
