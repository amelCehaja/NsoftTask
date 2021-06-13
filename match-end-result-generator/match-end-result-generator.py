import json
import random
import uuid
import requests
import time
import numpy
import sys


def json_reader(fileName):
    file = open(fileName)
    result = json.load(file)
    return result


def random_score():
    score = numpy.random.choice(
        numpy.arange(0, 8), p=[0.23, 0.23, 0.23, 0.11, 0.05, 0.05, 0.05, 0.05])
    return score


def infinite_sequence(data):
    while True:
        team1 = data[random.randint(0, len(data) - 1)]
        team2 = data[random.randint(0, len(data) - 1)]
        while team2 == team1:
            team2 = data[random.randint(0, len(data) - 1)]
        match_name = team1 + " - " + team2
        result = str(random_score()) + " : " + str(random_score())
        matchId = uuid.uuid4()
        yield {
            "matchId": str(matchId),
            "matchName": match_name,
            "endResult": result
        }


endpoint = "/save-end-result"
url = "http://localhost:8080" + endpoint
if (len(sys.argv) > 1):
    url = sys.argv[1] + endpoint

print("Generating match-result-end-events for " + url)
for match_result_event in infinite_sequence(json_reader("data.json")):
    try:
        response = requests.post(url, json=match_result_event)
        print(match_result_event)
        print("Response status code: ", response.status_code)
        time.sleep(1)
    except requests.exceptions.ConnectionError:
        print("Connection to " + url + " can't be established!")
        break
