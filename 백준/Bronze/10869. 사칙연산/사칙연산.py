import os

a, b = map(int, os.read(0, 1000001).decode('utf-8').split())
print(a + b)
print(a - b)
print(a * b)
print(a // b)
print(a % b)