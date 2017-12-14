#ifndef PLUS_HH_
#define PLUS_HH_

#include "binary.hh"
#include "calculator.hh"

class Plus : public BinaryOperation {
protected:
	double execute(double arg1, double arg2) const;
public:
	Plus(Calculator& calculator)
		: BinaryOperation(calculator, "+") {}

};

#endif
