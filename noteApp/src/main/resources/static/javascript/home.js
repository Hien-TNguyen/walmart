// read the cookie to get login
const cookieArr = document.cookie.split("=");
const userId = cookieArr[1];

// get the DOM elements
const submitForm = document.getElementById("note-form");
const noteContainer = document.getElementById("note-container");

// modal Elements 
let noteBody = document.getElementById("note-body");
let updateNoteBtn = document.getElementById("update-note-button");

const headers = {
  'Content-Type': 'application/json'
};

const baseURL = "http://localhost:8080/api/v1/notes/";

// clear cookie when logging out
function handleLogout() {
  let cookie = document.split(";");
  for (let i in cookie) {
    document.cookie = /^[^=]+/.exec(cookie[i])[0]+"=;expires=Thu, 01 Jan 1070 00:00:00 GMT";
  }
}

// Handle submit 
const handleSubmit = async (e) => {
  e.preventDefault();
  let bodyObj = {
    body: document.getElementById("note-input").value 
  }
  await addNote(bodyObj);
  document.getElementById("note-input").value = '';
}

async function addNote(obj) {
  const response = await fetch(`${baseURL}user/${userId}`, {
    method: "POST",
    body: JSON.stringify(obj),
    headers: headers
  })
    .catch(err => console.error(err.message))
  if (response.status == 200) {
    return getNotes(userId);
  }
}

async function getNotes(userId) {
  await fetch(`${baseURL}user/${userId}`, {
    method: "GET",
    headers: headers
  })
    .then(response => response.json())
    .then(data => createNoteCards(data))
    .catch(err => console.error(err))
}

async function getNoteById(noteId) {
  await fetch(baseURL + noteId, {
    method: "GET",
    headers: headers
  })
    .then(res => res.json())
    .then(data => popularModal(data))
    .catch(err => console.error(err.message))
}

async function handleNoteEdit(noteId) {
  let bodyObj = {
    id: noteId,
    body: noteBody.value
  }

  await fetch(baseURL, {
    method: "PUT",
    body: JSON.stringify(bodyObj),
    headers: headers
  })
    .catch(err => console.error(err))
  return getNotes(userId);
}

async function handleDelete(noteId) {
  await fetch(baseURL + noteId, {
    method: "DELETE",
    headers: headers
  })
    .catch(err => console.error(err)) 
  
  return getNotes(userId);
}

const createNoteCards = (array) => {
  noteContainer.innerHTML = ''
  array.forEach(obj => {
    let noteCard = document.createElement("div")
    noteCard.classList.add("m-2")
    noteCard.innerHTML = `
      <div class="card d-flex" style="width: 18rem; height: 18rem;">
        <div class="card-body d-flex flex-column justify-content-between" style="height:available">
          <p class="card-text">${obj.body}</p>
          <div class="d-flex justify-content-between">
            <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
            <button onclick="getNoteById(${obj.id})" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#note-edit-modal">Edit</button>
          </div>
        </div>
      </div>
    `
    noteContainer.append(noteCard);
  })
}

// popular Modal
// accept an object then use the object to populate the fields

const populateModal = (obj) => {
  noteBody.innerText = '';
  noteBody.innerText = obj.body;
  updateNoteBtn.setAttribute('data-note-id', obj.id);
}

// invoke getNotes and pass in userId 
getNotes(userId);

submitForm.addEventListener("submit", handleSubmit)

updateNoteBtn.addEventListener("click", (e) => {
  let noteId = e.target.getAttribute('data-note-id')
  handleNoteEdit(noteId);
})

