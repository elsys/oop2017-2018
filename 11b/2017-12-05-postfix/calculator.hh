#ifndef CALCULATOR_HH_
#define CALCULATOR_HH_

#include <vector>
#include <string>

class CalculatorError {
	std::string message_;
public:
	CalculatorError(std::string message)
		: message_(message) {}
	
	std::string get_message() const {
		return message_;
	}
};

class Calculator {
	std::vector<double> values_;
	void neg();
	void dup();
	void assure_size(int count);
public:
	void run();
};

#endif
