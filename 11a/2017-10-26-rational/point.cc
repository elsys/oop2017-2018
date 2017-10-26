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
	
	
	Point& add(const Point& other) { // p.add(o) -> p += o
		x_ += other.x_;
		y_ += other.y_;
		return *this;
	}
	
	Point& sub(const Point& other) { // p.sub(o) -> p -= o
		x_ -= other.x_;
		y_ -= other.y_;
		return *this;
	}
	
	Point& mul(double a) { // p.mul(a) -> p *= a;
		x_ *= a;
		y_ *= a;
		return *this;
	}
	
	void print() const {
		cout << "Point(" << x_ << "," << y_ << ")" << endl;
	}
	
	/*
	Point operator+(const Point other) const {
		Point result(x_, y_);
		result.add(other);
		return result;
	}
	*/
	
	Point operator-(void) const {
		Point result(-x_, -y_);
		return result;
	}
	
	Point& operator-=(const Point& other) {
		x_ -= other.x_;
		y_ -= other.y_;
		return *this;
	}
	
};

Point operator-(const Point& p1, const Point& p2) {
	Point result(p1.get_x(), p1.get_y());
	result -= p2;
	return result;
}

Point operator+(const Point& p1, const Point& p2) {
	Point result(p1.get_x(), p1.get_y());
	result.add(p2);
	return result;
}

ostream& operator<<(ostream& out, const Point& p) {
	out << "(" << p.get_x() << "," << p.get_y() << ")";
	return out;
}


istream& operator>>(istream& in, Point& p) {
	char ch=0;
	double x=0.0, y=0.0;
		
	in >> ch; //(
	if(ch!='(') {
		in.clear(ios_base::badbit);
		return in;
	}
	in >> x;
	in >> ch; //,
	if(ch!=',') {
		in.clear(ios_base::badbit);
		return in;
	}
	in >> y;
	in >> ch; //)
	if(ch!=')') {
		in.clear(ios_base::badbit);
		return in;
	}
	
	if(in.good()) {
		p.set_x(x).set_y(y);
	}
	return in;
}

int main() {
	Point p(0,0);;
	(p.set_x(1)).set_y(2);
	Point p1(1,1);
	Point p2(2,2);
	Point p3(3,3);
	Point p4(4,4);
	
	p.add(p2).sub(p3);
	p3.add(p4);
	// p3 += p4;
	p = p1 + p2;
	p.print();
	
	p= -p1;
	p.print();
	// p = p1 + 5;
	
	/*
	int a = 1;
	int b = 2;
	int m = (a>b)?a:b;
	*/
	
	p = p1 - p2;
	p.print();
	
	p -= p2;
	p.print();
	
	
	((cout << p) << p1) << endl;
	
	cout <<"p1=" << p1 << "; p2=" << p2 << endl;
	(cin >> p1) >> p2;
	if(!cin.good()) {
		cout << "reading points failed..." << endl;
	}
	cout <<"p1=" << p1 << "; p2=" << p2 << endl;
	
	
	return 0;
}

