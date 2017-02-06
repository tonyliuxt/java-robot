This project is based on JDK1.7, Maven3.3

For the compile environment, have the following suppose:
1. JDK already installed
2. Maven already installed
3. Related environment variables already set

For build, running unit test and generate the jar file:
1. In the root directory running "mvn test" command or "mvn install"
2. It will automatically generate a rea-robot.jar package in ./target directory and 
3. In the directory same with rea-robot.jar, run command "java -cp rea-robot.jar rea.robot.App" then input commands
