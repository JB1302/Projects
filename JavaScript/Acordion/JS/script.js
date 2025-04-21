const panel = document.getElementById("sidePanel");
const toggleBTN = document.getElementById("toggle-button");

if (panel && toggleBTN){
toggleBTN.addEventListener("click", ()=> {
  panel.classList.toggle("collapsed")
});
}