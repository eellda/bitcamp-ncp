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
const storage = firebase.storage();

// $('#register').click(function () {

//     var email = $('#email-new').val();
//     var password = $('#pw-new').val();

//     firebase.auth().createUserWithEamilAndPassword(email, password).then((result) => {
//         console.log(result);
//         console.log(result.user);
//     })
// })