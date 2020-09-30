var baseurl = "http://localhost:8080/survey";
function addSurvey(){
    var survey = {
        topic: document.getElementById("topicInput").value,
        question: document.getElementById("questionInput").value
    };
    var json = JSON.stringify(survey);
    var httprequest = new XMLHttpRequest();
    httprequest.open("POST", baseurl + "/add",true);
    httprequest.setRequestHeader("Content-Type", "application/json");
    httprequest.send(json);
    alert("Survey added.");
}