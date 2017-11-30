#include <iostream>
#include "point.hh"
#include "circle.hh"

int main() {
  Point p1(10, 15);
  p1.print();
  
  Circle c(Point(0, 0), 5);
  c.print();
  return 0;
}
