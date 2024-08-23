

import threading
import time
import json


class Inventory:
    def __init__(self):
        self.items = {}
        self.alerted_items = set()

    def add_item(self, item_name, quantity):
        if item_name in self.items:
            self.items[item_name] += quantity
        else:
            self.items[item_name] = quantity
        print(f"Added {quantity} of {item_name}. Total: {self.items[item_name]}")

    def remove_item(self, item_name, quantity):
        if item_name in self.items:
            if self.items[item_name] >= quantity:
                self.items[item_name] -= quantity
                print(f"Removed {quantity} of {item_name}. Remaining: {self.items[item_name]}")
            else:
                print(f"Cannot remove {quantity} of {item_name}. Only {self.items[item_name]} available.")
        else:
            print(f"{item_name} does not exist in inventory.")

    def check_stock(self, item_name):
        return self.items.get(item_name, 0)

   
    def save_to_file(self, filename):
        try:
            with open(filename, 'w') as f:
                json.dump(self.items, f)
            print(f"Inventory saved to {filename}.")
        except IOError as e:
            print(f"An error occurred while saving inventory to file: {e}")

   
    def load_from_file(self, filename):
        try:
            with open(filename, 'r') as f:
                self.items = json.load(f)
            print(f"Inventory loaded from {filename}.")
        except IOError as e:
            print(f"An error occurred while loading inventory from file: {e}")
        except json.JSONDecodeError as e:
            print(f"Error decoding JSON from file: {e}")

    
    def periodic_stock_check(self, interval=10):
        def check():
            while True:
                for item, quantity in self.items.items():
                    if quantity < 5:
                        print(f"Alert: {item} is low in stock. Only {quantity} left.")
                time.sleep(interval)
        
        thread = threading.Thread(target=check)
        thread.daemon = True
        thread.start()


inventory = Inventory()
inventory.add_item("Water Bottle", 10)
inventory.add_item("Soda Can", 3)
inventory.remove_item("Water Bottle", 2)
inventory.save_to_file("inventory.json")


inventory.periodic_stock_check(5)


time.sleep(1)  
inventory.load_from_file("inventory.json")

inventory.add_item("Soda Can", 10)


try:
    while True:
        time.sleep(1)
except KeyboardInterrupt:
    print("Exiting inventory management system.")
