#include <iostream>
#include "calculator.hh"
#include "negate.hh"
#include "power.hh"

using namespace std;

int main() {
	Calculator calculator;
	calculator.add_operation(new Negate(calculator));
	calculator.add_operation(new Power(calculator));
	calculator.run(cin, cout);
}
