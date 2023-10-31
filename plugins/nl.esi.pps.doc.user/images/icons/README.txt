Asciidoc PDF conversion does not support gif images, at least not easily on Windows.
As our icons are mainly gif images, this conversion script automatically converts them into png images.
To start the conversion, use the following command line:

> java -Ddelete -Doverwrite -jar convert2png.jar *.gif

PS: The sources of convert2png are included in the jar
