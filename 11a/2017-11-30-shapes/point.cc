#include "point.hh"


using namespace std;


ostream& operator<<(ostream& out, const Point& p) {
	out << "P(" << p.get_x() << "," << p.get_y() << ")";
	return out;
}
