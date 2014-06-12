@echo stop resin
call D:\p\resin\resin stop
@echo compile
call mvn clean package
@echo copy resource
cp -r -f src/main/resources/* target/joydeal-0.0.1-SNAPSHOT/WEB-INF/
@echo start resin
call D:\p\resin\resin start
pause