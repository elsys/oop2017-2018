#ifndef NEGATE_HH_
#define NEGATE_HH_

#include "unary.hh"

class Negate : public UnaryOperation {

public:
	
	Negate(Calculator& calculator)
		: UnaryOperation(calculator, "neg") {}

protected:

	double eval(double arg) const;
};

#endif
