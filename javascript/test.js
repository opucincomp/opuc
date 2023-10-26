// Simulate a vulnerable code snippet with an XSS vulnerability
function simulateXSS(userInput) {
    const output = "<div>" + userInput + "</div>";
    document.getElementById("output-container").innerHTML = output;
  }
  
  // User input (simulating input from a user or external source)
  const userInput = "<script>alert('XSS Attack!')</script>";
  
  // Call the function with the user input
  simulateXSS(userInput);
  