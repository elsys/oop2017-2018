#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include "calculator.hh"
#include "operation.hh"
#include "composite_operation.hh"

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
      } else if (token[0] == '\\') {
        // \\myAdd -> myAdd
        define_new_operation(token.substr(1));
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

void Calculator::define_new_operation(string operation_name) {
  CompositeOperation* composite = new CompositeOperation(*this, operation_name);
  string input;

  while(true) {
    getline(cin, input);

    if (input == "def") { break; }

    double value;
    istringstream iss(input);

    if( iss >> value ) {
      composite->add_operation(new Literal(*this, value));
    } else {
      try {
        Operation* operation = find_operation(input);
        composite->add_operation(operation);
      } catch (Calculator err) {
        delete composite;
        throw err;
      }
    }
  }
  add_operation(composite);
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




