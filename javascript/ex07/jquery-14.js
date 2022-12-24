// val()

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
// jQuery 함수는 값을 꺼내는 함수(getter) 따로 넣는 함수(setter) 따로 있지 않음
// 한 함수에서 값을 넣고 꺼내는 일을 한다
// 파라미터 값이 없으면 꺼내는 일을 한다
ElementBox.prototype.val = function(value) {
    if (this.el.length == 0) return;
    if (arguments.length > 0) { // 아규먼트가 한개라도 있으면
        // 값을 설정할 때는 모든 태그에 대해 수행함
        for(let e of this.el) {
            e.value = value;    // 값을 설정하고
        } return this;          // 리턴
    } else return this.el[0].value;
        // 값을 꺼낼 때는 맨 처음 태그 값만 꺼냄
}

jQuery.ajax = function (settings) {
    if(settings.method == undefined) settings.method = 'GET';
    if(settings.async == undefined) settings.ajax = true;
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                if (settings.success == undefined) {
                    return;
                }
                let result;
                if(settings.dataType == 'json') {
                    // json string --> javascript object 로 변환 = 디시리얼
                    result = JSON.parse(xhr.responseText);
                } else {
                    result = xhr.responseText; 
                }
                settings.success(result); 

            } else {
                if (settings.error == undefined) {
                    return;
                }
                settings.error();
            }
        }
    };
    xhr.open(settings.method, settings.url, settings.async);
    xhr.send();
}

jQuery.getJSON = function(url, success) {
    jQuery.ajax({
        url: url,
        dataType: 'json',
        success: success
    });
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