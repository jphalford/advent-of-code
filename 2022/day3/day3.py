import pathlib


def parse(inputFile):
    return pathlib.Path(inputFile).read_text().split('\n')


def split_list_in_half(list):
    half_index = len(list) // 2
    return list[:half_index], list[half_index:]


def common_char(input_line_chars):
    left, right = split_list_in_half(input_line_chars)
    common_char = set(left) & set(right)
    return common_char.pop()


def to_priority(input_char):
    ord_input_char = ord(input_char)
    if ord_input_char > ord('a'):
        priority = ord_input_char - ord('a') + 1
    else:
        priority = ord_input_char - ord('A') + 27
    return priority


def solvePart1(input):
    input_char_lists= map(list, input)
    common_chars = map(common_char, input_char_lists)
    priorities = map(to_priority, common_chars)
    return sum(priorities)


def solvePart2(input):
    input_char_sets = list(map(set, input))
    start_index = 0
    priority_sum = 0
    while start_index < len(input_char_sets):
        common_chars = input_char_sets[start_index] & \
                      input_char_sets[start_index + 1] & \
                      input_char_sets[start_index + 2]
        priority_sum += to_priority(common_chars.pop())
        start_index += 3
    return priority_sum


if __name__ == "__main__":
    print(ord('a'), ord('z'), ord('A'), ord('Z'))

    input = parse("input.txt")
    print('Part 1: ', solvePart1(input))
    print('Part 2: ', solvePart2(input))
