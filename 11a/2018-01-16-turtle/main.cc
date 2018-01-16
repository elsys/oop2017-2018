#include "turtle.hh"

#include <iostream>
using namespace std;

int main() {
	PSTurtle t(500,500);
	t.setup();

	t.pendown().forward(100)
	.left(90).forward(100)
	.left(90).forward(100)
	.left(90).forward(100)
	.left(90).forward(100);
	

	return 0;
}
