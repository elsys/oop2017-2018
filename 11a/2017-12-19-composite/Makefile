all: postfix

calculator.o: calculator.cc calculator.hh

composite.o: composite.cc composite.hh operation.hh

literal.o: literal.cc literal.hh operation.hh calculator.hh

unary.o: unary.cc

negate.o: negate.cc

power.o: power.cc

binary.o: binary.cc

plus.o: plus.cc

postfix.o: postfix.cc

postfix: calculator.o postfix.o negate.o power.o unary.o binary.o plus.o composite.o literal.o
	g++ -o postfix calculator.o postfix.o negate.o power.o unary.o binary.o plus.o composite.o literal.o


clean:
	rm -fr *.o postfix
