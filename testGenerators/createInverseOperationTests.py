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
# qb9k4a4o6f2	qbbbbbbbbbkkkkaaaaooooooff
# w8t4l3z5j4t8i5n7b5	wwwwwwwwttttlllzzzzzjjjjttttttttiiiiinnnnnnnbbbbb
# t9m10eaq2u4a6f8u10	tttttttttmmmmmmmmmmeaqquuuuaaaaaaffffffffuuuuuuuuuu
# c6	cccccc
# wr10	wrrrrrrrrrr
# hg5ng8	hgggggngggggggg
# a8q8f7	aaaaaaaaqqqqqqqqfffffff
# v7u9g9	vvvvvvvuuuuuuuuuggggggggg
# b3i8y10w8x8u2s9r9x4m7	bbbiiiiiiiiyyyyyyyyyywwwwwwwwxxxxxxxxuusssssssssrrrrrrrrrxxxxmmmmmmm
# a3c10q2nfe3sw9	aaaccccccccccqqnfeeeswwwwwwwww

compress_test_cases = ""
decompress_test_cases = ""

for i, test_case in enumerate(raw_inputs.split("\n")):
    encoded_string, decoded_string = test_case.split("\t")
    template1 = (
        f"@Test\n"
        f"public void test{i + 1}EInverseCheckCompress_{decoded_string}() {{\n"
        f"    String input = \"{decoded_string}\";\n"
        f"    String result = StringRLEAlgorithm.compress(input);\n"
        f"    String inverseResult = StringRLEAlgorithm.decompress(result);\n"
        f"    \n"
        f"    assertEquals(input, inverseResult);\n"
        f"}}\n\n"
    )
    compress_test_cases += template1

    template2 = (
        f"@Test\n"
        f"public void test{i + 1}FInverseCheckDecompress_{encoded_string}() {{\n"
        f"    String input = \"{encoded_string}\";\n"
        f"    String result = StringRLEAlgorithm.decompress(input);\n"
        f"    String inverseResult = StringRLEAlgorithm.compress(result);\n"
        f"    \n"
        f"    assertEquals(input, inverseResult);\n"
        f"}}\n\n"
    )
    decompress_test_cases += template2

print(compress_test_cases)
print(decompress_test_cases)
