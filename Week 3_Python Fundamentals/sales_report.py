def generate_report(sales):
    for sale in sales:
        if sale>=500:
            print("High sales:",sale)
        else:
            print("Low sales:",sale)
    return 0

sales= [200, 600, 150, 800, 300]
generate_report(sales)
print("Total sales of the month:",sum(sales))