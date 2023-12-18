const ProductManagement = {
    products: [],
    findById: (id) => ProductManagement.products.find(product => product.id === id),
    add: (name, price) => {
        const newProduct = {
            id: ProductManagement.products.length + 1,
            name: name,
            price: price
        };
        ProductManagement.products.push(newProduct);
        return newProduct;
    }
};

function addProduct() {
    const productNameInput = document.getElementById("productName");
    const productPriceInput = document.getElementById("productPrice");

    const productName = productNameInput.value;
    const productPrice = parseFloat(productPriceInput.value);

    if (productName && !isNaN(productPrice)) {
        const newProduct = ProductManagement.add(productName, productPrice);
        displayOutput(`Product added: ${JSON.stringify(newProduct)}`);
        displayProductList();
        clearInputFields(productNameInput, productPriceInput);
    } else {
        displayOutput("Please enter valid product name and price.");
    }
}

function findProduct() {
    const productIdInput = document.getElementById("productId");
    const productId = parseInt(productIdInput.value);

    if (!isNaN(productId)) {
        const foundProduct = ProductManagement.findById(productId);

        if (foundProduct) {
            displayOutput(`Product found: ${JSON.stringify(foundProduct)}`);
        } else {
            displayOutput("Product not found.");
        }
    } else {
        displayOutput("Please enter a valid product ID.");
    }
}

function displayOutput(message) {
    document.getElementById("output").innerHTML = message;
}

function displayProductList() {
    const productListElement = document.getElementById("productList");
    productListElement.innerHTML = '';

    ProductManagement.products.forEach(product => {
        const listItem = document.createElement("li");
        listItem.textContent = `ID: ${product.id} | Name: ${product.name} | Price: $${product.price.toFixed(2)}`;
        productListElement.appendChild(listItem);
    });
}

function clearInputFields(...inputs) {
    inputs.forEach(input => (input.value = ''));
}