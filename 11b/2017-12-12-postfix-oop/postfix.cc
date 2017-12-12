#include "calculator.hh"
#include "negate.hh"
#include "power.hh"
#include "plus.hh"

int main() {
	Calculator calc;
	calc.add_operation(new Negate(calc));
	calc.add_operation(new Power(calc));
	calc.add_operation(new Plus(calc));
	calc.run();
}
