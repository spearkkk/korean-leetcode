import os

a, b = map(int, os.read(0, 3).decode('utf-8').split())
print(a * b)