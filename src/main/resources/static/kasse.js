    // валидация
    document.getElementById('myForm').addEventListener('submit', function (event) {
        // Отмена отправки формы, если она невалидна
        if (!this.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
        }

        this.classList.add('was-validated');
    });