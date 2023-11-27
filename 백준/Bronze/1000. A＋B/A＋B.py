import os

sum = 0
for x in map(int, os.read(0, 3).decode('utf-8').split(' ')):
    sum += x
print(sum)