# Log Remover

This is a java project which is created for developing a java command line utility to remove log files if it reaches a defined threshold file size limit.

<br />

**How to use**
---
- You should have Java installed in your machine : <a href="https://www.javatpoint.com/javafx-how-to-install-java">Installation Guide</a>
- First download the **.jar** file from <a href="https://github.com/shayansaha85/logrem/raw/master/out/artifacts/logRemoval.jar">here</a>
- Open command prompt/powershell/terminal in the same location where the *logRemoval.jar* file is present
- Run below command in order to execute
```bash
java -jar logRemoval.jar -path=/location/of/logfile/<FILENAME_WITH_EXTENSION> -maxSize=5120
```
<i>**Note :** maxSize flag is in KiloBytes format</i>
- This utility is platform independent, and hence can be used in any operating system
