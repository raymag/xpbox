import random
sql_molde = """
UPDATE pessoas
SET time_preferido = '{}'
WHERE id = '{}';
"""
sql = ""
count = 1;
while(count<=61):
    sql+=sql_molde.format(random.randint(1, 20), count)
    count+=1
print(sql)
