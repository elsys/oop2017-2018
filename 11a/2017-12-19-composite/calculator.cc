#include "operation.hh"
#include "calculator.hh"
#include "composite.hh"
#include "literal.hh"

#include <string>
#include <vector>
#include <sstream>

using namespace std;


Calculator::Calculator() {
}

void Calculator::add_operation(Operation* op) {
	Operation* check = get_operation(op->get_name());
	if(check!=0) {
		cout << "operation " << op->get_name() 
			<< " already added..." << endl;
	} else {
	
		operations_.push_back(op);
	}
}

Operation* Calculator::get_operation(const string& name) {
	for(vector<Operation*>::iterator it = operations_.begin();
		it!=operations_.end(); ++it) {
	
		if(name == (*it)->get_name()) {
			return *it;
		}	
	}
	return 0;
}


bool Calculator::empty() const {
	return stack_.empty();
}

int Calculator::size() const {
	return stack_.size();
}

void Calculator::push(double val) {
	stack_.push_back(val);
}

double Calculator::pop() {
	if(stack_.empty()) {
		throw CalculatorError();
	}
	double val = stack_.back();
	stack_.pop_back();
	return val;
}

void Calculator::add_macro(const string& word, istream& in) {
	
	// token: \x2
	string name = word.substr(1);
	Composite* macro = new Composite(*this, name);
	
	string token;

	while(1) {
	
		// read tokens 
		in >> token;
		if(! in.good()) {
			throw CalculatorError();
		}
		if(token == "def") {
			break;
		}
		Operation* op = get_operation(token);
		if(op!=0) {
			macro -> add_child(op);
		} else {
			istringstream istr(token);
			double val = 0;
			istr >> val;
			if(!istr.fail()) { // Fixme!!!
				// number in macros???
				macro->add_child(new Literal(*this, val));
			} else {
				throw CalculatorError();
			}
		}
	}
	
	add_operation(macro);
	cout << "MACRO: " << word << " ADDED..." << endl;
}

void Calculator::run(istream& in, ostream& out) {
	string token;
	
	while(true) {
		out << "(" << size() << "): ";
		in >> token;
		if(! in.good()) {
			break;
		}

		if(token[0] == '\\') {
			// handle macro definition
			add_macro(token, in);
		} else {
	
			Operation* op = get_operation(token);
			if(op!=0) {
				op->eval();
				out << stack_.back() << endl;
			} else {
				istringstream istr(token);
				double val = 0;
				istr >> val;
				if(!istr.fail()) { // Fixme!!!
					push(val);
				} else {
					cerr << "UNKNOWN TOKEN " << token << endl;
				}
			}
		}		
	}


}
