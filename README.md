# Log Remover

This is a java project which is created for developing a java command line utility to remove log files if it reaches a defined threshold file size limit.

<br />

**How to use**
---
- You should have Java installed in your machine : <a href="https://www.javatpoint.com/javafx-how-to-install-java">Installation Guide</a>
- First download the **.jar** file from <a href="https://github.com/shayansaha85/logrem/raw/master/out/artifacts/logrem_jar/logrem.jar">here</a>
- Open command prompt/powershell/terminal in the same location where the *logRemoval.jar* file is present
- Run below command in order to execute
```bash
java -jar logrem.jar -path=/path/of/log/folders -maxSizeLimit=5M -logFileExtension=log,out,tmp
```
<i>**Note :** maxSize flag can be entered in any format.</i>
<br />
<i>e.g. If user want to delete files which are</i>
- More than 10KB, user will enter **-maxSizeLimit=10K**
- More than 10MB, user will enter **-maxSizeLimit=10M**
- More than 10GB, user will enter **-maxSizeLimit=10G**
<br />
This utility is platform independent, and hence can be used in any operating system
