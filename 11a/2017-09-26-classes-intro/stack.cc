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
	
	void push(int val) {
		if(full()) {
			cout << "OOOPS!!! Stack is full!" << endl;
			return;
		}
		data_[top_++] = val;
	}
	
	int pop() {
		if(empty()) {
			cout << "OOOPS!!! Stack is empty!" << endl;
			return -1;
		}
		return data_[--top_];
	}

};


int main() {
	Stack st;
	cout << st.empty() << endl;
	cout << st.full() << endl;
	st.push(0);
	cout << st.empty() << endl;
	cout << st.full() << endl;
	
	for(int i=1; i<11; ++i) {
		st.push(i);
	}
	
	while(!st.empty()) {
		cout << "pop: " << st.pop() << endl;
	}
	return 0;
}

