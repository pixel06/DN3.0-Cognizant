customer_data = {'Alice': 120, 'Bob': 75, 'Charlie': 90}
name='Bob'
amount=100
if name in customer_data:
    customer_data[name] = amount
else:
    print("Customer",name,"not found.")
print(customer_data)
