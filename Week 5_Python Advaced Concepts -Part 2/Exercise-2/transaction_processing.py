import logging
from datetime import datetime

logging.basicConfig(filename='errors.log', level=logging.ERROR, 
                    format='%(asctime)s - %(levelname)s - %(message)s')

def log_error(error):
    logging.error(error)

def validate_amount(amount):
    if not isinstance(amount, (int, float)):
        raise ValueError("Amount must be a number.")
    if amount <= 0:
        raise ValueError("Amount must be greater than zero.")

def process_transaction(amount):
    try:
        validate_amount(amount)
        print(f"Processing transaction of ${amount:.2f}")
    except ValueError as ve:
        log_error(ve)
        print(f"Error: {ve}")
    except Exception as e:
        log_error(e)
        print(f"An unexpected error occurred: {e}")

def main():
    while True:
        try:
            amount = float(input("Enter transaction amount: "))
            process_transaction(amount)
        except ValueError:
            print("Invalid input. Please enter a numeric value.")
        except Exception as e:
            log_error(e)
            print(f"An unexpected error occurred: {e}")
        finally:
            cont = input("Do you want to process another transaction? (yes/no): ").strip().lower()
            if cont != 'yes':
                break
if __name__ == "__main__":
    main()
