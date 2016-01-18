# GildedRoseKata
A number of solutions to the Gilded Rose Kata implemented in Java using various refactoring methods and Java testing tools.

Problem has been solved in 6 different ways, mainly learning a lot of Refactoring techniques and concepts about Domain objects. Also some tools on code coverage and writing tests (especially Golden Master):

*Solution 1* 

    git checkout Solution1


*Solution 2* 

    git checkout Solution2


*Solution 3* 

    git checkout Solution3


*Solution 4* 

    git checkout Solution4


*Solution 5*

    git checkout Solution5

*Solution 6*

    git checkout Solution6
    

**PiTest coverage plugin documentation**

_mutationCoverage goal_
    
The mutation coverage goal analyses all classes in the codebase that match the target tests and target classes filters.
It can be run directly from the commandline
    
`$ mvn org.pitest:pitest-maven:mutationCoverage`
    
This will output an html report to target/pit-reports/YYYYMMDDHHMI.
    
To speed-up repeated analysis of the same codebase set the withHistory parameter to true.
`$ mvn -DwithHistory org.pitest:pitest-maven:mutationCoverage`
    
_scmMutationCoverage goal_
    
The scm mutation coverage goal analyses only classes that match the filters and the source file has a given status         within the project source control system (by default ADDED or MODIFIED). This provides a quick way to check the            coverage of changes prior to checking code in / pushing code to a repository.
    
`$ mvn org.pitest:pitest-maven:scmMutationCoverage -Dinclude=ADDED,UNKNOWN -DmutationThreshold=85`
