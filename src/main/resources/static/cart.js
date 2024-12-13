document.addEventListener("DOMContentLoaded", function() {
    const addToCartButtons = document.querySelectorAll(".add-to-cart-btn");
    const cartCountSpan = document.getElementById("cartCount");

    addToCartButtons.forEach(btn => {
        btn.addEventListener("click", function(e) {
            e.preventDefault();
            const productId = btn.getAttribute("data-product-id");
            // Send POST request на /api/addToCart
            fetch("/api/addToCart?productId=" + productId, {
                method: "POST"
            })
            .then(response => response.json())
            .then(data => {
                cartCountSpan.textContent = data.totalCount;
                updateCartState();
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

                  // Get product card and quantity element
                  const productCard = btn.closest(".col-6.mb-3");
                  const quantityElement = productCard.querySelector(".card-text:nth-child(4)");

                  const newQuantity = data.productQuantities[productId];
                  if (newQuantity === 0) {
                    productCard.remove();
                  } else if (quantityElement) {
                        quantityElement.textContent = `quantity: ${newQuantity}`;
                  }
                    updateCartState();

            })
            .catch(error => console.error("Error:", error));
        });
    });
});

document.addEventListener("DOMContentLoaded", function() {
    updateCartState();
});

function updateCartState() {
    const emptyMessage = document.getElementById('emptyMessage');
    const placeOrderButton = document.getElementById('placeOrderButton');

    fetch("/api/getCartCount", { method: "GET" })
        .then(response => response.json())
        .then(data => {
                console.log("Received cart count:", data.totalCount); // Вывод в консоль
            if (data.totalCount > 0) {
            console.log(document.getElementById('emptyMessage'));
                emptyMessage.style.display = 'none';
                placeOrderButton.style.display = 'block';
            } else {
                emptyMessage.style.display = 'block';
                placeOrderButton.style.display = 'none';
            }
        })
        .catch(error => console.error("Error:", error));
}

