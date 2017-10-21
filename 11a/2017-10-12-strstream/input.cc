#include <iostream>
#include <string>
#include <sstream>

using namespace std;


int main() {

	string token;
	
	while(true) {
		cin >> token;
		if(token == "EXIT" ) {
			break;
		}
		if(!cin.good()) {
			break;
		}
		cout << "TOKEN: <" << token << ">" << endl;
		
		double val;
		istringstream in(token);
		in >> val;
		if(!in.fail() && in.eof()) {
			cout << "SUCCESS: val=" << val << endl;		
		} else {
			cout << "CANT CONVERT TO DOUBLE: <" 
				<< token << ">" << endl;		
		}
		/*
		if(!in.fail()) {
			cout << "SUCCESS: val=" << val << endl;
			if(!in.eof()) {
				string tmp;
				in >> tmp;
				cout << "TAIL FROM STREAM: " << tmp << endl;
			}
		} else {
			cout << "CANT CONVERT TO DOUBLE: <" 
				<< token << ">" << endl;
		}
		*/
	}


	return 0;
}

