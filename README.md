# IEXTrading4j: Open source IEX Cloud API library

[![Build Status](https://travis-ci.org/WojciechZankowski/iextrading4j.svg?branch=master)](https://travis-ci.org/WojciechZankowski/iextrading4j)
[![codecov](https://codecov.io/gh/WojciechZankowski/iextrading4j/branch/master/graph/badge.svg)](https://codecov.io/gh/WojciechZankowski/iextrading4j)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=pl.zankowski%3Aiextrading4j&metric=alert_status)](https://sonarcloud.io/dashboard/index/pl.zankowski:iextrading4j)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/WojciechZankowski/iextrading4j.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/WojciechZankowski/iextrading4j/context:java)
[![Maven Central](https://img.shields.io/maven-central/v/pl.zankowski/iextrading4j-all.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22pl.zankowski%22%20AND%20a:%22iextrading4j-all%22)

**Open IEX Cloud account using referal link: [IEX Cloud](https://iexcloud.io/s/632c5323)** 

**IEX Cloud (iexcloud.io) support has been added to the library. All stuff related to old IEX Api has been marked as Deprecated. Some of old IEX Api will be still supported. For full support please move to the IEX Cloud API (iexcloud.io).**


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
	<version>3.3.2</version>
</dependency>
```

Gradle:

```
dependencies {
	compile 'pl.zankowski:iextrading4j-all:3.3.2'
}
```

Library is up to:

* IEX Trading API version [1.24] - 09.11.2018
* IEX Cloud API version [1.0] - 03.11.2019

Supported versions: Java SE 8, Java SE 9, Java SE 10, Java SE 11, Java SE 12

## Description

IEXTrading4j library allows to receive all data available in API provided by IEXTrading company. They allow to use their market data completly for free, so go and try it out!

IEX Cloud Data & API description: https://iexcloud.io

Old Data & API description: https://iextrading.com/developer

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

### IEX Cloud (iexcloud.io) requests

#### Synchronous call

To build request use classes that extend ``` IEXCloudV1RestRequest ``` interface. Secret token is required only for Account calls, otherwise you can provide just publishable token. Example request:

```java
final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
              new IEXCloudTokenBuilder()
                      .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                      .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                      .build());
final Quote quote = cloudClient.executeRequest(new QuoteRequestBuilder()
        .withSymbol("AAPL")
        .build());
System.out.println(quote);
```

#### Batch call

```java
final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
              new IEXCloudTokenBuilder()
                      .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                      .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                      .build());
final BatchStocks result = cloudClient.executeRequest(new BatchStocksRequestBuilder()
        .withSymbol("AAPL")
        .addType(BatchStocksType.LARGEST_TRADES)
        .addType(BatchStocksType.PRICE_TARGET)
        .addType(BatchStocksType.QUOTE)
        .build());
System.out.println(result);
```

#### Streaming SSE

To build request use classes that extend ``` ISseRequestBuilder ``` interface. Example request:

```java
final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
              new IEXCloudTokenBuilder()
                      .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                      .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                      .build());

final Consumer<List<TOPS>> TOPS_CONSUMER = System.out::println;
final SseRequest<List<TOPS>> request = new TopsSseRequestBuilder()
        .withSymbol("AAPL")
        .build();

cloudClient.subscribe(request, TOPS_CONSUMER);
```

Please see samples for more examples.

### IEX Api (iextrading.com/developer) requests

**Support for IEX Api has been reduced after June 1, 2019.**

To build request use classes that extend ``` IEXApiRestRequest ``` interface. Example request:

```java
final IEXApiClient iexTradingClient = IEXTradingClient.create();
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

## Others

# [IEXTrading4j HIST](https://github.com/WojciechZankowski/iextrading4j-hist)

IEX Trading allows users to receive their market data completly for free. Their data can be accessed in real-time during market session or can be downloaded as recorded sessions in PCAP data format. Market Data is transported in binary format and can be read according to specification shared on their site. 

This library allows you to transform binary packets into human readable Market Data events in Java.

More on this topic can found here: [IEX Trading Market Data](https://www.iextrading.com/trading/market-data/)

# [IEXTrading4j BOOK](https://github.com/WojciechZankowski/iextrading4j-book)

IEXTrading4j Book library allows to build incremental Order Book based on PriceLevelUpdateMessages from DEEP market data stream. OrderBook implementation follows description from specification.

# [IEXTrading4j FIX](https://github.com/WojciechZankowski/iextrading4j-fix)

IEXTrading4j FIX project provides open source FIX dictionary that follows IEX FIX specification. It allows to easily integrate your systems with IEX FIX connectivity using libraries like QuickFIX or QuickFIX/J.

## Donations

To support this repository: bc1qv6cz6t302qvamxlhyr3m7mdwrnc7anqc35wp3t
