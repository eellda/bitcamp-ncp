




const blogTitleField = document.querySelector('.title');
const articleFeild = document.querySelector('.article');

// banner
const bannerImage = document.querySelector('#banner-upload');

console.log(bannerImage);
const banner = document.querySelector(".banner");
let bannerPath;

const publishBtn = document.querySelector('.publish-btn');
const uploadInput = document.querySelector('#image-upload');
console.log(uploadInput);
//console.log(publishBtn);

bannerImage.addEventListener('change', () => {
    uploadImage(bannerImage, "banner");
})

uploadInput.addEventListener('change', () => {
    uploadImage(uploadInput, "image");
})


const uploadImage = (uploadFile, uploadType) => {

    const [file] = uploadFile.files;

    if (file && file.type.includes("image")) {
        const formdata = new FormData();
        formdata.append("image", file);

        fetch('/upload', {
            method:'post', 
            body: formdata
        }).then(res => res.json()).then(data => {
            if(uploadType == "image") {
                addImage(data, file.name);
            } else {
                bannerPath = `${location.origin}/${data}`;
                banner.style.backgroundImage = `url("${bannerPath}")`;
            }
        })
    } else {
        alert('upload Image only');
    }
}

const addImage = (imagepath, alt) => {
    let curPos = articleFeild.selectionStart;
    let textToInsert = `\r![${alt}](${imagepath})\r`;

    articleFeild.value = articleFeild.value.slice(0, curPos) + textToInsert + 
    articleFeild.value.slice(curPos);
}

let months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

publishBtn.addEventListener('click', () => {
    console.log('yes');
    if(articleFeild.value.length && blogTitleField.value.length){
        // generating id
        let letters = 'abcdefghijklmnopqrstuvwxyz';
        let blogTitle = blogTitleField.value.split(" ").join("-");
        let id = '';
        for(let i = 0; i < 4; i++){
            id += letters[Math.floor(Math.random() * letters.length)];
        }

        // setting up docName
        let docName = `${blogTitle}-${id}`;
        let date = new Date(); // for published at info

        console.log(docName);

        //access firstore with db variable;
        db.collection("product").doc(docName).set({
            title: blogTitleField.value,
            article: articleFeild.value,
            bannerImage: bannerPath,
            publishedAt: `${date.getDate()} ${months[date.getMonth()]} ${date.getFullYear()}`
        })
        .then((result) => {
            console.log(result);
            location.href = `/${docName}`;
        })
        .catch((err) => {
            console.error(err);
        })
    }
})
        // https://www.youtube.com/watch?v=AWHGQfzfHxI 30:00
        // npm install xpress-fileupload



// const btn = document.querySelector('#send');
// const title = document.querySelector('#title');
// const content = document.querySelector('#content');
// const price = document.querySelector('#price');
// const storage = firebase.storage();
        
// publishBtn.addEventListener('click', () => {
//     console.log('yes');

//     db.collection('product').add({
//         name: $(blogTitleField).val(),
//         //cost: price.value,
//         content: articleFeild.value,
//         date: `${date.getDate()} ${months[date.getMonth()]} ${date.getFullYear()}`
//     }).then((result) => {
//         console.log(result);
//         window.location.href = "index.html";
//     }).catch((err) => {
//         console.log(err); 
//     })
// })













// 내가 적은거
// publishBtn.addEventListener('click', () => {
//     if(articleFeild.value.length && blogTitleField.value.length) {
//         let letters = 'abcdefghijklmnopqrstuvwxyz';
//         let blogTitle = blogTitleField.value.split(" ").join("-");
//         let id = '';
//         for (let i = 0; i < 4; i++) {
//             id += letters[Math.floor(Math.random() * letters.length)];
//         }

//         let docName = `${blogTitle}-${id}`;
//         let date = new Date();

//         db.collection('blogs').doc(docName).set({
//             title: blogTitleField.value,
//             article: articleFeild.value,
//             bannerImage: bannerPath,
//             publishAt: `${date.getDate()} ${months[date.getMonth()]} ${date.getFullYear()}`
//         })
//         .then(() => {
//             console.log('date entered');
//             location.href = `/${docName}`;
//         })
//         .catch((err) => {
//             console.error(err);
//         })
//     }
// })







// uploadInput.addEventListener('change', () => {
//     uploadImage(uploadInput, "image");
// })

// const uploadImage = (uploadFile, uploadType) => {
//     const [file] = uploadFile.files;
//     if(file && file.type.includes("image")){
//         const formdata = new FormData();
//         formdata.append('image', file);

//         fetch('/upload', {
//             method: 'post',
//             body: formdata
//         }).then(res => res.json())
//         .then(data => {
//             if(uploadType == "image"){
//                 addImage(data, file.name);
//             } else{
//                 bannerPath = `${location.origin}/${data}`;
//                 banner.style.backgroundImage = `url("${bannerPath}")`;
//             }
//         })
//     } else{
//         alert("upload Image only");
//     }
// }

// const addImage = (imagepath, alt) => {
//     let curPos = articleFeild.selectionStart;
//     let textToInsert = `\r![${alt}](${imagepath})\r`;
//     articleFeild.value = articleFeild.value.slice(0, curPos) + textToInsert + articleFeild.value.slice(curPos);
// }

// let months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

// publishBtn.addEventListener('click', () => {
//     if(articleFeild.value.length && blogTitleField.value.length){
//         // generating id
//         let letters = 'abcdefghijklmnopqrstuvwxyz';
//         let blogTitle = blogTitleField.value.split(" ").join("-");
//         let id = '';
//         for(let i = 0; i < 4; i++){
//             id += letters[Math.floor(Math.random() * letters.length)];
//         }

//         // setting up docName
//         let docName = `${blogTitle}-${id}`;
//         let date = new Date(); // for published at info

//         //access firstore with db variable;
//         db.collection("blogs").doc(docName).set({
//             title: blogTitleField.value,
//             article: articleFeild.value,
//             bannerImage: bannerPath,
//             publishedAt: `${date.getDate()} ${months[date.getMonth()]} ${date.getFullYear()}`
//         })
//         .then(() => {
//             location.href = `/${docName}`;
//         })
//         .catch((err) => {
//             console.error(err);
//         })
//     }
// })
