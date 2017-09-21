#include <iostream>

using namespace std;

int main() {
	char ch;
	while(true) {
		cin.get(ch);
		if(!cin.good()) {
			cerr << "Something went wrong!!" << endl;
			break;
		}
		cout << ch;
	}	
	
    return 0;
}

