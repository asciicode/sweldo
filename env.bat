@echo off
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_171
set M2_HOME=C:\Java\apache-maven-3.6.1
set PATH=%JAVA_HOME%\bin;%M2_HOME%\bin;%PATH%
java -version
javac -version
mvn -version