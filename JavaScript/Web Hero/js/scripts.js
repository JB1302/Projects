const panel = document.getElementById("sidePanel");
const toggleBTN = document.getElementById("toggle-btn");

if (panel && toggleBTN) {
  toggleBTN.addEventListener("click", () => {
    panel.classList.toggle("colapsed");

    if(panel.classList.contains("colapsed")){
      toggleBTN.textContent = "☰";
    }else{
      toggleBTN.textContent = "✖";
    }
  });
}
