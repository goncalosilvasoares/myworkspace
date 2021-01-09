var API_URL = 'http://localhost:8080/urlShortster/api';
var idUrl;

$(document).ready(function() {

  var parameters = location.search.substring(1).split("&");
  var temp = parameters[0].split("=");
  idUrl = temp[1];

  getURL();
  openURL();
  backURL();
});

function errorCallback(request, status, error){
    console.log("fail");
}

function getURL() {
  $.ajax({
        url: API_URL + "/getById/" + idUrl,
        async: true,
        success: function(data) {
          $('#form-urlLong-detail').val(data.url_long);
          $('#form-urlShort-detail').val(data.url_short);
          $('#form-creation-detail').val(transformDate(data.createDate));
          $('#form-lastAccess-detail').val(transformDate(data.updateDate));
          $('#form-accessTimes-detail').val(data.accessTimes);
        },
        error: errorCallback
    });
}

var openURL = function() {

    $('#btn-openLongUrl').click(function(event) {

      $.ajax({
        url: API_URL + '/getById/' + idUrl,
        async: true,
        success: function(data) {

        alert("You will now be redirected.");
        location.href = "http://" + data.url_long;
      },
        error: errorCallback()
    });
  });
};

var backURL = function() {

  $('#btn-back').click(function() {

    window.location.href = 'index.html';
  })
}

var transformDate = function(date) {

  const d = new Date(date);
  const formattedDate = d.getUTCFullYear() + "/" +
  ("0" + (d.getUTCMonth()+1)).slice(-2) + "/" +
  ("0" + d.getUTCDate()).slice(-2) + " " +
  ("0" + d.getUTCHours()).slice(-2) + ":" +
  ("0" + d.getUTCMinutes()).slice(-2) + ":" +
  ("0" + d.getUTCSeconds()).slice(-2);

  return formattedDate;
}
