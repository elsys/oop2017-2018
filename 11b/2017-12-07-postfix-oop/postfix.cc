#include "calculator.hh"
#include "negate.hh"

class Power : public Evalualte {

public:
  
  Power(Calculator& calculator, std::string name)
    : Operation(calculator, name) {} 

  void eval(int value) const {
    return value*value
  }
};

class Evaluate : public Operation {

  virtual void eval(int val) const = 0;
  
  void execute() const {
    double value = calculator_.pop();
    calculator_.push(eval(value));
  }
}

int main() {
	Calculator calc;
	calc.add_operation(new Negate(calc, "neg"));
  calc.add_operation(new Power(calc, "pow"));
	calc.run();
}

