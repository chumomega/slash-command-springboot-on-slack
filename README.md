# Slash Command Tic Tac Toe


## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```sh
git clone https://github.com/chumomega/slash-command-springboot-on-slack.git
cd java-getting-started
mvn install
heroku local:start
```

Your app should now be running on [localhost:5000](http://localhost:5000/).



## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Deploy on Slack
```sh
	Follow Instructions --> https://api.slack.com/slash-commands
		Use the /ttt controller link of the heroku app you hosted here
		

## Enjoy

