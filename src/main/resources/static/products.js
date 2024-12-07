document.addEventListener("DOMContentLoaded", function() {
    const addToCartButtons = document.querySelectorAll(".add-to-cart-btn");
    const cartCountSpan = document.getElementById("cartCount");

    addToCartButtons.forEach(btn => {
        btn.addEventListener("click", function(e) {
            e.preventDefault();
            const productId = btn.getAttribute("data-product-id");

            // Отправляем POST запрос на /api/addToCart с productId
            fetch("/api/addToCart?productId=" + productId, {
                method: "POST"
            })
            .then(response => response.json())
            .then(data => {
                cartCountSpan.textContent = data.totalCount;
                const cardFooter = btn.closest('.card-footer');
                const removeBtn = cardFooter.querySelector('.remove-from-cart-btn');
                removeBtn.style.display = 'inline-block';
            })
            .catch(error => console.error("Error:", error));
        });
    });
});

document.addEventListener("DOMContentLoaded", function() {
    const removeFromCartButtons = document.querySelectorAll(".remove-from-cart-btn");
    const cartCountSpan = document.getElementById("cartCount");

    removeFromCartButtons.forEach(btn => {
        btn.addEventListener("click", function(e) {
            e.preventDefault();
            const productId = btn.getAttribute("data-product-id");

            fetch("/api/removeFromCart?productId=" + productId, {
                method: "POST"
            })
            .then(response => response.json())
            .then(data => {
                cartCountSpan.textContent = data.totalCount;
            })
            .catch(error => console.error("Error:", error));
        });
    });
});

