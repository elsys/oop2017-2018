#include "binary.hh"

void BinaryOperation::eval() {
	double arg1 = calculator_.pop();
	double arg2 = calculator_.pop();
	calculator_.push(execute(arg1, arg2));
}
