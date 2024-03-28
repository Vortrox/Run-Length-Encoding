dates = """
1A 01 06 1994 31 05 1994
2A 02 06 1994 01 06 1994
3A 15 06 1994 14 06 1994
4A 30 06 1994 29 06 1994
5A 31 06 1994 Invalid Date
6A 15 01 1994 14 01 1994
7A 15 02 1994 14 02 1994
8A 15 11 1994 14 11 1994
9A 15 12 1994 14 12 1994
10A 15 06 1700 14 06 1700
11A 15 06 1701 14 06 1701
12A 15 06 2023 14 06 2023
13A 15 06 2024 14 06 2024
1B 01 06 1994 02 06 1994
2B 02 06 1994 03 06 1994
3B 15 06 1994 16 06 1994
4B 30 06 1994 01 07 1994
5B 15 01 1994 16 01 1994
6B 15 02 1994 16 02 1994
7B 15 11 1994 16 11 1994
8B 15 12 1994 16 12 1994
9B 15 06 1700 16 06 1700
10B 15 06 1701 16 06 1701
11B 15 06 2023 16 06 2023
12B 15 06 2024 16 06 2024
"""[1:-1]

dates = dates.split("\n")

with open("dates_output.txt", "a") as fp:
    for date in dates:
        if date.startswith("5A"):
            continue
        test_code, from_day, from_month, from_year, to_day, to_month, to_year = date.split(" ")
        increment_decrement = "Decrement" if test_code[1] == "A" else "Increment"
        # Example test case name: 1994_06_01ShouldDecrementTo1994_05_31
        test_case_name = f"{from_year}_{from_month}_{from_day}Should{increment_decrement}To{to_year}_{to_month}_{to_day}"
        template = (
        f"        @Test\n"
        f"        public void test{test_code}{test_case_name}() {{\n"
        f"            DateUtil date = new DateUtil({int(from_day)}, {int(from_month)}, {int(from_year)});\n"
        f"            System.out.println(\"{test_case_name} > \" + date);\n"
        f"            date.{increment_decrement.lower()}();\n"
        f"            System.out.println(date);\n"
        f"            Assert.assertEquals({int(to_year)}, date.getYear());\n"
        f"            Assert.assertEquals({int(to_month)}, date.getMonth());\n"
        f"            Assert.assertEquals({int(to_day)}, date.getDay());\n"
        f"        }}\n\n"
        )
        print(template, end="")
        fp.write(template)
