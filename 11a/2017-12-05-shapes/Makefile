all: main

point.o: point.cc

circle.o: circle.cc

main.o: main.cc

main: point.o circle.o main.o
	g++ -o shapes point.o circle.o main.o

clean:
	rm -f *.o shapes
