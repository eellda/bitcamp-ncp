package bitcamp.bootapp.vo;

public class Delivery {

  public int no; // 번호
  public long invNo;

  // 발송인
  public String senderName; // 이름
  public String senderTel; // 연락처
  public String senderPostNo; // 우편번호
  public String senderRoadAddress; // 도로명주소
  public String senderOldAddress; // 지번주소
  public String senderDetailAddress; // 상세주소
  public String senderNote; // 참고항목

  // 수취인
  public String reciverName; // 이름
  public String reciverTel; // 연락처
  public String reciverPostNo; // 우편번호
  public String reciverRoadAddress; // 도로명주소
  public String reciverOldAddress; // 지번주소
  public String reciverDetailAddress; // 상세주소
  public String reciverNote; // 참고항목

  public int paym; // 운임 0: 무료배송, 1: 선불, 2: 착불
  public int item; // 배송물품 0: 의류, 1: 서신/서류, 2: 전자제품, 3: 식품류, 4: 잡화/서적
  public int status; // 비고 0: 배송 준비, 1: 발송중, 2: 배송 완료
  public String msg; // 배송요청사항
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }

  public long getInvNo() {
    return invNo;
  }
  public void setInvNo(long invNo) {
    this.invNo = invNo;
  }
  public String getSenderName() {
    return senderName;
  }
  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }
  public String getSenderTel() {
    return senderTel;
  }
  public void setSenderTel(String senderTel) {
    this.senderTel = senderTel;
  }
  public String getSenderPostNo() {
    return senderPostNo;
  }
  public void setSenderPostNo(String senderPostNo) {
    this.senderPostNo = senderPostNo;
  }
  public String getSenderRoadAddress() {
    return senderRoadAddress;
  }
  public void setSenderRoadAddress(String senderRoadAddress) {
    this.senderRoadAddress = senderRoadAddress;
  }
  public String getSenderOldAddress() {
    return senderOldAddress;
  }
  public void setSenderOldAddress(String senderOldAddress) {
    this.senderOldAddress = senderOldAddress;
  }
  public String getSenderDetailAddress() {
    return senderDetailAddress;
  }
  public void setSenderDetailAddress(String senderDetailAddress) {
    this.senderDetailAddress = senderDetailAddress;
  }
  public String getSenderNote() {
    return senderNote;
  }
  public void setSenderNote(String senderNote) {
    this.senderNote = senderNote;
  }
  public String getReciverName() {
    return reciverName;
  }
  public void setReciverName(String reciverName) {
    this.reciverName = reciverName;
  }
  public String getReciverTel() {
    return reciverTel;
  }
  public void setReciverTel(String reciverTel) {
    this.reciverTel = reciverTel;
  }
  public String getReciverPostNo() {
    return reciverPostNo;
  }
  public void setReciverPostNo(String reciverPostNo) {
    this.reciverPostNo = reciverPostNo;
  }
  public String getReciverRoadAddress() {
    return reciverRoadAddress;
  }
  public void setReciverRoadAddress(String reciverRoadAddress) {
    this.reciverRoadAddress = reciverRoadAddress;
  }
  public String getReciverOldAddress() {
    return reciverOldAddress;
  }
  public void setReciverOldAddress(String reciverOldAddress) {
    this.reciverOldAddress = reciverOldAddress;
  }
  public String getReciverDetailAddress() {
    return reciverDetailAddress;
  }
  public void setReciverDetailAddress(String reciverDetailAddress) {
    this.reciverDetailAddress = reciverDetailAddress;
  }
  public String getReciverNote() {
    return reciverNote;
  }
  public void setReciverNote(String reciverNote) {
    this.reciverNote = reciverNote;
  }
  public int getPaym() {
    return paym;
  }
  public void setPaym(int paym) {
    this.paym = paym;
  }
  public int getItem() {
    return item;
  }
  public void setItem(int item) {
    this.item = item;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }


}
