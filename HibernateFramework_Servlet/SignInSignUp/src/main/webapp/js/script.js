function validateSignup() {
    const password = document.querySelector('#signupForm input[name="password"]').value;
    if (password.length < 6) {
        alert('Password must be at least 6 characters long');
        return false;
    }
    return true;
}

function validateLogin() {
    const email = document.querySelector('#loginForm input[name="email"]').value;
    const password = document.querySelector('#loginForm input[name="password"]').value;
    
    if (!email.includes('@') || !email.includes('.')) {
        alert('Please enter a valid email');
        return false;
    }
    if (password.length < 6) {
        alert('Password must be at least 6 characters long');
        return false;
    }
    return true;
}