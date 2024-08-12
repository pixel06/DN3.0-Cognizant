inventory = [('item1', 10), ('item2', 0), ('item3', 5)]
for item, quantity in inventory:
    if quantity == 0:
        print(item," is out of stock.")
