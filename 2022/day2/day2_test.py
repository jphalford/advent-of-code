import unittest
import day2

class Part1TestCase(unittest.TestCase):
    def test_one_value(self):
        self.assertEqual(4, day2.solvePart1(["A X"]))  # add assertion here

    def test_two_values(self):
        self.assertEqual(7, day2.solvePart1(["A Z", "A X"]))  # add assertion here


if __name__ == '__main__':
    unittest.main()
