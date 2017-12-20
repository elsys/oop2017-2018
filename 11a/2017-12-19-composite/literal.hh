#ifndef LITERAL_HH__
#define LITERAL_HH__

#include "operation.hh"


class Literal: public Operation {
	double val_;
public:
	Literal(Calculator& calc, double val);
	void eval();
};

#endif
