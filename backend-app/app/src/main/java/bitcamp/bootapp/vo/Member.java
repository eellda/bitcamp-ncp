package bitcamp.bootapp.vo;

// 회원 데이터를 담을 메모리를 설계한다.
public class Member {
  private int no; // 필드
  private String name;
  private String tel;
  private String postNo;
  private String basicAdress;
  private String detailAdress;
  private boolean working;
  private char gender;
  private byte level;
  private String createdDate;
  private String password;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getPostNo() {
    return postNo;
  }
  public void setPostNo(String postNo) {
    this.postNo = postNo;
  }
  public String getBasicAdress() {
    return basicAdress;
  }
  public void setBasicAdress(String basicAddress) {
    this.basicAdress = basicAddress;
  }
  public String getDetailAdress() {
    return detailAdress;
  }
  public void setDetailAdress(String detailAddress) {
    this.detailAdress = detailAddress;
  }
  public boolean isWorking() {
    return working;
  }
  public void setWorking(boolean working) {
    this.working = working;
  }
  public char getGender() {
    return gender;
  }
  public void setGender(char gender) {
    this.gender = gender;
  }
  public byte getLevel() {
    return level;
  }
  public void setLevel(byte level) {
    this.level = level;
  }
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }


}
