# NsoftTask

The project consists of two parts:

- match-end-event-generator
- match-end-event-sinking-service

The goal of this project is to generate a match-result-event and store it in the MySQL database. Communication between match and service is achieved using HTTP Post.

![](https://i.ibb.co/nj5QRX9/Screenshot-from-2021-06-11-23-26-13.png)

## match-end-event-generator

Python script that generates result every second, and sends it to service using HTTP Post. Schema of match-end-result-event is following:

```
{
    matchId : uuidv4,
    matchName : string,
    endResult : string
}
```

matchName is randomly generated from two teams listed in the file: data.json.
endResult is randomly generated where maximum goals by one team can be 7.

## match-end-result-sinking-service

Spring boot app that has the task to receive match-end-result-event and store it in the MySQL database. The endpoint for receiving match via HTTP Post is "/save-end-result".

## Technologies

The project is created using:

- Java: 11
- Spring Boot: 2.5.0
- Python3

## How to run it

First, you need to run the match-end-result-sinking-service. Navigate to the root folder of match-end-result-sinking-service and in terminal run command:

```
docker-compose up
```

This will run the MySQL database and match-end-result-sinking-service in a docker container. After that match-end-event-generator should be run. Navigate to the root folder of a match-end-event-generator and run the command:

```
python match-end-result-generator.py
```

The default URL where requests are sent is [http://localhost:8080]. If match-end-result-sinking-service is hosted outside of localhost then URL should be set as a parameter when starting the generator. Example:

```
python match-end-result-generator.py http://nsoft.com
```