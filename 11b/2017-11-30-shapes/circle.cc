#include <iostream>
#include "circle.hh"
#include "point.hh"

Circle::Circle(Point center, double radius)
    : center_(center), radius_(radius) {}

void Circle::print() const {
  std::cout << "O (r=" << radius_ << ", c="
            << center_.get_x() << ","
            << center_.get_y() << ")"
            << std::endl;
}

double Circle::get_radius() const {
  return radius_;
}

Point Circle::get_center() const {
  return center_;
}

void Circle::set_radius(double radius) {
  radius_ = radius;
}

void Circle::set_center(Point center) {
  center_ = center;
}
