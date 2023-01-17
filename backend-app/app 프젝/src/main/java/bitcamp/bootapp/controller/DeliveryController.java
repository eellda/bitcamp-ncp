package bitcamp.bootapp.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.DeliveryDao;
import bitcamp.bootapp.vo.Delivery;


@RestController
public class DeliveryController {

  @Autowired DeliveryDao deliveryDao;

  @PostMapping("/deliverys")
  public Object addDelivery(Delivery d) {

    this.deliveryDao.insert(d);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }

  @GetMapping("/deliverys")
  public Object getDeliverys() {

    Delivery[] d = this.deliveryDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", d);

    return contentMap;
  }

  @GetMapping("/deliverys/{no}")
  public Object getDelivery(@PathVariable int no) {

    Delivery d = this.deliveryDao.findByNo(no);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();

    if (d == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "해당 번호의 택배가 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", d);
    }

    return contentMap;
  }

  @PutMapping("/deliverys/{no}")
  public Object updateDelivery(Delivery d) {

    Map<String,Object> contentMap = new HashMap<>();

    Delivery old = this.deliveryDao.findByNo(d.getNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "수정할 내용이 없습니다.");
      return contentMap;
    }

    this.deliveryDao.update(d);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/deliverys/{no}")
  public Object deleteDelivery(@PathVariable int no) {

    Delivery d = this.deliveryDao.findByNo(no);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();

    if (d == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "해당 번호의 택배가 없습니다.");

    } else {
      this.deliveryDao.delete(d);
      contentMap.put("status", "success");
    }

    return contentMap;
  }
}
