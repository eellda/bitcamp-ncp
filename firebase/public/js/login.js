$('#register').click(function () {

    var email = $('#email-new').val();
    var password = $('#pw-new').val();

    firebase.auth().createUserWithEmailAndPassword(email, password).then((result) => {
        console.log(result);
        console.log(result.user);
    })
})

