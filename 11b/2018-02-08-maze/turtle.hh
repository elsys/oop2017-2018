/*
 * tutle.hh
 *
 *  Created on: Oct 21, 2017
 *      Author: lubo
 */

#ifndef TURTLE_HH_
#define TURTLE_HH_

#include <iostream>
#include <cassert>

class Point {
	double x_, y_;
public:
	Point(double x = 0.0, double y = 0.0) :
			x_(x), y_(y) {
	}
	double get_x() const {
		return x_;
	}
	double get_y() const {
		return y_;
	}

	static Point polar(double angle, double distance);
	static Point cartesian(double x, double y);

	Point& operator+=(const Point& other) {
		x_ += other.get_x();
		y_ += other.get_y();
		return *this;
	}

	Point& operator-=(const Point& other) {
		x_ -= other.get_x();
		y_ -= other.get_y();
		return *this;
	}
};

Point operator+(const Point& p1, const Point& p2);
Point operator-(const Point& p1, const Point& p2);

std::ostream& operator<<(std::ostream& out,
		const Point& p);

class Color {
	double r_, g_, b_;
public:
	Color(double r=0.0, double g=0.0, double b=0.0)
	: r_(r), g_(g), b_(b) {
		assert(0 <= r_ && r_ <= 1.0);
		assert(0 <= g_ && g_ <= 1.0);
		assert(0 <= b_ && b_ <= 1.0);
	}

	double red() const {
		return r_;
	}
	double green() const {
		return g_;
	}
	double blue() const {
		return b_;
	}

	static Color gray(double gray) {
		assert(0 <= gray && gray <= 1);
		return Color(gray, gray, gray);
	}
};

std::ostream& operator<<(std::ostream& out,
		const Color& c);

class Turtle {

	double width_, height_;
	Point pos_;
	double heading_;
	bool is_pendown_;
	Color color_;
	double pen_size_;

	bool setup_;

protected:
	bool inside(const Point& pos) {
		return 0 <= pos.get_x() &&
				pos.get_x() <= width_ &&
				0 <= pos.get_y()
				&& pos.get_y() <= height_;
	}

public:

	Turtle(double width, double height);
	virtual ~Turtle();

	bool is_setup() const {
		return setup_;
	}

	bool is_pendown() const {
		return is_pendown_;
	}

	double get_width() const {
		return width_;
	}
	double get_height() const {
		return height_;
	}
	const Color& get_color() const {
		return color_;
	}
	const Point& get_pos() const {
		return pos_;
	}

	double get_pensize() const {
		return pen_size_;
	}

	double get_heading() const {
		return heading_;
	}

	virtual Turtle& setup() {
		setup_ = true;
		return *this;
	}

	virtual Turtle& moveto(const Point& pos) {
		pos_ = pos;
		return *this;
	}

	Turtle& forward(double distance);
	Turtle& backward(double distance);

	Turtle& right(double angle);
	Turtle& left(double angle);

	virtual Turtle& set_pos(const Point& p);
	Turtle& set_heading(double angle);

	Turtle& penup();
	Turtle& pendown();
	virtual Turtle& pensize(double width = 1.0);
	virtual Turtle& pencolor(const Color& c);

	virtual Turtle& dot(double size=1.0);

};

class PSTurtle: public Turtle {
	std::ostream& out_;

public:
	PSTurtle(double width, double height, std::ostream& out=std::cout);
	~PSTurtle();

	Turtle& setup();
	Turtle& moveto(const Point& pos);
	Turtle& pencolor(const Color& c);
	Turtle& pensize(double width);
	Turtle& set_pos(const Point& pos);

	Turtle& dot(double size=1.0);
};

#endif
