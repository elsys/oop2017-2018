all: postfix

calculator.o: calculator.cc

unary.o: unary.cc

negate.o: negate.cc

power.o: power.cc

postfix.o: postfix.cc

postfix: calculator.o postfix.o negate.o power.o unary.o
	g++ -o postfix calculator.o postfix.o negate.o power.o unary.o

clean:
	rm -fr *.o postfix
