$(document).ready(function() {
    $.getJSON('http://localhost:8081/files', function(response) {
        var tr=[];
        for (var i = 0; i < response.length; i++) {
            tr.push('<tr>');
            tr.push('<td>' + response[i].id + '</td>');
            tr.push('<td> <strong>' + response[i].name + '</strong> </td>');
            tr.push('<td>'+ Math.trunc((response[i].size/1024))+' KB </td>');
            tr.push('<td>  <a href="'+response[i].url+'"><button class="primary">Download</button></a> </td>');
            tr.push('</tr>');

        }
        $('#tabela2').append($(tr.join()));
    });
});