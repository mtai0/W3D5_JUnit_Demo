Assignment 1:
- Make changes to pom.xml so you can run JUnit tests via commandline
	- Search Term: "run junit tests using mvn test command"
	
Extend Calculator
- Calculator
	- Addition
	- Subtraction
	- Multiplication
	- Division
	
	- Use Annotations:
		@Display Name
		@Order
		
		@BeforeEach
		@AfterEach (Optional)
		
Assignment 2:

for addition -- write parameterized tests. (@ParameterizedTest)
	- Ways to do it (pick 1):
		- Separate method to supply input values (@MethodSource)
		- Using CSV source (@CsvSource)
		- Using CSV file (@CsvFileSource)
		
Assignment 3:

for division -- test should throw an exception when dividing by 0 -- ArithmaticException
	- Use assertThrows

- 1 test class for addition
- 1 test class for subtratction and multiplication
- 1 test class for division
Group these together in a Test Suite