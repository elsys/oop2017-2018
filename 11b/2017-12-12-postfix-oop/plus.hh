#ifndef PLUS_HH_
#define PLUS_HH_

#include "binary.hh"

class Plus : public BinaryOperation {

public:
	Plus(Calculator& calculator)
		: BinaryOperation(calculator, "+") {}
protected:
	double eval(double arg1, double arg2) const;
};

#endif
