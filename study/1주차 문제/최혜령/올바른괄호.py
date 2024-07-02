def solution(s):
    stack = []
    i = 0
    while i < len(s):
        if len(stack) > 1:
            if stack[-1] == ')' and stack[-2] == '(':
                stack.pop(-1)
                stack.pop(-1)
            else:
                stack.append(s[i])
                i += 1
        else:
            stack.append(s[i])
            i += 1
    if len(stack) == 2 and stack[0] == '(' and stack[1] == ')': return True

    return False
