#ifndef UNARY_HH_
#define UNARY_HH_

#include <string>
#include "operation.hh"

class UnaryOperation : public Operation {
protected:
	virtual double eval(double arg) const = 0;
public:
	
	UnaryOperation(Calculator& calculator, std::string name)
		: Operation(calculator, name) {}

	void execute();
};

#endif
