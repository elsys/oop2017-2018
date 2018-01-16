
#include "turtle.hh"

#include <iostream>
using namespace std;

int main() {
	PSTurtle t;

	Point p1 = Point::polar(0, 100);
	Point p2 = Point::polar(90, 100);
	Point p3 = Point::polar(180, 100);
	
	cout << p1 << endl;
	cout << p2 << endl;
	cout << p3 << endl;

	return 0;
}

