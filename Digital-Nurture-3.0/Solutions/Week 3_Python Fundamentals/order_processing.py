def apply_discount(order_amount):
    if(order_amount>=100):
        discount = 0.1 * order_amount
        return order_amount - discount
    else:
        return order_amount
order_amount=int(input("Enter the order value:"))
print("The amount after discount is:",apply_discount(order_amount))