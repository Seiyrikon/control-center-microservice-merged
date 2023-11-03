window.onload = function() {
    initialDomLoad();
}

let initialDomLoad = function initialDomLoadHandler() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        topNavigation();
        projectTable();
      }
    };
    xhttp.open("GET", "http://localhost:8080/index/project", true);
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

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("content").innerHTML = this.responseText;

            //callback function for datatable js
            dataTableCallBack();
        } else {
            errorPage();
        }
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

        datePickerCallBack();
    };
    xhttp.open("GET", `http://localhost:8080/index/project/${projectId}`, true);
    xhttp.send();
}

let topNavigation = function getTopNavigation() {
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("top-nav").innerHTML = this.responseText;
        }
    }
    xhttp.open("GET", "http://localhost:8080/index/top-nav", true);
    xhttp.send();
}

let errorPage = function getErrorPage() {
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState < 4 && this.status > 200) {
            document.getElementById("body").innerHTML = this.responseText;
        }
    }
    xhttp.open("GET", "http://localhost:8080/index/error-page", true);
    xhttp.send();
}
