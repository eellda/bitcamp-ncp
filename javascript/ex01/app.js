const express = require('express')
const app = express()
const port = 3000


const delay = async () => {
  console.log("===> 잠들다");
  await sleep(5000);
  console.log("===> 깨어나다");
}
const sleep = (ms) => {
  return new Promise(resolve => {
    setTimeout(resolve, ms)
  })
}

app.get('/', async (req, res) => {
  //res.header("Access-Control-Allow-Origin", "*");
  res.send('console.log("exam05_2 ok!");');
})

app.get('/exam05_x', async (req, res) => {
  await new Promise(resolve => setTimeout(resolve, 10000));
  res.send('var rate = 30000;')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
})

function handleHello(req, res) {
  res.send('hello');
}
