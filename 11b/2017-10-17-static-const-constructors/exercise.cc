#include <iostream>

using namespace std;

class Point {
    double x_, y_;
    const double cx_, cy_;
    
    public:
    
    static const double DEFAULT_CX_ = 0, DEFAULT_CY_ = 0;

    static Point get_default_beginning() {
        // won't compile:
        // cout << x_;
        // cout << cx_;
        return Point(DEFAULT_CX_, DEFAULT_CY_);
    }

    Point(double x, double y, double cx, double cy)
            : x_(x), y_(y), cx_(cx), cy_(cy) {}
    
    Point(double x, double y)
            : x_(x), y_(y), cx_(DEFAULT_CX_), cy_(DEFAULT_CY_) {}
    
    Point transform_in_default() {
        return transform_in(DEFAULT_CX_, DEFAULT_CY_);
    }
    
    Point transform_in(double new_cx, double new_cy) {
        return Point(x_ + cx_ - new_cx, y_ + cy_ - new_cy, new_cx, new_cy);
    }
    
    double get_x() {
        return x_;
    }
    
    void set_x(double x) {
        x_ = x;
    }
    
    double get_y() {
        return y_;
    }
    
    void set_y(double y) {
        y_ = y;
    }
    
    double get_cx() {
        return cx_;
    }
    
    double get_cy() {
        return cy_;
    }
    
    void print() {
        cout << "(" << x_ << "," << y_ << ") in ("
             << cx_ << "," << cy_ << ")" << endl;
    }
};


int main() {
    Point p1(10, 15), p2(3, 3, 7, 11), p3(1, 1);
    p1.print();
    p2.print();
    cout << "in default: ";
    p2.transform_in_default().print();
    cout << "in (-1, -1): ";
    p2.transform_in(-1, -1).print();
    
    cout << "default coords: (" << Point::DEFAULT_CX_ << "," << Point::DEFAULT_CY_ << ")" << endl;
    Point::get_default_beginning().print();
    // calls the same function
    p2.get_default_beginning().print();
    return 0;
}







