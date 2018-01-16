#ifndef TURTLE_HH__
#define TURTLE_HH__

#include <iostream>

class Point {
	double x_, y_;
public:
	Point(double x=0.0, double y=0.0)
	: x_(x), y_(y)
	{}
	
	static Point polar(double angle, double distance);
	static Point cartesian(double x, double y);
	
	double get_x() const {
		return x_;
	}
	double get_y() const {
		return y_;
	}
	
	Point& operator+=(const Point& p) {
		x_ += p.x_;
		y_ += p.y_;
		return *this;
	}
	
	Point& operator-=(const Point& p) {
		x_ -= p.x_;
		y_ -= p.y_;
		return *this;
	}
};

Point operator+(const Point& p1, const Point& p2);
Point operator-(const Point& p1, const Point& p2);
std::ostream& operator<<(std::ostream& out, const Point& p);


class Color {

};

class Turtle {

};

class PSTurtle {


};


#endif
