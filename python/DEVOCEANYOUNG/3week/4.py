
def programmerStrings(s):
    # Write your code here
    leftmost = s.find('programmer')
    rightmost = s.rfind('programmer')

    if leftmost == -1 or rightmost == -1:
        return 0

    indices_between = rightmost - leftmost - len('programmer') + 1

    return indices_between

print(programmerStrings("progxrammerrxproxgrammer"))