from tests.utils import TranspileTestCase

class ProdTests(TranspileTestCase):

    def test_positive_numbers(self):
        self.assertCodeExecution("""
            import math
            print(math.prod([30,4]))
        """)
    
    def test_negative_numbers(self):
        self.assertCodeExecution("""
            import math
            print(math.prod([-2, 5, 8]))
        """)

    def test_empty_list(self):
        self.assertCodeExecution("""
            import math
            print(math.prod([]))
        """)

    def test_non_numeric(self):
        self.assertCodeExecution("""
            import math
            print(math.prod(["hej"]))
        """)

    def test_new_start_value(self):
        self.assertCodeExecution("""
            import math
            print(math.prod([1, 2], start=5))
        """)

    

