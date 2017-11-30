#include <iostream>
#include "point.hh"

Point::Point(double x, double y)
    : x_(x), y_(y)
  {}

void Point::print() const {
  std::cout << "(" << x_ << ", "
                   << y_ << ")"
                   << std::endl;
}

double Point::get_x() const {
  return x_;
}

double Point::get_y() const {
  return y_;
}

void Point::set_x(double x) {
  x_ = x;
}

void Point::set_y(double y) {
  y_ = y;
}

