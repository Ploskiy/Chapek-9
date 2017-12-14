function controllerTaskList() {
    $.ajax("/controllerTaskList", {
        method: "GET"
    }).done(function (response) {
        var table = "<table class=\"table table-striped\">" + "\n" + "<tbody>";

        for (var i = 0; i < response.length; i++){
            table +=  "<tr>" + "\n";
            table +=  "<th>" + response[i].title + "</th>" + "\n";
            table += "</tr>" + "\n";
        }
        table += "</tbody>"  + "\n" + "</table>";
        var div = document.querySelector('#taskTable');
        div.innerHTML = table;

        console.log(response);
    });

    setTimeout(controllerTaskList, 5000);
}

function controllerRobotsList() {
    $.ajax("/allRobots", {
        method: "GET"
    }).done(function (response) {
        var robotTable = "<table class=\"table table-striped\">" + "\n" + "<tbody>";

        for (var i = 0; i < response.length; i++){
            var typeRobot = response[i].name.replace(/[0-9]+/, "");
            var task = response[i].task == null ? "-" : response[i].task.title;

            robotTable +=  "<tr>" + "\n";
            // robotTable +=  "<th>" + response[i].name + "</th>" + "\n";
            robotTable +=  "<th>" + "<img src=\"/resources/img/"
                + typeRobot
                + ".jpg\" class=\"img-rounded\" alt=\"Cinque Terre\">" + "</th>" + "\n";
            robotTable +=  "<th>" + response[i].free + "</th>" + "\n";
            robotTable +=  "<th>" + task + "</th>" + "\n";
            robotTable +=  "<th>" + response[i].robotLog[0] + "</th>" + "\n";
            robotTable += "</tr>" + "\n";
        }

        robotTable += "</tbody>"  + "\n" + "</table>";

        var roboDiv = document.querySelector('#numberOfRobots');
        roboDiv.innerHTML = robotTable;

        var roboCountDiv = document.querySelector('#robotCount');
        roboCountDiv.innerHTML = "Robots: " + response.length;

        console.log(response);
    });

    setTimeout(controllerRobotsList, 5000);
}

function controllerLogList() {
    $.ajax("/controllerLogList", {
        method: "GET"
    }).done(function (response) {
        var table = "<table class=\"table table-striped\">" + "\n" + "<tbody>";

        for (var i = 0; i < response.length; i++){
            table +=  "<tr>" + "\n";
            table +=  "<th>" + response[i] + "</th>" + "\n";
            table += "</tr>" + "\n";
        }
        table += "</tbody>"  + "\n" + "</table>";
        var div = document.querySelector('#LogTable');
        div.innerHTML = table;

        console.log(response);
    });

    setTimeout(controllerLogList, 5000);
}

function addTaskToController(data) {

    var dataButton = data;
    console.log(dataButton);

    $.ajax("/addTaskToController", {
        method: "POST",
        contextType: "application/json",
        data: dataButton
    })
}

function addRobot() {
    $.ajax("/addRobot", {
        method: "POST"
    })
}

function buttonsGroupsComandsForRobots() {
    $.ajax("/allComandsForRobots", {
        method: "GET"
    }).done(function (response) {
        console.log(response);
        var buttonsGroups = "" + "\n";

        for (var i = 0; i < response.length; i++){
            buttonsGroups +=  "<button type=\"button\" class=\"btn btn-primary\" onclick='addTaskToController(\"" + response[i] + "\")'>"  + response[i] + "</button>" + "\n";
        }
        buttonsGroups += "\n";
        console.log(buttonsGroups);

        var div = document.querySelector('#buttonsGroupsComandsForRobots');

        div.innerHTML = buttonsGroups;
    })
}