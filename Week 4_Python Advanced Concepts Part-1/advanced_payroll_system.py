class Employee:
    def __init__(self,name, hours_worked,hourly_rate):
        self.name = name
        self.hours_worked = hours_worked
        self.hourly_rate = hourly_rate

    def calculate_pay(self):
        if(self.hours_worked>40):
            return (40 *self.hourly_rate) + ((self.hours_worked - 40) * 1.5)
        else:
            return self.hours_worked * self.hourly_rate


class Manager(Employee):
    def __init__(self, name, hours_worked, hourly_rate,bonus):
        super().__init__(name, hours_worked, hourly_rate)
        self.bonus = bonus

    def calculate_pay(self):
        base_pay = super().calculate_pay()
        total_pay = base_pay + self.bonus
        return total_pay

ename=input("Enter the Employee Name:")
ehours_worked=int(input("Enter the Hours Worked:"))
ehourly_rate=int(input("Enter the Hourly Rate:"))
employee = Employee(ename,ehours_worked,ehourly_rate)
employee_pay = employee.calculate_pay()
print("Employee Name:",employee.name, "total pay: $", employee_pay)

mname=input("Manager Name:")
mhours_worked=int(input("Enter the Hours Worked:"))
mhourly_rate=int(input("Enter the Hourly Rate:"))
bonus=int(input("Enter the bonus amount:"))
manager = Manager(mname, mhours_worked, mhourly_rate,bonus)
manager_pay = manager.calculate_pay()
print("Manager Name:",manager.name, "total pay: $",manager_pay)