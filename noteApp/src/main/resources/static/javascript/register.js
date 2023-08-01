
// create variable to store elements 
const registerForm = document.getElementById('register-form');
const registerUsername = document.getElementById('register-username');
const registerPassword = document.getElementById('register-password');

// create header and baseURL variable
const headers = {
  'Content-Type': 'application/json'
};

const baseURL = 'http://localhost:8080/api/v1/users';

// create function to handle submiting form.
const handleSubmit = async (e) => {
  // prevent default behavior of the form
  e.preventDefault()
  // get the value of the inputs and store them inside an Object
  let bodyObj = {
    username: registerUsername.value,
    password: registerPassword.value
  }
  // make the request and handle the response
  const response = await fetch(`${baseURL}/register`, {
    method: "POST",
    body: JSON.stringify(bodyObj),
    headers: headers
  })
    .catch(err => console.error(err.message))

  const responseArr = await response.json()

  if (response.status === 200) {
    window.location.replace(responseArr[0])
  }

}
// add event listener to listen to submit event and invoke the handleSubmit

registerForm.addEventListener("submit", handleSubmit)