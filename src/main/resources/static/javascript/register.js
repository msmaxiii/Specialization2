const registerForm = document.getElementById('register-form')
const registerCustomerName = document.getElementById('register-username')
const registerPassword = document.getElementById('register-password')
const registerEmail = document.getElementById('register-email')
const submitButton = document.getElementById('submit-button')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'


const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        username: registerCustomerName.value,
        password: registerPassword.value,
        email: registerEmail.value
    }

    const response = await fetch(${baseUrl}/register, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

submitButton.addEventListener("click", handleSubmit)