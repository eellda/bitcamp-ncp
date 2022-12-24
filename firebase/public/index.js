    // Import the functions you need from the SDKs you need
    //import { initializeApp } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-app.js";
    //import { initializeApp } from "./firebase/app";
    //import { getFirestore } from "./firebase/firestore";
    // TODO: Add SDKs for Firebase products that you want to use
    // https://firebase.google.com/docs/web/setup#available-libraries
  
    // Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyCUYNKXbJxxKZ2Q9jPK71jpVOEjvhBmPNI",
    authDomain: "test-80ec7.firebaseapp.com",
    projectId: "test-80ec7",
    storageBucket: "test-80ec7.appspot.com",
    messagingSenderId: "278194240267",
    appId: "1:278194240267:web:f2e896c24b62f142aac00e"
};
firebase.initializeApp(firebaseConfig);
const db = firebase.firestore();


// Initialize Firebase
//const app = initializeApp(firebaseConfig);
//const db = getFirestore(app);



db.collection('product').get().then((result)=> {
    result.forEach((doc)=> {
        console.log(doc.data());
        var templit = `<div class="product">
        <div class="thumbnail" style="background-image: url('https://via.placeholder.com/350')"></div>
        <div class="flex-grow-1 p-4">
          <h5 class="title">${doc.data().name}</h5>
          <p class="date">2030년 1월 8일</p>
          <p class="price">${doc.data().cost}</p>
          <p class="float-end">?0</p>
        </div>
      </div>`;
        $('.container').append(templit);
    })
})

