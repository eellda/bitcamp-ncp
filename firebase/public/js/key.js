const firebaseConfig = {
  apiKey: "",
  authDomain: "",
  projectId: "",
  storageBucket: "",
  messagingSenderId: "",
  appId: ""

  
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
