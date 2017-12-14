all: postfix

unary.o: unary.cc

negate.o: negate.cc

power.o: power.cc

binary.o: binary.cc

plus.o: plus.cc

calculator.o: calculator.cc

postfix.o: postfix.cc

composite_operation.o: composite_operation.cc

postfix: calculator.o postfix.o unary.o negate.o power.o binary.o plus.o composite_operation.o
	g++ -o postfix calculator.o postfix.o unary.o negate.o power.o binary.o plus.o composite_operation.o

clean:
	rm -fr *.o postfix
