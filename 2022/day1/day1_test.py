import unittest
import day1


class TestDay1Part1Original(unittest.TestCase):
    def test_no_elves_no_calories(self):
        self.assertEqual(0, day1.solvePart1Original([]))

    def test_one_elf_one_food_item(self):
        self.assertEqual(10, day1.solvePart1Original([10]))

    def test_one_elf_two_food_items(self):
        self.assertEqual(30, day1.solvePart1Original([10, 20]))

    def test_two_elves_one_food_item_each(self):
        self.assertEqual(20, day1.solvePart1Original([10, '', 20]))

    def test_two_elves_multiple_food_item_eachs(self):
        self.assertEqual(60, day1.solvePart1Original([10, 20, '', 20, 40]))


class TestSumElves(unittest.TestCase):
    def test_no_elves_no_calories(self):
        self.assertEqual([], day1.reduceToSumPerElf([]))

    def test_one_elf_one_food_item(self):
        self.assertEqual([10], day1.reduceToSumPerElf([10]))

    def test_one_elf_two_food_items(self):
        self.assertEqual([30], day1.reduceToSumPerElf([30]))

    def test_two_elves_one_food_item_each(self):
        self.assertEqual([10, 20], day1.reduceToSumPerElf([10, '', 20]))

    def test_two_elves_multiple_food_item_eachs(self):
        self.assertEqual([30, 60], day1.reduceToSumPerElf([10, 20, '', 20, 40]))


class TestSumTopN(unittest.TestCase):
    def test_one_value_top_one(self):
        self.assertEqual(1, day1.sumTopN([1], 1))

    def test_several_values_top_one(self):
        self.assertEqual(10, day1.sumTopN([10], 1))

    def test_several_values_top_two(self):
        self.assertEqual(81, day1.sumTopN([30, 20, 50, 31], 2))


class TestDay1Part1(unittest.TestCase):
    def test_no_elves_no_calories(self):
        self.assertEqual(0, day1.solvePart1([]))

    def test_one_elf_one_food_item(self):
        self.assertEqual(10, day1.solvePart1([10]))

    def test_one_elf_two_food_items(self):
        self.assertEqual(30, day1.solvePart1([10, 20]))

    def test_two_elves_one_food_item_each(self):
        self.assertEqual(20, day1.solvePart1([10, '', 20]))

    def test_two_elves_multiple_food_item_eachs(self):
        self.assertEqual(60, day1.solvePart1([10, 20, '', 20, 40]))


class TestDay1Part2(unittest.TestCase):

    def test_three_elves_one_food_item_each(self):
        self.assertEqual(30, day1.solvePart2([10, '', 10, '', 10]))


if __name__ == '__main__':
    unittest.main()
