function validateForm() {
    // Reset previous error messages
    clearErrors();

    // Get form values
    var employeeName = document.getElementById('employeeName').value;
    var department = document.getElementById('department').value;

    // Validate Name
    if (employeeName.trim() === '') {
      displayError('Invalid name. Name should not be empty.');
      return;
    }

    // Validate Department
    if (department.trim() === '') {
      displayError('Invalid department. Department should not be empty.');
      return;
    }

    // Display success feedback
    displayFeedback('Form submitted successfully!');
  }

  function displayError(message) {
    var errorDiv = document.createElement('div');
    errorDiv.className = 'error';
    errorDiv.textContent = message;
    document.getElementById('feedback').appendChild(errorDiv);
  }

  function displayFeedback(message) {
    document.getElementById('feedback').textContent = message;
  }

  function clearErrors() {
    var errorDivs = document.querySelectorAll('.error');
    errorDivs.forEach(function (errorDiv) {
      errorDiv.remove();
    });
  }