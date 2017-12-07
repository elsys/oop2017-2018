#include "calculator.hh"
#include "negate.hh"


int main() {
	Calculator calc;
	calc.add_operation(new Negate(calc, "neg"));
	calc.run();
}
