#include <iostream>
#include <sstream>
#include <string>
#include "calculator.hh"

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
				values_.push_back(value);
			} else {
				if (token == "neg") {
					neg();
				} else if (token == "dup") {
					dup();
				} else {
					throw CalculatorError("Unknown operation");
				}
				cout << values_.back() << endl;
			}
		} catch (CalculatorError err) {
			cout << err.get_message() << endl;
		}
	}
}

void Calculator::neg() {
	assure_size(1);
	double top_value = values_.back();
	values_.pop_back();
	values_.push_back(-top_value);
}

void Calculator::dup() {
	assure_size(1);
	double top_value = values_.back();
	values_.push_back(top_value);
}

void Calculator::assure_size(int count) {
	if (values_.size() < count) {
		throw CalculatorError("Not enough values in stack");
	}
}






