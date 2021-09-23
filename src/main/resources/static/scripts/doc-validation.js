// import { displayErrors } from "./error";


// 1- Select dom elemnts

let docName = document.getElementById("docName");
let docEmail = document.getElementById("docEmail");
let docAddr = document.getElementById("docAddr");
let docNumber = document.getElementById("docNumber");
let docGender = document.getElementById("docGender");
let docNote = document.getElementById("docNote");

let docNameError = document.getElementById("docNameError");
let docEmailError = document.getElementById("docEmailError");
let docAddrError = document.getElementById("docAddrError");
let docNumberError = document.getElementById("docNumberError");
let docGenderError = document.getElementById("docGenderError");
let docNoteError = document.getElementById("docNoteError");

// 2- Hide the error section

docNameError.style.display = "none";
docEmailError.style.display = "none";
docAddrError.style.display = "none";
docNumberError.style.display = "none";
docGenderError.style.display = "none";
docNoteError.style.display = "none";


// 2- Declare error variable with initial value false

let docNameErrorBoolean = false;
let docEmailErrorBoolean = false;
let docAddrErrorBoolean = false;
let docNumberErrorBoolean = false;
let docGenderErrorBoolean = false;
let docNoteErrorBoolean = false;

// 3- define validate function

function validate_docName() {
    let expression = /^[A-Za-z\s]{4,20}$/
    if (docName.value == '') {
        let message = "<b>Name</b> can't be empty";
        docNameError.style.display = "block";
        docNameError.innerHTML=message;
        docNameError.classList.add("text-danger");
    } else if (!expression.test(docName.value)) {
        let message = "Only alphabets are allowed with max 20 chars."
        docNameError.style.display = "block";
        docNameError.innerHTML=message;
        docNameError.classList.add("text-danger");
    } else {
        const xhr = new XMLHttpRequest();
        let url = `check-doc-name?docName=${docName.value}`;
        xhr.open('GET', url);
        xhr.onload = function () {
            const isExist = JSON.parse(xhr.response);
            let message = "Name already exist"
            console.log(typeof isExist + " " + isExist)
            if (isExist) {
                docNameError.style.display = "block";
                docNameError.innerHTML = message;
                docNameError.classList.add("text-danger");
                docNameErrorBoolean = true;
            }
            else {
                docNameError.style.display = "none";
                docNameErrorBoolean = false;
            };
        }
        xhr.send();
    }
}

function validate_docAddress() {
    let expression = /^[A-Za-z0-9\s'.]{8,200}$/
    if (docAddr.value == '') {
        let message = "<b>Address</b> can't be empty";
        docAddrError.style.display = "block";
        docAddrError.innerHTML=message;
        docAddrError.classList.add("text-danger");
    } else if (!expression.test(docAddr.value)) {
        let message = "Only alphabets are allowed with max 200 chars."
        docAddrError.style.display = "block";
        docAddrError.innerHTML=message;
        docAddrError.classList.add("text-danger");
    } else {
        const xhr = new XMLHttpRequest();
        let url = `check-doc-addr?docAddr=${docAddr.value}`;
        xhr.open('GET', url);
        xhr.onload = function () {
            const isExist = JSON.parse(xhr.response);
            let message = "Name already exist"
            console.log(docAddrError)
            if (isExist) {
                docAddrError.style.display = "block";
                docAddrError.innerHTML = message;
                docAddrError.classList.add("text-danger");
                docAddrErrorBoolean = true;
            }
            else {
                docAddrError.style.display = "none";
                docAddrErrorBoolean = false;

            };
            console.log(docAddrError)
        }
        xhr.send();
    }
}
// link the validate function to action events
docName.addEventListener("keyup", function () {
    validate_docName();
})

docAddr.addEventListener("keyup", function () {
    validate_docAddress();
})










