// Generated by CoffeeScript 1.7.1
(function() {
  $(function() {
    var jumboHeight, parallax;
    parallax = function() {
      var scrolled;
      scrolled = $(window).scrollTop();
      return $(".bg").css("height", (jumboHeight - scrolled) + "px");
    };
    jumboHeight = $(".jumbotron").outerHeight();
    $(window).scroll(function(e) {
      return parallax();
    });
    $('#input-rating').rating('refresh', {
      showCaption: false
    });
    return console.log("hello world");
  });

}).call(this);
