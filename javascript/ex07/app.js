
// express librarry 로딩하기
const express = require('express');
const port = 3000;

// express () 롤 호출하여 웹서버를 준비한다.
const app = express();

// client request에 대해 호출될 매소드 등록
app.get(                                                                         // client 에서 get request가 들어 왔을때 호출될 method 지정
    '/exam01-1',                                                                 // 요청 url
    (req, res) => {                                                              // res 응답과 관련된 도구함을 받음       // 요청 핸들러 - 요청이 들어왔을때 호출되는 매소드
        res.set('Access-Control-Allow-Origin', '*');
        res.set('Content-Type', 'text/plain; charset=UTF-8');
        res.send('hello');
        //console.log('오호라!');
    }
);


// 웹서버 실행하기
app.listen(
    3000,                                                                            // 포트 번호 지정
    () => {                                                                  
        console.log(`${port}번 포트에서 서버 구동 시작`);                          // 서버가 시작 되었을때 호출될 함수 = 리스너 = 핸들러
    }                                                     
)



