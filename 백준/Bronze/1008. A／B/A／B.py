import decimal
import os

a, b = map(decimal.Decimal, os.read(0, 3).decode('utf-8').split())
print(round(a / b, 10))