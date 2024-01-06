# RomanNumber
Designed a class named RomanNumber according to professor-specified UML diagram/description.

Assignment Description: (From SSW-315)

Design a class named RomanNumber. The class contains:

A private int data field that stores the value represented by this object.
A private String data field representing the value in Roman Numbers. 
Constructors that create a RomanNumber object for the Roman Number specified as a String or an int.
A getNumber method that returns a String representing the Roman Number.
A getValue method that returns an int representing the number.
A static method parseValue(String num) that converts a String representing a Roman Number into an int.
A static method parseNumber(int num) that converts an int num into a String representing the Roman Number .
Methods equals(String) and equals(int) that return true if the value in the object is equal to the specified value.
Methods add(String num), subtract(String num), multiply(String num), divide(String num),  that return a String representing the Roman Number after addition, subtraction, multiplication, integer division, respectively, of the object value with the num.
A static method calculate(String expression) that performs calculation of a String of two roman numbers separated with an operand, and returns a String representing the resulting Roman Number. For instance, you may get RomanNumber.calculate(“Ⅿ/Ⅺ”) or RomanNumber.calculate(“ⅭⅬⅦ-ⅬⅩⅢ”). 
Methods min(String num) and max(String num) that return a string representing the maximum and minimum, respectively, of the value of the object and given num.
Below is the UML for the class.

RomanNumber
- value: int

- number: String

+ RomanNumber(int)

+ RomanNumber(String)

+ getValue(): int

+ getNumber(): String

+ parseValue(String): int

+ parseNumber(int): String

+ equals(String): boolean

+ equals(int): boolean

+ add(String): String

+ subtract(String): String

+ multiply(String): String

+ divide(String): String

+ min(String): String

+ max(String): String

+ calculate(String): String

Notes:

Assignment requirements may change before the deadline.
As Roman Numbers only have positive values, any calculation that yields zero or negative value should throw an exception.
Make sure to use the roman numeral characters from https://en.wikipedia.org/wiki/Numerals_in_Unicode#Roman_numeralsLinks to an external site. table.
Use the top row of Unicode characters and the bottom row for large values (5,000, 10,000, 50,000 and 100,000) that are not in the top row. 
In general, use the largest Unicode character that can represent the number. However, if there is not a single character, use the general base of 5, 10, 50, 100, etc. as one of the characters and the rest with the complementing character of 1, 10, 100, etc.
When uploading the results of your test run, make sure to include a snapshot of your code and test results within IDE.
You can continue updating your work and submitting newer versions before the deadline. Only the last version before the deadline will be graded.
Write a unit test for each of the methods. Each overloaded method should be tested separately.
Assume the number is between 1 and 300,000. 
 

Submission:

Java source code named RomanNumber.java
Java source code for unit testing RomanNumberTest.java
Screenshot of your test run as pdf or image (jpg, jpeg, png)
