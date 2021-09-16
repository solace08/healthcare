
$(document).ready(function(){
    // 1. hide error section
    $("#specCodeError").hide();
    $("#specNameError").hide();
    $("#specNoteError").hide();

    // 2. define error variable with initial value false;
    var specCodeError=false;
    var specNameError=false;
    var specNoteError=false;


    // 3. validate function
    function specCode_validate() {
	console.log("validated")
        let specVal=$("#specCode").val().toUpperCase();
        $("#specCode").val(specVal);
        let specMsg= $("#specCodeError");
        let exp= /^[A-Za-z0-9]{4,12}$/;
      if(specVal==''){
          specMsg.show();
          specMsg.html("<p class='text-danger'>**<b>Code</b> cannot be empty..</p>")
          specCodeError=true;
      }
      else if(!exp.test(specVal)){
        specMsg.show();
        specMsg.html("<p class='text-danger'>**<b>Code</b> [A-Za-z0-9] chars are allowed with min 4 and max 12 characters..</p>")
        specCodeError=true;
    }
      else {
          specMsg.hide();
          specCodeError=false;
      }

        return specCodeError;
    }

    function specName_validate(){
	console.log(specCodeError)
        let exp= /^[A-Za-z\s]{6,40}$/
        if($("#specName").val() ==''){
            $("#specNameError").show();
            $("#specNameError").html("<p class='text-danger'>**<b>Name</b> cannot be empty..</p>")
            specNameError=true;
        }
        else if(! exp.test($("#specName").val())){
            $("#specNameError").show();
            $("#specNameError").html("<p class='text-danger'>**<b>Name</b> [A-Za-z/s] are allowed with max 40 characters..</p>")
            specNameError=true;
        }
        else {
            $("#specNameError").hide();
            specNameError=false;
        }
        return specNameError;
    }

    function specNote_validate(){
	    console.log("validated")
        let exp = /^[A-Za-z0-9\s\,\'\.]{20,250}$/
        if($("#specNote").val() ==''){
            $("#specNoteError").show();
            $("#specNoteError").html("<p class='text-danger'>**<b>Note</b> cannot be empty..</p>")
            specNoteError=true;
        }
        else if(! exp.test($("#specNote").val())){
            $("#specNoteError").show();
            $("#specNoteError").html("<p class='text-danger'>**<b>Note</b> Maximum allowed characters are 250..Check terms for allowed characters</p>")
            specNoteError=true;
        }
        else {
            $("#specNoteError").hide();
            specNoteError=false;
        }
        return specNoteError;
    }
    // link action with function
    $("#specCode").keyup(function(){
        console.log(this)
        specCode_validate(this);
    })

    $("#specName").keyup(function(){
        specName_validate();
    })

    $("#specNote").keyup(function(){
        specNote_validate();
    })
        
    

    // on form submit

   $("#spec-form").submit(function(){
	  specCode_validate();
	  specName_validate();
	  specNote_validate();
	  console.log(specCodeError+" "+ specNameError+" "+specNoteError)
	  if(specCodeError) return false;
	  else if(specNameError) return false;
	  else if(specNoteError) return false;
        
	  else
	   return true;
   })
})
