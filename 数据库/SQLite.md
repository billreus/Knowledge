## 数据库操作

### 读取
用`read_sql`从sqlite数据库中读取数据
```
import sqliter3
con = sqlite3.connect('user_information.sqlite')
sql = 'select * from user_information LIMIT 3'
df = pd.read_sql(sql.con)
```

用`index_col`参数来规定将哪一列设置为index
```
df = pd.real_sql(sql, con, index_col='id')
# 多个index只需设为列表即可
df = pd.real_sql(sql, con, index_col=['id', 'bank_id'])
```

### 删除某个表
```
con.execute('DROP TABLE IF EXISTS user_information')
```

### 保存
```
pd.io.sql.write_sql(df, 'user_information', con)
```