#ifndef TURTLE_HH__
#define TURTLE_HH__

// http://paulbourke.net/dataformats/postscript/

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
	double width_, height_;
	Point pos_;
	double heading_;
	bool is_pendown_;
	
public:
	Turtle(double w, double h)
	: width_(w), height_(h), 
	  pos_(width_/2.0, height_/2.0),
	  heading_(0),
	  is_pendown_(false)
	{}
	
	virtual ~Turtle() {
	}
	
	virtual void setup() {
	}
	
	bool is_pendown() const {
		return is_pendown_;
	}
	
	Turtle& set_pendown(bool down) {
		is_pendown_ = down;
		return *this;
	}
	
	const Point& get_pos() const {
		return pos_;
	}
	
	double get_width() const {
		return width_;
	}
	
	double get_height() const {
		return height_;
	}
	
	double get_heading() const {
		return heading_;
	}
	
	Turtle& set_heading(double heading) {
		heading_ = heading;
		return *this;
	}
	
	Turtle& left(double angle) {
		heading_ += angle;
		return *this;
	}
	
	Turtle& right(double angle) {
		heading_ -= angle;
		return *this;
	}
	
	virtual Turtle& moveto(const Point& next_pos) {
		pos_ = next_pos;
		return *this;
	}
	
	virtual Turtle& forward(double distance) = 0;
	
	virtual Turtle& backward(double distance) = 0;
};

class PSTurtle: public Turtle {
	std::ostream& out_;
public:
	PSTurtle(double w, double h, std::ostream& out=std::cout)
	: Turtle(w, h), out_(out)
	{}
	
	~PSTurtle();
	void setup();
	Turtle& moveto(const Point& next_pos);
	Turtle& forward(double distance);
	Turtle& backward(double distance);
};


#endif
