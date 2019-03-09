![Logo](https://github.com/zh-efimenko/Kicker-telegram-bot/blob/master/docs/logo.png?raw=true)    
  
  
<p align="center">
    <a href="https://github.com/zh-efimenko/Kicker-telegram-bot/releases"><img alt="GitHub release" src="https://img.shields.io/github/release/zh-efimenko/Kicker-telegram-bot.svg"></a>
    <a href="https://hub.docker.com/r/eefimenko/kicker-telegram-bot"><img alt="DockerHub Size" src="https://img.shields.io/microbadger/image-size/eefimenko/kicker-telegram-bot.svg"></a>
    <a href="https://github.com/zh-efimenko/ZenKicker-telegram-bot/blob/master/LICENSE.txt"><img alt="license" src="https://img.shields.io/github/license/zh-efimenko/Kicker-telegram-bot.svg"></a>
</p>

# Kicker-telegram-bot

## Running

### From sources

To build and run the application, you will need Java preinstalled.

```bash
$ git clone https://github.com/zh-efimenko/Kicker-telegram-bot.git  
$ cd Kicker-telegram-bot  
$ ./gradlew build installDist  
$ ./build/install/Kicker-telegram-bot/bin/Kicker-telegram-bot --kicker.api.host=value --telegram.access-key=value
```

### Dockerimage

```bash
$ docker run -d --name kicker-bot --restart always \
             -e TELEGRAM_ACCESS_KEY=$TELEGRAM_ACCESS_KEY \
             -e KICKER_API_HOST=$KICKER_API_HOST \
             eefimenko/kicker-telegram-bot
```

## Prerequisites

The **_Application_** uses several environment variables. 
All of them are required to run the application.

* `kicker.api.host` or `KICKER_API_HOST`

Configure the **kicker.api.host** environment variable to point to the host where 
you are running your Kicker server. 

* `telegram.access-key` or `TELEGRAM_ACCESS_KEY`

Configure the **telegram.access-key** environment variable to point to the your telegram bot.
