
#include "turtle.hh"

#include <iostream>
using namespace std;

class HilbertCurve {
	int order_;
	int length_;
	Turtle* turtle_;

	void left(int order) {
		if (order == 0) {
			turtle_->left(180);
			return;
		}
		order--;
		turtle_->left(90);
		right(order);
		turtle_->left(90).forward(length_);
		left(order);
		turtle_->right(90).forward(length_).right(90);
		left(order);
		turtle_->forward(length_).left(90);
		right(order);
	}
	
	void right(int order) {
		if (order == 0) {
			turtle_->left(180);
			return;
		}
		order--;
		turtle_->right(90);
		left(order);
		turtle_->right(90).forward(length_);
		right(order);
		turtle_->left(90).forward(length_).left(90);
		right(order);
		turtle_->forward(length_).right(90);
		left(order);
	}

	public:
	
	HilbertCurve(int order, int length, Turtle* turtle)
		: order_(order), length_(length), turtle_(turtle) {}
	
	void draw() {
		turtle_->setup();
		turtle_->set_pendown(true).right(90);
		right(order_);
	}
};

int main() {
	PSTurtle* turtle = new PSTurtle(500, 500);
	HilbertCurve curve(1, 20, turtle);
	curve.draw();
	delete turtle;
	return 0;
}

