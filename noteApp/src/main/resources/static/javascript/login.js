
// create variable to store elements 
const loginForm = document.getElementById('login-form');
const loginUsername = document.getElementById('login-username');
const loginPassword = document.getElementById('login-password');

// create header and baseURL variable
const headers = {
  'Content-Type': 'application/json'
};

const baseURL = 'http://localhost:8080/api/v1/users';

// create function to handle submiting form.
const loginSubmit = async (e) => {
  // prevent default behavior of the form
  e.preventDefault()
  // get the value of the inputs and store them inside an Object
  let bodyObj = {
    username: loginUsername.value,
    password: loginPassword.value
  }
  // make the request and handle the response
  const response = await fetch(`${baseURL}/login`, {
    method: "POST",
    body: JSON.stringify(bodyObj),
    headers: headers
  })
    .catch(err => console.error(err.message))

  const responseArr = await response.json()

  if (response.status === 200) {
    document.cookie =`userId=${responseArr[1]}`
    window.location.replace(responseArr[0])
  }

}
// add event listener to listen to submit event and invoke the handleSubmit

loginForm.addEventListener("submit", loginSubmit)