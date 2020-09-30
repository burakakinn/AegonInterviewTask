var baseurl = "http://localhost:8080/survey";
function loadResults(){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",baseurl + "/allResults",true);
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
    loadResults();
}