#@ECHO OFF
ECHO Cleaning project folder...
ECHO .
call mvn clean
ECHO .
ECHO Create repository ${service}Repo...
ECHO .
call aws codecommit create-repository --repository-name ${service}Repo --repository-description "My demonstration repository"
ECHO .
ECHO Git commit and push into repo...
ECHO .
call git init
call git add -A
call git commit -m "Initial commit of ${artifactId} project"
call git remote add origin https://git-codecommit.${awsregion}.amazonaws.com/v1/repos/${service}Repo
call git push origin master
ECHO .
ECHO Create S3 bucket codepipeline-${awsregion}-${awsaccountid}...
ECHO .
call aws s3 mb s3://codepipeline-${awsregion}-${awsaccountid} --region ap-southeast-1
ECHO .
ECHO Create service role ${service}ServiceRole for CodeBuild project...
ECHO .
call aws iam create-role --role-name ${service}ServiceRole --assume-role-policy-document file://create-role.json
ECHO .
call aws iam put-role-policy --role-name ${service}ServiceRole --policy-name ${service}CodeBuildServiceRolePolicy --policy-document file://put-role-policy.json
ECHO .
PAUSE
ECHO Create CodeBuild project...
ECHO .
call aws codebuild create-project --cli-input-json file://cf_codebuild.json
ECHO .
ECHO Create CodePipeline...
ECHO .
call aws codepipeline create-pipeline --cli-input-json file://cf_codepipeline.json
