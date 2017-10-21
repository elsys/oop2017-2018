#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {
	string s1 = "3.14 42";
	istringstream in(s1);

	double pi;
	in >> pi;

	cout << "pi=" << pi << endl;
	if (in.good()) {
		cout << "in is good!" << endl;
	} else {
		cout << "in is NOT good!" << endl;
	}
	
	int answer;
	in >> answer;
	cout << "the answer is " << answer << endl;
	if (in.good()) {
		cout << "in is good!" << endl;
	} else {
		cout << "in is NOT good!" << endl;
	}
	
	if(in.eof()) {
		cout << "in is EOF" << endl;
	}
	
	if(!in.fail()) {
		cout << "success!" << endl;
	}
	
	
	return 0;
}

