#include <iostream>

using namespace std;

int gcd(int number1, int number2) {
    int dividor = number1 < number2 ? number1 : number2;
    while (number1 % dividor != 0 || number2 % dividor != 0) {
        dividor--;
    }
    
    return dividor;
}

class rational {
    int numerator_;
    int denominator_;

    public:
    
    rational(int numerator, int denominator) {
        int dividor = gcd(numerator, denominator);
        numerator_ = numerator / dividor;
        denominator_ = denominator / dividor;
    }

    int get_numerator() {
        return numerator_;
    }
    
    int get_denominator() {
        return denominator_;
    }
    
    void print() {
        cout << numerator_ << "/" << denominator_ << endl;
    }
    
    bool is_equal_to(rational other) {
        return numerator_ == other.numerator_ && denominator_ == other.denominator_;
    }
};

int main() {
    rational r1(2, 3), r2(4, 10), r3(2, 5);
    r1.print(); // 2/3
    r2.print();
    if (r3.is_equal_to(r2)) {
        cout << "True";
    } else {
        cout << "False";
    }
    cout << endl;
    return 0;
}


