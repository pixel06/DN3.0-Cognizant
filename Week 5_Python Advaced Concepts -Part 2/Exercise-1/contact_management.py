import pickle
def read_contacts(text_file_path):
    try:
        with open(text_file_path, 'r') as f:
            c = f.readlines()
        return [i.strip() for i in c]
    except FileNotFoundError:
        print(f"Error: The file '{text_file_path}' does not exist.")
        return []

def write_contacts(text_file_path, contact_list):
    try:
        with open(text_file_path, 'w') as f:
            for i in contact_list:
                f.write(f"{i}\n")
    except IOError as e:
        print(f"Error writing to file '{text_file_path}': {e}")

def add_contact(text_file_path, contact):
    c = read_contacts(text_file_path)
    c.append(contact)
    write_contacts(text_file_path, c)

def remove_contact(text_file_path, contact):
    c = read_contacts(text_file_path)
    if contact in c:
        c.remove(contact)
        write_contacts(text_file_path, c)
    else:
        print(f"Contact '{contact}' not found.")
        
def display_contacts(text_file_path):
    c = read_contacts(text_file_path)
    if c:
        print("Contacts:")
        for i in c:
            print(i)
    else:
        print("No contacts found.")

def save_contacts_binary(binary_file_path, contact_list):
    try:
        with open(binary_file_path, 'wb') as f:
            pickle.dump(contact_list, f)
    except IOError as e:
        print(f"Error writing to file '{binary_file_path}': {e}")

def load_contacts_binary(binary_file_path):
    try:
        with open(binary_file_path, 'rb') as f:
            c = pickle.load(f)
        return c
    except FileNotFoundError:
        print(f"Error: The file '{binary_file_path}' does not exist.")
        return []
    except pickle.PickleError as e:
        print(f"Error loading from file '{binary_file_path}': {e}")
        return []

def main():
    t = 'contacts.txt'
    b = 'contacts.dat'
    
    while True:
        print("\n1. Add Contact")
        print("2. Remove Contact")
        print("3. Display Contacts (Text File)")
        print("4. Save Contacts (Binary File)")
        print("5. Load Contacts (Binary File)")
        print("6. Exit")
        ch = input("Enter your choice: \n")
        
        if ch == '1':
            i = input("Enter contact name to add: ")
            add_contact(t, i)
        elif ch == '2':
            i = input("Enter contact name to remove: ")
            remove_contact(t, i)
        elif ch == '3':
            display_contacts(t)
        elif ch == '4':
            c = read_contacts(t)
            save_contacts_binary(b, c)
        elif ch == '5':
            c = load_contacts_binary(b)
            print("Contacts from binary file:")
            for i in c:
                print(i)
        elif ch == '6':
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
