// ajax()

function jQuery(selector) {
    return new ElementBox(selector);
}

function ElementBox(selector) {
    this.el =[];  // 생성한 태그나 찾은 태그를 담는 배열

    if(selector.startsWith('<')) {
        this.el[0] = document.createElement(selector.substring(1, selector.length - 1));
    } else {
        let nodeList = document.querySelectorAll(selector);
        for(let e of nodeList) {
            this.el.push(e);
        }
    }
}

ElementBox.prototype.append = function(childBox) {

    for(let parent of this.el) {
        for(let child of childBox.el) {
            parent.appendChild(child.cloneNode(true));
        }
    }
    for(let child of childBox.el) {
        if(child.appendElement != null || child.appendElement != undefined) {
        child.appendElement.removeChild(child);
        }
    }
    return this;
}

ElementBox.prototype.appendTo = function(parentsBox) {
    for(let parentTag of parentsBox.el) {
        for(let child of this.el) {
            parentTag.appendChild(child.cloneNode(true));
        }
    } 
    for(let child of this.el) {
        if(child.appendElement != null || child.appendElement != undefined) {
        child.appendElement.removeChild(child);
        }
    }
    return this;
}

ElementBox.prototype.html = function (content) {
    for(let e of this.el) {
        e.innerHTML = content;
    }
    return this;
}

ElementBox.prototype.on = function(eventName, listener) {
    for (let e of this.el) {
        e.addEventListener(eventName, listener);
    }
    return this;
}

ElementBox.prototype.click = function(handler) {
    return this.on('click', handler);
}

jQuery.ajax = function (settings) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                let result;
                if(settings.dataType == 'json') {
                    // json string --> javascript object 로 변환 = 디시리얼
                    result = JSON.parse(xhr.responseText);
                } else {
                    result = xhr.responseText; 
                }
                settings.success(result); 

            } else {
                settings.error();
            }
        }
    };
    xhr.open(settings.method, settings.url, settings.async);
    xhr.send();
}

var $ = jQuery;



//1. 태그 찾기
//2. 태그 만들기
//3. append() 
//4. 리팩토링
//5. html()
//6. on()
//7. appendTo()
//8. Method Chaining
//9. click()
//10. 리팩토링

// function jQuery(selector) {
//     let el = []; // 생성한 태그나 찾은 태그를 담는 배열
  
//     if (selector.startsWith("<")) {
//       el[0] = document.createElement(selector.substring(1, selector.length - 1));
  
//     } else {
//       let nodeList = document.querySelectorAll(selector);
//       for (let e of nodeList) {
//         el.push(e);
//       }
//     }
  
//     el.append = function(childBox) {
//       // 자식 태그를 복제해서 각 부모 태그에 붙인다.
//       for (let parent of el) {
  
//         // 자식들이 들어있는 상자에서 자식을 한 개씩 꺼내 복제하여 각 부모의 자식으로 붙인다.
//         for (let child of childBox) {
//           parent.appendChild(child.cloneNode(true));
//         }
//       }
  
//       // 자식 태그는 제거한다.
//       for (let child of childBox) {
//         if (child.parentElement != null || child.parentElement != undefined) {
//           child.parentElement.removeChild(child);
//         }
//       }
  
//       return this;
//     };
  
//     el.appendTo = function(parents) {
//       // 자식 태그를 복제해서 각 부모 태그에 붙인다.
//       for (let parent of parents) {
  
//         // 자식들이 들어있는 상자에서 자식을 한 개씩 꺼내 복제하여 각 부모의 자식으로 붙인다.
//         for (let child of el) {
//           parent.appendChild(child.cloneNode(true));
//         }
//       }
  
//       // 자식 태그는 제거한다.
//       for (let child of el) {
//         if (child.parentElement != null || child.parentElement != undefined) {
//           child.parentElement.removeChild(child);
//         }
//       }
  
//       return this;
//     };
  
//     el.html = function(content) {
//       for (let e of el) {
//         e.innerHTML = content;
//       }
  
//       return this;
//     };
  
//     el.on = function(eventName, listener) {
//       for (let e of el) {
//         e.addEventListener(eventName, listener);
//       }
  
//       return this;
//     };
  
//     return el;
//   }
  
//   var $ = jQuery;