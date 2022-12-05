import unittest

import day3


class Part1TestCase(unittest.TestCase):
    def test_simple_case(self):
        self.assertEqual(1, day3.solvePart1(["aa"]))  # add assertion here


if __name__ == '__main__':
    unittest.main()
