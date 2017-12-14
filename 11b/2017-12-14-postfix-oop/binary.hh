#ifndef BINARY_HH_
#define BINARY_HH_

#include <string>
#include "operation.hh"

class BinaryOperation : public Operation {
protected:
	virtual double eval(double arg1, double arg2) const = 0;
public:
	BinaryOperation(Calculator& calculator, std::string name)
		: Operation(calculator, name) {}

	void execute();
};

#endif
