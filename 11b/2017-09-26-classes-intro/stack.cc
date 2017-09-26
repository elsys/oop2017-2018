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

	void push(int val) {
		if(is_full()) {
			cout << "OOOOPS! stack is full" << endl;
			return;
		}
		data_[top_++] = val;
	}

	int pop() {
		if(is_empty()) {
			cout << "OOPS!! stack is empty" << endl;
			return -1;
		}
		return data_[--top_];
	}

};


int main() {
	Stack st;
	cout << st.is_empty() << endl;
	cout << st.is_full() << endl;
	
	st.push(0);
	cout << st.is_empty() << endl;
	cout << st.is_full() << endl;

	for(int i=1;i<=STACK_SIZE; ++i) {
		st.push(i);
	}
	cout << st.is_empty() << endl;
	cout << st.is_full() << endl;
	
	while(!st.is_empty()) {
		cout << "pop: " << st.pop() << endl;
	}
	
	return 0;
}

