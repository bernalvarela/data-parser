> # data-parser

A log file contains newline-terminated, space-separated text formatted like:

`
<unix_timestamp> <hostname> <hostname>
`

For example:


1366815793 quark garak

1366815795 brunt quark

1366815811 lilac garak


Each line represents connection from a host (left) to another host (right) at a given time. The lines are
roughly sorted by timestamp. They might be out of order by maximum 5 minutes.
Implement a tool that parse log files like these, we provide you a input Data Example.

## Goals to Achieve

#### 1. Parse the data with a time_init, time_end
Build a tool, that given the name of a file (with the format described above), an init_datetime, an
end_datetime, and a Hostname, returns:

a list of hostnames connected to the given host during the given period

To run this option we run this command from command line

```bash
java -jar data-parser-VERSION-jar-with-dependencies.jar filename -i init_datetime -e end_datetime -h host
```

- filename: Route to log file
- init_datetime: Timestamp value. (Numeric)
- end_datetime: Timestamp value. (Numeric)

#### Example
```bash
java -jar data-parser-VERSION-jar-with-dependencies.jar /home/Descargas/input-file-10000.txt -i 1565647204351 -e 1565733598341 -h Jenyssa
```

#### 2. Unlimited Input Parser
The tool should both parse previously written log files and terminate or collect input from a new log
file while it's being written and run indefinitely.
The script will output, once every hour:

- a list of hostnames connected to a given (configurable) host during the last hour

- a list of hostnames received connections from a given (configurable) host during the last hour

- the hostname that generated most connections in the last hour


Both the number of log lines and hostnames can be very high.

```bash
java -jar data-parser-VERSION-jar-with-dependencies.jar filename -f -h host1, host2
```

- filename: Route to log file

#### Example
```bash
java -jar data-parser-VERSION-jar-with-dependencies.jar /home/Descargas/input-file-10000.txt -f -h "Ramondo, Haileen"
```

### Setup

___

#### Requirement

data-parser application uses Java 11, you need this version or higher:

Install openjdk on Debian, Ubuntu, etc.,

```bash
 sudo apt-get install openjdk-11-jdk
```

Install openjdk on Fedora, Oracle Linux, Red Hat Enterprise Linux, etc.,

```bash
 su -c "yum install java-11-openjdk-devel"
```

For windows and mac you can:

* download oracle JDK 11 setup from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* using chocolatey (windows):
        <https://chocolatey.org/packages?q=java>
   brew (mac):

```bash
 brew tap adoptopenjdk/openjdk
 brew cask install adoptopenjdk11
```

You also need to install maven to compile the project.

#### Build Project

In order to build the project you have to run this commands:

```bash
 mvn clean package
```

This will create the target directory with a jar with the compiled sources and a jar with sources and the dependencies.
