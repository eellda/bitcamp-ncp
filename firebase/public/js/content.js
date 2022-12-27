var quaryString = new URLSearchParams(window.location.search);


db.collection('product').doc(quaryString.get('id')).get().then((result) => {
    console.log(result.data());

    var templit = 
        `<div class="detail-pic my-4" style="background-image: url('${result.data().image}');"></div>
        <div>
        <h1 class="title">${result.data().title}</h1>
        <hr>
        <h3>작성자 : ${result.data().name}</h3>
        <p class="date">${result.data().date}</p>
        <p class="content">${result.data().content}</p>
        </div>`;

    $('.main > .container > .blog > .blog-card-group').append(templit);

})