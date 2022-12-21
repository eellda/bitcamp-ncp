
// express librarry 로딩하기
const express = require('express');
// HTTP 요청을 다루는 라이브러리 로딩하기
const request = require('request');

//POST 요청으로 보낸 payload 를 분석하는 라이브러리 로딩하기
//const bodyParser = require('body-parser');

const port = 3000;

// express () 롤 호출하여 웹서버를 준비한다.
const app = express();

// POST 요청으로 보낸 payload 데이터를 분석할 객체를 지정하기
// => Content-Type: Application/x-www-form-urlencoded 형식으로 된 payload 처리
// 예> name=hong&age=24


app.use(express.urlencoded({extended: true}));  // 객체를 만들어서 던저준다~

// client request에 대해 호출될 매소드 등록
app.get(                                                                                // client 에서 get request가 들어 왔을때 호출될 method 지정
    '/exam01-1',                                                                        // 요청 url
    (req, res) => {                                                                     // res 응답과 관련된 도구함을 받음       // 요청 핸들러 - 요청이 들어왔을때 호출되는 매소드
        res.set('Access-Control-Allow-Origin', '*');
        res.set('Content-Type', 'text/plain; charset=UTF-8');
        res.send('hello(성민)');
        //console.log('오호라!');
    }
);

app.get('/exam02-1', (req, res) => {                                                                   
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/plain; charset=UTF-8');
    res.send(`이름: ${req.query.name} \
나이: ${req.query.age}`);
});

app.post('/exam02-2', (req, res) => {                                   // post 요청이 들어왔을때 실행할 함수를 등록 하는것임                                                    
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/plain; charset=UTF-8');
    
    res.send(`이름: ${req.body.name} \
나이: ${req.body.age}`);
});

app.get('/exam03-1', (req, res) => {                                   // post 요청이 들어왔을때 실행할 함수를 등록 하는것임                                                    
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/plain; charset=UTF-8');
    setTimeout(() => {
        res.send('NOT Found 404');
    }, 15000);
});

app.get('/exam03-4', (req, res) => {                                   // post 요청이 들어왔을때 실행할 함수를 등록 하는것임                                                    
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/plain; charset=UTF-8');

    let a = parseInt(req.query.a);
    let b = parseInt(req.query.b);

    res.send(`${a+b}`);
});

app.get('/header', (req, res) => {                                   // post 요청이 들어왔을때 실행할 함수를 등록 하는것임                                                    
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/html; charset=UTF-8');

    res.send('<h1>비트캠프 네이버 클라우드 AIaaS 개발자 양성과정</h1>');
});

app.get('/footer', (req, res) => {                                   // post 요청이 들어왔을때 실행할 함수를 등록 하는것임                                                    
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/html; charset=UTF-8');

    res.send('<adress>비트캠프 서초캠프 2022</adress>');
});

app.get('/exam04-3', (req, res) => {                                   // post 요청이 들어왔을때 실행할 함수를 등록 하는것임                                                    
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/html; charset=UTF-8');

     let arr = [
        {no: 1, title: '제목1', writer: 'IU', viewCnt: 19},
        {no: 2, title: '제목2', writer: 'UI', viewCnt: 712},
        {no: 3, title: '제목3', writer: 'UI/UX', viewCnt: 12},
        {no: 4, title: '제목4', writer: 'BACK', viewCnt: 12712},
        {no: 5, title: '제목5', writer: 'CLOUD', viewCnt: 2}
     ];

    // 배열 객체를 JSON 문자열로 변환하여 클라이언테에게 보냄
    // => 시리얼라이제이션
     res.send(JSON.stringify(arr));
});


app.get('/proxy', (req, res) => {                
    //console.log(req.query.url);   
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'application/json; charset=UTF-8');
    request.get({url: req.query.url}, (error, response, body) => res.send(body));
    //console.log('오호라!');
});



app.get('/proxy2', (req, res) => {                
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/plain; charset=UTF-8');

    let openApiUrl = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?' +
    'serviceKey=sxu9KRkG12s8M1jzMQue37aHfnGiREb4AkZ3vd3k6AyedQ%2Bwzi69FPFxjjhCFBRG%2Bg2yWdwfHlsp9ICw5TfOZQ%3D%3D' +
    '&pageNo=1&numOfRows=1000&dataType=JSON' +
    '&base_date=20221216' + req.query.base_date +
    '&base_time=0600&' + req.query.nx +
    'nx=55' + req.query.ny +
    '&ny=127';

    
    request.get({url: openApiUrl}, (error, response, body) => res.send(body));
});


app.post('/login', (req, res) => {                                   // post 요청이 들어왔을때 실행할 함수를 등록 하는것임                                                    
    res.set('Access-Control-Allow-Origin', '*');
    res.set('Content-Type', 'text/plain; charset=UTF-8');
    
    res.send(`email: ${req.body.email} \
password: ${req.body.password}`);
});




// 웹서버 실행하기
app.listen(
    4000,                                                                               // 포트 번호 지정
    () => {                                                                  
        console.log(`${port}번 포트에서 서버 구동 시작`);                               // 서버가 시작 되었을때 호출될 함수 = 리스너 = 핸들러
    }                                                     
)



