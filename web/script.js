const display = document.getElementById('display');

function append(value) {
  display.value += value;
}

function clearDisplay() {
  display.value = '';
}

function calculate() {
  if (display.value === "Error") {
    clearDisplay();
    return;
  }

  try {
    const result = eval(display.value);
    display.value = result;
  } catch (err){
    display.value = "Error";
  }
}
