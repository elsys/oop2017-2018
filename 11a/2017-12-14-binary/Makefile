all: postfix

calculator.o: calculator.cc

unary.o: unary.cc

negate.o: negate.cc

power.o: power.cc

binary.o: binary.cc

plus.o: plus.cc

postfix.o: postfix.cc

postfix: calculator.o postfix.o negate.o power.o unary.o binary.o plus.o
	g++ -o postfix calculator.o postfix.o negate.o power.o unary.o binary.o plus.o

clean:
	rm -fr *.o postfix
