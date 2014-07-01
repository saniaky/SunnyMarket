$ ->
  parallax = ->
    scrolled = $(window).scrollTop()
    $(".bg").css "height", (jumboHeight - scrolled) + "px"

  jumboHeight = $(".jumbotron").outerHeight()
  $(window).scroll (e) ->
    parallax()

  $('#input-rating').rating('refresh', {showCaption: false});

  console.log("hello world")
