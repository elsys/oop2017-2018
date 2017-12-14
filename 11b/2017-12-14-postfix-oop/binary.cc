#include "binary.hh"

void BinaryOperation::execute() {
	double arg1 = calculator_.pop();
	double arg2 = calculator_.pop();
	calculator_.push(eval(arg1, arg2));
}
