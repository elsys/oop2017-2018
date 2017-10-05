#include <iostream>

using namespace std;

class StackError {};

#define STACK_SIZE 10

template<typename T> class Stack {
	T data_[STACK_SIZE];
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
	
	void push(T val) {
		if(full()) {
			throw StackError();
		}
		data_[top_++] = val;
	}
	
	T pop() {
		if(empty()) {
			throw StackError();
		}
		return data_[--top_];
	}
};

/*
template<typename T> int foo(T t) {

}
*/

int main() {
	Stack<int> st;
	Stack<double> dst;
	
	Stack<Stack<int> > st_of_st;

	for(int i=0;i<STACK_SIZE; ++i) {
		st.push(i*10);
		dst.push(i*3.14);
	}
	
	while(!st.empty()) {
		cout << st.pop() << "\t" << dst.pop() << endl;
	}
	return 0;
}

