import pymysql

class ChangSql():
    def __init__(self,host,user,passwd,dbname):
        self.host = host
        self.user = user
        self.passwd = passwd
        self.dbname = dbname
    def connet(self):
        self.db = pymysql.connect(self.host,self.user,self.passwd,self.dbname)
        self.cursor = self.db.cursor()
    def close(self):
        self.cursor.close()
        self.db.close()
    def get_one(self,sql):
        res = None
        try:
            self.connet()
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取返回的信息
            res = self.cursor.fetchone()
        except:
            # 如果提交失败回滚到上一次数据
            self.db.rollback()
        finally:
            # 断开
            self.close()
        return res
    def get_all(self,sql):
        res = ()
        try:
            self.connet()
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取返回的信息
            res = self.cursor.fetchall()
        except:
            # 如果提交失败回滚到上一次数据
            self.db.rollback()
        finally:
            # 断开
            self.close()
        return res

    def insert(self, sql):
        return self._edit(sql)
    def update(self, sql):
        return self._edit(sql)
    def delete(self, sql):
        return self._edit(sql)
    def _edit(self,sql):
        count = 0
        try:
            self.connet()
            # 执行SQL语句
            self.cursor.execute(sql)
            self.db.commit()
        except:
            print("事务提交失败")
            # 如果提交失败回滚到上一次数据
            self.db.rollback()
        finally:
            # 断开
            self.close()
        return count
