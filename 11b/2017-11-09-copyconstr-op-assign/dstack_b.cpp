#include <cstdlib>
#include <iostream>

using namespace std;

class Stack {

  const static int chunk_ = 2;
  int *data_;
  int size_;
  int top_;

  public:

  Stack() : top_(-1), size_(chunk_), data_(new int[chunk_]) {}

  Stack(const Stack& other)
      : top_(other.top_), size_ (other.size_), data_(new int[other.size_]) {
    cout << "copying" << endl;
    for (int i = 0; i < size_; i++) {
      data_[i] = other.data_[i];
    }
  }

  ~Stack() {
    cout << "destructing" << endl;
    delete [] data_;
  }
  
  Stack& operator=(const Stack& other) {
    cout << "assigning" << endl;
    if (this != &other) {
      size_ = other.size_;
      top_ = other.top_;
      delete [] data_;
      data_ = new int[size_];
      for (int i = 0; i < size_; i++) {
        data_[i] = other.data_[i];
      }
    }
    return *this;
  }

  int length() const {
    return top_ + 1;
  }

  bool empty() const {
    return top_ == -1;
  }

  void push(int v) {
    if (top_ == (size_ - 1)) {
      resize();
    }
    data_[++top_] = v;
  }

  int pop(void) {
    if ( top_ < 0 ) {
      throw exception();
    }
    return data_[top_--];
  }

  private:

  void resize() {
    cout << "resizing" << endl;
    int* tmp = data_;
    data_ = new int[size_ + chunk_];
    for( int i = 0; i < size_; i++ ) {
      data_[i] = tmp[i];
    }
    size_ += chunk_;
    delete [] tmp;
  }
};

double average(Stack stack) {
  int count = stack.length();
  int sum = 0;
  while (!stack.empty()) {
    sum += stack.pop();
  }
  return ((double) sum) / count;
}

int main(void) {
  Stack st;
  
  for (int i = 0; i < 10; i++) {
    st.push(i * 47);
  }
  cout << "Added 10 values" << endl;
  cout << "Average: " << average(st) << endl;
  
  try {
    Stack st2;
    st2 = st;
    st2.push(1000);
    cout << st.pop () << endl ;
    cout << st.pop () << endl ;
    cout << st.pop () << endl ;
  } catch ( const exception & e ) {
    cout << " exception () ␣ catched ␣ in ␣ pop ... " << endl ;
  }
  return 0;
}






