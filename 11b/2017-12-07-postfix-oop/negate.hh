#ifndef NEGATE_HH_
#define NEGATE_HH_

#include <string>
#include "operation.hh"

class Negate : public Operation {

public:
	
	Negate(Calculator& calculator, std::string name)
		: Operation(calculator, name) {}

	void execute() const {
		double value = calculator_.pop();
		calculator_.push(-value);
	}
};

#endif
