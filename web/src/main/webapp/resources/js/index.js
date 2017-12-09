function getRole() {
    $.ajax("/test", {
        "method": "GET"
    }).done(function (response) {
        console.log(response);
        $('#role').text(response.role);
    })
}