$('#singleUploadForm').submit(function(event) {
    var formElement = this;

    var formData = new FormData(formElement);


    var a = document.getElementById("linkid");
    var tabela = document.getElementById("tabelaid");

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "http://localhost:8081/upload",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log("HI");
            console.log(response);
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p>"
            fileid.innerHTML = response.id;
            filename.innerHTML = response.name;
            filesize.innerHTML = "<p>"+Math.trunc((response.size/1024))+" KB</p>";
            tabela.style.display="block";   
            a.style.display="block";
            a.href = response.url;
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