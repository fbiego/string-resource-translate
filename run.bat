@echo off

echo Compiling...
call kotlinc translate.kt -include-runtime -d translate.jar

echo Exporting files...
call java -jar translate.jar "export.txt"

echo Complete
pause