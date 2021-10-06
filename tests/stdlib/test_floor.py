from tests.utils import TranspileTestCase, BuiltinFunctionTestCase


class FloorTests(TranspileTestCase):


    def test_floor_string(self):
        self.assertCodeExecution("""
            import math
            print(math.floor("Test floor"))
            """)

    def test_floor_positive(self):
        self.assertCodeExecution("""
            import math
            print(math.floor(2))
            """)

    def test_floor_negative(self):
        self.assertCodeExecution("""
            import math
            print(math.floor(-2))
            """)

    def test_floor_double(self):
        self.assertCodeExecution("""
            import math
            print(math.floor(5.5))
            """)

    def test_floor_zero(self):
        self.assertCodeExecution("""
            import math
            print(math.floor(0))
            """)


class BuiltinFloorFunctionTests(BuiltinFunctionTestCase, TranspileTestCase):
    functions = ["floor"]

    not_implemented = [
    ]
