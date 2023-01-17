package bitcamp.bootapp.controller;

import java.util.HashMap;
import java.util.Map;
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

  DeliveryDao deliveryDao = new DeliveryDao();

  public DeliveryController(DeliveryDao deliveryDao) {
    this.deliveryDao = deliveryDao;
  }

  @PostMapping("/delivery")
  public Object addDelivery(Delivery d) {

    this.deliveryDao.insert(d);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }

  @GetMapping("/delivery/{no}")
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

  @PutMapping("/delivery/{no}")
  public Object updateDelivery(Delivery d) {

    Map<String,Object> contentMap = new HashMap<>();

    Delivery old = this.deliveryDao.findByNo(d.getNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "수정할 내용이 없습니다.");
      return contentMap;
    }

    d.setCreatedDate(old.getCreatedDate());

    this.deliveryDao.update(d);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/delivery/{no}")
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
