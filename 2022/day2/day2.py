import pathlib

ROCK_SCORE = 1
PAPER_SCORE = 2
SCISSORS_SCORE = 3

LOSE_SCORE = 0
DRAW_SCORE = 3
WIN_SCORE = 6

PART1_SCORES = {
    "A X": ROCK_SCORE + DRAW_SCORE,
    "A Y": PAPER_SCORE + WIN_SCORE,
    "A Z": SCISSORS_SCORE + LOSE_SCORE,

    "B X": ROCK_SCORE + LOSE_SCORE,
    "B Y": PAPER_SCORE + DRAW_SCORE,
    "B Z": SCISSORS_SCORE + WIN_SCORE,

    "C X": ROCK_SCORE + WIN_SCORE,
    "C Y": PAPER_SCORE + LOSE_SCORE,
    "C Z": SCISSORS_SCORE + DRAW_SCORE,
}

PART2_SCORES = {
    "A X": SCISSORS_SCORE + LOSE_SCORE,
    "A Y": ROCK_SCORE + DRAW_SCORE,
    "A Z": PAPER_SCORE + WIN_SCORE,

    "B X": ROCK_SCORE + LOSE_SCORE,
    "B Y": PAPER_SCORE + DRAW_SCORE,
    "B Z": SCISSORS_SCORE + WIN_SCORE,

    "C X": PAPER_SCORE + LOSE_SCORE,
    "C Y": SCISSORS_SCORE + DRAW_SCORE,
    "C Z": ROCK_SCORE + WIN_SCORE,
}


def parse(inputFile):
    return pathlib.Path(inputFile).read_text().split('\n')


def solve(input, scoreFn):
    scores = map(scoreFn, input)
    return sum(scores)


def part1Score(entry):
    return PART1_SCORES[entry]


def part2Score(entry):
    return PART2_SCORES[entry]


if __name__ == "__main__":
    input = parse("input.txt")
    print('Part 1: ', solve(input, part1Score))
    print('Part 2: ', solve(input, part2Score))
