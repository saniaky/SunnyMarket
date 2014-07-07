$(document).ready(function () {

    console.log(getCookie('lang'));

    $('#edit').editable({
        inlineMode: false,
        buttons: ['undo', 'redo' , 'sep', 'bold', 'italic', 'underline',  'align', 'fontSize', 'color', 'insertOrderedList', 'strikeThrough', 'insertVideo'],
        language: getCookie('lang')
    });

    $('#addBtn').click(function () {
        var number = $('input[name=images]').length;
        var newElem = $('input[name=images]:last').clone();
        $('input[name=images]:last').after(newElem);
        $('#removeBtn').removeAttr("disabled");
        if (number == 5)
            $('#addBtn').attr('disabled', '');
    });

    $('#removeBtn').click(function () {
        var number = $('input[name=images]').length;
        $('input[name=images]:last').remove();
        $('#addBtn').removeAttr("disabled");
        if (number == 0)
            $('#removeBtn').attr('disabled', '');
    });

    $('#removeBtn').attr('disabled', '');

    // Adding custom typeahead support using http://twitter.github.io/typeahead.js
//    $('#tags').tagsinput('input').typeahead({
//        prefetch: 'tags.json'
//    }).bind('typeahead:selected', $.proxy(function (obj, data) {
//        this.tagsinput('add', data.value);
//        this.tagsinput('input').typeahead('setQuery', '');
//    }, $('input')));
});

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}