Steps to generate project from archetype

1. Clone archetype project from codecommit url (https://git-codecommit.us-east-2.amazonaws.com/v1/repos/GeeArchetype)
2. mvn clean compile
3. mvn install
4. Execute below command into the project folder 
		
	mvn archetype:generate 
		-DarchetypeGroupId=com.tcg.poc 
		-DarchetypeArtifactId=lambda-archetype 
		-DarchetypeVersion=0.0.1-SNAPSHOT 
		-DgroupId=com.tcg.poc.lc 
		-DartifactId=demo-lambda  
		-Dservice=HelloWorld
		-Dawsregion=ap-southeast-1
		-Dawsaccountid=XXXXX2791573
		
To Compile, Commit and create initial CodePipeline developer has to do the following steps
1.	Go to project folder
2.	Execute magic.bat
		