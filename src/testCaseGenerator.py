# Possible states:
# 0 = Empty
# 1 = Incorrect
# 2 = Correct
# 3 = Don't care
decision_table = [
    [0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2],
    [0, 1, 2, 0, 1, 2, 0, 1, 2, 2, 2],
    [3, 3, 3, 3, 3, 3, 3, 3, 0, 1, 2]
]

states = ["Empty", "Incorrect", "Correct", "DontCare"]
# password_val = ["null", "\"abc\"", ""]

for i in range(len(decision_table[0])):
    username_state = decision_table[0][i]
    password_state = decision_table[1][i]
    val_code_state = decision_table[2][i]
    template = "@Test\n" + \
    f"public void testFail{states[username_state]}UsernameAnd{states[password_state]}PasswordAnd{states[val_code_state]}ValCode()\n" + \
    f"{{\n" + \
    f"    LoginStatus status = LoginForm.login(null, null);\n" + \
    f"    Assert.assertFalse(status.isLoginSuccess());\n" + \
    f"}}\n"

    print(template)
