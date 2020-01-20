window.addEventListener("load", init, false)
function init() {
  var button = document.getElementsByTagName("button")
  button[0].addEventListener("click", changeColor, false)
  function changeColor() {
    var listItems = document.getElementsByTagName("li");

    //람다식 사용법
    //1) Array.from()으로 listItems 를 iterable 하게 변환한후 사용
    //1-1) forEach문의 매개변수로 익명함수로 사용, 
    // this의 의미: 이 함수가 사용된 익명함수로 scope이 제한되고 이 함수를 호출한 객체는 전역객체인 window
    // Array.from(listItems).forEach(function (ele) {
    //   console.log(this);
    //   this.setAttribute("style", "background-color:yellow")
    // });

    // 1-2)forEach문의 매개변수로 람다식 사용
    // this의 의미: 이 함수를 매개변수로 사용한 addEventListener를 
    // 호출한 객체 button[0]이 this로 바인딩 됨
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
