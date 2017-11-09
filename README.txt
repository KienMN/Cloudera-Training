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

Lecture 04
Project: toolrunner
File: AvgWordLength.java
Implement the run method and modify main to call run

File LetterMapper.java
Override setup method to get a configuration parameter called caseSensitive
Modify run method (drive class) to pass parameters progammatically or as a runtime parameter
Note: this.getConf() is to get current configuration

Terminal:
hadoop jar [.JAR file] [package.driveClass] -DcaseSensitive=true/false [input Dir] [output Dir]

Project: combiner
File: WordCountDriver.java
Set input, output paths, set output key and value class, set mapper, reducer, combiner class for the job (in run method)
Execute .JAR file as usual

Lecture 05
Project: toolrunner
Terminal:
hadoop jar [.JAR file] [package.driveClass] -DcaseSensitive=true/false -fs=file:/// -jt=local [local input dir] [local output dir]
