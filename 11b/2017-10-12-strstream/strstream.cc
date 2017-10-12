#include <iostream>
#include <sstream>

using namespace std;

int main() {
    string input;
    while (true) {
        cout << "> ";
        getline(cin, input);
        if (input == "q") {
            cout << "goodbye!" << endl;
            break;
        }
        istringstream in(input);
        double value;
        in >> value;
        if (!in.fail() && in.eof()) {
            cout << input << " is a number" << endl;
        } else {
            cout << input << " is not a number" << endl;
        }
    }
    return 0;
}

//double d1;
//while (true) {
//    cin >> d1;
//    if (cin.good()) {
//        cout << d1 << " is a number" << endl;
//    } else {
//        cout << "not a number" << endl;
//       cin.clear();
//    }
//}
