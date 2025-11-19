document.getElementById('passwordToggle').addEventListener('click', function() {
    const passwordInput = document.getElementById('password');
    const icon = this.querySelector('i');

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        icon.classList.remove('fa-eye');
        icon.classList.add('fa-eye-slash');
    } else {
        passwordInput.type = 'password';
        icon.classList.remove('fa-eye-slash');
        icon.classList.add('fa-eye');
    }
});

document.querySelector('.social-btn.google').addEventListener('click', function(e) {
    e.preventDefault();
    alert('Redirecionando para autenticação com Google...');

});

document.querySelector('.social-btn.facebook').addEventListener('click', function(e) {
    e.preventDefault();
    alert('Redirecionando para autenticação com Facebook...');

});