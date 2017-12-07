#include <iostream>
#include "point.hh"
#include "circle.hh"

using namespace std;

int main(){
  Point p1, p2;

  cout << p1 << endl << p2 << endl;

  Circle c1(p1,3);
  c1.draw();
  return 0;
}
 
