/*
 * hilbert.cc
 *
 *  Created on: Oct 21, 2017
 *      Author: lubo
 */
 
 // http://www.ethoberon.ethz.ch/WirthPubl/AD.pdf

#include "turtle.hh"
#include <iostream>
using namespace std;

class Hilbert {
	Turtle& turtle_;
	double step_;
	double width_;
	Point center_;

	void draw_0();

public:
	Hilbert(Turtle& t, double width, Point center);

	void draw_a(int order);
	void draw_b(int order);
	void draw_c(int order);
	void draw_d(int order);

	void draw(int order);

	double calc_step(int order);
};

Hilbert::Hilbert(Turtle& t, double width, Point center) :
		turtle_(t), step_(0), width_(width), center_(center) {
}

void Hilbert::draw_0() {
//	Color c = turtle_.get_color();
//	turtle_.pencolor(Color(1, 0, 0));
//	turtle_.dot(1);
//	turtle_.pencolor(c);
}

void Hilbert::draw_a(int order) {
	assert(order >= 0);

	if (order == 0) {
		draw_0();
	} else {
		draw_d(order - 1);
		turtle_.set_heading(180).forward(step_);
		draw_a(order - 1);
		turtle_.set_heading(-90).forward(step_);
		draw_a(order - 1);
		turtle_.set_heading(0).forward(step_);
		draw_b(order - 1);
	}
}

void Hilbert::draw_b(int order) {
	assert(order >= 0);

	if (order == 0) {
		draw_0();
	} else {
		draw_c(order - 1);
		turtle_.set_heading(90).forward(step_);
		draw_b(order - 1);
		turtle_.set_heading(0).forward(step_);
		draw_b(order - 1);
		turtle_.set_heading(-90).forward(step_);
		draw_a(order - 1);
	}
}

void Hilbert::draw_c(int order) {
	assert(order >= 0);

	if (order == 0) {
		draw_0();
	} else {
		draw_b(order - 1);
		turtle_.set_heading(0).forward(step_);
		draw_c(order - 1);
		turtle_.set_heading(90).forward(step_);
		draw_c(order - 1);
		turtle_.set_heading(180).forward(step_);
		draw_d(order - 1);
	}
}

void Hilbert::draw_d(int order) {
	assert(order >= 0);

	if (order == 0) {
		draw_0();
	} else {
		draw_a(order - 1);
		turtle_.set_heading(-90).forward(step_);
		draw_d(order - 1);
		turtle_.set_heading(180).forward(step_);
		draw_d(order - 1);
		turtle_.set_heading(90).forward(step_);
		draw_c(order - 1);
	}
}

double Hilbert::calc_step(int order) {
	assert(order > 0);
	double step = width_;
	while (--order > 0) {
		step /= 2.0;
	}
	cerr << "step=" << step << endl;
	step_ = step;
	return step;
}

void Hilbert::draw(int order) {
	Point p0 = center_;
	for (int i = 1; i <= order; ++i) {
		calc_step(i);
		p0 = p0 + Point(step_ / 2.0, step_ / 2.0);
		turtle_.penup();
		turtle_.moveto(p0);
		turtle_.pendown();
		turtle_.pencolor(Color::gray(0.1 * order - 0.1 * i));
		turtle_.pensize(1);

		draw_a(i);

	}
}

int main() {
	PSTurtle t = PSTurtle(3000, 3000);
	t.setup();

	Hilbert h(t, 1024, Point(1500, 1500));
	h.draw(7);

}
