def calculate_pay(hours,rate):
    return hours*rate
hours=int(input("Enter the number of hours worked:"))
rate=int(input("Enter the rate per hour: "))
print("Total Payroll for the day is:",calculate_pay(hours,rate)) 