#include <iostream>

using namespace std;

class Point {
    double x_, y_;
    const double cx_, cy_;
    
    public:
    
    static const double DEFAULT_CX_ = 0, DEFAULT_CY_ = 0;

    static Point get_default_beginning() {
        return Point(DEFAULT_CX_, DEFAULT_CY_);
    }

    Point(double x, double y, double cx, double cy)
            : x_(x), y_(y), cx_(cx), cy_(cy) {}
    
    Point(double x, double y)
            : x_(x), y_(y), cx_(DEFAULT_CX_), cy_(DEFAULT_CY_) {}
    
    Point transform_in_default() const {
        return transform_in(DEFAULT_CX_, DEFAULT_CY_);
    }
    
    Point transform_in(double new_cx, double new_cy) const {
        return Point(x_ + cx_ - new_cx, y_ + cy_ - new_cy, new_cx, new_cy);
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
        cout << "(" << x_ << "," << y_ << ") in ("
             << cx_ << "," << cy_ << ")" << endl;
    }
};

Point add(const Point* p1, const Point* p2) {
    // also possible: (*p1).tranform_in_default()
    Point p1_default = p1->transform_in_default();
    Point p2_default = p2->transform_in_default();
    return Point(p1_default.get_x() + p2_default.get_x(), p1_default.get_y() + p2_default.get_y());
}

int main() {
    Point p1(1, 1), p2(5, 15);
    p1.set_y(11);
    p1.print();
    
    const Point p3 = add(&p1, &p2);
    p3.print();
    
    // won't compile; non-constant reference to constant object
    // Point& p3ref = p3;
    const Point& p3ref = p3;
    p3ref.print();
    
    const Point& p2ref = p2;
    p2ref.print();
    // const reference; can't call non-constant methods
    // p2ref.set_y(11);
    
    Point* const p2ptr = &p2;
    p2ptr->set_y(14);
    p2ptr->print();
    
    p1.transform_in(11, 42)
        .set_x(21)
        .set_y(41)
        .print();
}













