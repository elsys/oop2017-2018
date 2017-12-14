#ifndef COMPOSITE_OPERATION_HH_
#define COMPOSITE_OPERATION_HH_

#include <string>
#include <vector>
#include "operation.hh"

class CompositeOperation : public Operation {
  std::vector<Operation*> operations_;
public:
	CompositeOperation(Calculator& calculator, std::string name)
		: Operation(calculator, name) {}

	void execute();
  void add_operation(Operation* operation);
};

#endif

#ifndef LITERAL_HH_
#define LITERAL_HH_

#include <string>
#include <vector>
#include "operation.hh"

class Literal : public Operation {
  double val_;
public:
	Literal(Calculator& calculator, double val)
		: Operation(calculator, "literal"), val_(val) {}

	void execute();
};

#endif
