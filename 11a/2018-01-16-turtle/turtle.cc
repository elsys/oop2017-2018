#include "turtle.hh"

#include <cmath>
#include <iostream>

using namespace std;


Point Point::polar(double angle, double distance) {
	double radians = angle * M_PI /180.0;
	
	double x = distance*cos(radians);
	double y = distance*sin(radians);
	return Point(x, y);
}

Point Point::cartesian(double x, double y) {
	return Point(x, y);
}

Point operator+(const Point& p1, const Point& p2) {
	Point r(p1);
	r+=p2;
	return r;
}

Point operator-(const Point& p1, const Point& p2) {
	Point r(p1);
	r-=p2;
	return r;
}

ostream& operator<<(ostream& out, const Point& p) {
	out << p.get_x() << " " << p.get_y();
	return out;
}

void PSTurtle::setup() {

	out_ << "%!PS-Adobe-3.0 EPSF-3.0" << endl;
	out_ << "%%Creator: turtle" << endl;
	out_ << "%%DocumentData: Clean7Bit" << endl;
	out_ << "%%BoundingBox: 0 0 " 
		<< get_width() << " "
		<< get_height() << endl;
	out_ << "%%Pages: 1" << endl;
	out_ << "%%Page: 1 1" << endl;
	
	out_ << "newpath" << endl;
	out_ << get_pos() << " moveto" << endl;

}

PSTurtle::~PSTurtle() {
	
	out_ << "stroke" << endl;
	out_ << "%%EOF" << endl;
}


Turtle& PSTurtle::moveto(const Point& next_pos) {
	out_ << next_pos << " ";
	if(is_pendown()) {
		out_ << "lineto";
	} else {
		out_ << "moveto";
	}
	out_ << endl;
    Turtle::moveto(next_pos);
	return *this;
}

