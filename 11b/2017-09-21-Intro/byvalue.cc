#include <iostream>
using namespace std;

void fun(int& val) {

	cout << "input val=" << val << endl;
	val = 42;
	cout << "output val=" << val << endl;
}

int main() {
	int b=13;
	
	fun(b);
	cout << "b=" << b << endl;

	return 0;
}

