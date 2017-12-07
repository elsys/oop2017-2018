#include "point.hh"
#include "circle.hh"
#include <iostream>

using namespace std;

Circle::Circle(const Point& center, double radius)
: center_(center),
  radius_(radius)
{}

void Circle::draw() const{
  cout << "C(" << center_ << "," << radius_ << ")" << endl;
}
