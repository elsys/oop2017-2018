#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include "calculator.hh"
#include "operation.hh"

using namespace std;

void Calculator::run() {
	string token;
	while (true) {
		try {
			cout << "(" << values_.size() << "): ";
			getline(cin, token);
		
			istringstream iss(token);
			double value;
		
			if (iss >> value) {
				push(value);
			} else {
				Operation* operation = find_operation(token);
				operation -> execute();
				cout << values_.back() << endl;
			}
		} catch (CalculatorError err) {
			cout << err.get_message() << endl;
		}
	}
}

Operation* Calculator::find_operation(string name) {
	for (vector<Operation*>::iterator it = operations_.begin(); it != operations_.end(); ++it) {
		if ((*it) -> get_name() == name) {
			return *it;
		}
	}
	throw CalculatorError("Unknown operation");
}

void Calculator::add_operation(Operation* operation) {
	operations_.push_back(operation);
}

double Calculator::pop() {
	if (values_.size() == 0) {
		throw CalculatorError("Not enough values in stack");
	}
	double top_value = values_.back();
	values_.pop_back();
	return top_value;
}

void Calculator::push(double value) {
	values_.push_back(value);
}




