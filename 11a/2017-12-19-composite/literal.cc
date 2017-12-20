#include "literal.hh"
#include "calculator.hh"


Literal::Literal(Calculator& calc, double val)
: Operation(calc, "#LITERAL#"), val_(val)
{}

void Literal::eval() {
	calculator_.push(val_);
}
