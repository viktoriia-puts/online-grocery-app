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
                  const productCard = btn.closest(".col");
                  const quantityElement = productCard.querySelector(".card-text:nth-child(4)");

                  const newQuantity = data.productQuantities[productId];
                  if (newQuantity === 0) {
                    productCard.remove();
                  } else if (quantityElement) {
                    quantityElement.textContent = `quantity: ${newQuantity}`; // Update the quantity
                  }
                  console.log(data.productQuantities);
                  console.log("Product ID:", productId);
                 console.log("New Quantity:", data.productQuantities[productId]);

            })
            .catch(error => console.error("Error:", error));
        });
    });
});





