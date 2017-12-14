#include "composite_operation.hh"

void CompositeOperation::execute() {
  for(std::vector<Operation*>::const_iterator it = operations_.begin(); it != operations_.end(); it++) {
    (*it)->execute();
  }
}

void CompositeOperation::add_operation(Operation* operation) {
  operations_.push_back(operation);
}

void Literal::execute() {
  calculator_.push(val_);
}

http://192.168.31.173/
