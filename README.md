# IEXTrading4j: Open source IEX Trading API library

[![Build Status](https://travis-ci.org/WojciechZankowski/iextrading4j.svg?branch=master)](https://travis-ci.org/WojciechZankowski/iextrading4j)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.zankowski/iextrading4j-all/badge.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22pl.zankowski%22%20AND%20a%3A%22iextrading4j-all%22)

## Table of Contents

* [Quick Start](#quick-start)
* [IEX Trading](#iex-trading)
* [How to](#how-to)
* [Wiki](#wiki)
* [License](#license)

## Quick Start

Java SE 8 is required to use IEXTrading4j library.

```
<dependency>
	<groupId>pl.zankowski</groupId>
	<artifactId>iextrading4j-all</artifactId>
	<version>2.0.0</version>
</dependency>
```

Library is up to IEX Trading API version [1.0] - 25.11.2017 

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

To build request use classes that extend ``` IRestRequestBuilder ``` interface. Example request:

```java
final IEXTradingClient iexTradingClient = IEXTradingClient.create();
final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
        .withSymbol("AAPL")
        .build());
System.out.println(quote);
```

## Wiki

Please visit [Wiki](https://github.com/WojciechZankowski/iextrading4j/wiki) to get more information.


## License

Code and documentation released under the Apache License, Version 2.0

Data provided for free by [IEX](https://iextrading.com/developer).

IEX Trading API Exhibit A: [Exhibit A](https://iextrading.com/api-exhibit-a)


