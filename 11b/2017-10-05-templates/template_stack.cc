#include <iostream>
#define STACK_CAPACITY__ 100

using namespace std;

class StackException {};

template<class T> //template<typename T>
class Stack {
    int size_;
    T data_[STACK_CAPACITY__];
    
    public:
    
    Stack() : size_(0) {}
    
    bool empty() {
        return size_ == 0;
    }
    
    void push(T value) {
        if (size_ == STACK_CAPACITY__) {
            throw StackException();
        }
        data_[size_++] = value;
    }

    T pop() {
        if (empty()) {
            throw StackException();
        }
        return data_[--size_];
    }
};

template<typename T, typename E>
T add(T number1, E number2) {
    return number1 + number2;
}

int main() {
    Stack<double> st;
    st.push(10.5);
    cout << st.pop() << endl;
    
    cout << add(10.5, 11) << endl; // prints 21.5 because T is double
    cout << add(11, 10.5) << endl; // prints 21 because T is int and the result is casted to int
    return 0;
}






