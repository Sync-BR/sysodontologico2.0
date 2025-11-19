const mobileMenu = document.querySelector('.mobile-menu');
const mobileNav = document.querySelector('.mobile-nav');
const overlay = document.querySelector('.overlay');

mobileMenu.addEventListener('click', function() {
    this.classList.toggle('active');
    mobileNav.classList.toggle('active');
    overlay.classList.toggle('active');
    document.body.style.overflow = mobileNav.classList.contains('active') ? 'hidden' : '';
});

overlay.addEventListener('click', function() {
    mobileMenu.classList.remove('active');
    mobileNav.classList.remove('active');
    this.classList.remove('active');
    document.body.style.overflow = '';
});

document.querySelectorAll('.mobile-nav a').forEach(link => {
    link.addEventListener('click', function() {
        mobileMenu.classList.remove('active');
        mobileNav.classList.remove('active');
        overlay.classList.remove('active');
        document.body.style.overflow = '';
    });
});


document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();

        const targetId = this.getAttribute('href');
        if(targetId === '#') return;

        const targetElement = document.querySelector(targetId);
        if(targetElement) {
            window.scrollTo({
                top: targetElement.offsetTop - 80,
                behavior: 'smooth'
            });
        }
    });
});