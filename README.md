![Logo](docs/logo.png)    
  
# Kicker-telegram-bot

## Running

### From sources

To build and run the application, you will need Java preinstalled.

```bash
$ git clone https://github.com/zh-efimenko/Kicker-telegram-bot.git  
$ cd ZenKicker  
$ ./gradlew build installDist  
$ ./build/install/Kicker-telegram-bot/bin/Kicker-telegram-bot --kicker.api.host=value --telegram.access-key=value
```

### Dockerimage

```bash
$ docker run -d --name kicker-bot --restart always eefimenko/kicker-telegram-bot \
	--kicker.api.host=value --telegram.access-key=value
```

## Prerequisites

* `kicker.api.host`

Configure the **kicker.api.host** environment variable to point to the host where 
you are running your Kicker server. 

* `telegram.access-key`

Configure the **telegram.access-key** environment variable to point to the your telegram bot.