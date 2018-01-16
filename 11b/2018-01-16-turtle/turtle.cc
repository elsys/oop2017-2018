
#include "turtle.hh"

#include <iostream>
#include <cmath>
using namespace std;


Point Point::polar(double angle, double distance) {
	double radians = angle * M_PI / 180.0;
	double x = distance*cos(radians);
	double y = distance*sin(radians);
	return Point(x, y);
}

Point Point::cartesian(double x, double y) {
	return Point(x, y);
}

Point operator+(const Point& p1, const Point& p2) {
	Point r=p1;
	r+=p2;
	return r;
}

Point operator-(const Point& p1, const Point& p2) {
	Point r=p1;
	r-=p2;
	return r;
}

ostream& operator<<(ostream& out, const Point& p) {
	out << p.get_x() << " " << p.get_y();
	return out;
}


