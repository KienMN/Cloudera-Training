# Cloudera-Training
Lecture 03

Project: averagewordlength

Project: log_file_analysis

File:
LogFileMapper.java, ProcessLogs.java, SumReducer.java

Terminal:
// Cd to directory containing .JAR file on local
// Execute Map Reduce Job
hadoop jar [.JAR file] [package.DriveClass] [inputDir] [outPutDir]
E.g: hadoop jar logFileAnalysis.jar stubs.ProcessLogs testlog countTestLog
// View result
hadoop fs -ls [outputDir]
hadoop fs -cat [outputDir/fileName]

Project: mrunit
File: TestWordCount.java
Add 3 tests (for mapper, reducer, and mapper&reducer) together to TestWordCount.java
