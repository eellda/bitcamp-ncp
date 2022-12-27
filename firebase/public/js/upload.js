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

const btn = document.querySelector('#send');
const title = document.querySelector('#title');
const content = document.querySelector('#content');
const price = document.querySelector('#price');
const storage = firebase.storage();

firebase.auth().onAuthStateChanged((user) => {
    if(user) {
        console.log(user.uid);
        console.log(user.displayName);
        $('#userName').html(user.displayName + '님');
    }
})

btn.addEventListener('click', () => {

    var file = document.querySelector('#image').files[0];
    var storageRef = storage.ref();
    var saveLink = storageRef.child('image/' + file.name);
    var upLoad = saveLink.put(file)

    upLoad.on( 'state_changed', 
    // 변화시 동작하는 함수 
        null, 
        //에러시 동작하는 함수
        (error) => {
            console.error('실패사유는', error);
        }, 
        // 성공시 동작하는 함수
        () => {
            upLoad.snapshot.ref.getDownloadURL().then((url) => {
                console.log('업로드된 경로는', url);

                var save = {
                    name: $(title).val(),
                    //cost: price.value,
                    content: content.value,
                    date: new Date(),
                    image: url
                }
                db.collection('product').add(save).then((result) => {
                    console.log(result);
                    window.location.href = "index.html";
                }).catch((err) => {
                    console.log(err); 
                })
            });
        }
    );
    
   
})
// btn.addEventListener('click', () => {
//     window.location.href = "index.html";
// })