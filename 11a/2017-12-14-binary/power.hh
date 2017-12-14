#ifndef POWER_HH_
#define POWER_HH_

#include "unary.hh"

class Power : public UnaryOperation {
public:
	Power(Calculator& calculator)
		: UnaryOperation(calculator, "**") {}
	
	double execute(double value);
};

#endif
