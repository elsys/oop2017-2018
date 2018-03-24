# Симулация на логически вериги

Задачата на настоящото упражнение е да се развие проект, подобен на разработените
в часовете проекти за симулация на логически вериги 
[https://github.com/elsys/oop2017-2018/tree/master/11a/2018-03-22-gates](https://github.com/elsys/oop2017-2018/tree/master/11a/2018-03-22-gates)
и 
[https://github.com/elsys/oop2017-2018/tree/master/11b/2018-03-22-gates](https://github.com/elsys/oop2017-2018/tree/master/11b/2018-03-22-gates).

Идеята за упражнението е частично заимствана от книгата:
[Harold Abelson, Gerald Jay Sussman, "Structure and Interpretation of Computer Programs"](https://github.com/elsys/oop2017-2018/blob/master/practice/08-gates/docs/StructIntCompPrograms.pdf).

За целите на упражнението и домашното трябва да използвате от приложеният стартов проект
[https://github.com/elsys/oop2017-2018/tree/master/practice/08-gates](https://github.com/elsys/oop2017-2018/tree/master/practice/08-gates), 
а не проектите разбработени в клас.


## Бинарни логически елементи

### XOR логически елемент (3т)

Реалзирайте логически елемент XOR като бинарен логичести елемент:

```java
public class XorGate extends BinaryGate implements Gate {
...
}
```

### NAND логически елемент (3т)

Реалзирайте логически елемент NAND като бинарен логичести елемент:

```java
class NandGate extends BinaryGate {
...
}
```

Таблицата на истинност на NAND можете да видите в статията от Wikipedia 
[NAND gate](https://en.wikipedia.org/wiki/NAND_gate).

## Логически елементи базирани на NAND

Описание на използването на NAND логика можете да видите в статията
[NAND logic](https://en.wikipedia.org/wiki/NAND_logic).


### NOT логически елемент базиран на NAND (5т)

Добавете статична функция в класа ```NandFactory``` която създава композитен NOT 
логически елемент базиран на NAND логически елементи.

```java
public static Gate makeNotGate(Wire in, Wire out, String name) {
	...
}
```

### AND логически елемент базиран на NAND (5т)

Добавете статична функция в класа ```NandFactory``` която създава композитен AND 
логически елемент базиран на NAND логически елементи.

```java
public static Gate makeAndGate(Wire in1, Wire in2, Wire out, String name) {
	...
}
```


### OR логически елемент базиран на NAND (5т)

Добавете статична функция в класа ```NandFactory``` която създава композитен `OR` 
логически елемент базиран на NAND логически елементи.

```java
public static Gate makeOrGate(Wire in1, Wire in2, Wire out, String name) {
	...
}
```

### XOR логически елемент базиран на NAND (5т)

Добавете статична функция в класа ```NandFactory``` която създава композитен `XOR` 
логически елемент базиран на NAND логически елементи.

```java
public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
	...
}
```

## Релизация на суматори (Half Adder, Full Adder, Ripple Carry Adder)

За изпълнение на задачите за суматори можете да ползвате статиите 
[Adder (electronics)](https://en.wikipedia.org/wiki/Adder_(electronics))
и [Explain Half Adder and Full Adder with Truth Table](https://www.elprocus.com/half-adder-and-full-adder/).


### Логически елемент полу-суматор (Half Adder) (5т)

Добавете статична функция в класа `GateFactory`, която създава композитен 
`Half Adder` логически елемент:

```java
public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c, String name) {
	...
}
```

### Пълен еднобитов суматор (Full Adder) (5т)

Добавете статична функция в класа `GateFactory`, която създава композитен 
`Full Adder` логически елемент:

```java
public static Gate makeFullAdder(Wire a, Wire b, Wire s, Wire c, String name) {
	...
}
```

При създаването на логическият елемент `Full Adder` трябва да използвате
два полусуматора, както е показано в 
[Explain Half Adder and Full Adder with Truth Table](https://www.elprocus.com/half-adder-and-full-adder/).


### Пълен N-битов суматор (Ripple Carry Adder) (15т)

Добавете статична функция в класа `GateFactory`, която създава композитен 
`Ripple Carry Adder` логически елемент:

```java
public static Gate makeRippleCarryAdder(
					Wire a[], Wire b[], Wire cIn, 
					Wire sum[], Wire cOut) {
	...
}
```

Като входове на суматора се подават два масива от елементи 
`Wire a[]` и `Wire b[]` които репрезентират побитово двете събираеми `a` и `b`.
Допълнително се подава и вохда `cIn`, който репрезентира входният бит за 
пренос (препълване).

Изходите на суматора са масив `Wire sum[]`, който репрезентира побитово резултата
`sum` от сумирането на числата `a` и `b`. Допълнителен изход е и `cOut`, който е
изходният бит за пренос (препълване).

Масивите `a`, `b` и `sum`, които се подават на функцията `makeRippleCarryAdder` 
трябва да са с еднаква дължина (нека обозначим дължината на тези масиви с `N`).

Функцията `makeRippleCarryAdder` трябва да създаде `N` пълни еднобитови суматора
(Full Adder) и да ги свърже така, че да се превърнат в `N`-битов пълен суматор 
(RippleCarryAdder).

### Главна функция (10т)

Напишете програма, която:

* създава пълен 8 битов суматор като изплозва `makeRiplleCarryAdder`;
* чете от стандартния вход двойки 8-битови числа без знак до достигане на 
край на файла;
* за всяка прочена двойка числа:
	* намира побитовото представяне на всяко от числата го установява като
	стойности на сигналите на входовете `a` и `b` на 8 битовият суматор;
	* прочита стойностите на сигнала на изходите на суматора `sum` и ги 
	преобразува в 8 битово число;
	* отпечатва на стандартният изход стойността числото, което съответсва на
	`sum`.

	