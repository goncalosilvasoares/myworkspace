var API_URL = 'http://localhost:8080/urlShortster/api';

$(document).ready(function() {
  getURLs();
  cancel();
  add();
  openURL();
  openAll();
  $('#alert-success').hide();
  $('#alert-warning').hide();
});

function errorCallback(request, status, error){
    console.log("fail");
}


function getURLs() {
  $.ajax({
        url: API_URL,
        async: true,
        success: populateUrlTable,
        error: errorCallback
    });
}

function populateUrlTable(Data) {

     $.each(Data, function(i, urlData) {

       $("#url-table").append(
            "<tr><td>" +
           urlData.url_long +
            "</td>" +

            "<td>" +
            urlData.url_short +
            "</td>" +

            '<td><button type="button" id="table-openURL-btn-' +
            urlData.id +
            '" class="edit-btn btn btn-success">Open</button></td>' +

            '<td><button type="button" id="table-openAll-btn-' +
            urlData.id +
            '" class="edit-btn btn btn-success">Open</button></td>' +

            '<td><button type="button" id="remove-btn-'+
            urlData.id +
            '" class="remove-btn btn btn-danger">delete</button></td></tr>');


      $('#table-openURL-btn-' + urlData.id).click(function() {

        alert("You will now be redirected.");
        location.href = "http://" + urlData.url_long;
      })

      $('#table-openAll-btn-' + urlData.id).click(function() {

          window.location = 'showURL.html?url='+urlData.id;
     });

     $('#remove-btn-' + urlData.id).click(function() {

         $.ajax({
              type:'DELETE',
              url: API_URL + '/' + urlData.id,
              cache: false,
              success: function() {
                success()
              },
              error: function() {
                error()
              }
        });
      });
   });


};

function checkBox() {

  var checkBox = document.getElementById('check-urlShort');
  var form = document.getElementById('form-urlShort');

  if (checkBox.checked == true ) {

    form.disabled = false;
  } else {

    form.disabled = true;
  }
}

var add = function() {

  $('#btn-add').click(function(event) {

        var obj;

        if ($('#form-urlShort').val() == "") {

          obj = {url_long: $('#form-urlLong').val(),
            url_short: null
          };

        } else {

            obj = {url_long: $('#form-urlLong').val(),
                url_short: $('#form-urlShort').val()
            };
        }

    var json = JSON.stringify(obj);
    console.log(json);

    $.ajax({
      url: API_URL + "/addUrl",
      type:'POST',
      data: json,
      contentType: 'application/json;charset=UTF-8',
      success: function() {
        success()
      },
      error: function() {
        error()
      }
    });

   });
};

var openURL = function() {

    $('#btn-openURL').click(function(event) {

      $.ajax({
        url: API_URL + '/' + $('#form-OpenShortUrl').val(),
        async: true,
        success: function (data) {
        alert("You will now be redirected.");
        location.href = "http://" + data;
      },
        error: function() {
          error()
        }
    });
  });
};


var openAll = function() {

  $('#btn-openAllDetails').click(function(event) {

    $.ajax({
      url: API_URL + '/getByShort/' + $('#form-OpenShortUrl').val(),
      async: true,
      success: function (data) {
      window.location = 'showURL.html?url=' + data.id;
    },
      error: function() {
        error()
      }
  });
});
}

var cancel = function() {

  $('#btn-cancel').click(function(event) {

    $('#form-urlLong').val(null);
    $('#form-urlShort').val(null);
  });
};

var success = function() {

    $('#alert-success').fadeIn(500);
    $('#alert-success').fadeOut(500);

    setTimeout(function() {

      location.reload();
      return false;
    }, 1000);
}

var error = function() {

  $('#alert-warning').fadeIn(500);
  $('#alert-warning').fadeOut(500);
}

