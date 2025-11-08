# web_site
```
mvn spring-boot:run

mvn clean package

java -jar target/spboot.jar
```

## Run Docker java
```
docker build -t web_site_sb .
docker run -it --rm -p 6892:8081 --name p22-java_container web_site_sb

docker run -d --restart=always -p 6892:8081 --name p22-java_container web_site_sb

docker run -d --restart=always -v d:/volumes/web_site_sb/images:/app/images -p 6892:8081 --name p22-java_container web_site_sb

docker stop p22-java-container
docker rm p22-java-container
docker rmi web_site_sb

docker login
docker tag web_site_sb:latest nastiapyv/web_site_p22:latest
docker push nastiapyv/web_site_p22:latest
```

## Run app
```
dos2unix web_site_sb.sh
chmod +x web_site_sb.sh
./web_site_sb.sh
```

## nginx config
```
server {
    server_name   javap22.itstep.click *.javap22.itstep.click;
    client_max_body_size 200M;
    location / {
       proxy_pass         http://localhost:6892;
       proxy_http_version 1.1;
       proxy_set_header   Upgrade $http_upgrade;
       proxy_set_header   Connection keep-alive;
       proxy_set_header   Host $host;
       proxy_cache_bypass $http_upgrade;
       proxy_set_header   X-Forwarded-For $proxy_add_x_forwarded_for;
       proxy_set_header   X-Forwarded-Proto $scheme;
    }
}
```

## nginx command
```
systemctl status nginx
systemctl restart nginx
cerbot
```

