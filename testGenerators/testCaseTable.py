raw_inputs = """
a2b2	aabb
ab3	abbb
a3b	aaab
abcde	abcde
a2b2c2d2e2	aabbccddee
a4ba4	aaaabaaaa
a4	aaaa
a	a
"""[1:-1]

cross_check_test_cases = ""
inverse_op_test_cases = ""

for i, test_case in enumerate(raw_inputs.split("\n")):
    encoded_string, decoded_string = test_case.split("\t")
    template1 = (
        f"test{i + 1}CCrossCheckCompress_{decoded_string}\t{decoded_string}\t{encoded_string}\n"
    )
    cross_check_test_cases += template1

    template2 = (
        f"test{i + 1}EInverseCheckCompress_{decoded_string}\t{decoded_string}\t{decoded_string}\n"
    )
    inverse_op_test_cases += template2

for i, test_case in enumerate(raw_inputs.split("\n")):
    encoded_string, decoded_string = test_case.split("\t")
    template1 = (
        f"test{i + 1}DCrossCheckDecompress_{encoded_string}\t{encoded_string}\t{decoded_string}\n"
    )
    cross_check_test_cases += template1

    template2 = (
        f"test{i + 1}FInverseCheckDecompress_{encoded_string}\t{encoded_string}\t{encoded_string}\n"
    )
    inverse_op_test_cases += template2

print(cross_check_test_cases)
print(inverse_op_test_cases)
