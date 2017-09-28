#include <iostream>
using namespace std;

#define STACK_SIZE 10

class Stack {
	int data_[STACK_SIZE];
	int top_;
public:
	Stack() {
		top_ = 0;
	}
	
	bool empty() {
		return top_ == 0;
	}
	
	bool full() {
		return top_ == STACK_SIZE;
	}
	
	int push(int val) {
		if(full()) {
			cout << "OOOPS!!! Stack is full!" << endl;
			return -1;
		}
		data_[top_++] = val;
		return 0;
	}
	
	int pop(int& val) {
		if(empty()) {
			cout << "OOOPS!!! Stack is empty!" << endl;
			return -1;
		}
		val = data_[--top_];
		return 0;
	}

};


int main() {
	Stack st;
	cout << st.empty() << endl;
	cout << st.full() << endl;
	if(st.push(0) == -1) {
		cout << "error on push..." << endl;
		return -1;
	}
	cout << st.empty() << endl;
	cout << st.full() << endl;
	
	for(int i=1; i<11; ++i) {
		if(st.push(i) == -1) {
			cout << "error on push..." << endl;
			return -2;
		}
	}
	
	while(!st.empty()) {
		int val;
		if(st.pop(val) == -1) {
			cout << "error on pop..." << endl;
			return -3;
		}
		cout << "pop: " << val << endl;
	}
	return 0;
}

