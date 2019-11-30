from django.db import models

# Create your models here.
class Grades(models.Model):
    gname = models.CharField(max_length=20)
    gdate = models.DateTimeField()
    ggirlnum = models.IntegerField()
    gboynum = models.IntegerField()
    isDelete = models.BooleanField(default=False)
    def __str__(self):
        return self.gname

    class Meta:
        # 定义数据表名，推荐使用小写字母，若不写，数据表名默认为项目名小写_类名小写
        db_table = "grades"
#自定义管理器Manager类
class StudentsManager(models.Manager):
    def get_queryset(self):
        return super(StudentsManager, self).get_queryset().filter(isDelete=False)  #取出isDelete=False的数据   .filter()是一个过滤器
    # 在定义管理器中添加一个方法
    # 定义一个类方法创建对象
    def createStudent(self, name, age, gender, contend, grade, lastT, createT, isD=False):
        stu = self.model()
        stu.sname= name
        stu.sage = age
        stu.sgender = gender
        stu.scontend = contend
        stu.sgrade=grade
        stu.lastTime = lastT
        stu.createTime = createT
        stu.isDelete= isD
        return stu
class Students(models.Model):
    #自定义模型管理器(objects就不存在了)   模型管理器是django的模型与数据库进行交互的接口
    stuObj = models.Manager()
    stuobj2 = StudentsManager()

    sname = models.CharField(max_length=20)
    sgender = models.BooleanField(default=True)
    sage = models.IntegerField(db_column="age")
    scontend = models.CharField(max_length=20)
    isDelete = models.BooleanField(default=False)
    #关联外键
    sgrade = models.ForeignKey("Grades")
    def __str__(self):
        return self.sname
    lastTime = models.DateTimeField(auto_now=True)
    createTime = models.DateTimeField(auto_now_add=True)
    #在模型中定义元信息类，用于设置信息
    class Meta:
        # 定义数据表名，推荐使用小写字母，若不写，数据表名默认为项目名小写_类名小写
        db_table = "students"
        # 对象的默认排序字段，获取对象的列表时可以使用
        ordering = ['id']

    #定义一个类方法创建对象
    @classmethod
    def createStudent(cls, name, age, gender, contend, grade, lastT, createT, isD=False):
        stu = cls(sname = name, sage = age, sgender = gender, scontend = contend, sgrade=grade, lastTime = lastT, createTime = createT, isDelete= isD)
        return stu


