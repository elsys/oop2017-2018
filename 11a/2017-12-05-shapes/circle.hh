#ifndef CIRCLE_HH_
#define CIRCLE_HH_

#include "point.hh"
#include "shape.hh"

class Circle: public Shape {
  Point center_;
  double radius_;

public:
  Circle(const Point& center, double radius);
  void draw()const;
};

#endif
