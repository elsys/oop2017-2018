#ifndef CALCULATOR_HH__
#define CALCULATOR_HH__


#include <vector>
#include <string>
#include <iostream>

class Operation;

class CalculatorError {};

class Calculator {
	std::vector<Operation*> operations_;
	std::vector<double> stack_;
	
	void add_macro(const std::string& token,
				std::istream& in);
	
public:
	Calculator();

	void add_operation(Operation* op);
	Operation* get_operation(const std::string& name);
	
	void push(double val);
	int size() const;
	bool empty() const;
	double pop();
	
	void run(std::istream& in, std::ostream& out);

};


#endif
