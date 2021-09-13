from .. utils import TranspileTestCase, BuiltinFunctionTestCase


class FactorialTests(TranspileTestCase):
    def test_factorial_positive(self):
        self.assertCodeExecution("""
            import math
            print(math.factorial(5))
            """)

    def test_factorial_negative(self):
        self.assertCodeExecution("""
            import math
            print(math.factorial(-4))
        """)

    def test_factorial_double(self):
        self.assertCodeExecution("""
            import math
            print(math.factorial(4.5))
        """)

    def test_factorial_string(self):
        self.assertCodeExecution("""
            import math
            print(math.factorial("test"))
        """)

