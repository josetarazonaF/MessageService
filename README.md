
# MessageService

Final Thesis work for COLPE of Java + Spring + REST Academy - January 2022


## Requirements

- Java 17
- Spring Boot 2.6.4
- Maven 

## API Reference


### Auth Services

| Method | URL | Decription | Request Body |
| ------ | --- | ---------- | --------------------------- 
| POST   | /api/auth/signup | Sign Up | [JSON](#sign-up) | 
| POST   | /api/auth/signin | Sign In | [JSON](#sign-in) |
| POST   | /api/auth/signout | Sign Out | | 

### Mailbox Services

| Method | URL | Decription | Request Body |
| ------ | --- | ---------- | --------------------------- |
| POST   | /api/mailbox/newMessage | Send a new message | [JSON](#new-message) |
| GET   | /api/mailbox/receivedMessages | Get all received messages |  |
| GET   | /api/mailbox/sentMessages | Get all sent messages |  |
| POST   | /api/mailbox/createLabel | Create a new label | [JSON](#create-label) |
| GET   | /api/mailbox/getLabels | Get all labels |  |
| GET   | /api/mailbox/receivedMessages/{id}/addLabel/{label} | add a label to a message | |
| GET   | /api/mailbox//receivedMessages/labelFilter/{label} | Get messages filtring by label |  |




## JSON Request Bodys

##### <a id="sign-up">Sign Up -> /api/auth/signup</a>
```json
{
    "username":"josetara",
    "password":"12345abc",
    "name":"Jose",
    "lastName":"Tarazona",
    "identificationNumber":"1090123456",
    "address":"calle 15",
    "zipCodeCity":"540004",
    "state":"nds",
    "country":"colombia"
}
```

##### <a id="sign-in">Sign In -> /api/auth/signin</a>
```json
{
    "username":"josetara",
    "password":"12345abc"
}
```

##### <a id="new-message">New Message -> /api/mailbox/newMessage</a>
```json
{
    "subject": "Greetings",
    "body": "helloWorld!",
    "attachment": "empty",
    "primaryReceptor": "primaryReceptor"
}
```

##### <a id="create-label">Create Label -> /api/mailbox/createLabel</a>
```json
{
    "name":"work"
}
```
## Author

- [@JoseTarazonaF](https://github.com/josetarazonaF)

