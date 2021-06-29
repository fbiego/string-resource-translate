import java.io.File

const val SEPARATOR = ","

fun main(args: Array<String>) {
    
    if (args.size > 0){
        val data = File(args[0]).readLines()
        if (data.size > 0){
            generate(data)
			println("-----Done-------")
        } else {
			println("Could not read from ${args[0]}")
		}
    } else {
        println("Specify the file name")
    }

    
}

fun generate(strings: List<String>){
    val lang = strings[0].split(SEPARATOR).count() - 1
    println("Languages: $lang")
	
	val dir = File("output")
	if (!dir.exists())
        dir.mkdirs()
		println("Created output folder")
    
    for (x in 1..lang){
        var output = ""
    	output += "<resources>\n"
        var name = ""
    	for (s in strings){
        	var word = s.split(SEPARATOR)
            if (word[0] == "id"){
                name = if (word[x] == "en"){
                    "values"
                } else {
                    "values-${word[x]}"
                }
            } else {
                output += "\t<string name=\"${word[0]}\">${word[x]}</string>\n"
            }
    	}
    	output += "</resources>"
        println("Generated: ${name}/strings.xml")
		if (!dir.exists())
        dir.mkdirs()
		val res = File(dir, name)
		if (!res.exists())
            res.mkdirs()
		val file = File(res, "strings.xml")
		file.createNewFile()
		file.writeText(output)
	}
}
