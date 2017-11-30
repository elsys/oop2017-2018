#ifndef POINT_HH_
#define POINT_HH_

#include "shape.hh"

class Point : public Shape {
  double x_, y_;
public:
  Point(double x, double y);
  // concrete instance, this is not an abstract method
  void print() const;
  double get_x() const;
  double get_y() const;
  void set_x(double x);
  void set_y(double y);
};

#endif
