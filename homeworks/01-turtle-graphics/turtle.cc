/*
 * turtle.cc
 *
 *  Created on: Oct 21, 2017
 *      Author: lubo
 */

#include "turtle.hh"
#include <cmath>

using namespace std;

Point Point::polar(double angle, double distance) {
	double radians = angle * M_PI / 180.0;

	double x = distance * cos(radians);
	double y = distance * sin(radians);
	return Point(x, y);
}

Point Point::cartesian(double x, double y) {
	return Point(x, y);
}

Point operator+(const Point& p1, const Point& p2) {
	Point result = p1;
	result += p2;
	return result;
}

Point operator-(const Point& p1, const Point& p2) {
	Point result = p1;
	result -= p2;
	return result;
}

ostream& operator<<(ostream& out, const Point& p) {
	out << p.get_x() << ' ' << p.get_y();
	return out;
}

ostream& operator<<(ostream& out, const Color& c) {
	out << c.red() << " "
		<< c.green() << " "
		<< c.blue();
	return out;
}

Turtle::Turtle(double width, double height) :
		width_(width), height_(height),
		pos_(width_ / 2.0, height_ / 2.0),
		heading_(0.0),
		is_pendown_(false),
		pen_size_(1.0),
		setup_(false) {

}

Turtle::~Turtle() {

}

Turtle& Turtle::forward(double distance) {
	assert(setup_);
	assert(distance >= 0);

	Point tr = Point::polar(heading_, distance);
	Point next_pos = pos_ + tr;
	return moveto(next_pos);
}

Turtle& Turtle::backward(double distance) {
	assert(setup_);
	assert(distance >= 0);

	Point tr = Point::polar(heading_ + 180.0, distance);
	Point next_pos = pos_ + tr;
	return moveto(next_pos);
}

Turtle& Turtle::right(double angle) {
	assert(setup_);
	assert(angle >= 0);

	heading_ -= angle;
	return *this;
}

Turtle& Turtle::left(double angle) {
	assert(setup_);
	assert(angle >= 0);

	heading_ += angle;
	return *this;
}

Turtle& Turtle::set_pos(const Point& p) {
	assert(setup_);
	assert(inside(p));

	pos_ = p;
	return *this;
}

Turtle& Turtle::set_heading(double angle) {
	assert(setup_);

	heading_ = angle;
	return *this;
}

Turtle& Turtle::penup() {
	assert(setup_);

	is_pendown_ = false;
	return *this;
}

Turtle& Turtle::pendown() {
	assert(setup_);

	is_pendown_ = true;
	return *this;
}

Turtle& Turtle::pencolor(const Color& c) {
	assert(is_setup());

	color_ = c;
	return *this;
}

Turtle& Turtle::pensize(double width) {
	assert(is_setup());

	pen_size_ = width;
	return *this;
}

Turtle& Turtle::dot(double size) {
// do nothing
	return *this;
}

PSTurtle::PSTurtle(double width, double height, ostream& out) :
		Turtle(width, height), out_(out) {
}

PSTurtle::~PSTurtle() {
	out_ << "stroke" << endl;
	out_ << "showpage" << endl;
	out_ << "%%EOF" << endl;
}

Turtle& PSTurtle::setup() {
	out_ << "%!PS-Adobe-3.0 EPSF-3.0" << endl;
	out_ << "%%Creator: turtle" << endl;
	out_ << "%%DocumentData: Clean7Bit" << endl;
	out_ << "%%Origin: 0 0" << std::endl;
	out_ << "%%BoundingBox: 0 0 "
			<< get_width() << " " << get_height() << endl;
	out_ << "%%LanguageLevel: 2" << endl;
	out_ << "%%Pages: 1" << endl;
	out_ << "%%Page: 1 1" << endl;

	out_ << "newpath" << endl;
	out_ << get_pos() << " moveto" << endl;
	Turtle::setup();

	return *this;
}

Turtle& PSTurtle::moveto(const Point& next_pos) {
	assert(is_setup());
	assert(inside(next_pos));

	out_ << next_pos << ' ';
	if (is_pendown()) {
		out_ << "lineto" << std::endl;
	} else {
		out_ << "moveto" << std::endl;
	}
	Turtle::moveto(next_pos);
	return *this;
}

Turtle& PSTurtle::pencolor(const Color& c) {
	assert(is_setup());

	Turtle::pencolor(c);
	out_ << "stroke" << endl;
	out_ << "newpath" << endl;
	out_ << get_pos() << " moveto" << endl;
	out_ << c << " setrgbcolor" << endl;
	return *this;
}

Turtle& PSTurtle::pensize(double width) {
	assert(is_setup());

	Turtle::pensize(width);
	out_ << "stroke" << endl;
	out_ << "newpath" << endl;
	out_ << get_pos() << " moveto" << endl;
	out_ << width << " setlinewidth" << endl;
	return *this;
}


Turtle& PSTurtle::dot(double size) {
	out_ << "gsave" << endl;
	out_ << "newpath" << endl;
	out_ << get_pos() << " " << size << " "
		 << "0 360 arc closepath fill" << endl;
	out_ << "grestore" << endl;
	return *this;
}

Turtle& PSTurtle::set_pos(const Point& p) {
	out_ << p << " moveto" << endl;
	return Turtle::set_pos(p);
}
