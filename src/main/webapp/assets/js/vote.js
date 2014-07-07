var url = window.location.pathname;
var username = url.substring(url.lastIndexOf('/') + 1);

$('.vote').click(function(e) {
    e.preventDefault();
    var vote = $(this).attr('id');
    console.log(vote);

    $.ajax({
        type: 'POST',
        url: '/profile/vote',
        data: { user: username, decision: vote },
        dataType: "text",
        error: function (err) {
            alert("error - " + err);
        },
        success: function (msg) {
            if (msg == "ok") {
                alert("Thank you");
                if (vote == 'up')
                    $("#upNumber").text(parseInt($("#upNumber").html()) + 1);
                else
                    $("#downNumber").text(parseInt($("#downNumber").html()) + 1)
            } else {
                alert(msg);
            }
        }
    });
});