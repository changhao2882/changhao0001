from django.contrib import admin

# Register your models here.
from .models import Grades,Students

from .models import Text
admin.site.register(Text)




#注册
#添加班级的时候自动加入两条学生信息admin.StackedInline是竖排
class StudentsInfo(admin.TabularInline):
    model = Students
    extra = 2
class GradesAdmin(admin.ModelAdmin):
    inlines = [StudentsInfo]
    #列表页的属性
    #显示字段
    list_display = ['pk','gname','gdate','ggirlnum','gboynum','isDelete']
    #过滤字段
    list_filter = ['gname']
    #出现搜索框，只能按gname搜索
    search_fields = ['gname']
    #分页
    list_per_page = 5
    #添加和修改页属性
    #可以规定属性的先后顺序
    # fields = ['ggirlnum','gboynum','gname','gdate','isDelete']
    fieldsets = [
        ("num",{"fields":['ggirlnum','gboynum']}),
        ("base",{"fields":['gname','gdate','isDelete']}),
    ]
admin.site.register(Grades, GradesAdmin)

#使用装饰器来注册，就不用# admin.site.register(Students, StudentsAdmin) #了
@admin.register(Students)
class StudentsAdmin(admin.ModelAdmin):
    # 改变页面性别显示
    def gender(self):
        if self.sgender:
            return "男"
        else:
            return "女"
    gender.short_description = "性别"

    # 改变页面标题sage描述为年龄
    def age(self):
        return self.sage
    age.short_description = "年龄"
    list_display = ['pk', 'sname', age, gender, 'scontend','sgrade', 'isDelete']
    list_per_page = 2
    #执行动作的位置
    actions_on_bottom = True
    actions_on_top = False
# admin.site.register(Students, StudentsAdmin)
