#include "unary.hh"

void UnaryOperation::execute() {
	double value = calculator_.pop();
	calculator_.push(eval(value));
}
