## Завдання

Як основа використовувати вихідний текст проекту попередньої лабораторної роботи. Забезпечити розміщення результатів обчислень уколекції з можливістю збереження/відновлення. Використовуючи шаблон проектування Factory Method (Virtual Constructor), розробити ієрархію, що передбачає розширення рахунок додавання нових відображуваних класів. Розширити ієрархію інтерфейсом "фабрикованих" об'єктів, що представляє набір методів для відображення результатів обчислень. Реалізувати ці методи виведення результатів у текстовому виде. Розробити тареалізувати інтерфейс для "фабрикуючого" методу.

### Тестування програми

```
Testing initialization and display of randomly generated values:
BinaryCurrent = 100000000100000001110111101111010110010110011000100000001101110

Testing save and restore functionality:
Saving current state...
Restoring last saved state...
BinaryCurrent = 100000000100000001110111101111010110010110011000100000001101110

Testing setResult and getResult:
Custom result:
BinaryCurrent = 1010101010

Testing random generation:
BinaryCurrent = 100000000010011111110001101100111001011111001011010011111000101

Testing creation of Displayable object:
BinaryCurrent = 100000000010011111110001101100111001011111001011010011111000101

Testing completed.

Process finished with exit code 0
```
