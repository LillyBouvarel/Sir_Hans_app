function postServerData(url,data,callDone){
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        url: url,
        data: data,
        success: callDone
    });
}

function getServerData(url,callDone){
    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (response) {
            callDone(response);
        }
    });
}


/**
 * try to get the user who has the given name and test if he has
 * entered the right password
 */
function connection(username,password){

    var data = JSON.stringify([username,password]);

    postServerData("ws/User/connection",data,function(response){
        if (response){
            window.location.href="main.html";//here we go to the map tagger!
            
        }
        else{
            alert("Error: the username and the password doesn't match");
        }
    })
}


