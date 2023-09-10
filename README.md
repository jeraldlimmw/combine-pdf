1. To build locally:
mvn clean package

import dependencies locally into "target/dependency" folder:
mvn dependency:copy-dependencies

2. Copy the pdf files into app main folder

3. To run the jar package:
Use either of the following commands:
java -cp target/dependency/pdfbox-2.0.28.jar:target/dependency/commons-logging-1.2.jar:target/combpdf-1.0-SNAPSHOT.jar:classes app.CombinePDFPages

sudo java -cp target/combpdf-1.0-SNAPSHOT.jar:target/dependency/* app.CombinePDFPages

4. Enter the names of document1, document 2 and the name of the final merged document
