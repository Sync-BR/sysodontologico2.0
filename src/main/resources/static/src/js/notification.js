function showNotification(notification) {
    if (notification) {
        notification.offsetWidth;
        notification.classList.add('show');

        const closeBtn = notification.querySelector('.close-btn');
        closeBtn.addEventListener('click', () => {
            hideNotification(notification);
        });

        setTimeout(() => {
            hideNotification(notification);
        }, 5000);
    }
}


function hideNotification(notification) {
    if (notification) {
        notification.classList.remove('show');
        setTimeout(() => {
            if (notification.parentNode) {
                notification.parentNode.removeChild(notification);
            }
        }, 300);
    }
}


document.addEventListener('DOMContentLoaded', function() {
    const successNotification = document.getElementById('successNotification');
    const errorNotification = document.getElementById('errorNotification');
    const errorEmailNotification = document.getElementById('errorEmail');

    showNotification(successNotification);
    showNotification(errorNotification);
    showNotification(errorEmailNotification);
});