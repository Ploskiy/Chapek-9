getPanelOfButtons();

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
    });

    setTimeout(controllerTaskList, 5000);
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
    });

    setTimeout(controllerLogList, 5000);
}

function addTaskToController(data) {
    var dataButton = data;

    $.ajax("/addTaskToController", {
        method: "POST",
        contextType: "application/json",
        data: dataButton
    })
}

function addTaskToRobot(dataButton , dataRobot) {
    $.ajax("/addTaskToRobot", {
        method: "POST",
        contextType: "application/json",
        data: {task: dataButton, name: dataRobot}
    })
}

function addRobot() {
    $.ajax("/addRobot", {
        method: "POST"
    })
}

var taskButtons = [];
var taskDescription = [];

function getPanelOfButtons() {
    $.ajax("/allTaskDescription", {
        method: "GET"
    }).done(function (response) {
        taskDescription = response;
    });

    setTimeout(createButtonsGroupsComandsForRobots(), 1000);
}

function controllerRobotsList() {
    $.ajax("/allRobots", {
        method: "GET"
    }).done(function (response) {

        var robotTable = "<table class=\"table table-striped\">" + "\n" + "<tbody>";

        for (var i = 0; i < response.length; i++){
            var buttonsGroupsForRobot = "" + "\n";
            for (var n = 0; n < taskButtons.length; n++){
                buttonsGroupsForRobot += "<button type=\"button\" class=\"btn btn-primary btn-xs\" onclick='addTaskToRobot(\"" + taskButtons[n]
                    + "\", \"" + response[i].name + "\")'>" + taskDescription[taskButtons[n]] + "</button>" + "\n";
            }
            buttonsGroupsForRobot += "\n";

            var typeRobot = response[i].name.replace(/[0-9]+/, "");
            var task = response[i].task == null ? "-" : response[i].task.title;

            robotTable +=  "<tr>" + "\n";
            robotTable +=  "<th>" + "<img src=\"/resources/img/"
                + typeRobot
                + ".jpg\" class=\"img-rounded\" alt=\"Cinque Terre\">" + "</th>" + "\n";
            robotTable +=  "<th>" +
                "<div class=\"btn-group-vertical\">" +
                buttonsGroupsForRobot +
                "</div>" +
                "</th>" + "\n";
            robotTable +=  "<th>" + response[i].robotLog[0] + "</th>" + "\n";
            robotTable += "</tr>" + "\n";
        }

        robotTable += "</tbody>"  + "\n" + "</table>";

        var roboDiv = document.querySelector('#numberOfRobots');
        roboDiv.innerHTML = robotTable;

        var roboCountDiv = document.querySelector('#robotCount');
        roboCountDiv.innerHTML = "Robots (6 max): " + response.length;
    });

    setTimeout(controllerRobotsList, 5000);
}

function createButtonsGroupsComandsForRobots() {
    $.ajax("/allComandsForRobots", {
        method: "GET"
    }).done(function (response) {
        taskButtons = response;

        var buttonsGroups = "" + "\n";

        for (var i = 0; i < taskButtons.length; i++) {
            buttonsGroups += "<button type=\"button\" class=\"btn btn-primary\" onclick='addTaskToController(\""
                + taskButtons[i] + "\")'>" + taskDescription[taskButtons[i]] + "</button>" + "\n";
        }
        buttonsGroups += "\n";

        var div = document.querySelector('#buttonsGroupsComandsForRobots');
        div.innerHTML = buttonsGroups;
    })
}