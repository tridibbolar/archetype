Steps to generate project from archetype

1. Clone archetype project from codecommit url (https://git-codecommit.ap-southeast-1.amazonaws.com/v1/repos/tcg-archetype)
2. mvn clean compile
3. mvn install
4. Execute below command into the project folder 

	mvn archetype:generate 
		-DarchetypeGroupId=com.tcg.ua 
		-DarchetypeArtifactId=tcg-archetype 
		-DarchetypeVersion=0.0.1-SNAPSHOT 
		-DgroupId=com.tcg.ua.cwe 
		-DartifactId=ingestion-lambda 
		-Dservice=Ingestion
		
To Compile, Commit and create initial CodePipeline developer has to do the following steps
1.	Go to project folder
2.	Execute magic.bat
		