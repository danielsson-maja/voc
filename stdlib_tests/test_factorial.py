#print(factorial(3))

from tests.utils import TranspileTestCase

class factorialTest(TranspileTestCase):
    def test_positive_integers(self):
        print("Test positive integers")
        self.assertCodeExecution("""
            import math
            print(math.factorial(3))
        """)
