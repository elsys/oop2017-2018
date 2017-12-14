#include "unary.hh"

void UnaryOperation::eval() {
	double value = calculator_.pop();
	calculator_.push(execute(value));
}
