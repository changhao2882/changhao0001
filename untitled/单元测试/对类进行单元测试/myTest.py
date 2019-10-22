import unittest
from person import Person


class Test(unittest.TestCase):
    def setUp(self):
        print("开始测试时自动调用")
    def tearDown(self):
        print("结束测试时自动调用")
    def test_init(self):
        p = Person("jack",20)
        self.assertEqual(p.name, "jack", "属性赋值有误")
    def test_getAge(self):
        p = Person("jack", 20)
        self.assertEqual(p.getAge(), p.age, "getAge函数有误")
if __name__ == "__main__":
    unittest.main()