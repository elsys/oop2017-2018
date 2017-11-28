#include <iostream>
#include <list>
using namespace std;

class Shape {

public:
	virtual void draw() const = 0;
};


class Point {
	double x_, y_;
public:
	Point(double x=0.0, double y=0.0)
	:x_(x), y_(y)
	{}
	
	double get_x() const {
		return x_;
	}
	double get_y() const {
		return y_;
	}
};

ostream& operator<<(ostream& out, const Point& p) {
	out << "P(" << p.get_x() << "," << p.get_y() << ")";
	return out;
}



class Circle: public Shape {
	Point center_;
	double radius_;
	
public:
	Circle(const Point& center, double radius)
	: center_(center),
	  radius_(radius)
	{}
	void draw() const {
		cout << "C(" << center_ << ";" << radius_ << ")" << endl;
	}
};

class Rectangle: public Shape {
	Point ul_, br_;
	
	static double min_(double a, double b) {
		return (a<b)? a: b;
	}
	static double max_(double a, double b) {
		return (a>b)? a: b;
	}
public:
	Rectangle(const Point& p1, const Point& p2)
	: ul_(min_(p1.get_x(), p2.get_x()),
		  max_(p1.get_y(), p2.get_y())),
	  br_(max_(p1.get_x(), p2.get_x()),
	      min_(p1.get_y(), p2.get_y()))
	{}
	
	void draw() const {
		cout << "R(" << ul_ << ";" << br_ << ")" << endl;
	}

};

int main() {
	// Shape sh;
	list<Shape*> shapes;
	
	Circle c1(Point(-3, 0), 3.0);
	shapes.push_back(&c1);
	Circle c2(Point(3, 0), 3.0);
	shapes.push_back(&c2);
	
	Rectangle r1(Point(-3,-1), Point(3,1));
	shapes.push_back(&r1);
	
	for(list<Shape*>::iterator it=shapes.begin();
		it!= shapes.end(); ++it) {
		
		(*it) -> draw();	
	}


	return 0;
}

