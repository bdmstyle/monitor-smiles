
## Smiles Monitor Api

* The main goal is help travellers to travel in pandemic!
* The smiles monitor is an api that notify in realtime the clients about covid situation
* As an benefit so smiles motivate the users to donwload the app and give to smiles your real travel desires places 

The api is divided in thre parts

## Places Api
Place Api is used by the frontend to render the site
But is used to smiles partners update our current pandemic situation like (news specialists)

## Notify Api
Used to push notification destination updates to smiles clients every time a monitored place changes (can be used by smiles patterns also)

## Monitoring Api
Is Used to only by the smiles site or app to monitor or unmonitor places

Try It Online
https://monitorsmiles.com.br/

Api Documentation
https://monitorsmiles.com.br/api/index.html

### Back end

This section should list any major frameworks that you built your project using.

Backend
* [Java 15]()
* [SpringBoot]()
* [MongoDb 4]()

FrontEnd is React to see more details in
* [View Front End Project ](https://github.com/wiliamtaesunglee/monitor-de-destinos)

UX/Design
* [View Full layout in Figma ](https://www.figma.com/file/xmWZJppwyuUSq10rwH36EJ/Untitled?node-id=0%3A1)

## Run local

To run the Smiles Monitor Api you only need DOCKER installed
The app will run an embeded mongodb enjoy!

```shellsession
docker pull brunomarinholee/api-smiles && docker run --rm -t -d -p 8080:8080 brunomarinholee/api-smiles
```
