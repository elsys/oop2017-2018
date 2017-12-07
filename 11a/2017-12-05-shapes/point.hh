#ifndef POINT_HH_
#define POINT_HH_

#include <iostream>
#include "shape.hh"

class Point : public Shape {
  double x_, y_;
public:
  Point(double x=0.0, double y=0.0)
  :x_(x),y_(y)
  {}
  // concrete instance, this is not an abstract method
  double get_x() const{
    return x_;
  }
  double get_y() const{
    return y_;
  }
  void draw() const;
};
std::ostream& operator << (std::ostream& out, const Point& p);

#endif
