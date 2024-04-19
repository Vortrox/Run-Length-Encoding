import re

dates = """
1A 1 1 2000 2 1 2000
2A 28 1 2000 29 1 2000
3A 29 1 2000 30 1 2000
4A 30 1 2000 31 1 2000
5A 31 1 2000 1 2 2000
6A 1 2 2000 2 2 2000
7A 28 2 2000 29 2 2000
8A 29 2 2000 1 3 2000
9A 30 2 2000 Invalid date
10A 31 2 2000 Invalid date
11A 1 6 2000 2 6 2000
12A 28 6 2000 29 6 2000
13A 29 6 2000 30 6 2000
14A 30 6 2000 1 7 2000
15A 31 6 2000 Invalid date
16A 1 1 2001 2 1 2001
17A 28 1 2001 29 1 2001
18A 29 1 2001 30 1 2001
19A 30 1 2001 31 1 2001
20A 31 1 2001 1 2 2001
21A 1 2 2001 2 2 2001
22A 28 2 2001 1 3 2001
23A 29 2 2001 Invalid date
24A 30 2 2001 Invalid date
25A 31 2 2001 Invalid date
26A 1 6 2001 2 6 2001
27A 28 6 2001 29 6 2001
28A 29 6 2001 30 6 2001
29A 30 6 2001 1 7 2001
30A 31 6 2001 Invalid date
1B 1 1 2000 31 12 1999
2B 28 1 2000 27 1 2000
3B 29 1 2000 28 1 2000
4B 30 1 2000 29 1 2000
5B 31 1 2000 30 1 2000
6B 1 2 2000 31 1 2000
7B 28 2 2000 27 2 2000
8B 29 2 2000 28 2 2000
9B 30 2 2000 Invalid date
10B 31 2 2000 Invalid date
11B 1 6 2000 31 5 2000
12B 28 6 2000 27 6 2000
13B 29 6 2000 28 6 2000
14B 30 6 2000 29 6 2000
15B 31 6 2000 Invalid date
16B 1 1 2001 31 12 2000
17B 28 1 2001 27 1 2001
18B 29 1 2001 28 1 2001
19B 30 1 2001 29 1 2001
20B 31 1 2001 30 1 2001
21B 1 2 2001 31 1 2001
22B 28 2 2001 27 2 2001
23B 29 2 2001 Invalid date
24B 30 2 2001 Invalid date
25B 31 2 2001 Invalid date
26B 1 6 2001 31 5 2001
27B 28 6 2001 27 6 2001
28B 29 6 2001 28 6 2001
29B 30 6 2001 29 6 2001
30B 31 6 2001 Invalid date
"""[1:-1]

output = ""

dates = dates.split("\n")

for date in dates:
    if date.endswith("Invalid date"):
        test_code, from_day, from_month, from_year = date.split(" ")[:-2]
        template = (
        f"        @Test\n"
        f"        public void test{test_code}{from_year}_{from_month}_{from_day}ShouldBeInvalid() {{\n"
        f"            Assert.assertThrows(RuntimeException.class, () -> new DateUtil({from_day}, {from_month}, {from_year}));\n"
        f"        }}\n\n"
        )
        output += template
        continue
    test_code, from_day, from_month, from_year, to_day, to_month, to_year = date.split(" ")
    increment_decrement = "Increment" if test_code[-1] == "A" else "Decrement"
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
    output += template

print(output)
with open("dates_output.txt", "a") as fp:
    fp.write(output)