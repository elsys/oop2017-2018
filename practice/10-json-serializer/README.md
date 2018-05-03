# Сериализация на клас до JSON 

## Първоначална функционалност

Целта на настоящото упражнение е да се имплементира класа `JsonSerializer`, който
трябва да е в състояние за сериализира обикновен `Java` обект в стринг в `JSON`
формат.

Например: ако имате обект от типа на класа `Student`:
```java
public class Student {
    
    private String name;
    
    private String lastName;
    
    private String fatherName;

    private List<Integer> grades;

    // ...
}
```

 със следните полета:

```java
Student student = new Student();
student.setName("Pesho");
student.setFatherName("Ivanov");
student.setLastName("Peshev");
student.setGrades(Arrays.asList(2, 5, 6));
```

то метода `serialize` на `JsonSerializer` трябва да върне следният `JSON` стринг:
```
{"name" : "Pesho", "lastName" : "Peshev", "grades": ["2","5","6"], "fatherName" : "Ivanov"}
```

## Поддръжка на `includeNullFields(boolean)`

Нека имаме следният обект:
```java
Student student = new Student();
student.setName("Pesho");
student.setLastName("Peshev");
student.setGrades(Arrays.asList(2, 5, 6));
```

Ако `includeNullFileds` се установи в `true`, то метода `serialize` на 
`JsonSerializer` трябва да върне следният `JSON` стринг:

```
{"name" : "Pesho", "lastName" : "Peshev", "grades": ["2","5","6"], "fatherName" : "null"}
```
Обърнете внимание, че стойността на `fatherName` е `null`.

Ако `includeNullFileds` се установи във `false`, то метода `serialize` на 
`JsonSerializer` трябва да върне следният `JSON` стринг:

```
{name : "Pesho", lastName : "Peshev", grades : ["2","5","6"]}
```
Обърнете внимание, че полето `fatherName` е пропуснато.



## Поддръжка на анотацията `Ignore`

Ако класът стринг се анотира по следният начин:
```java
public class Student {
    
    private String name;
    
    private String lastName;
    
    @Ignore
    private String fatherName;

    private List<Integer> grades;

    // ...
}
```

то метода `serialize` на `JsonSerializer` трябва да върне следният `JSON` стринг:
```
{"name" : "Pesho", "lastName" : "Peshev", "grades" : ["2","5","6"]}
```

## Поддръжка на `isPretty`

Ако метода `isPretty` на `JsonSerializer` връща `true`, то стринга, който
връща сериализатора трябва да бъде форматиран така:
```
{  
   "name":"Pesho",
   "lastName":"Peshev",
   "grades":[  
      "2",
      "5",
      "6"
   ]
}
```

## Поддръжка на анотацията `MapAs`

Ако класът стринг се анотира по следният начин:
```java
public class Student {
    
    @MapBy("first_name")
    private String name;
    
    @MapBy("last_name")
    private String lastName;
    
    @MapBy("father_name")
    private String fatherName;

    private List<Integer> grades;

    // ...
}
```

то метода `serialize` на `JsonSerializer` трябва да върне следният `JSON` стринг:
```
{first_name : "Pesho", last_name : "Peshev", grades : ["2","5","6"], father_name : "Ivanov"}
