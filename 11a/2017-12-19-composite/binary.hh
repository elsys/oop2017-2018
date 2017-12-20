#ifndef BINARY_HH_
#define BINARY_HH_

#include <string>
#include "operation.hh"
#include "calculator.hh"

class BinaryOperation : public Operation {
protected:
	virtual	double execute(double arg1, double arg2) const = 0;
public:

	BinaryOperation(Calculator& calculator, const std::string& name) : Operation(calculator, name) {}

	void eval();
};

#endif
