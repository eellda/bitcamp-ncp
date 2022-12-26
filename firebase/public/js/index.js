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
        var templit = `


            <div class="blog-card">
              <div class="blog-card-banner">
                <img src="./images/blog-1.png" alt="Building microservices with Dropwizard, MongoDB & Docker"
                  width="250" class="blog-banner-img">
              </div>
              <div class="blog-content-wrapper">
                <button class="blog-topic text-tiny">Database</button>
                <h3>
                  <a href="#" class="h3">
                    ${doc.data().name}
                  </a>
                </h3>
                <p class="blog-text">
                  ${doc.data().content}
                </p>
                <div class="wrapper-flex">
                  <div class="profile-wrapper">
                    <img src="" alt="" width="50">
                  </div>
                  <div class="wrapper">
                    <a href="#" class="h4"></a>
                    <p class="text-sm">
                      <time datetime="${doc.data().date}"></time>
                      <span class="separator"></span>
                      <ion-icon name="time-outline"></ion-icon>
                      <time datetime="PT3M">3 min</time>
                    </p>
                  </div>
                </div>
              </div>
            </div>

        `;



        $('.main > .container > .blog > .blog-card-group').append(templit);
    })
})

