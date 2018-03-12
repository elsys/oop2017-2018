#ifndef TURTLE_HH__
#define TURTLE_HH__
#include <iostream>


// http://paulbourke.net/dataformats/postscript/

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
	
	Point& operator+=(const Point& other) {
		x_ += other.x_;
		y_ += other.y_;
		return *this;
	}
	
	Point& operator-=(const Point& other) {
		x_ -= other.x_;
		y_ -= other.y_;
		return *this;
	}
};

Point operator+(const Point& p1, const Point& p2);
Point operator-(const Point& p1, const Point& p2);

std::ostream& operator<<(std::ostream& out, const Point& p);

class Color {

};

class Turtle {
	double width_, height_;
	Point pos_;
	double heading_;
	bool is_pendown_;

public:

	Turtle(double width, double height)
	: width_(width), height_(height),
	pos_(width_/2.0, height_/2.0),
	heading_(0),
	is_pendown_(false)
	{}
	
	virtual ~Turtle() {
	
	}
	
	virtual void setup() {
	
	}
	
	double get_width() const {
		return width_;
	}
	double get_height() const {
		return height_;
	}
	
	const Point& get_pos() const {
		return pos_;
	}
	
	double get_heading() const {
		return heading_;
	}
	
	bool is_pendown() const {
		return is_pendown_;
	}
	
	virtual Turtle& set_pos(const Point& p) {
		pos_ = p;
		return *this;
	}
	
	Turtle& set_heading(double angle) {
		heading_ = angle;
		return *this;
	}
	
	Turtle& penup() {
		is_pendown_ = false;
		return *this;
	}
	
	Turtle& pendown() {
		is_pendown_ = true;
		return *this;
	}
	
	Turtle& right(double angle) {
		heading_ -= angle;
		return *this;
	}
	
	Turtle& left(double angle) {
		heading_ += angle;
		return *this;
	}
	
	virtual Turtle& moveto(const Point& pos) {
		pos_ = pos;
		return *this;
	}
	
	Turtle& forward(double distance) {
		Point movement = Point::polar(heading_, distance);
		Point next_pos = get_pos() + movement;
		moveto(next_pos);
		return *this;
	}
	
};

class PSTurtle: public Turtle {
	std::ostream& out_;

public:
	PSTurtle(double w, double h, std::ostream& out=std::cout)
	: Turtle(w, h), out_(out)
	{}
	
	virtual void setup();
	virtual ~PSTurtle();
	
	Turtle& moveto(const Point& p);
	Turtle& set_pos(const Point& p) {
		Turtle::set_pos(p);
		out_ << get_pos() << " moveto" << std::endl;
		return *this;
	}
};



#endif

