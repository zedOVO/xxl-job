export dir=/Volumes/mojave/Users/zed/Java/Project/IdeaWorkSpace/xxl-job/package

cp /Volumes/mojave/Users/zed/Java/Project/IdeaWorkSpace/xxl-job/xxl-job-admin/target/xxl-job-admin-2.3.1-SNAPSHOT.jar $dir/xxl-job-admin-2.3.1-SNAPSHOT.jar
cp /Volumes/mojave/Users/zed/Java/Project/IdeaWorkSpace/xxl-job/xxl-job-executor-samples/xxl-job-executor-sample-springboot/target/xxl-job-executor-sample-springboot-2.3.1-SNAPSHOT.jar $dir/xxl-job-executor-sample-springboot-2.3.1-SNAPSHOT.jar
cp /Volumes/mojave/Users/zed/Java/Project/IdeaWorkSpace/xxl-job/xxl-job-executor-samples/ssm/target/ssm-0.0.1-SNAPSHOT.jar $dir/ssm-0.0.1-SNAPSHOT.jar

zip -r package.zip package/*.jar
scp /Volumes/mojave/Users/zed/Java/Project/IdeaWorkSpace/xxl-job/package.zip centos@32a017h342.wicp.vip:/home/app/java/server
