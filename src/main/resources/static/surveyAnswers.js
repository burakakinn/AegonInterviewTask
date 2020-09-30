var baseurlSurvey = "http://localhost:8080/survey";
var baseurlAnswer = "http://localhost:8080/answer";
function loadTopics(){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",baseurlSurvey + "/allTopics",true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
            var results = JSON.parse(xmlhttp.responseText);
            var top = `<div class="input-group-prepend"><label class="input-group-text" for="inputGroupSelect01">CHOOSE TOPIC</label>
                    </div><select style="height: 40px" class="custom-select" id="inputGroupSelect01"><option selected>Choose...</option>`;
            //main table content we fill from data from the rest call
            var main ="";
            for (i = 0; i < results.length; i++){
                main += "<option value=\"1\">" + results[i] + "</option>";
            }
            var bottom = "</select>";
            var customSelect = top + main + bottom;
            document.getElementById("allTopics").innerHTML = customSelect;
        }
    };
    xmlhttp.send();
}
function loadTable(){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",baseurlAnswer + "/list",true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
            var results = JSON.parse(xmlhttp.responseText);
            var tbltop = `<table class="table"><thead>
			    <tr><th scope="col">TOPIC ID</th><th scope="col">TOPIC</th><th scope="col">NPM SCORE</th></tr></thead><tbody>`;
            //main table content we fill from data from the rest call
            var main ="";
            for (i = 0; i < results.length; i++){
                main += "<tr><td>"+results[i].topicId+"</td><td>"+results[i].topicName+"</td><td>"+results[i].npmScore+"</td></tr>";
            }
            var tblbottom = "</tbody></table>";
            var tbl = tbltop + main + tblbottom;
            document.getElementById("surveyTopicsWithNPM").innerHTML = tbl;
        }
    };
    xmlhttp.send();
}
window.onload = function(){
    // loadTopics();
}