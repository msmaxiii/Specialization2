//$(document).ready(function(){
//    $(".content).click(function()){
//        $(".content").toggleClass("heart-active")
//         $(".favorite").toggleClass("heart-active")
//          $(".heart").toggleClass("heart-active")
//           $(".numb").toggleClass("heart-active")
//    });
//});

const heartBtn = document.getElementById('heart-Btn')


const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/customer'


const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        favoriteHeart: favorite.value,

    }

    const response = await fetch(`${baseUrl}/favorite`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(onclick ="favorite.html")
    }
}

favoriteForm.addEventListener("submit", handleSubmit)
