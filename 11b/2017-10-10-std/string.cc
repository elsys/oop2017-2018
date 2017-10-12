#include <string>
#include <iostream>
using namespace std;


int main() {
	string s1 = "Hello";
	string s2("world!");
	string s3 = " ";
	
	string s;
	s = s1 + s3 + s2;
	cout << s << endl;

	for(int i=0; i<s.size(); ++i) {
		cout << s[i] << endl;
	}

	for(int i=0; i<s.length(); ++i) {
		cout << s[i] << endl;
	}
	
	cout << s.substr(0, 5) << endl;
	cout << s.substr(6, 5) << endl;


	size_t pos = s.find("wo11");
	if(pos != string::npos) {
		cout << s.substr(pos, 2) << endl;
	} else {
		cout << "wo not found..." << endl;
	}
	return 0;
}

