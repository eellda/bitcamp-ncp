package bitcamp.myapp.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import com.google.gson.Gson;
import bitcamp.myapp.dao.StudentDao;
import bitcamp.myapp.vo.Student;
import bitcamp.util.Prompt;

public class StudentServlet {

  private StudentDao studentDao;

  public StudentServlet(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  private void onInsert(DataInputStream in, DataOutputStream out) throws Exception {
    Student s = new Gson().fromJson(in.readUTF(), Student.class);
    this.studentDao.insert(s);
    out.writeUTF("200");
    out.writeUTF("success");
  }

  private void onFindAll(DataInputStream in, DataOutputStream out) throws Exception{

    out.writeUTF("200");
    out.writeUTF(new Gson().toJson(this.studentDao.findAll()));
  }

  private void onFindByNo(DataInputStream in, DataOutputStream out) throws Exception {
    int studentNo = new Gson().fromJson(in.readUTF(), int.class);
    Student s = this.studentDao.findByNo(studentNo);

    if (s == null) {
      out.writeUTF("400");
      return;
    }
    out.writeUTF("200");
    out.writeUTF(new Gson().toJson(s));
  }

  // 인스턴스 멤버(필드나 메서드)를 사용하지 않기 때문에
  // 그냥 스태틱 메서드로 두어라!
  private static String getLevelText(int level) {
    switch (level) {
      case 0: return "비전공자";
      case 1: return "준전공자";
      default: return "전공자";
    }
  }

  private void onUpdate(DataInputStream in, DataOutputStream out) throws Exception {

    Student student = new Gson().fromJson(in.readUTF(), Student.class);
    Student old = this.studentDao.findByNo(student.getNo());

    if (old == null) {
      out.writeUTF("400");
      return;
    }
    out.writeUTF("200");
    out.writeUTF("success");
    this.studentDao.update(student);

  }

  private void onDelete(DataInputStream in, DataOutputStream out) throws Exception {

    Student student = new Gson().fromJson(in.readUTF(), Student.class);
    Student old = this.studentDao.findByNo(student.getNo());

    if (old == null) {
      out.writeUTF("400");
      return;
    }
    out.writeUTF("200");
    out.writeUTF("success");
    this.studentDao.delete(old);
  }

  private void searchMember(DataInputStream in, DataOutputStream out) {

    Student[] members = this.studentDao.findAll();

    String name = Prompt.inputString("이름? ");

    System.out.println("번호\t이름\t전화\t재직\t전공");

    for (Student m : members) {
      if (m.getName().equalsIgnoreCase(name)) {
        System.out.printf("%d\t%s\t%s\t%s\t%s\n",
            m.getNo(), m.getName(), m.getTel(),
            m.isWorking() ? "예" : "아니오",
                getLevelText(m.getLevel()));
      }
    }
  }

  public void service(DataInputStream in, DataOutputStream out) throws Exception {

    try {

      String action = in.readUTF();

      switch (action) {
        case "insert": this.onInsert(in, out); break;
        case "findAll": this.onFindAll(in, out); break;
        case "findByNo": this.onFindByNo(in, out); break;
        case "update": this.onUpdate(in, out); break;
        case "delete": this.onDelete(in, out); break;
        //        case 6: this.searchMember(); break;
        default:
          System.out.println("잘못된 메뉴 번호 입니다.");
      }
    } catch (Exception e) {
      out.writeUTF("500");
    }
  }
}
