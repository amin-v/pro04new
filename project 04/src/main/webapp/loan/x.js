function createLoan() {
    var loanName = document.getElementById("loanName1").value;
    var minDuration = document.getElementById("minDuration1").value;
    var maxDuration = document.getElementById("maxDuration1").value;
    var minAmount = document.getElementById("minAmount1").value;
    var maxAmount= document.getElementById("maxAmount1").value ;
    var interestRate= document.getElementById("interestRate1").value ;

    var params = "loanName="+loanName+"&minDuration="+minDuration+ "&maxDuration="+maxDuration+ "minAmount="+minAmount+ "interestRate="+ interestRate;
    alert(params);
    if (navigator.appName == "Microsoft Internet Explorer") {
        http = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        http = new XMLHttpRequest();
    }
    http.open("POST", "/loan/create.do", true);

    http.onreadystatechange = function () {
        if (http.readyState == 4) {
            document.getElementById('resultCreate').innerText = http.responseText;
        }
    }
    http.send(params);


}
