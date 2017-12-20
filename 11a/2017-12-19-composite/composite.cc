#include "composite.hh"

#include <list>
#include <string>
using namespace std;

Composite::Composite(Calculator& calc, const string& name)
: Operation(calc, name)
{}

void Composite::add_child(Operation* op) {
	children_.push_back(op);
}


void Composite::eval() {
	for(list<Operation*>::iterator it=children_.begin();
		it!=children_.end(); ++it) {
		
		(*it) -> eval();	
	}
}
