#!/bin/bash

BACKUP=/data/backup/db
DATETIME=$(date +%Y_%m_%d_%H%M%S)

echo "========开始备份==========="
echo "========备份路径:$BACKUP/$DATETIME.tar.gz==================="

HOST=localhost
DB_USER=root
DB_PWD=123456
DATABASE=db0629

[ ! -d "$BACKUP/$DATETIME" ] && mkdir -p "$BACKUP/$DATETIME"

mysqldump -u${DB_USER} -p${DB_PWD} --host=$HOST $DATABASE | gzip > $BACKUP/$DATETIME/$DATETIME.sql.gz

cd $BACKUP
tar -zcvf $DATETIME.tar.gz $DATETIME

rm -rf $BACKUP/$DATETIME

find $BACKUP -mtime +10 -name "*.tar.gz" -exec rm -rf {} \;

echo "========备份成功================="
