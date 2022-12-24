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

const btn = document.querySelector('.btn');
const title = document.querySelector('#title');
const content = document.querySelector('#content');
const price = document.querySelector('#price');

btn.addEventListener('click', () => {
    db.collection('product').doc('post2').set({
        name: title.value,
        cost: price.value,
        content: content.value
    });
})
