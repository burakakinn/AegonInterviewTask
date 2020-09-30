var baseurlSurvey = "http://localhost:8080/survey";
var baseurlAnswer = "http://localhost:8080/answer";
var score = 0;
var topicId = 0;
function loadTopics(){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",baseurlSurvey + "/allResults",true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
            var results = JSON.parse(xmlhttp.responseText);
            var top = `<div class="input-group-prepend"><label class="input-group-text" for="inputGroupSelect01">CHOOSE TOPIC</label>
                    </div><select onchange="loadFields(value);setTopicId(value);" style="height: 40px" class="custom-select" id="inputGroupSelect01"><option selected>Choose...</option>`;
            //main table content we fill from data from the rest call
            var main ="";
            for (i = 0; i < results.length; i++){
                main += "<option value=\""+results[i].topicId+"\">" + results[i].topicName + "</option>";
            }
            var bottom = "</select>";
            var customSelect = top + main + bottom;
            document.getElementById("allTopics").innerHTML = customSelect;
        }
    };
    xmlhttp.send();
}

function loadFields(id){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",baseurlSurvey + "/"+id,true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
            var result = JSON.parse(xmlhttp.responseText);
            document.getElementById("topic").innerHTML = "<p>How likely are you to recommend " + result.topic +" to a friend or colleague?</p>";
            document.getElementById("question").innerHTML = "<p>"+result.question+"</p>";
        }
    };
    xmlhttp.send();
}

window.onload = function(){
    loadTopics();
}

function submitSurvey(){
    var answer = {
        topicId: topicId,
        score: score,
        feedback: document.getElementById("answerInput").value
    };
    var json = JSON.stringify(answer);
    var httprequest = new XMLHttpRequest();
    httprequest.open("POST", baseurlAnswer + "/add",true);
    httprequest.setRequestHeader("Content-Type", "application/json");
    httprequest.send(json);
    alert("Survey submitted.");
}

function setScore(scoreInput){
    score = scoreInput;
}

function setTopicId(id){
    topicId = id;
}
