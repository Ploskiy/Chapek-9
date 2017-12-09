function controllerTaskList() {
    $.ajax("/controllerTaskList", {
        "method": "GET"
    }).done(function (response) {
        console.log(response);
    })
}

function addTaskToController() {
    var title = $("#title").val();
    var type = $("#type").val();

    $.ajax("/addTaskToController", {
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            title: title,
            type: type
        })
    })
}

function buttonsGroupsComandsForRobots() {
    $.ajax("/allComandsForRobots", {
        "method": "GET"
    }).done(function (response) {
        console.log(response);
        var buttonsGroups = "" + "\n";

        for (var i = 0; i < response.length; i++){
            buttonsGroups +=  "<button type=\"button\" class=\"btn btn-primary\">" + response[i] + "</button>" + "\n";
        }
        buttonsGroups += "\n";
        console.log(buttonsGroups);

        var div = document.querySelector('#buttonsGroupsComandsForRobots');

        div.innerHTML = buttonsGroups;
    })
}