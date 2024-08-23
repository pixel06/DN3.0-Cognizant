from text_processing_tool import count_words, find_unique_words, convert_to_uppercase

def main():
    text = input("Enter a text string: ")

    print("Choose an option:")
    print("1. Count words")
    print("2. Find unique words")
    print("3. Convert to uppercase")
    option = input("Enter the option number: ")

    if option == '1':
        word_count = count_words(text)
        print(f"Word count: {word_count}")
    elif option == '2':
        unique_words = find_unique_words(text)
        print(f"Unique words: {unique_words}")
    elif option == '3':
        uppercase_text = convert_to_uppercase(text)
        print(f"Uppercase text: {uppercase_text}")
    else:
        print("Invalid option selected!")

if __name__ == "__main__":
    main()