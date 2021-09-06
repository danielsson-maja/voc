from ..utils import TranspileTestCase

class PermTests(TranspileTestCase):

    def test_valid_input(self):
        self.assertCodeExecution("""
            import math
            print(math.perm(30,4))
        """)

    def test_wrong_type_input(self):
         self.assertCodeExecution("""
            import math
            try:
                print(math.perm('s',1))
            except TypeError as e:
                print(e)
        """)

    def test_null_input(self):
        self.assertCodeExecution("""
            import math
            print(math.perm(3,None))
        """)

    def test_negative_input(self):
        self.assertCodeExecution("""
            import math 
            try:
                print(math.perm(-1, 5))
            except ValueError as err:
                print(err)
            """)
