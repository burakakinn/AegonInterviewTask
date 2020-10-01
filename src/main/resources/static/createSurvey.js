var baseurl = "http://localhost:8080/survey";
function addSurvey(){
    var topicName = document.getElementById("topicInput").value.trim();
    var question = document.getElementById("questionInput").value.trim();
    if(isEmptyOrSpaces(topicName) || isEmptyOrSpaces(question)){
        alert("Fields can not be null or blank!")
    } else {
        var survey = {
            topic: topicName,
            question: question
        };
        var json = JSON.stringify(survey);
        var httprequest = new XMLHttpRequest();
        httprequest.open("POST", baseurl + "/add", true);
        httprequest.setRequestHeader("Content-Type", "application/json");
        httprequest.onreadystatechange = function () {
            if (httprequest.readyState === 4 && httprequest.status === 200) {
                alert("Survey added.");
            } else if (httprequest.readyState === 4 && httprequest.status === 400) {
                alert("Survey already exists!")
            }
        };
        httprequest.send(json);
    }
}

function isEmptyOrSpaces(str){
    return str === null || str.match(/^\s*$/) !== null;
}