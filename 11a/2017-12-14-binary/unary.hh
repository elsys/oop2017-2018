#ifndef UNARY_HH_
#define UNARY_HH_

#include "operation.hh"

class UnaryOperation : public Operation {

public:
	UnaryOperation(Calculator& calculator, const std::string& name)
		: Operation(calculator, name) {}
	void eval();
protected:
	virtual double execute(double value) = 0;
};

#endif
