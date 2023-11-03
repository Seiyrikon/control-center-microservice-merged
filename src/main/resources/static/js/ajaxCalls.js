window.onload = function() {
    initialDomLoad();
}

let initialDomLoad = function initialDomLoadHandler() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        projectTable();
      }
    };
    xhttp.open("GET", "http://localhost:8080/index/sample-index", true);
    xhttp.send();
}

let projectTable = function getProjectTable() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("content").innerHTML = this.responseText;

            //callback function for datatable js
            dataTableCallBack();
        }
    };
    xhttp.open("GET", "http://localhost:8080/index/project-table", true);
    xhttp.send();
}

let projectMembers = function getProjectMembers(projectId) {
    let xhttp = new XMLHttpRequest();
    // let projectId = document.getElementById("project-id").textContent;

    console.log("projectId: ", projectId);

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("content").innerHTML = this.responseText;
            dataTableCallBack();
        }

        projectMembersCallBack();
    };
    xhttp.open("GET", `http://localhost:8080/index/project-members/${projectId}`, true);
    xhttp.send();
}

let projectAttribute = function getProjectAttribute(projectId) {
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("content").innerHTML = this.responseText;
        }

        projectMembersCallBack();
    };
    xhttp.open("GET", `http://localhost:8080/index/project/${projectId}`, true);
    xhttp.send();
}
