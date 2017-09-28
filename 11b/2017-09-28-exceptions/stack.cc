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
	
	bool is_empty() {
		return top_ == 0;
	}
	
	bool is_full() {
		return top_ == STACK_SIZE;
	}

	int push(int val) {
		if(is_full()) {
			cout << "OOOOPS! stack is full" << endl;
			return -1;
		}
		data_[top_++] = val;
		return 0;
	}

	int pop(int& val) {
		if(is_empty()) {
			cout << "OOPS!! stack is empty" << endl;
			return -1;
		}
		val = data_[--top_];
		return 0;
	}

};


int main() {
	Stack st;
	cout << st.is_empty() << endl;
	cout << st.is_full() << endl;
	
	if(st.push(0) == -1) {
		cout << "error on push..." << endl;
		return -1;
	}
	cout << st.is_empty() << endl;
	cout << st.is_full() << endl;

	for(int i=1;i<=STACK_SIZE; ++i) {
		if(st.push(i) == -1) {
			cout << "error on push 2..." << endl;
			return -2;
		}
	}
	cout << st.is_empty() << endl;
	cout << st.is_full() << endl;
	
	while(!st.is_empty()) {
		int val;
		if(st.pop(val) == -1) {
			cout << "error on pop..." << endl;
			return -3;
		}
		cout << "pop: " << val << endl;
	}
	
	return 0;
}

