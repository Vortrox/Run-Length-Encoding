import random

last_letter = ""
letter = ""
n_test_cases = 20

for i in range(n_test_cases):
    decoded_string = ""
    encoded_string = ""
    for j in range(random.randint(1, 10)):
        while letter == last_letter:
            letter = random.choice("abcdefghijklmnopqrstuvwxyz")
        repetitions = random.randint(1, 10)
        decoded_string += letter * repetitions
        encoded_string = encoded_string + letter + (str(repetitions) if repetitions > 1 else "")
        last_letter = letter
    print(encoded_string, decoded_string)
