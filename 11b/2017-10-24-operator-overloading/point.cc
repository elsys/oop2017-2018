#include <iostream>
using namespace std;



class Point {
	double x_, y_;
public:
	Point(double x, double y)
	: x_(x), y_(y)
	{}
	
	double get_x() const {
		return x_;
	}
	double get_y() const {
		return y_;
	}
	
	Point& set_x(double x) {
		x_ = x;
		return *this;
	}
	Point& set_y(double y) {
		y_ = y;
		return *this;
	}
	
	void print() const {
		cout << "Point(" << x_ << "," << y_ << ")" << endl;
	}
	
	Point& add(const Point& other) {
		x_ += other.x_;
		y_ += other.y_;
		return *this;
	}
	Point& sub(const Point& other) {
		x_ -= other.x_;
		y_ -= other.y_;
		return *this;
	}
	Point& mul(double a) {
		x_ *= a;
		y_ *= a;
		return *this;
	}
	/*
	Point operator+(const Point& other) const {
		Point result(x_, y_);
		result.add(other);
		return result;
	}
	*/
	
	Point& operator+=(const Point& other) {
		add(other);
		return *this;
	}
	
	Point& operator-=(const Point& other) {
		sub(other);
		return *this;
	}
	
	Point& operator*=(double a) {
		mul(a);
		return *this;
	}
};

Point operator+(const Point& p1, const Point& p2) {
	Point result(p1.get_x(), p1.get_y());
	result.add(p2);
	return result;
}

Point operator-(const Point& p1, const Point& p2) {
	Point result(p1.get_x(), p1.get_y());
	result.sub(p2);
	return result;
}

Point operator*(double a, const Point& p) {
	Point result(p.get_x(), p.get_y());
	result*=a;
	return result;
}

Point operator*(const Point& p, double a) {
	return a*p;
}

ostream& operator<<(ostream& out, const Point& p) {
	out << "Point(" << p.get_x() << "," << p.get_y() << ")";
	return out;
}

int main() {
	Point p(0,0);
	(p.set_x(1)).set_y(2);
	p.print();
	Point p1(1,1);
	Point p2(2,2);
	Point p3(3,3);
	
	// p1 += p2 (p1=p1+p2)
	p1.add(p2);
	p1.print();
	// p1 -= p2 (p1 = p1 - p2)
	p1.sub(p2);
	p1.print();
	
	p1.add(p2).sub(p3);
	p1.print();
	
	p3.mul(-1);
	p3.print();

	p1.set_x(1).set_y(1);
	p1.print();
	p2.print();
	
	p = p1 + p2;
		// p1.operator+(p2);
	p.print();
	
	p+=p1; // p = p + p1
	p.print();
	
	p = p2 - p1;
	p -= p1;
	p.print();
	p1.print();
	p1*=2;
	p1.print();
	
	p = 2*p1;
	p.print();
	
	p = p1*2;
	
	
	((cout << p) << p1) << p2 << endl;
	
/*
	int a=1, b=2;
	int m = (a>b)?a:b;
*/	


	return 0;
}

