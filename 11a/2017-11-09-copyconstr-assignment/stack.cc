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

  ~Stack() {
    cout << "destructing" << endl;
    delete [] data_;
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


int main(void) {
  Stack st;
  
  for (int i = 0; i < 10; i++) {
    st.push(i * 47);
  }
  
  while(!st.empty()) {
  	cout << st.pop() << endl;
  }
  return 0;
}






