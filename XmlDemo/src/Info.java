public class Info {
    private String name;
    private String id;
    private String gender;
    private int age;
    private String tel;
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
