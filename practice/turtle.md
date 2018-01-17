# Turtle Graphics


## Точка в равнината

```cpp
class Point {
	double x_, y_;
public:
	Point(double x = 0.0, double y = 0.0);
	double get_x() const;
	double get_y() const;

	static Point polar(double angle, double distance);
	static Point cartesian(double x, double y);

	Point& operator+=(const Point& other);

	Point& operator-=(const Point& other);
};

Point operator+(const Point& p1, const Point& p2);
Point operator-(const Point& p1, const Point& p2);

std::ostream& operator<<(std::ostream& out, const Point& p);
```

## Цвят

```cpp
class Color {
	double r_, g_, b_;
public:
	Color(double r = 0.0, double g = 0.0, double b = 0.0);

	double red() const;
	double green() const;
	double blue() const;

	static Color gray(double gray);
};

std::ostream& operator<<(std::ostream& out, const Color& c);
```

## Базов клас `Turtle`

```cpp
class Turtle {
	...
	...
	
public:

	Turtle(double width, double height);
	virtual ~Turtle();
	virtual Turtle& setup();

	bool is_setup() const;
	double get_width() const;
	double get_height() const;
	
	const Point& get_pos() const;
	bool is_pendown() const;

	double get_pensize() const;
	const Color& get_color() const;

	virtual Turtle& moveto(const Point& pos);

	Turtle& right(double angle);
	Turtle& left(double angle);
	double get_heading() const;

	Turtle& penup();
	Turtle& pendown();

	Turtle& forward(double distance);
	Turtle& backward(double distance);

	Turtle& set_pos(const Point& p);
	Turtle& set_heading(double angle);

	virtual Turtle& pensize(double width = 1.0);
	virtual Turtle& pencolor(const Color& c);

	virtual Turtle& dot(double size=1.0);
};
```
* Конструктор, деструктор:

	```cpp
	Turtle(double width, double height);
	virtual ~Turtle();
	```

* Инициализиране полето за рисуване:

	```cpp
	virtual Turtle& setup();
	```	

* Проверява дали полето за рисуване е инициализирано:

	```cpp
	bool is_setup() const;
	```
* Връща ширината и височината на полето за рисуване:
	
	```cpp
	double get_width() const;
	double get_height() const;
	```

* Връща текущата позиция на писеца:

	```cpp
	const Point& get_pos() const;
	```

* Проверява дали писеца е спуснат или вдигнат:

	```cpp
	bool is_pendown() const;
	```		

* Връщат текущият размер на писеца и текущият цвят:

	```cpp
	double get_pensize() const;
	const Color& get_color() const;
	```

* Завърта посоката на писеца на ъгъл `angle` градуса надясно или наляво съответно:

	```cpp
	Turtle& right(double angle);
	Turtle& left(double angle);
	```	

* Връща текущата посока на писеца в градуси:

	```cpp
	double get_heading() const;
	```
* Вдига и сваля писеца съответно:

	```cpp
	Turtle& penup();
	Turtle& pendown();
	```

* Придвиждва писеца напред или назад на разстояние `distance`.

	```cpp
	Turtle& forward(double distance);
	Turtle& backward(double distance);
	```

* Задава позиция и посока на писеца:
	
	```cpp
	Turtle& set_pos(const Point& p);
	Turtle& set_heading(double angle);
	```

* Задава ширина и цвят на писеца:

	```cpp
	virtual Turtle& pensize(double width = 1.0);
	virtual Turtle& pencolor(const Color& c);
	```

* Рисува точка с размер `size`:

	```cpp
	virtual Turtle& dot(double size=1.0);
	```
	

## Имплементация на `Turtle` базирана върху `PostScript`

```cpp
class PSTurtle: public Turtle {
	std::ostream& out_;

public:
	PSTurtle(double width, double height, std::ostream& out=std::cout);
	~PSTurtle();

	Turtle& setup();
	Turtle& moveto(const Point& pos);
	Turtle& pencolor(const Color& c);
	Turtle& pensize(double width);

	Turtle& dot(double size=1.0);
};
```
