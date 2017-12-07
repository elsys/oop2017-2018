all: postfix

calculator.o: calculator.cc

postfix.o: postfix.cc

postfix: calculator.o postfix.o
	g++ -o postfix calculator.o postfix.o

clean:
	rm -fr *.o postfix
