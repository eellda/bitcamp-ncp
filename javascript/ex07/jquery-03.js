function jQuery(selector) {
    if(selector.startsWith('<')) {
        var e = document.createElement(selector.substring(1, selector.length - 1));
        e.append = function (child) { // 태그 만듦 
            e.appendChild(child);
        }
        return e;
    } else {
        let el = document.querySelectorAll(selector);
        for(let e of el) {
            e.append = function (child) { 
                e.appendChild(child);
            };
        }
        return el;
    }
}

var $ = jQuery;