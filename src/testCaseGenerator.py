# Possible condition states:
# W = Incorrect
# B = Empty
# C = Correct
decision_table_condition = """
W	W	W	B	B	B	C	C	C
W	B	C	W	B	C	W	B	C
"""[1:-1]
email_condition, password_condition = [c.split("\t") for c in decision_table_condition.split("\n")]

decision_table_action = """
Fail	Fail	Fail	Fail	Fail	Fail	Fail	Fail	Pass
"""[1:-1]
action, = [c.split("\t") for c in decision_table_action.split("\n")]

states = ["Empty", "Incorrect", "Correct"]

def get_state_from_shorthand(state: str) -> str:
    match state:
        case "W":
            return "Incorrect"
        case "B":
            return "Blank"
        case "C":
            return "Correct"
        case _:
            raise RuntimeError("Invalid state")

output = ""
for i in range(len(email_condition)):
    email_state = get_state_from_shorthand(email_condition[i])
    password_state = get_state_from_shorthand(password_condition[i])
    action_state = action[i]

    email_input = "VALID_EMAIL" if email_state == "Correct" else "INVALID_EMAIL" if email_state == "Incorrect" else '""'
    password_input = "VALID_PASSWORD" if password_state == "Correct" else "INVALID_PASSWORD" if password_state == "Incorrect" else '""'

    template = (
        f"@Test\n" +
        f"public void test{action_state}{email_state}EmailAnd{password_state}Password() {{\n" +
        f"    BunningsLoginForm form = new BunningsLoginForm();\n" +
        f"    form.login({email_input}, {password_input});\n" +
        f"    Assert.{'assertTrue' if action == 'Pass' else 'assertFalse'}(form.loginSuccessful());\n" +
        f"    form.close();\n" +
        f"}}\n\n"
    )

    output += template
with open("output.txt", "w") as fp:
    fp.write(output)
print(output)