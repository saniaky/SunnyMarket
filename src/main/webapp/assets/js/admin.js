/**
 * Created by saniaky on 7/7/14.
 */
$(document).ready(function () {

    $(".deleteBtn").click(function () {
        var line = $(this).closest('tr');
        var user_id = line.attr('id');

        console.log(user_id);

        $.ajax({
            type: "POST",
            url: "/admin/user/delete",
            data: { id: user_id },
            success: function(msg) {
                if (msg == "ok") {
                    $.growl({
                        title: '<strong>Info:</strong> ',
                        message: 'User deleted'
                    },{
                        type: 'success'
                    });
                    line.remove();
                } else {
                    $.growl({
                        title: '<strong>Info:</strong> ',
                        message: 'User is not deleted!'
                    },{
                        type: 'danger'
                    });
                }
            },
            dataType: "text"
        });

    })
});
