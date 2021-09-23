

export function displayErrors(message){
    docNameError.style.display="block";
        docNameError.innerHTML=message;
        docNameError.classList.add("text-danger");
        docNameError=true;
}


export function hideErrors(){
    docNameError.style.display="none";
}