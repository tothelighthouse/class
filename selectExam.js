window.addEventListener("load", init, false)
function init() {
  var button = document.getElementsByTagName("button")
  button[0].addEventListener("click", changeColor, false)
  function changeColor() {
    var listItems = document.getElementsByTagName("li");
    // Array.from(listItems).forEach(function (ele) {
    //   console.log(this);
    //   this.setAttribute("style", "background-color:yellow")
    // });
    Array.from(listItems).forEach(ele=>{
      this.style.backgroundColor = "yellow"
      console.log(this);
    })
  }
  button2.addEventListener("click", function () {
    var javascript = document.getElementById("javascript")
    javascript.style.color = "red";
    var db = document.getElementById("db");
    db.style.color = "red";
  }, false)

  button3.addEventListener("click", function () {
    var servlet = document.querySelectorAll("ul>li")[3]
    var pContent = document.getElementsByTagName("p")[0].innerHTML
    servlet.innerHTML = pContent
  })

}