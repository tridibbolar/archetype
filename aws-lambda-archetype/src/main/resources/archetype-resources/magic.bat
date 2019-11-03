call mvn clean
call aws codecommit create-repository --repository-name CWE${service}Repo --repository-description "My demonstration repository"
call git init
call git add -A
call git commit -m "Initial commit of ${artifactId} project"
call git remote add origin https://git-codecommit.ap-southeast-1.amazonaws.com/v1/repos/CWE${service}Repo
call git push origin master
call aws iam create-role --role-name CWE${service}ServiceRole --assume-role-policy-document file://create-role.json
call aws iam put-role-policy --role-name CWE${service}ServiceRole --policy-name CWE${service}CodeBuildServiceRolePolicy --policy-document file://put-role-policy.json
call aws codebuild create-project --cli-input-json file://cf_codebuild.json
call aws codepipeline create-pipeline --cli-input-json file://cf_codepipeline.json