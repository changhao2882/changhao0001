#日历模块
import calendar
print(calendar.month(2017,7))
print(calendar.calendar(2017))
#判断闰年
print(calendar.isleap(2000))
#2017年7月的天数和第一天是星期几从0开始
print(calendar.monthrange(2017,7))
print(type(calendar.monthrange(2017,7)))
#2017年7月以每一周为元素的列表
print(calendar.monthcalendar(2017,7))

