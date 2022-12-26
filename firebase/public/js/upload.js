const firebaseConfig = {

    // my key
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

btn.addEventListener('click', () => {

    var file = document.querySelector('#image').files[0];
    var storageRef = storage.ref();
    var saveLink = storageRef.child('image/' + '파일명');
    var 업로드작업 = saveLink.put(file)
    
    var save = {
        name: $(title).val(),
        //cost: price.value,
        content: content.value,
        date: new Date()
    }
    db.collection('product').add(save).then((result) => {
        console.log(result);
        window.location.href = "index.html";
    }).catch((err) => {
        console.log(err); 
    })
})
// btn.addEventListener('click', () => {
//     window.location.href = "index.html";
// })