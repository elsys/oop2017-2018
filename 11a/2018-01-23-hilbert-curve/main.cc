#include "turtle.hh"

#include <iostream>
using namespace std;

class HilbertCurve {
	
	int order_;
	Turtle* turtle_;
	int length_;

	void left(int order) {
		if (order == 0) {
			turtle_->right(180);
			return;
		}
		order--;
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
		: order_(order), length_(length), turtle_(turtle) {
		turtle_->setup();	
	}
	
	~HilbertCurve() {
		delete turtle_;
	}

	void draw() {
		turtle_->//moveto(Point(0, turtle_->get_width()))
				pendown()
				.right(90);
		left(order_);
	}
};

int main() {
	HilbertCurve curve(1, 20, new PSTurtle(500, 500));
	curve.draw();
	return 0;
}
