#ifndef COMPOSITE_HH__
#define COMPOSITE_HH__

#include "operation.hh"

#include <string>
#include <list>


class Composite: public Operation {

	std::list<Operation*> children_;

public:
	Composite(Calculator& calculator, const std::string& name);
	
	void add_child(Operation* op);
	
	void eval();


};



#endif

