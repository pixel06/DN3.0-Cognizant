from abc import ABC, abstractmethod

class DiscountStrategy(ABC):
    @abstractmethod
    def apply_discount(self, order_amount):
        pass
    
class RegularDiscount(DiscountStrategy):
    
    def apply_discount(self, order_amount):
        discount = order_amount * 0.05
        return order_amount - discount

class PremiumDiscount(DiscountStrategy):
    
    def apply_discount(self, order_amount):
        discount = order_amount * 0.10
        return order_amount - discount
    
class VIPDiscount(DiscountStrategy):
    
    def apply_discount(self, order_amount):
        discount = order_amount * 0.20
        return order_amount - discount
    


class Order:
    def __init__(self, customer_type, order_amount):
        self.customer_type = customer_type
        self.order_amount = order_amount
        
    def final_price(self):
        if self.customer_type == "Regular":
            discount_strategy = RegularDiscount()
        elif self.customer_type == "Premium":
            discount_strategy = PremiumDiscount()
        elif self.customer_type == "VIP":
            discount_strategy = VIPDiscount()
        else:
            raise ValueError("Invalid customer type")
        
        return discount_strategy.apply_discount(self.order_amount)
    
    
order_1 = Order("Regular", 1000)
order_2 = Order("Premium", 2000)
order_3 = Order("VIP", 3000)

print(f"Final price for Regular customer: ${order_1.final_price():.2f}")
print(f"Final price for Premium customer: ${order_2.final_price():.2f}")
print(f"Final price for VIP customer: ${order_3.final_price():.2f}")