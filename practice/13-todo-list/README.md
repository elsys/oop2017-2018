# To-do Lists
Целта на упражнението е да се имплементират класове, които да репрезентират to-do списъци.

## Формат
Форматът на един to-do списък като текстов низ е следният:
```
TODO    | Do OOP homework              | Low    | school, programming
TODO    | Get 8 hours of sleep.        | Low    | health
DOING   | Party hard.                  | Normal | social
DONE    | Netflix and chill.           | Normal | tv shows
TODO    | Find missing socks.          | Low    | meh
```
Всяка задача в to-do списъка има статус, описание, приоритет и тагове. Те са 
разделени със символа `|`, а таговете, когато са повече от един, са разделени 
със запетайка.

Статусите са дефинирани в изброимия тип `Status`, а приоритетите - в `Priority`.

## TodoList
Вашият списък трябва да имплементира интерфейсът `TodoList`. Инстанции на класа 
се създават чрез статичния метод `TodoList.parse(String)`, като форматът на 
подадения `String` съответства на този, дефиниран по-горе.

### TodoList::getTasks
Връща списък от задачи (`List<Task>`), като `Task` отново е интерфейс, който 
трябва да имплементирате. Има 4 метода, представляващи 4-те му характеристики.

### TodoList::isCompleted
Връща булева стойност - `true` ако всички задачи в списъка са със статус DONE.

### TodoList::completedPercentage
Връща `Double`, който представлява какъв процент от задачите са със статус DONE. 
Резултатът трябва да е закръглен до втората цифра след десетичната запетая.

### TodoList::statusPercentage и TodoList::matchingPercentage
Връщат `Double`, който представлява съответно процентът от задачи с подадения 
статус и отговарящите на подадения критерий.

### TodoList::filter(Criteria)
Връща ***нова*** инстанция на to-do списъка, филтриран по заданения критерий 
чрез обекта `Criteria`. Описание на `Criteria` следва по-долу.

### TodoList::count(Criteria)
Връща броя на задачи, които съответстват на подадения критерий.

### TodoList::each(Consumer<Task>)

За всяка задача в списъка, извиква инстанцията на функционалния интерфейс `Consumer`.

### TodoList::join(TodoList)

Обединява 2 списъка, като премахва повтарящите се задачи. **Не** променя 
текущата инстанция, а връща **нова**. 

## Criteria
`Criteria` представлява интерфейс, дефиниращ 3 статични метода и 3 нестатични. 
Чрез статичните методи се създават нови инстанции на обекти имплементиращи интерфейса:

```java
Criteria.status(Status.TODO);                   // Критерий за статус.
Criteria.priority(Priority.NORMAL);             // Критерий за приоритет.
Criteria.tags(new String[] {"food", "school"}); // Критерий за етикети.
```

Инстанциите на Criteria трябва да имат методи `and`, `or`, `xor` и `not`, които 
да позволяват критериите да се групират. Например:

```java
Criteria.tags(new String[] { "OOP" }).or(Criteria.priority(Priority.LOW));
```
ще върне критерия за задачи, които са с таг `OOP` или с приоритет `LOW`.

Както вече споменахме, `TodoList.filter(Criteria)` приема като аргумент 
инстанция на `Criteria`, като връща нов подсписък на този, върху който е извикан методът. Например:

```java
todoList.filter(Criteria.priority(Priority.HIGH));
```

ще върне нов подсписък, съдържащ само задачите с висок приоритет.

Критериите могат да се обединяват:
```java
todoList.filter(Criteria.priority(Priority.HIGH).and(Criteria.tags(new String[] { "school" }).not());
```

Това ще върне нов подсписък от задачи с висок приоритет и тагове, сред които няма `"school"`.

Подсписъците могат да се обединяват с метода `TodoList.join(TodoList)`. Следващите два реда трябва да връщат еквивалентен резултат:

```java
todoList.filter(Criteria.tags(new String[] { "school" }).or(Criteria.priority(Priority.HIGH));
todoList.filter(Criteria.tags(new String[] { "school" })).join(todoList.filter(Criteria.priority(Priority.HIGH)));
```
