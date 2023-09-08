1. A student submitting an answer to a game. The body of the request should contain the answer as an integer:
2.

```json
POST /game/1/answer?studentId=1
```

Body:

```json
{
    "answer": 2
}
```

In this request, the answer submitted by the student with ID 1 to the game with ID 1 is 2. Please note that the 'answer'
field in the body must be an integer representing the answer option chosen by the student.

Please replace the game ID, student ID, and answer as needed in your actual requests. Also note that you should set
the `Content-Type` header of your requests to `application/json` to let your server know that you're sending JSON data.

---

# POST /submitAnswer

This endpoint allows a student to submit their answer to the current question in a specific game.

## Request

The body of the request should contain a JSON object with the following fields:

- `gameId`: The ID of the game to which the answer is being submitted. This should be an integer.
- `studentId`: The ID of the student who is submitting the answer. This should be an integer.
- `answer`: The submitted answer. This should be an integer representing the chosen answer option.

### Example

Request URL:

```
POST /submitAnswer
```

Request Headers:

```
Content-Type: application/json
```

Request Body:

```json
{
    "gameId": 1,
    "studentId": 2,
    "answer": 3
}
```

In this example, the student with ID 2 is submitting answer option 3 to the game with ID 1.

## Response

The server will respond with a status code of 200 OK if the answer was successfully submitted. The response body will be
empty.

### Example

Response Status Code:

```
200 OK
```