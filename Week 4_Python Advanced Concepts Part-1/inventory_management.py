
product_names = []

def add_product_name(product_name):
    product_names.append(product_name)
    print(f"Product '{product_name}' added.")

def remove_product_name(product_name):
    if product_name in product_names:
        product_names.remove(product_name)
        print(f"Product '{product_name}' removed.")
    else:
        print(f"Product '{product_name}' not found.")

def update_product_name(old_name, new_name):
    if old_name in product_names:
        index = product_names.index(old_name)
        product_names[index] = new_name
        print(f"Product '{old_name}' updated to '{new_name}'.")
    else:
        print(f"Product '{old_name}' not found.")


product_details = {}

def add_product_detail(name, quantity, price):
    product_details[name] = (quantity, price)
    print(f"Product '{name}' added with quantity {quantity} and price ${price}.")

def update_product_detail(name, quantity=None, price=None):
    if name in product_details:
        current_quantity, current_price = product_details[name]
        new_quantity = quantity if quantity is not None else current_quantity
        new_price = price if price is not None else current_price
        product_details[name] = (new_quantity, new_price)
        print(f"Product '{name}' updated to quantity {new_quantity} and price ${new_price}.")
    else:
        print(f"Product '{name}' not found.")

def delete_product_detail(name):
    if name in product_details:
        del product_details[name]
        print(f"Product '{name}' deleted.")
    else:
        print(f"Product '{name}' not found.")


def display_product_catalog(products):
    for product in products:
        print(f"Product: {product[0]}, Quantity: {product[1]}, Price: ${product[2]:.2f}")

product_catalog = [
    ("Laptop", 10, 999.99),
    ("Smartphone", 20, 499.99),
    ("Tablet", 15, 299.99),
]


product_categories = set()

def add_category(category):
    product_categories.add(category)
    print(f"Category '{category}' added.")

def remove_category(category):
    if category in product_categories:
        product_categories.remove(category)
        print(f"Category '{category}' removed.")
    else:
        print(f"Category '{category}' not found.")


def generate_price_report():
    sorted_products = sorted(product_details.items(), key=lambda item: item[1][1])
    print("Products sorted by price:")
    for name, (quantity, price) in sorted_products:
        print(f"{name}: ${price:.2f}")

def find_products_in_price_range(min_price, max_price):
    matching_products = {
        name for name, (quantity, price) in product_details.items()
        if min_price <= price <= max_price
    }
    return matching_products


if __name__ == "__main__":
    # list operations
    add_product_name("Laptop")
    add_product_name("Smartphone")
    update_product_name("Smartphone", "Smartphone Pro")
    remove_product_name("Laptop")

    #dictionary operations
    add_product_detail("Smartphone Pro", 20, 599.99)
    add_product_detail("Tablet", 15, 299.99)
    update_product_detail("Tablet", price=279.99)
    delete_product_detail("Smartphone Pro")

  
    display_product_catalog(product_catalog)

    # Set operations
    add_category("Electronics")
    add_category("Accessories")
    remove_category("Electronics")

    # Combined collections
    generate_price_report()
    products_in_range = find_products_in_price_range(250, 500)
    print(f"Products in price range $250-$500: {products_in_range}")
