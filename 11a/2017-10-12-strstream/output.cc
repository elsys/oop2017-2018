#include<iostream>
#include<string>
#include<sstream>

using namespace std;


int main() {

	ostringstream out;
	out << 3.14 << " " << 42 << "hello" << " " << "world!" <<"!";
	
	string s = out.str();
	
	cout << "s=<" << s << ">" << endl;

	return 0;
}
