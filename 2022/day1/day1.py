import pathlib


def parse(inputFile):
    return pathlib.Path(inputFile).read_text().split('\n')


def solvePart1Original(input):
    largestSum = 0
    currentSum = 0
    for inputLine in input:
        if inputLine == '':
            if currentSum > largestSum:
                largestSum = currentSum
            currentSum = 0
            continue

        currentSum += int(inputLine)
    if currentSum > largestSum:
        largestSum = currentSum
    return largestSum


def reduceToSumPerElf(input):
    elves = []
    currentSum = 0
    for inputLine in input:
        if inputLine == '':
            elves.append(currentSum)
            currentSum = 0
            continue
        currentSum += int(inputLine)

    if currentSum > 0:
        elves.append(currentSum)
    return elves


def sumTopN(listOfNumbers, n):
    sortedListOfNumbers = sorted(listOfNumbers,reverse=True)
    return sum(sortedListOfNumbers[0:n])


def solvePart1(input):
    return sumTopN(reduceToSumPerElf(input), 1)


def solvePart2(input):
    return sumTopN(reduceToSumPerElf(input), 3)


if __name__ == "__main__":
    input = parse("input.txt")
    print('Part 1 Original: ', solvePart1Original(input))
    print('Part 1: ', solvePart1(input))
    print('Part 2: ', solvePart2(input))
