#include <iostream>
#include <list>
using namespace std;

class Point {
	double x_, y_;
public:
	Point(double x=0.0, double y=0.0)
	: x_(x), y_(y)
	{}

	double get_x() const { return x_;}
	double get_y() const { return y_;}
};

ostream& operator<<(ostream& out, const Point& p) {
	out << "P(" << p.get_x() << "," << p.get_y() << ")";	
	return out;
}

class Shape {

public:
	virtual void draw() const = 0;
};

class Circle: public Shape {
	Point center_;
	double radius_;
	
public:
	Circle(const Point& p, double radius)
	: center_(p), radius_(radius)
	{}
	
	void draw() const {
		cout << "Circle(" << center_ << "," << radius_ << ")"
			<< endl;
	}
};

class Rectangle: public Shape {
	Point ul_, br_;
	static double min_(double a, double b) {
		return (a<b)?a:b;
	}
	static double max_(double a, double b) {
		return (a>b)?a:b;
	}
public:
	Rectangle(Point p1, Point p2) 
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
	//.....
	Circle c1(Point(0,0), 3);
	shapes.push_back(&c1);
	Circle c2(Point(6,0), 3);
	shapes.push_back(&c2);
	
	Rectangle r1(Point(-1, -2), Point(1,2));
	shapes.push_back(&r1);
	
	for(list<Shape*>::iterator it = shapes.begin();
		it!=shapes.end(); ++it) {
		
		(*it) -> draw();	
	}


	return 0;
}

