all: shapes

point.o: point.cc point.hh

circle.o: circle.cc circle.hh point.hh

shapes.o: shapes.cc point.hh

shapes: point.o circle.o shapes.o
	g++ -o shapes point.o circle.o shapes.o

clean:
	rm -f *.o shapes

