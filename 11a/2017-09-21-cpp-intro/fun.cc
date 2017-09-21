#include <iostream>
using namespace std;

void fun(int& val) {
	cout << "val=" << val << endl;
	val = 42;
	cout << "val new value=" << val << endl;
}

int main() {
	int a = -1;
	fun(a);
	cout << "a=" << a << endl;
	return 0;
}

