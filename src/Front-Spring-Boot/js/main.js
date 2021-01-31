$('#singleUploadForm').submit(function(event) {
    var formElement = this;
    // You can directly create form data from the form element
    // (Or you could get the files from input element and append them to FormData as we did in vanilla javascript)
    var formData = new FormData(formElement);
    console.log("HELLO")
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "http://localhost:8080/upload",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log("HI");
            console.log(response);
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p> <p>DownloadUrl : <a href='" + response.url+ "' target='_blank'>" + response.url + "</a></p> <p>Name of the file: </p>" + response.name;

        },
        error: function (error) {
            console.log("HI2");
            console.log(error);
            // process error
        }
    });
    console.log("HI3");
    event.preventDefault();
});