SET LIBS=./build/libs
SET SERVER_PORT=8080
SET DEBUG_PORT=8081

SET SERVER_DEBUG=-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=%DEBUG_PORT% -Xdebug -Xnoagent
@REM SET SERVER_MEMORY=-XX:+UseG1GC -XX:MaxGCPauseMillis=75
SET SERVER_MEMORY=

java -Dspring.profiles.active=%HUMMINGBIRD_ACTIVE_PROFILES% ^
     -Dserver.port=%SERVER_PORT% ^
     -Dspring.cloud.bootstrap.enabled=false ^
     -Dmanagement.security.enabled=false ^
     %SERVER_MEMORY% ^
     -jar  %LIBS%/java.telecom-1.0.0.jar

pause
