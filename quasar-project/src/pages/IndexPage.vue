<template>
  <div class="calculator">
    <input type="text" v-model="display" disabled />
    <div class="buttons">
      <button @click="clearDisplay">C</button>
      <button @click="append('%')">%</button>
      <button @click="append('/')">/</button>
      <button @click="append('*')">*</button>

      <button @click="append('7')">7</button>
      <button @click="append('8')">8</button>
      <button @click="append('9')">9</button>
      <button @click="append('-')">-</button>

      <button @click="append('4')">4</button>
      <button @click="append('5')">5</button>
      <button @click="append('6')">6</button>
      <button @click="append('+')">+</button>

      <button @click="append('1')">1</button>
      <button @click="append('2')">2</button>
      <button @click="append('3')">3</button>
      <button @click="append('^')">^</button>
      
      <button @click="append('0')" class="zero">0</button>
      <button @click="append('.')">.</button>
      <button @click="calculate">=</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const display = ref('')

function append(value) {
  if (display.value === "Error") display.value = '';
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
    // ^ 연산자 지원 (JS의 eval은 ^ 대신 **)
    let expr = display.value.replace(/\^/g, '**');
    let result = eval(expr);
    display.value = result.toString();
  } catch {
    display.value = "Error";
  }
}
</script>

<style scoped>
.calculator {
  width: 300px;
  background: white;
  box-shadow: 0 0 15px rgba(0,0,0,0.1);
  padding: 20px 10px 10px 10px;
}

input {
  width: 100%;
  height: 60px;
  font-size: 24px;
  text-align: right;
  padding: 10px;
  box-sizing: border-box;
  margin-bottom: 10px;
}

.buttons {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 5px;
}

button {
  height: 60px;
  font-size: 20px;
  border: 1px solid rgba(255, 255, 255, 0.404);
  background: #74afe6;
  cursor: pointer;
  transition: background 0.2s;
}

button:hover {
  background: #d0d0d0;
}

.zero {
  grid-column: span 2;
}
</style>  