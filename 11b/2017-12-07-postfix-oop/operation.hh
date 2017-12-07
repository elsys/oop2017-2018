#ifndef OPERATION_HH_
#define OPERATION_HH_

#include <string>

#include "calculator.hh"

class Calculator;

class Operation {
	std::string name_;

protected:

	Calculator& calculator_;

public:

	Operation(Calculator& calculator, std::string name)
		: calculator_(calculator), name_(name) {}

	std::string get_name() const {
		return name_;
	}
	
	virtual void execute() const = 0;

};

#endif
