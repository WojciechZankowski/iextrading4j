# IEXTrading4j: Open source IEX Trading API library

[![Build Status](https://travis-ci.org/WojciechZankowski/iextrading4j.svg?branch=master)](https://travis-ci.org/WojciechZankowski/iextrading4j)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.zankowski/iextrading4j-all/badge.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22pl.zankowski%22%20AND%20a%3A%22iextrading4j-all%22)
[![codecov](https://codecov.io/gh/WojciechZankowski/iextrading4j/branch/master/graph/badge.svg)](https://codecov.io/gh/WojciechZankowski/iextrading4j)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=pl.zankowski%3Aiextrading4j&metric=alert_status)](https://sonarcloud.io/dashboard/index/pl.zankowski:iextrading4j)

## Table of Contents

* [Quick Start](#quick-start)
* [Description](#description)
* [IEX Trading](#iex-trading)
* [How to](#how-to)
* [Wiki](#wiki)
* [License](#license)
* [Others](#others)

## Quick Start

Java SE 8 is required to use IEXTrading4j library.

Maven:

```
<dependency>
	<groupId>pl.zankowski</groupId>
	<artifactId>iextrading4j-all</artifactId>
	<version>2.2.2</version>
</dependency>
```

Gradle:

```
dependencies {
	compile 'pl.zankowski:iextrading4j-all:2.2.2'
}
```

Library is up to IEX Trading API version [1.0] - 04.07.2018

## Description

IEXTrading4j library allows to receive all data available in API provided by IEXTrading company. They allow to use their market data completly for free, so go and try it out!

Data & API description: https://iextrading.com/developer

Unofficial library listed on [IEXTrading](https://iextrading.com/developer/docs/#unofficial-libraries-and-integrations)

## IEX Trading

IEX A Fair, Simple, Transparent Exchange.

IEX is a stock exchange based in the United States. Started by Brad Katsuyama, it opened for trading on October 25, 2013. The company’s offices are located at 4 World Trade Center in New York City. The matching engine is located across the Hudson River in Weehawken, New Jersey, and the initial point of presence is located in a data center in Secaucus, New Jersey. IEX's main innovation is a 38-mile coil of optical fiber placed in front of its trading engine. This 350 microsecond delay adds a round-trip delay of 0.0007 seconds and is designed to negate the certain speed advantages utilized by some high-frequency traders.

IEX was created in response to questionable trading practices that had become widely used across traditional public Wall Street exchanges as well as dark pools and other alternative trading systems. The IEX exchange aims to attract investors by promising to "play fair" by operating in a transparent and straightforward manner, while also helping to level the playing field for traders. Strategies to achieve those goals include:

* Publishing the matching rules used in the exchanges's computerized order matching engine.
* Offering a limited number of simple and familiar order types.
* Charging fixed fees on most orders (or a flat percentage rate on small orders).
* Ensuring market pricing data arrives at external points of presence simultaneously.
* Slightly delaying market pricing data to all customers (no colocation).
* Refusing to pay for order flow.

Check out their beautiful site: [IEX Trading](https://iextrading.com/)

## How to

### Synchronous requests

To build request use classes that extend ``` IRestRequestBuilder ``` interface. Example request:

```java
final IEXTradingClient iexTradingClient = IEXTradingClient.create();
final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
        .withSymbol("AAPL")
        .build());
System.out.println(quote);
```

### Batch synchronous request

Instead of creating multiple requests, some data can accessed in single Batch:

```java
final IEXTradingClient iexTradingClient = IEXTradingClient.create();
final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
        .withSymbol("AAPL")
        .addType(BatchStocksType.BOOK)
        .addType(BatchStocksType.COMPANY)
        .addType(BatchStocksType.EARNINGS)
        .build());
System.out.println(batchStocks);
```

### Asynchronous requests

To build request use classes that extend ``` IAsyncRequestBuilder ``` interface. Example request:

```java
final IEXTradingClient iexTradingClient = IEXTradingClient.create();

final Consumer<TOPS> TOPS_CONSUMER = System.out::println;
final SocketRequest<TOPS> request = new TopsAsyncRequestBuilder()
          .withAllSymbols()
          .build();
	  
iexTradingClient.subscribe(request, TOPS_CONSUMER);
```

### DEEP asynchronous request

To get multiple data almost in real-time using socket technology you can use DEEP request with multiple channels:  

```java
final IEXTradingClient iexTradingClient = IEXTradingClient.create();

final Consumer<DeepAsyncResponse<DeepResult>> DEEP_ASYNC_RESPONSE_CONSUMER = System.out::println;
final SocketRequest<DeepAsyncResponse<DeepResult>> request = new DeepAsyncRequestBuilder()
        .addChannel(DeepChannel.TRADING_STATUS)
        .addChannel(DeepChannel.AUCTION)
        .addChannel(DeepChannel.TRADES)
        .withSymbol("AAPL")
        .build();

iexTradingClient.subscribe(request, DEEP_ASYNC_RESPONSE_CONSUMER);
```

## Wiki

Please visit [Wiki](https://github.com/WojciechZankowski/iextrading4j/wiki) to get more information.


## License

Code and documentation released under the Apache License, Version 2.0

Data provided for free by [IEX](https://iextrading.com/developer).

IEX Trading API Exhibit A: [Exhibit A](https://iextrading.com/api-exhibit-a)

## Others

# [IEXTrading4j HIST](https://github.com/WojciechZankowski/iextrading4j-hist)

IEX Trading allows users to receive their market data completly for free. Their data can be accessed in real-time during market session or can be downloaded as recorded sessions in PCAP data format. Market Data is transported in binary format and can be read according to specification shared on their site. 

This library allows you to transform binary packets into human readable Market Data events in Java.

More on this topic can found here: [IEX Trading Market Data](https://www.iextrading.com/trading/market-data/)

# [IEXTrading4j BOOK](https://github.com/WojciechZankowski/iextrading4j-book)

IEXTrading4j Book library allows to build incremental Order Book based on PriceLevelUpdateMessages from DEEP market data stream. OrderBook implementation follows description from specification.

# [IEXTrading4j FIX](https://github.com/WojciechZankowski/iextrading4j-fix)

IEXTrading4j FIX project provides open source FIX dictionary that follows IEX FIX specification. It allows to easily integrate your systems with IEX FIX connectivity using libraries like QuickFIX or QuickFIX/J.
