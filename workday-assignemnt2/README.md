README- Workday Assignment

The Map based implementation takes care of the integer values , by entering them into a map
associating an id to them
It is implemented via a HashMap and TreeMap  by changing which class object is called in the
Interface
Details of implementation have been included in the classes.

It has a main class , which has the main method, to run tests with random data
I have used a generic random number generator, to pass random numbers from 0-32k
and return the searches the ids, for 100k ranges (eg. 1)
It runs the load test to check for bulk random data.

Steps to Run:

Run the main method to load test it with random data,
Printing the ids for the sample values ( 10,12,17,21,2,15,16) in the range 14-17
, not for the random range

To run the main method with maven  :
#mvn package
#cd workday-assignemnt2/workday/target/
# java -jar workday-1.0-SNAPSHOT.jar
    2
    5
    6
The reason it takes a while to print data is cause it is running a loadTest , with random data
in the range 0-32k ,

Test case suite is in the test directory, It includes the sample test as well as other tests
To run the Unit test cases, test for more volume of data has been included in the main class
you can run a "mvn test", to see the results.







