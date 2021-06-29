# string-resource-translate
Generate translated string resources for Android Studio

## Google Sheets
Use `=GOOGLETRANSLATE(text, [source], [target])` formula to translate resources

[`Sample Translations`](https://docs.google.com/spreadsheets/d/1lhdiHR3SQ64gfVINh-0R4BrurcOl7Btu_H36IjDYhDI/edit?usp=sharing)

Export as csv 
> File>Download>Comma-separated values

Compile translate.kt
> `kotlinc translate.kt -include-runtime -d translate.jar`

Generate output
> `java -jar translate.jar "export.txt"`

On Windows just run the batch file `run.bat`
