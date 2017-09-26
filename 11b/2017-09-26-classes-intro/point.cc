#include <iostream>
using namespace std;


class Point {
	double x_;
	double y_;

public:
/*
	Point() {
		cout << "Point() called..." << endl;
		x_ = 0.0;
		y_ = 0.0;
	}
*/

	Point(double x=0.0, double y=0.0) {
		cout << "Point(" << x << "," << y << ") called..." << endl;
		x_ = x;
		y_ = y;
	}
	double get_x() {
		return x_;
	}
	double get_y() {
		return y_;
	}
	void set_x(double x) {
		x_ = x;
	}
	void set_y(double y) {
		y_ = y;
	}
};

class Rectangle {
	Point bl_, ur_;
public:

	Rectangle(Point bl, Point ur) {
		bl_ = bl;
		ur_ = ur;
	}

};

int main() {
	Point p1, p2(1.0, 2.0);
	Point p3(42.0);
/*
	p1.set_x(0.0);
	p1.set_y(0.0);
	
	p2.set_x(1.0);
	p2.set_y(1.0);
*/
	cout << "p1= " << p1.get_x() << "," << p1.get_y() << endl;
	cout << "p2= " << p2.get_x() << "," << p2.get_y() << endl;
	
	Rectangle r(p1, p2);
	
	return 0;
}

