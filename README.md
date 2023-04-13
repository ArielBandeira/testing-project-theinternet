# Selenium project learning

## Steps

 - [ ] Create project with skeleton of folders/files structure
 - [ ] Create a repository on github
 - [ ] Upload the project to the github repository
 - [ ] Create base package for tests
	 - [ ] BaseTest
	 - [ ] BrowserFactory
	 - [ ] TestListener
	 - [ ] TestUtilities
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
 - [ ] Test on firefox and edge
 - [ ] List of tests:
	 - [ ] [Welcome Page](https://the-internet.herokuapp.com)
	 - [ ] [Digest Authentication](https://the-internet.herokuapp.com/digest_auth)
	 - [ ] [Dropdown](https://the-internet.herokuapp.com/dropdown)
	 - [ ] [Dynamic Controls](https://the-internet.herokuapp.com/dynamic_controls)
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
D[BasePage] ---> G[LoginPage]
D[BasePage] ---> H[...]
D[BasePage] ---> I[CheckboxesPage]
Q[src/Main/resources] ---> R[Files]
Q[src/Main/resources] ---> S[Profiles]
B[Base] ---> J[BaseTest]
B[Base] ---> K[TestUtilities]
B[Base] ---> L[...]
B[Base] ---> M[BrowserDriverFactory]
N[src/Test] ---> O[Java]
N[src/Test] ---> P[Resources]
O[Java] ---> T[TestPackages]
T[TestPackages] ---> U[dropdowntests]
T[TestPackages] ---> V[logintests]
T[TestPackages] ---> W[...]
T[TestPackages] ---> X[checkboxestests]
P[Resources] ---> Y[DataProviders]
P[Resources] ---> Z[TestSuites]