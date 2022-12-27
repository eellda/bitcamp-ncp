var quaryString = new URLSearchParams(window.location.search);


db.collection('product').doc(quaryString.get('id')).get().then((result) => {
    console.log(result.data());
})

