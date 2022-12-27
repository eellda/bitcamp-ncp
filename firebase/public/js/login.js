firebase.auth().onAuthStateChanged((user) => {
    if(user) {
        console.log(user.uid);
        console.log(user.displayName);
        //window.location.href = "index.html";
        $('#userName').html(user.displayName + '님');
    }
})

$('#login').click(function () {

    var email = $('#email').val();
    var password = $('#pw').val();

    firebase.auth().signInWithEmailAndPassword(email, password).then((result) => {
        console.log(result.user);
    })
})

$('#logout').click(function () {
    firebase.auth().signOut();
})


$('#register').click(function () {

    var email = $('#email-new').val();
    var password = $('#pw-new').val();
    var name = $('#name-new').val();

    firebase.auth().createUserWithEmailAndPassword(email, password).then((result) => {
        console.log(result);
        console.log(result.user);
        result.user.updateProfile({displayName: name})
    })
})

