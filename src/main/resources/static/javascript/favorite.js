
//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("favorite-form")
const favoriteContainer = document.getElementById("favorite-container")
//const form = document.querySelector('#email');

//Modal Elements
let favoriteBody = document.getElementById("favorite-body")
let updateFavoriteBtn = document.getElementById("update-favorite-button")

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/favorite/'

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
     favorite: document.getElementById("favorite-input").value
    }
    console.log(bodyObj);

    await addFavorite(bodyObj);
    document.getElementById("favorite-input").value = ''
}

async function addFavorite(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getFavorites(userId);
    }
   }
    async function getFavorites(userId) {
        await fetch(`${baseUrl}user/${userId}`, {
            method: "GET",
            headers: headers
        })
            .then(response => response.json())
            .then(data => createFavoriteCards(data))
            .catch(err => console.error(err))
    }

    async function handleDelete(favoriteId){
        await fetch(baseUrl + favoriteId, {
            method: "DELETE",
            headers: headers
        })
            .catch(err => console.error(err))

        return getFavorites(userId);
    }


async function getFavoriteById(favoriteId){
    await fetch(baseUrl + favoriteId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))
}

async function handleFavoriteEdit(favoriteId){
    let bodyObj = {
        id: favoriteId,
       body: favoriteBody.value
    }


    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getFavorites(userId);
}

const createFavoriteCards = (array) => {
    favoriteContainer.innerHTML = ''
    array.forEach(obj => {
        let favoriteCard = document.createElement("div")
        favoriteCard.classList.add("m-2")
       favoriteCard.innerHTML =`
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">${obj.favorite}</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
                        <button onclick="getFavoriteById(${obj.id})" type="button" class="btn btn-primary"
                        data-bs-toggle="modal" data-bs-target="#favorite-edit-modal">
                        Edit
                        </button>
                    </div>
                </div>
            </div>
            `
        favoriteContainer.append(favoriteCard);
    })
}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }

}

const populateModal = (obj) =>{
    favoriteBody.innerText = ''
    favoriteBody.innerText = obj.body
    updateFavoriteBtn.setAttribute('data-favorite-id', obj.id)
}

getFavorites(userId);

submitForm.addEventListener("submit", handleSubmit)

updateFavoriteBtn.addEventListener("click", (e)=>{
    let favoriteId = e.target.getAttribute('data-favorite-id')
    handleFavoriteEdit(favoriteId);
})











