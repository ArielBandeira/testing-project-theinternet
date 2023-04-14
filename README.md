# Selenium project learning

## Steps

 - [X] Create project with skeleton of folders/files structure
 - [X] Create a repository on github
 - [X] Upload the project to the github repository
 - [ ] Create base package for tests
	 - [X] BaseTest
	 - [X] BrowserFactory
	 - [ ] TestListener
	 - [X] TestUtilities
 - [ ] Use test listeners for ALL tests
 - [ ] Use soft assert for ALL tests
 - [ ] Use logger for ALL tests
 - [ ] Take a screenshot at the end of every test and save on the right folder
	 - Add a test-output/screenshots folder and inside it each screenshot should follow the pattern:
		 - date/testsuitename/testname/methodname
 - [ ] For each test create a positive and negative scenario
 - [ ] Create csv data providers
	 - Store the data providers on: src/test/resources/dataproviders/testname 
 - [ ] Test suites
	 - [ ] Create a test suite for each page
	 - [ ] Create smoke test for positive scenarios
	 - [ ] Create full regression test suite for all tests
 - [ ] Test on firefox
 - [ ] List of tests:
	 - [ ] [Welcome Page](https://the-internet.herokuapp.com)
	 - [ ] [Basic Auth](https://the-internet.herokuapp.com/basic_auth)
	 - [ ] [Dropdown](https://the-internet.herokuapp.com/dropdown)
	 - [ ] [Dynamic Controls](https://the-internet.herokuapp.com/dynamic_controls)
	 - [ ] [Dynamic Loading](https://the-internet.herokuapp.com/dynamic_loading)

## Project diagram

Project should follow this template of organization:

```mermaid
graph
A[src/Main/java] --- Q[src/Main/resources]
A[src/Main/java] ---> B[Base]
A[src/Main/java] ---> C[Pages]
C[Pages] ---> D[BasePage]
D[BasePage] ---> E[WelcomePage]
D[BasePage] ---> F[DropdownPage]
D[BasePage] ---> G[BasicAuthPage]
D[BasePage] ---> H[...]
D[BasePage] ---> I[DynamicControlsPage]
Q[src/Main/resources] ---> R[Files]
B[Base] ---> J[BaseTest]
B[Base] ---> K[TestUtilities]
B[Base] ---> L[...]
B[Base] ---> M[BrowserFactory]
N[src/Test] ---> O[Java]
N[src/Test] ---> P[Resources]
O[Java] ---> T[TestPackages]
T[TestPackages] ---> U[dropdowntests]
T[TestPackages] ---> V[basicauthtests]
T[TestPackages] ---> W[...]
T[TestPackages] ---> X[dynamiccontrolstests]
P[Resources] ---> Y[DataProviders]
P[Resources] ---> Z[TestSuites]