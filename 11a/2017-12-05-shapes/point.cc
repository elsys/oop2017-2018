#include "point.hh"
#include <iostream>

using namespace std;

void Point::draw() const {
	cout << *this << endl;
}

ostream& operator<<(ostream& out , const Point& p){
  out << "P(" << p.get_x() << "," << p.get_y() << ")";
  return out;
}
