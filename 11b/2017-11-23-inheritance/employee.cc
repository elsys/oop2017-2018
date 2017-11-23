#include <iostream>
#include <string>
#include <list>

using namespace std;

class Employee {

  string name_;
  long id_;
  
public:

  Employee(string name, long id) : name_(name), id_(id) {}
  
  string get_name() const {
    return name_;
  }
  
  long get_id() const {
    return id_;
  }
  
  virtual void print() const {
    cout << "Employee " << get_id() << ": "
         << get_name() << endl;
  }
};

class Manager : public Employee {
  int level_;
  
public:

  Manager(string name, long id, int level)
      : Employee(name, id), level_(level) {}
  
  int get_level() const {
    return level_;
  }
  
  virtual void print() const {
    cout << "Manager " << get_id() << ", level " << get_level() << ": "
         << get_name() << endl;
  }
};

int main() {

  list<Employee*> employees;

  employees.push_back(new Employee("Emil", 1));
  employees.push_back(new Employee("Vladimir", 2));
  Manager* m = new Manager("Lubo", 0, 1);
  employees.push_back(new Manager("Lubo", 0, 1));
  for (list<Employee*>::iterator it = employees.begin();
      it != employees.end(); it++) {
    (*it)->print();
  }
  //m->print();
  
  // won't compile
  //Manager* m1 = new Employee("Ivan", 3);
  
  // 
  cout << "Pointer vs instance" << endl;
  Employee* e1 = m;
  Employee e2 = *m;
  e1->print();
  e2.print();
}




















