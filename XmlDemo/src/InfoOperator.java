import java.util.List;

public interface InfoOperator {
    void addInfo(Info info);
    void deleteInfo(String id);
    void modifyInfo(Info info);
    List<Info> listAll();
}
