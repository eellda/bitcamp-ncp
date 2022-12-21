// 기존 jQery 객체에 메소드 추가
ElementBox.prototype.button = function () {
  this.el.forEach((e) => {
    e.classList.add('btn');
  });
}