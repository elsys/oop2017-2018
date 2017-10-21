#include <iostream>

using namespace std;

class Point {

    double x_, y_;
    const double cx_, cy_;
    
    public:

    static const double DEFAULT_CX_ = 0, DEFAULT_CY_ = 0;
    
    Point(double x, double y, double cx, double cy)
        : x_(x), y_(y), cx_(cx), cy_(cy) {}

    Point(double x, double y)
        : x_(x), y_(y), cx_(DEFAULT_CX_), cy_(DEFAULT_CY_) {}
    
    static Point get_default_beginning()  {
        // won't compile!!
        //cout << cx_ << endl;
        //print();
        return Point(DEFAULT_CX_, DEFAULT_CY_);
    }

    double get_x() const {
        return x_;
    }

    Point& set_x(double x) {
        x_ = x;
        return *this;
    }

    double get_y() const {
        return y_;
    }

    Point& set_y(double y) {
        y_ = y;
        return *this;
    }
    
    double get_cx() const {
    	return cx_;
    }
    
    double get_cy() const {
    	return cy_;
    }
    
    
    
    void print() const {
    	this; // const Point *const
        cout << "(" << x_ << "," << y_ << ")" << " in "
             << "(" << cx_ << "," << cy_ << ")" << endl;
    }
    Point transform_in_default() {
        return transform_in(DEFAULT_CX_, DEFAULT_CY_);
    }
    Point transform_in(double new_cx, double new_cy) {
        return Point(x_ + cx_ - new_cx, y_ + cy_ - new_cy, new_cx, new_cy);
    }
};
int main() {
/*
	char* pchar;
	const char* cpchar;
	char* const pchar;
	const char *const cpchar;
*/



    const Point orig(0,0);
	orig.print();
	Point p1(1,1,0,0);
	Point p2(2,2,0,0);
	
	Point& rp = p1;
	const Point& crp = p2;
	
	// crp.set_x(1.);
	crp.get_x();
	
	rp.set_x(1.);
	rp.get_x();
	
	
	p1.transform_in(2,2);
	p2.transform_in(3,3);
	p1.print();
	p2.print();
	
	(p1.set_x(3.0)).set_y(3.0);
	p2.set_y(4.0).set_x(4.0);
	
	p1.print();
	p2.print();
	
    return 0;
}





