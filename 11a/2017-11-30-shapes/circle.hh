#ifndef CIRCLE_HH__
#define CIRCLE_HH__

#include "point.hh"
#include "shape.hh"

class Circle: public Shape {
	Point center_;
	double radius_;
public:

	Circle(const Point& center, double radius);
	
	void draw() const;
};

#endif

