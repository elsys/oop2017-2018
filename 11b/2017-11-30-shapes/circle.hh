#ifndef CIRCLE_HH_
#define CIRCLE_HH_

#include "shape.hh"
#include "point.hh"

class Circle : public Shape {
  Point center_;
  double radius_;
public:
  Circle(Point center, double radius);
  void print() const;
  double get_radius() const;
  Point get_center() const;
  void set_radius(double radius);
  void set_center(Point center);
};

#endif
